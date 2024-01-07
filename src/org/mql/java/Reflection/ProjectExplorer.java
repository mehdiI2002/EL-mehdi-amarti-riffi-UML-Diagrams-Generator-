package org.mql.java.Reflection;
import java.io.File;
import java.util.Vector;

public class ProjectExplorer {
	Vector<String > data ;
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
		File projectFile = new File(projectPath,"src");
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
	       // System.out.println("Files: "+pathClasses );
	        
	  
	    }
}
	/*public void projectRelationClass() {
		 for(File path : pathClasses) {
				try {
					String filePath = path.getAbsolutePath();
					String relativePath = filePath.replace("C:\\projects java\\AmartiRiffi_El Mehdi_Generics\\src\\", "");
					String qualifiedClassName =  relativePath
	                        .replace(File.separator, ".")
	                        .replace(".java", "") ;
					
					
					Class <?> c1 = Class.forName(qualifiedClassName);
			if(c1.getSuperclass() == null) {
                System.out.println("la classe object comme classe mere ");
                }
			else {
				System.out.println("la classe:"+c1.getName()+"herite de la classe:"+c1.getSuperclass().getName());
			}
				}
			 catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
		 }
		
	 }*/
	

