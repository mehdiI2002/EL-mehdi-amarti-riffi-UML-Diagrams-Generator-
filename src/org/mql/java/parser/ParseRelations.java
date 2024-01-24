package org.mql.java.parser;

import java.util.HashMap;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class ParseRelations {
	private HashMap<String, String> heritgeRelation;
	private HashMap<String, String> compositionRelation;
	private HashMap<String, String> agregationRelation;
	private XmlParser parse;

	public ParseRelations(XmlParser parse) {
		heritgeRelation = new HashMap<String, String>();
		compositionRelation = new HashMap<String, String>();
		agregationRelation = new HashMap<String, String>();
		this.parse = parse;

	}

	public void parseRelations(String filePath) {
		NodeList relationsNodes = parse.getRootElement().getElementsByTagName("relations");
		for (int i = 0; i < relationsNodes.getLength(); i++) {
			Element relationsElement = (Element) relationsNodes.item(i);
			NodeList relationNodes = relationsElement.getChildNodes();
			for (int j = 0; j < relationNodes.getLength(); j++) {
				Element relationElement = (Element) relationNodes.item(j);
				String relationType = relationElement.getNodeName();
				if (relationType.equals("relationheritage")) {
					String mere = relationElement.getAttribute("mere");
					String fille = relationElement.getAttribute("fille");
					heritgeRelation.put(fille, mere);
				} else if (relationType.equals("relationcomposition")) {
					String composite = relationElement.getAttribute("composite");
					String composee = relationElement.getAttribute("composée");
					compositionRelation.put(composee, composite);
				} else if (relationType.equals("relationagregation")) {
					String agregat = relationElement.getAttribute("agregat");
					String agregée = relationElement.getAttribute("agregée");
					agregationRelation.put(agregée, agregat);
				}
			}
		}
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

}
