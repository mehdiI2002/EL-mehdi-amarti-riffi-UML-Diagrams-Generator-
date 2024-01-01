package org.mql.java.Reflection;
import java.io.File;
import java.util.Vector;

public class ProjectExplorer {
	Vector<String > data ;
	Vector<String > result; 
	public ProjectExplorer() {
		data = new Vector<String>();
		result = new Vector<>();
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
				 
			 }
         
}
	} 
	 public void extractAll() {
	        System.out.println("Directories: " + result);
	        System.out.println("Files: " + data);
	    }
	
}

