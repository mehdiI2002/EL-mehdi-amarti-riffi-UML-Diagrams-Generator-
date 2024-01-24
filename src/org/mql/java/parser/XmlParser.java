package org.mql.java.parser;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XmlParser {

	private Document document;
	private Element rootElement;

	public XmlParser(String source) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			File xmlFile = new File(source);
			this.document = builder.parse(xmlFile);
			this.rootElement = document.getDocumentElement();
		} catch (Exception e) {
			System.out.println("erreur dans parseur" + e.getMessage());
		}

	}

	public Document getDocument() {
		return document;
	}

	public Element getRootElement() {
		return rootElement;
	}

}
