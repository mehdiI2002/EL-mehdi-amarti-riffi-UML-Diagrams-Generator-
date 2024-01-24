package org.mql.java.reflection;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;

public class ExtractAgregation {
	private String projectName;
	ArrayList<Class<?>> loadedClasses;
	private HashMap<String, String> agregationRelations;

	public ExtractAgregation(String projectName, ArrayList<Class<?>> loadedClasses) {
		this.projectName = projectName;
		this.loadedClasses = loadedClasses;
		agregationRelations = new HashMap<String, String>();

	}

	public void extractAgragation() {
		ArrayList<Class<?>> classes = loadedClasses;
		for (int i = 0; i < classes.size(); i++) {
			Field fields[] = classes.get(i).getDeclaredFields();
			for (Field f : fields) {
				if (!f.getType().isPrimitive() && !f.getType().getName().startsWith("java")
						&& !Object[].class.equals(f.getType()) && !Object.class.equals(f.getType())) {
					String key = f.getType().getSimpleName();
					String value = classes.get(i).getSimpleName();
					agregationRelations.put(key, value);
				}

			}

		}
	}

	public String getProjectName() {
		return projectName;
	}

	public HashMap<String, String> getAgregationRelations() {
		return agregationRelations;
	}

}
