package org.mql.java.Models;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.mql.java.Reflection.ClassExtractor;
import org.mql.java.Reflection.ProjectExplorer;
import org.w3c.dom.Element;

public class XmlWriter {

	public XmlWriter() {
	}
	public  void writeXML(Vector<String> result,ArrayList<Class<?>> loadedclass,String projectPath){
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
                Vector<Field> fieldVector = extract.extractFields();
                Vector<Method> methodVector = extract.extractMethods();
         	 for (Field field : fieldVector) {
     	        org.w3c.dom.Element fieldElement = doc.createElement("field");
     	        fieldElement.appendChild(doc.createTextNode(field.getName()));
     	        className.appendChild(fieldElement);
     	        	 fieldElement.setAttribute("type", field.getType().getSimpleName());
     	  }
       	 for (Method method : methodVector) {
            org.w3c.dom.Element methodElement = doc.createElement("method");
            methodElement.appendChild(doc.createTextNode(method.getName()));
            className.appendChild(methodElement);
             methodElement.setAttribute("typeretour", method.getReturnType().getSimpleName());
            	 }
            }
       	 	org.w3c.dom.Element elementRelations = doc.createElement("relations");
       	 	rootElement.appendChild(elementRelations);
   		 	ProjectExplorer explorer = new ProjectExplorer();
            explorer.projectExtractor(projectPath);
            explorer.extractHeritage(projectPath);
            explorer.extractComposition(projectPath);
            explorer.extractAgragation(projectPath);;
            HashMap<String, String> heritageMap =  explorer.getHeritageRelation();
            for (HashMap.Entry<String, String> entry : heritageMap.entrySet()) {
                org.w3c.dom.Element heritagerelations = doc.createElement("relationheritage");
                heritagerelations.setAttribute("fille", entry.getKey());
                heritagerelations.setAttribute("mere", entry.getValue());
                elementRelations.appendChild(heritagerelations);
            }
            HashMap<String, String> compositionMap =  explorer.getCompositionRelations();
            for (HashMap.Entry<String, String> elementsComposition : compositionMap.entrySet()) {
                org.w3c.dom.Element compositionRelations = doc.createElement("relationcomposition");
               compositionRelations.setAttribute("composée", elementsComposition.getKey());
                compositionRelations.setAttribute("composite", elementsComposition.getValue());
                elementRelations.appendChild(compositionRelations);
            }
            HashMap<String, String> agregationMap =  explorer.getAgregationRelations();
            for (HashMap.Entry<String, String> elementsAgreation : agregationMap.entrySet()) {
                org.w3c.dom.Element agregationRelations = doc.createElement("relationagregation");
               agregationRelations.setAttribute("agregée", elementsAgreation.getKey());
                agregationRelations.setAttribute("agregat", elementsAgreation.getValue());
                elementRelations.appendChild(agregationRelations);
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
	
