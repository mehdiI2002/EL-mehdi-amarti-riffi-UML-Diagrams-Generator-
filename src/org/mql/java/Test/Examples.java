package org.mql.java.Test;
import java.util.Vector;

import javax.swing.JFrame;

import org.mql.java.Models.XmlWriter;
import org.mql.java.Reflection.ProjectExplorer;
import org.mql.java.views.EntitiesPanel;
public class Examples {
	public Examples() {
		exp02();
	}
	public void exp01() {
		 ProjectExplorer explorer = new ProjectExplorer();
	    explorer.projectExtractor("C:\\projects java\\AmartiRiffi_El Mehdi_Generics");
	    explorer.extractAll();
	    explorer.extractRelationCLasses("C:\\projects java\\AmartiRiffi_El Mehdi_Generics");
	// explorer.afficher("C:\\projects java\\AmartiRiffi_El Mehdi_Generics");
	
	XmlWriter write = new  XmlWriter();
    write.writeXML(explorer.getResult(),explorer.getData());
	}
	public void exp02() {
		 ProjectExplorer explorer = new ProjectExplorer();
		    explorer.projectExtractor("C:\\projects java\\AmartiRiffi_El Mehdi_Generics");
		    Vector<String> data =  explorer.simpleNameCLasse("C:\\projects java\\AmartiRiffi_El Mehdi_Generics");
		EntitiesPanel e = new EntitiesPanel(data);
		JFrame frame = new JFrame(); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(e);
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
	new Examples();
	}
}