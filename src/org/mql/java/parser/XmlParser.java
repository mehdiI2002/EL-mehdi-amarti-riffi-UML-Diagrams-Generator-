package org.mql.java.parser;

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
	private Vector<String> relations;
	private Vector<String> typefields;
	private Vector<String> typeMethods;
	public XmlParser() {
		data = new Vector<String>();
		fields = new Vector<String>();
		methods = new Vector<String>();
		relations = new Vector<String>();
		typefields = new Vector<String>();
		typeMethods = new Vector<String>();
}
	public Vector<String> parseClasses(String source,String className) {
		
		try {
			     DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	            DocumentBuilder builder = factory.newDocumentBuilder();
	            File xmlFile = new File(source);
	            org.w3c.dom.Document document = builder.parse(xmlFile);
	            Element rootElement = document.getDocumentElement();
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
	                        String typefield =((Element) childNode) .getAttribute("type");
	                        fields.add( fieldContent);
	                        typefields.add(typefield);
	                    }
	                }
	                      for (int k = 0; k < childNodes.getLength(); k++) {
	                	Node childNode = childNodes.item(k);
	                	        if ( childNode.getNodeName().equals("method")) {
		                        String methodContent = childNode.getTextContent();
		                        String typeMethod =((Element) childNode) .getAttribute("typeretour");
		                        methods.add( methodContent);
		                       typeMethods.add(typeMethod);
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
	public Vector<String> getTypefields() {
		return typefields;
	}
	public Vector<String> parseRelations(String source ) {
		try {
		 DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
         DocumentBuilder builder = factory.newDocumentBuilder();
         File xmlFile = new File(source);
         org.w3c.dom.Document document = builder.parse(xmlFile);
         Element rootElement = document.getDocumentElement();
		 NodeList relationNodes = rootElement.getElementsByTagName("relation");
         for (int i = 0; i < relationNodes.getLength(); i++) {
         	   Element relationElement= (Element) relationNodes.item(i); 
         	   String classeMere = relationElement. getAttribute("classfille");
         	   String classFille = relationElement.getAttribute("classmere");
         	 //  String typeRelation = relationElement.getAttribute("type");
         	   relations.add(classeMere);
         	   relations.add(classFille);
         	  // relations.add(typeRelation);
         }
         
	}
         catch (Exception e) {
 			System.out.println("erreur"+e.getMessage());
 		}
		return relations;
	}
	
	public Vector<String> getRelations() {
		return relations;
	}
	public void setRelations(Vector<String> relations) {
		this.relations = relations;
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
	public void afficherRelations() {
		for (int i = 0; i < relations.size(); i++) {
			System.out.println(relations.get(i));
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
	public void afficherTypeFields() {
		for (int i = 0; i < typefields.size(); i++) {
			System.out.println(typefields.get(i));
			
		}
	}
	public Vector<String> getTypeMethods() {
		return typeMethods;
	}
	
	
}
