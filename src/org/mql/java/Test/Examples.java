package org.mql.java.Test;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import org.mql.java.Models.XmlWriter;
import org.mql.java.Reflection.ProjectExplorer;
import org.mql.java.controller.XmlParser;
import org.mql.java.views.EntitiesPanel;
import org.mql.java.views.Entity;
public class Examples{
	public Examples() {
		exp04();
	}
	
	public void exp01() {
		String projectPath = "C:\\projects java\\Amarti riffi El mehdi - Reflection";
		 ProjectExplorer explorer = new ProjectExplorer();
	    explorer.projectExtractor(projectPath);
	  explorer.loadCLasses(projectPath);
	
	XmlWriter write = new  XmlWriter();
    write.writeXML(explorer.getResult(),explorer.getLoadedClasses());
    
	}

	public void exp02() {
		String projectPath = "C:\\projects java\\Amarti riffi El mehdi - Reflection";
		 ProjectExplorer explorer = new ProjectExplorer();
		    explorer.projectExtractor(projectPath);
		    Vector<String> data =  explorer.simpleNameCLasse(projectPath);
	//	EntitiesPanel e = new EntitiesPanel(data);
		JFrame frame = new JFrame(); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setContentPane(e);
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
	public void exp03() {
		String projectPath = "C:\\projects java\\Amarti riffi El mehdi - Reflection";
		XmlParser parse = new XmlParser();
		parse.parseClasses("C:\\projects java\\Amarti Riffi El mehdi - UML Diagrams Generator\\resources\\file.xml","Author");
        Entity e = new Entity("Author",parse.getFields(),parse.getMethods());
		JFrame frame = new JFrame("Entity  Example");
        frame.setSize(300, 400);
        frame.getContentPane().add(e);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
	}
	public void exp04() {
		String projectPath = "C:\\projects java\\Amarti riffi El mehdi - StringMapper";
		String filePath = "C:\\projects java\\Amarti Riffi El mehdi - UML Diagrams Generator\\resources\\file.xml";
		
		 ProjectExplorer explorer = new ProjectExplorer();
	    explorer.projectExtractor(projectPath);
	  explorer.loadCLasses(projectPath);
	  XmlWriter write = new  XmlWriter();
	    write.writeXML(explorer.getResult(),explorer.getLoadedClasses());
	  EntitiesPanel panelEntity = new EntitiesPanel(explorer.getLoadedClasses(), filePath);
	  JFrame frame = new JFrame("Diagramme de classe");
      frame.setSize(300, 400);
      frame.getContentPane().add(panelEntity);
      frame.pack();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
      
	 // System.out.println(explorer.simpleNameCLasse(projectPath));
	  //EntitiesPanel panel = new EntitiesPanel(explorer.)
		
	}
	
	
	public static void main(String[] args) {
	new Examples();
	}
}