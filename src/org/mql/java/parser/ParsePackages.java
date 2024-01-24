package org.mql.java.parser;

import java.util.Vector;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class ParsePackages {
	private XmlParser parse;
	private Vector<String> directories;

	public ParsePackages(XmlParser parse) {
		this.parse = parse;
		directories = new Vector<String>();

	}

	public void parsePackages() {
		NodeList directoriesNodes = parse.getRootElement().getElementsByTagName("directories");
		for (int i = 0; i < directoriesNodes.getLength(); i++) {
			Element directoriesElement = (Element) directoriesNodes.item(i);
			NodeList directoryList = directoriesElement.getChildNodes();
			for (int j = 0; j < directoryList.getLength(); j++) {
				Element relationElement = (Element) directoryList.item(j);
				String directoryName = relationElement.getTextContent();
				if (!directoryName.equals("bin")) {
					directories.add(directoryName);

				}
			}
		}
	}

	public Vector<String> getDirectories() {
		return directories;
	}
}
