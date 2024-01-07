package org.mql.java.Models;
import java.io.File;
import java.util.Vector;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Element;

public class XmlWriter {

	public XmlWriter() {
		
	}
	public  void writeXML(Vector<String> result,Vector<String> data){
		try {
            // Créer un nouveau document XML
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            org.w3c.dom.Document doc = dBuilder.newDocument();

            // Élément racine
            org.w3c.dom.Element rootElement = doc.createElement("liste");
            doc.appendChild(rootElement);
            
            
            org.w3c.dom.Element directories = doc.createElement("Directories");
            rootElement.appendChild(directories);
            for (String d: result) {
                Element name = doc.createElement("directory");
                name.appendChild(doc.createTextNode(d));
                directories.appendChild(name);
            }
            org.w3c.dom.Element files= doc.createElement("files");
            rootElement.appendChild(files);
            for (String f: data) {
            	 org.w3c.dom. Element name = doc.createElement("file");
               name.appendChild(doc.createTextNode(f));
                files.appendChild(name);
            }
            
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);

            // Spécifier le fichier de sortie
            StreamResult resultFile = new StreamResult(new File("C:\\projects java\\Amarti Riffi El mehdi - UML Diagrams Generator\\resources\\file.xml"));

            // Enregistrer le document dans le fichier XML
            transformer.transform(source, resultFile);

            System.out.println("Fichier XML créé avec succès!");
           
		}
		catch (Exception e) {
			System.out.println("l'erreur "+e.getMessage());
			
		}
	}
	
}

