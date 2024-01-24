package org.mql.java.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;

public class ExtractRelationsComposition {
	private String projectName;
	ArrayList<Class<?>> loadedClasses;
	HashMap<String, String> compositionRelations;

	public ExtractRelationsComposition(String projectName, ArrayList<Class<?>> loadedClasses) {
		this.projectName = projectName;
		this.loadedClasses = loadedClasses;
		compositionRelations = new HashMap<String, String>();

	}

	public void extractComposition() {
		ArrayList<Class<?>> classes = loadedClasses;
		for (int i = 0; i < classes.size(); i++) {
			Field fields[] = classes.get(i).getDeclaredFields();
			for (Field f : fields) {
				int modifiers = f.getModifiers();
				if (!f.getType().isPrimitive() && !f.getType().getName().startsWith("java")
						&& !Object[].class.equals(f.getType()) && !Object.class.equals(f.getType())) {
					if (Modifier.isFinal(modifiers)) {
						String key = f.getType().getSimpleName();
						String value = classes.get(i).getSimpleName();
						compositionRelations.put(key, value);
					}
				}

			}

		}
	}

	public ArrayList<Class<?>> getLoadedClasses() {
		return loadedClasses;
	}

	public HashMap<String, String> getCompositionRelations() {
		return compositionRelations;
	}

	public String getProjectName() {
		return projectName;
	}

}
