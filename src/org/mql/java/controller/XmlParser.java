package org.mql.java.controller;

import java.io.File;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlParser {
	private Vector<String> data; 
	private Vector<String> fields;
	private Vector<String> methods;
	
	public XmlParser() {
		data = new Vector<String>();
		fields = new Vector<String>();
		methods = new Vector<String>();
	  

}
	public Vector<String> parseClasses(String source,String className) {
		data = new Vector<String>();
		try {
			
			 DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	            DocumentBuilder builder = factory.newDocumentBuilder();
	            File xmlFile = new File(source);
	            org.w3c.dom.Document document = builder.parse(xmlFile);
	            Element rootElement = document.getDocumentElement();

	            // Obtenez tous les éléments <class>
	            NodeList classNodes = rootElement.getElementsByTagName("class");
                 
	            for (int i = 0; i < classNodes.getLength(); i++) {
	                Element classElement = (Element) classNodes.item(i);            
	                String classNameValue = classElement.getAttribute("className");
	                if(classNameValue.equals(className)) {
	                data.add(classNameValue);
	                NodeList childNodes = classElement.getChildNodes();
	                for (int j = 0; j < childNodes.getLength(); j++) {
	                    Node childNode = childNodes.item(j);
	                    if ( childNode.getNodeName().equals("field")) {
	                        String fieldContent = childNode.getTextContent();
	                        fields.add( fieldContent);
	                    }
	                }
	                
	                for (int k = 0; k < childNodes.getLength(); k++) {
	                	Node childNode = childNodes.item(k);
	                	 if ( childNode.getNodeName().equals("method")) {
		                        String methodContent = childNode.getTextContent();
		                        methods.add( methodContent);
		                    }
	                }
	            }
	            }      
	  }
		 catch (Exception e) {
				System.out.println("Erreur : " + e.getMessage());
			}
		return data;
	
	}
	public void afficherData () {
		for (int i = 0; i < data.size(); i++) {
			System.out.println(data.get(i));
			
		}
		
	}
	public void afficherFields () {
		for (int i = 0; i < fields.size(); i++) {
			System.out.println(fields.get(i));
			
		}
	}
	
	public void afficherMethods () {
		for (int i = 0; i < methods.size(); i++) {
			System.out.println(methods.get(i));
			
		}
	}
	public Vector<String> getData() {
		return data;
	}
	
	public Vector<String> getFields() {
		return fields;
	}
	
	public Vector<String> getMethods() {
		return methods;
	}
	
}
