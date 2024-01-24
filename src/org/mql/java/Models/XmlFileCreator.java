package org.mql.java.Models;

import java.io.File;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class XmlFileCreator {
	XmlDocumentBuilder write;

	public XmlFileCreator(XmlDocumentBuilder write) {
		this.write = write;

	}

	public void createXmlFile(String filePath) {
		try {

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(write.getDoc());
			StreamResult resultFile = new StreamResult(new File(filePath));
			transformer.transform(source, resultFile);

		} catch (

		Exception e) {
			System.out.println("l'erreur  dans la creation de fichier xml" + e.getMessage());
		}

	}

}
