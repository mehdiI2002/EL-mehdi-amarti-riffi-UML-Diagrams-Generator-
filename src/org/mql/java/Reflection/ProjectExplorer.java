package org.mql.java.Reflection;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Vector;
public class ProjectExplorer {
	Vector<String > data ;
	ArrayList<Class<?>> loadedClasses;
	Vector<Class<?>> relations = new Vector<>();
	
	public Vector<String> getData() {
		return data;
	}
	public Vector<Class<?>> getRelations() {
		return relations;
	}
	public void setRelations(Vector<Class<?>> relations) {
		this.relations = relations;
	}
	public void setData(Vector<String> data) {
		this.data = data;
	}
	public Vector<String> getResult() {
		return result;
	}
	public void setResult(Vector<String> result) {
		this.result = result;
	}
	Vector<String > result;
	Vector<File> pathClasses;
	public ProjectExplorer() {
		data = new Vector<String>();
		result = new Vector<>();
		pathClasses = new Vector<File>();
		//relations = new Vector<ClassRelation>();
	}
	public void  projectExtractor(String projectPath) {
		File projectFile = new File(projectPath,"bin");
		extractDiretories(projectFile);
	}
	public void  extractDiretories( File fileDirectory) {
		result.add(fileDirectory.getName());
		File[] files = fileDirectory.listFiles();

		for (File file : files) {
			if(file.isDirectory()) {
				extractDiretories(file);	
			}
			else{
				data.add(file.getName());
				pathClasses.add(file);
			}
		}
	} 
	public void extractAll() {
		System.out.println("Directories: " + result);
		System.out.println("Files: " + data);
		System.out.println("paths: "+pathClasses );
       //System.out.println("relations:"+ relations);

	}    
	public  Class<?>[] loadCLasses(String projectPath) {
		 loadedClasses = new ArrayList<>();
		for (File path : pathClasses) {
			try {
				String classPath = path.getAbsolutePath();
				String className = classPath.replace(projectPath + "\\bin\\", "");
				String qualifiedClassName = className
						.replace(File.separator, ".")
						.replace(".class", "");
				URLClassLoader classLoader = createClassLoader(projectPath + "\\bin\\");
				Class<?> loadedClass = classLoader.loadClass(qualifiedClassName);
				loadedClasses.add(loadedClass);
			} catch (ClassNotFoundException | MalformedURLException e) {
				e.printStackTrace();
			}
		}
		return loadedClasses.toArray(new Class[0]);
	}

	private static URLClassLoader createClassLoader(String classPath) throws MalformedURLException {
		File file = new File(classPath);
		URL url = file.toURI().toURL();
		return new URLClassLoader(new URL[]{url});
	}
	public Vector<Class<?>> extractHeritageRelation(String projectName) {
	    Class<?>[] classes = loadCLasses(projectName);
	    for (int i = 0; i < classes.length; i++) {
	        Class<?> superClass = classes[i].getSuperclass();
	        if (superClass != null && !superClass.equals(Object.class) && !superClass.getName().startsWith("java.")) {
	            for (int j = 0; j < classes.length; j++) {
	                if (!classes[j].getName().startsWith("java.") && verifierHeritage(superClass, classes[j])) {
	                                  	relations.add(superClass);
	                                	relations.add(classes[j]);      
	                } 
	            }
	        }
	    }
	    return relations;
	}	
	public boolean verifierHeritage(Class<?> mereClass, Class<?> filleClass) {
	    Class<?> mere = filleClass.getSuperclass();
	    return mere != null && mere.equals(mereClass);
	}
	public Vector<String> simpleNameCLasse (String projectPath) {
     Class<?>[] loadedClass = loadCLasses(projectPath);
	   Vector<String> data = new  Vector<String>();
	   for (int i = 0; i < loadedClass.length; i++) {
		   data.add(loadedClass[i].getName());
		
	}
	   return data;
	}
	public void afficher (String projectName) {
		Class<?>[] data = loadCLasses(projectName);
		for (int i = 0; i < data.length; i++) {
			System.out.println(data[i]);

		}

	}
	public ArrayList<Class<?>> getLoadedClasses() {
		return loadedClasses;
	}
	public void setLoadedClasses(ArrayList<Class<?>> loadedClasses) {
		this.loadedClasses = loadedClasses;
	}
	public void afficheChemin() {
		for (int i = 0; i < pathClasses.size(); i++) {
			System.out.println(pathClasses.get(i));
			
		}
	}



}






