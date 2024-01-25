package org.mql.java.parser;

import java.util.Vector;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ParseClasse {
	private XmlParser parse;
	private Vector<String> data;
	private Vector<String> fields;
	private Vector<String> methods;

	private Vector<String> typefields;
	private Vector<String> typeMethods;

	public ParseClasse(XmlParser parse) {
		this.parse = parse;
		data = new Vector<String>();
		fields = new Vector<String>();
		methods = new Vector<String>();
		typefields = new Vector<String>();
		typeMethods = new Vector<String>();

	}

	public void parseClasse(String className) {
		NodeList classNodes = parse.getRootElement().getElementsByTagName("class");
		for (int i = 0; i < classNodes.getLength(); i++) {
			Element classElement = (Element) classNodes.item(i);
			String classNameValue = classElement.getAttribute("classname");
			if (classNameValue.equals(className)) {
				data.add(classNameValue);

				NodeList childNodes = classElement.getChildNodes();
				for (int j = 0; j < childNodes.getLength(); j++) {
					Node childNode = childNodes.item(j);
					if (childNode.getNodeName().equals("field")) {
						String fieldContent = childNode.getTextContent();
						String typefield = ((Element) childNode).getAttribute("type");
						fields.add(fieldContent);
						typefields.add(typefield);

					}
				}
				for (int k = 0; k < childNodes.getLength(); k++) {
					Node childNode = childNodes.item(k);
					if (childNode.getNodeName().equals("method")) {
						String methodContent = childNode.getTextContent();
						String typeMethod = ((Element) childNode).getAttribute("typeretour");
						methods.add(methodContent);
						typeMethods.add(typeMethod);

					}
				}

			}
		}

	}

	public Vector<String> getData() {
		return data;
	}

	public Vector<String> getTypefields() {
		return typefields;
	}

	public Vector<String> getFields() {
		return fields;
	}

	public Vector<String> getMethods() {
		return methods;
	}

	public Vector<String> getTypeMethods() {
		return typeMethods;
	}

}
