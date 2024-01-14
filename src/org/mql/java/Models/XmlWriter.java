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
	public  void writeXML(Vector<String> result,Vector<String> data,ArrayList<Class<?>> loadedclass){
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
            org.w3c.dom.Element files= doc.createElement("classes");
            rootElement.appendChild(files);
            for (String f: data) {
            	 org.w3c.dom. Element name = doc.createElement("class");
               name.appendChild(doc.createTextNode(f));
                files.appendChild(name);
            }
            org.w3c.dom.Element fields= doc.createElement("fields");
            rootElement.appendChild(fields);
            for (int i = 0; i < loadedclass.size(); i++) {
            	  ClassExtractor extract = new ClassExtractor(loadedclass.get(i));
            	  Vector<String> fieldVector = extract.extractFields();
            	
            	  
            	  for (String field : fieldVector) {
            	        org.w3c.dom.Element fieldElement = doc.createElement("field");
            	        fieldElement.setAttribute("classeName", loadedclass.get(i).getSimpleName());
            	        fieldElement.appendChild(doc.createTextNode(field));
            	        fields.appendChild(fieldElement);
            	  }
            	}
            org.w3c.dom.Element methods= doc.createElement("methods");
            rootElement.appendChild(methods);
            for (int i = 0; i < loadedclass.size(); i++) {
          	  ClassExtractor extract = new ClassExtractor(loadedclass.get(i));
          	 Vector<String> methodVector = extract.extractMethods();
          	 for (String method : methodVector) {
     	        org.w3c.dom.Element methodElement = doc.createElement("method");
     	       methodElement.setAttribute("classeName", loadedclass.get(i).getSimpleName());
     	      methodElement.appendChild(doc.createTextNode(method));
     	       methods.appendChild(methodElement);
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

