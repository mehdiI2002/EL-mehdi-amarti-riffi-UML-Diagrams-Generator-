package org.mql.java.Test;
import org.mql.java.Models.XmlWriter;
import org.mql.java.Reflection.ProjectExplorer;
public class Examples {
	public Examples() {
		exp01();
	}
	public void exp01() {
		 ProjectExplorer explorer = new ProjectExplorer();
	    explorer.projectExtractor("C:\\projects java\\AmartiRiffi_El Mehdi_Generics");
	    explorer.extractAll();
	  XmlWriter write = new  XmlWriter();
			  write.writeXML(explorer.getResult(),explorer.getData());
	}
	
	
	public static void main(String[] args) {
	new Examples();
	}
}