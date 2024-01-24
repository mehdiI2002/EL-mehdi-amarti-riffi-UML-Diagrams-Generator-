package org.mql.java.reflection;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Vector;

public class ClassLoader {
	private ArrayList<Class<?>> loadedClasses;

	public ClassLoader() {
		loadedClasses = new ArrayList<>();
	}

	public Class<?>[] loadCLasses(String projectPath, Vector<File> pathClasses) {
		for (File path : pathClasses) {
			try {
				String classPath = path.getAbsolutePath();
				String className = classPath.replace(projectPath + "\\bin\\", "");
				String qualifiedClassName = className.replace(File.separator, ".").replace(".class", "");
				URLClassLoader classLoader = createClassLoader(projectPath + "\\bin\\");
				Class<?> loadedClass = classLoader.loadClass(qualifiedClassName);
				loadedClasses.add(loadedClass);
			} catch (ClassNotFoundException | MalformedURLException e) {
				e.printStackTrace();
			}
		}
		return loadedClasses.toArray(new Class[0]);
	}

	public ArrayList<Class<?>> getLoadedClasses() {
		return loadedClasses;
	}

	private static URLClassLoader createClassLoader(String classPath) throws MalformedURLException {
		File file = new File(classPath);
		URL url = file.toURI().toURL();
		return new URLClassLoader(new URL[] { url });
	}

}
