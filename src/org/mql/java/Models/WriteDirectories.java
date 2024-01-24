package org.mql.java.Models;

import java.util.Vector;

import org.w3c.dom.Element;

public class WriteDirectories {
	private XmlDocumentBuilder write;

	public WriteDirectories(XmlDocumentBuilder write) {
		this.write = write;

	}

	public void writeDirectories(Vector<String> result) {
		Element directories = write.getDoc().createElement("directories");
		write.getListe().appendChild(directories);
		for (String d : result) {
			Element name = write.getDoc().createElement("directory");
			name.appendChild(write.getDoc().createTextNode(d));
			directories.appendChild(name);
		}
	}

}
