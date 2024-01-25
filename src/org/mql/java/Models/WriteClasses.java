package org.mql.java.Models;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Vector;

import org.mql.java.reflection.ClassExtractor;
import org.w3c.dom.Element;

public class WriteClasses {
	private XmlDocumentBuilder write;

	public WriteClasses(XmlDocumentBuilder write) {
		this.write = write;

	}

	public void writeClasses(ArrayList<Class<?>> loadedClass) {
		Element classesName = write.getDoc().createElement("classes");
		write.getListe().appendChild(classesName);
		for (int i = 0; i < loadedClass.size(); i++) {
			Element className = write.getDoc().createElement("class");
			className.setAttribute("classname", loadedClass.get(i).getSimpleName());
			classesName.appendChild(className);
			ClassExtractor extract = new ClassExtractor(loadedClass.get(i));
			Vector<Field> fieldVector = extract.extractFields();
			Vector<Method> methodVector = extract.extractMethods();
			for (Field field : fieldVector) {
				writeMembersClass(write, "field", field.getName(), className, "type", field.getType().getSimpleName());
			}
			for (Method method : methodVector) {
				writeMembersClass(write, "method", method.getName(), className, "typeretour",
						method.getReturnType().getSimpleName());
			}

		}

	}

	private void writeMembersClass(XmlDocumentBuilder write, String baliseName, String baliseContenu,
			Element parentElement, String nameAttribute, String typeAttribute) {
		Element memberElement = write.getDoc().createElement(baliseName);
		memberElement.appendChild(write.getDoc().createTextNode(baliseContenu));
		parentElement.appendChild(memberElement);
		memberElement.setAttribute(nameAttribute, typeAttribute);

	}

}
