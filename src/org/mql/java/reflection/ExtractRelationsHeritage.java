package org.mql.java.reflection;

import java.util.ArrayList;
import java.util.HashMap;

public class ExtractRelationsHeritage {

	private String projectName;
	ArrayList<Class<?>> loadedClasses;
	private HashMap<String, String> heritageRelation;

	public ExtractRelationsHeritage(String projectName, ArrayList<Class<?>> loadedClasses) {
		this.projectName = projectName;
		this.loadedClasses = loadedClasses;
		heritageRelation = new HashMap<String, String>();
	}

	public void extractHeritage() {
		ArrayList<Class<?>> classes = loadedClasses;
		for (int i = 0; i < classes.size(); i++) {
			Class<?> superClass = classes.get(i).getSuperclass();
			if (superClass != null && !superClass.equals(Object.class) && !superClass.getName().startsWith("java.")) {
				for (int j = 0; j < classes.size(); j++) {
					if (!classes.get(j).getName().startsWith("java.") && verifierHeritage(superClass, classes.get(j))) {
						String key = classes.get(j).getSimpleName();
						String value = superClass.getSimpleName();
						heritageRelation.put(key, value);

					}
				}
			}
		}

	}

	private boolean verifierHeritage(Class<?> mereClass, Class<?> filleClass) {
		Class<?> mere = filleClass.getSuperclass();
		return mere != null && mere.equals(mereClass);
	}

	public String getProjectName() {
		return projectName;
	}

	public HashMap<String, String> getHeritageRelation() {
		return heritageRelation;
	}
}
