package org.mql.java.reflection;

import java.io.File;
import java.util.Vector;

public class ProjectExplorer {
	private Vector<String> data;
	private Vector<String> result;
	private Vector<File> pathClasses;

	public ProjectExplorer() {
		data = new Vector<String>();
		result = new Vector<>();
		pathClasses = new Vector<File>();

	}

	public void projectExtractor(String projectPath) {
		File projectFile = new File(projectPath, "bin");
		extractDiretories(projectFile);
	}

	private void extractDiretories(File fileDirectory) {
		result.add(fileDirectory.getName());
		File[] files = fileDirectory.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				extractDiretories(file);
			} else {
				data.add(file.getName());
				pathClasses.add(file);
			}
		}
	}

	public Vector<String> getData() {
		return data;
	}

	public void setData(Vector<String> data) {
		this.data = data;
	}

	public Vector<String> getResult() {
		return result;
	}

	public Vector<File> getPathClasses() {
		return pathClasses;
	}

}
