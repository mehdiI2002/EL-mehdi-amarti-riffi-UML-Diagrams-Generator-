package org.mql.java.Models;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XmlDocumentBuilder {
	private Element liste;
	private Document doc;

	public XmlDocumentBuilder() {
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			this.doc = dBuilder.newDocument();
			this.liste = doc.createElement("liste");
			this.doc.appendChild(this.liste);
		} catch (Exception e) {
			System.out.println("erreur d ecriture xml " + e.getMessage());
		}
	}

	public Element getListe() {
		return liste;
	}

	public Document getDoc() {
		return doc;
	}

}
