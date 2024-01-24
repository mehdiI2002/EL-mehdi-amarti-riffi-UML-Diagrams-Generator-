package org.mql.java.Models;

import java.util.HashMap;

import org.mql.java.reflection.ClassLoader;
import org.mql.java.reflection.ExtractAgregation;
import org.mql.java.reflection.ExtractRelationsComposition;
import org.mql.java.reflection.ExtractRelationsHeritage;
import org.mql.java.reflection.ProjectExplorer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class WriteRelations {
	private XmlDocumentBuilder write;

	public WriteRelations(XmlDocumentBuilder write) {
		this.write = write;
	}

	public void writeRelations(String projectPath) {
		Element elementRelations = write.getDoc().createElement("relations");
		write.getListe().appendChild(elementRelations);
		ProjectExplorer explorer = new ProjectExplorer();
		explorer.projectExtractor(projectPath);
		ClassLoader load = new ClassLoader();
		load.loadCLasses(projectPath, explorer.getPathClasses());
		ExtractRelationsHeritage heritage = new ExtractRelationsHeritage(projectPath, load.getLoadedClasses());
		heritage.extractHeritage();
		HashMap<String, String> heritageMap = heritage.getHeritageRelation();
		ExtractRelationsComposition composition = new ExtractRelationsComposition(projectPath, load.getLoadedClasses());
		composition.extractComposition();
		extractRelation(write.getDoc(), elementRelations, heritageMap, "fille", "mere", "relationheritage");
		HashMap<String, String> compositionMap = composition.getCompositionRelations();
		extractRelation(write.getDoc(), elementRelations, compositionMap, "composée", "composite",
				"relationcomposition");
		ExtractAgregation agregation = new ExtractAgregation(projectPath, load.getLoadedClasses());
		agregation.extractAgragation();
		HashMap<String, String> agregationMap = agregation.getAgregationRelations();
		extractRelation(write.getDoc(), elementRelations, agregationMap, "agregée", "agregat", "relationagregation");

	}

	private void extractRelation(Document doc, Element elementRelations, HashMap<String, String> heritageMap,
			String leftRelation, String rigthRelation, String relationName) {
		for (HashMap.Entry<String, String> entry : heritageMap.entrySet()) {
			Element heritagerelations = doc.createElement(relationName);
			heritagerelations.setAttribute(leftRelation, entry.getKey());
			heritagerelations.setAttribute(rigthRelation, entry.getValue());
			elementRelations.appendChild(heritagerelations);
		}
	}

}
