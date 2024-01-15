package org.mql.java.Models;
import java.io.File;
import java.util.ArrayList;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.mql.java.Reflection.ClassExtractor;
import org.w3c.dom.Element;

public class XmlWriter {

	public XmlWriter() {
		
	}
	public  void writeXML(Vector<String> result,ArrayList<Class<?>> loadedclass){
		try {
         
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            org.w3c.dom.Document doc = dBuilder.newDocument();
            org.w3c.dom.Element rootElement = doc.createElement("liste");
            doc.appendChild(rootElement);
            
            
            org.w3c.dom.Element directories = doc.createElement("Directories");
            rootElement.appendChild(directories);
            for (String d: result) {
                Element name = doc.createElement("directory");
                name.appendChild(doc.createTextNode(d));
                directories.appendChild(name);
            }
            org.w3c.dom.Element classesName= doc.createElement("classes");
            rootElement.appendChild(classesName);
            for (int i = 0; i < loadedclass.size(); i++) {
            	 org.w3c.dom. Element className = doc.createElement("class");
            	 className.setAttribute("className", loadedclass.get(i).getSimpleName());
               classesName.appendChild(className);
               ClassExtractor extract = new ClassExtractor(loadedclass.get(i));
         	  Vector<String> fieldVector = extract.extractFields();
         	 Vector<String> methodVector = extract.extractMethods();
         	 for (String field : fieldVector) {
     	        org.w3c.dom.Element fieldElement = doc.createElement("field");
     	        fieldElement.appendChild(doc.createTextNode(field));
     	        className.appendChild(fieldElement);
     	  }
       	 for (String method : methodVector) {
            org.w3c.dom.Element methodElement = doc.createElement("method");
          methodElement.appendChild(doc.createTextNode(method));
          className.appendChild(methodElement);
            	 }
            }
           
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult resultFile = new StreamResult(new File("C:\\projects java\\Amarti Riffi El mehdi - UML Diagrams Generator\\resources\\file.xml"));
            transformer.transform(source, resultFile);
            System.out.println("Fichier XML créé avec succès!");
		}
		catch (Exception e) {
			System.out.println("l'erreur "+e.getMessage());
		}
	}
	
}
	
