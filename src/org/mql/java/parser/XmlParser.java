package org.mql.java.parser;

import java.io.File;
import java.util.HashMap;
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
	private HashMap<String,String> heritgeRelation;
	private HashMap<String, String> compositionRelation;
	private HashMap<String, String> agregationRelation;
	private Vector<String> directories ;
	public XmlParser() {
		data = new Vector<String>();
		fields = new Vector<String>();
		methods = new Vector<String>();
		relations = new Vector<String>();
		typefields = new Vector<String>();
		typeMethods = new Vector<String>();
		heritgeRelation = new HashMap<String, String>();
		compositionRelation = new HashMap<String, String>();
		agregationRelation  = new HashMap<String, String>();
		directories = new Vector<String>();
		
		
		
	}
	
	public   void parseClasse(String source,String className) {
		try {
			  DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	          DocumentBuilder builder = factory.newDocumentBuilder();
	          File xmlFile = new File(source);
	          org.w3c.dom.Document document = builder.parse(xmlFile);
	          Element  rootElement = document.getDocumentElement();
			    
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
			 e.printStackTrace(); 
			 System.out.println("Erreur : " + e.getMessage());
			}
	}
	public Vector<String> getTypefields() {
		return typefields;
	}
	public void parseRelations(String source ) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	          DocumentBuilder builder = factory.newDocumentBuilder();
	          File xmlFile = new File(source);
	          org.w3c.dom.Document document = builder.parse(xmlFile);
	          Element  rootElement = document.getDocumentElement();
		      NodeList relationsNodes = rootElement.getElementsByTagName("relations");
		      for (int i = 0; i < relationsNodes.getLength(); i++) {
             Element relationsElement = (Element) relationsNodes.item(i);
             NodeList relationNodes = relationsElement.getChildNodes();
             for (int j = 0; j < relationNodes.getLength(); j++) {
                     Element relationElement = (Element) relationNodes.item(j);
                     String relationType = relationElement.getNodeName();
                     if(relationType.equals("relationheritage")) {
                    	 String mere = relationElement.getAttribute("mere");
                         String fille = relationElement.getAttribute("fille");
                         heritgeRelation.put(fille, mere);
                     }
                     else if(relationType.equals("relationcomposition")) {
                         String composite = relationElement.getAttribute("composite");
                         String composee = relationElement.getAttribute("composée");
                         compositionRelation.put(composee, composite);  
                     }
                     else if( relationType.equals("relationagregation")) {
                         String agregat = relationElement.getAttribute("agregat");
                         String agregée = relationElement.getAttribute("agregée");
                         agregationRelation.put(agregée, agregat);
                     }
                 }
             }
		}
		catch (Exception e) {
			 e.printStackTrace();
			    System.out.println("Erreur : " + e.getMessage());
		}
	}
	public void parsePackages(String source) {
		try {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        File xmlFile = new File(source);
        org.w3c.dom.Document document = builder.parse(xmlFile);
        Element  rootElement = document.getDocumentElement();
	    NodeList directoriesNodes = rootElement.getElementsByTagName("Directories");
	    for (int i = 0; i < directoriesNodes.getLength(); i++) {
	    	Element directoriesElement = (Element)  directoriesNodes.item(i);
	       NodeList directoryList = directoriesElement.getChildNodes();
	       for (int j = 0; j < directoryList.getLength(); j++) {
	    	   Element relationElement = (Element) directoryList.item(j);
	    	   String directoryName = relationElement.getTextContent();
	    	   if(!directoryName.equals("bin")) {
	    	   directories.add(directoryName);
	    	   }
	       }
	    }
	      
		}
		catch(Exception e) {
			System.out.println("exception :"+ e.getMessage());
		}
	}
	public Vector<String> getRelations() {
		return relations;
	}
	public void setRelations(Vector<String> relations) {
		this.relations = relations;
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
	public Vector<String> getTypeMethods() {
		return typeMethods;
	}

	public HashMap<String, String> getHeritgeRelation() {
		return heritgeRelation;
	}

	public HashMap<String, String> getCompositionRelation() {
		return compositionRelation;
	}

	public HashMap<String, String> getAgregationRelation() {
		return agregationRelation;
	}

	public Vector<String> getDirectories() {
		return directories;
	}

	public void setDirectories(Vector<String> directories) {
		this.directories = directories;
	}
	
	
	
}
