package org.mql.java.Reflection;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;
public class ProjectExplorer {
	 private Vector<String > data ;
	 private ArrayList<Class<?>> loadedClasses;
	 private Vector<Class<?>> relations;
	 private Vector<String> attributs ;
	 private Vector<String > result;
	 private Vector<File> pathClasses;
	 private HashMap<String, String>  agregationRelations;
	 private HashMap<String, String>  compositionRelations;
	 private HashMap<String,String>  heritageRelation;
public HashMap<String, String> getAgregationRelations() {
		return agregationRelations;
	}

	public HashMap<String, String> getCompositionRelations() {
		return compositionRelations;
	}

	public HashMap<String, String> getHeritageRelation() {
		return heritageRelation;
	}

public ProjectExplorer() {
		data = new Vector<String>();
		result = new Vector<>();
		pathClasses = new Vector<File>();
		attributs = new Vector<String>();
		relations = new Vector<>();
		loadedClasses = new ArrayList<>();
		agregationRelations= new HashMap<>();
		compositionRelations = new HashMap<>();
		heritageRelation = new HashMap<>();
	}
	
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
	}    
	public  Class<?>[] loadCLasses(String projectPath) {
		
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
	public Vector<Class<?>> extractHeritage(String projectName) {
	    Class<?>[] classes = loadCLasses(projectName);
	    for (int i = 0; i < classes.length; i++) {
	        Class<?> superClass = classes[i].getSuperclass();
	        if (superClass != null && !superClass.equals(Object.class) && !superClass.getName().startsWith("java.")) {
	            for (int j = 0; j < classes.length; j++) {
	                if (!classes[j].getName().startsWith("java.") && verifierHeritage(superClass, classes[j])) {
	                	String key = classes[j].getSimpleName();
	                	String value = superClass.getSimpleName();
	                    heritageRelation.put(key, value);
	                                    
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
	public  void  extractAgragation(String projectName) {
		Class<?>[] classes = loadCLasses(projectName);
		for (int i = 0; i < classes.length; i++) {
			Field fields[] = classes[i].getDeclaredFields();
			for(Field f : fields) {
				if(!f.getType().isPrimitive() && !f.getType().getName().startsWith("java") &&  !Object[].class.equals(f.getType())
						&& !Object.class.equals(f.getType())){
					 String key =  f.getType().getSimpleName();
	                    String value =   classes[i].getSimpleName();
	                    agregationRelations.put(key, value);
				}
				
			}
			
		}
	}
	public void extractComposition(String projectName) {
		Class<?>[] classes = loadCLasses(projectName);
		for (int i = 0; i < classes.length; i++) {
			Field fields[] = classes[i].getDeclaredFields();
			for(Field f : fields) {
						 int modifiers = f.getModifiers();
			 if(!f.getType().isPrimitive() && !f.getType().getName().startsWith("java") &&  !Object[].class.equals(f.getType())
						&& !Object.class.equals(f.getType())){
				 if(Modifier.isFinal(modifiers)) {
					 String key =f.getType().getSimpleName();
					 String value =classes[i].getSimpleName();
					  compositionRelations.put(key,value);
				 }
			 }

		   }
		
	}
	}
public void afficheAgregation() {
	for (HashMap.Entry<String, String> entry : agregationRelations.entrySet()) {
        System.out.println(" Agregation Clé : " + entry.getKey() + ", Valeur : " + entry.getValue());
    }
}
public void afficheComposition() {
	for (HashMap.Entry<String, String> entry : compositionRelations.entrySet()) {
        System.out.println(" Composition Clé : " + entry.getKey() + ", Valeur : " + entry.getValue());
}
}
public void afficheheritage() {
	for (HashMap.Entry<String, String> entry : heritageRelation.entrySet()) {
        System.out.println(" fille : " + entry.getKey() + ", mere : " + entry.getValue());
}
}
}
	
		

	
  
		   
		    
	
	   
	   
   
	










