package org.mql.java.Reflection;
import java.io.File;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Vector;
public class ProjectExplorer {
	Vector<String > data ;
	ArrayList<Class<?>> loadedClasses;
	public Vector<String> getData() {
		return data;
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
			//	System.out.println("Classe chargée avec succès: " + loadedClass.getSimpleName());
			} catch (ClassNotFoundException | MalformedURLException e) {
				e.printStackTrace();
			}
		}

		// Convertir la liste en tableau avant de le retourner
		return loadedClasses.toArray(new Class[0]);//tableau de taille 0 qui stocke les noms de classe  s
	}

	private static URLClassLoader createClassLoader(String classPath) throws MalformedURLException {
		File file = new File(classPath);
		URL url = file.toURI().toURL();//Convertit le chemin de classe en une URL. Cela est nécessaire
		//)car le URLClassLoader s'attend à une URL pour charger les classes.
		return new URLClassLoader(new URL[]{url});//url et uri 
	}
	public void  extractRelationCLasses(String projectName) {

		Class<?> superClasse;
		Class<?>[] data = loadCLasses(projectName);

		// Héritage 
		for (int i = 0; i < data.length; i++) {
			if (data[i].getSuperclass() != null) {
				superClasse = data[i].getSuperclass();
				for (int j = 0; j < data.length; j++) {
					if (data[j].getSimpleName().equals(superClasse.getSimpleName())) {
						System.out.println("La classe : " + data[i].getSimpleName() + " hérite de la classe : " + superClasse.getSimpleName());
					}
				}
			} 
		}
		//implementation  interface
		
		//agregation 
		for (int i = 0; i < data.length; i++) {
			Field[] fields = data[i].getDeclaredFields();
			for(Field f : fields) {
				if(!f.getType().isPrimitive()) {
					for (int j = 0; j < data.length; j++) {
						if(data[j].getSimpleName().equals(f.getType().getSimpleName())) {
							System.out.println("relation d agregation entre  "+data[j].getSimpleName()+" et  "+f.getType().getSimpleName());				
						}
					}
				}
			}
		}
		//composition 
		
	}
	public Vector<String> simpleNameCLasse (String projectPath) {
     Class<?>[] loadedClass = loadCLasses(projectPath);
	   Vector<String> data = new  Vector<String>();
	   for (int i = 0; i < loadedClass.length; i++) {
		   data.add(loadedClass[i].getSimpleName());
		
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


}






