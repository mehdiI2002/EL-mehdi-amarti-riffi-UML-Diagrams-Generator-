package org.mql.java.Test;
import java.awt.BorderLayout;
import java.awt.Menu;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import org.mql.java.Models.XmlWriter;
import org.mql.java.Reflection.ProjectExplorer;
import org.mql.java.parser.XmlParser;
import org.mql.java.views.EntitiesPanel;
import org.mql.java.views.FirstInterface;
import org.mql.java.views.GenratePackages;
import org.mql.java.views.Package;
public class Examples{
	public Examples() {
		exp06();
	}
	public void exp01() {
		String projectPath = "C:\\projects java\\AmartiRiffi_El Mehdi_Generics";
		String filePath = "C:\\projects java\\Amarti Riffi El mehdi - UML Diagrams Generator\\resources\\file.xml";
		 ProjectExplorer explorer = new ProjectExplorer();
	    explorer.projectExtractor(projectPath);
	  explorer.loadCLasses(projectPath);
	  XmlWriter write = new  XmlWriter();
	    write.writeXML(explorer.getResult(),explorer.getLoadedClasses(),projectPath);
	  EntitiesPanel panelEntity = new EntitiesPanel(explorer.getLoadedClasses(), filePath,projectPath);
	  JFrame frame = new JFrame("Diagramme de classe");
      frame.setSize(300, 400);
      frame.setLayout(new BorderLayout());
      JScrollPane scroll = new JScrollPane(panelEntity);
      scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
      frame.getContentPane().add(scroll,BorderLayout.CENTER);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
     frame. setExtendedState(JFrame.MAXIMIZED_BOTH);
     frame.setVisible(true);
	 // System.out.println(explorer.simpleNameCLasse(projectPath));
	  //EntitiesPanel panel = new EntitiesPanel(explorer.)
		
     
	}
	public void exp02() {
		FirstInterface interfaceF = new FirstInterface();
		
	}
public void exp03() {
	String projectPath = "C:\\projects java\\AmartiRiffi_El Mehdi_Generics";
	String filePath = "C:\\projects java\\Amarti Riffi El mehdi - UML Diagrams Generator\\resources\\file.xml";
	 ProjectExplorer explorer = new ProjectExplorer();
	 explorer.projectExtractor(projectPath);
	  explorer.loadCLasses(projectPath);
	  XmlWriter write = new  XmlWriter();
	    write.writeXML(explorer.getResult(),explorer.getLoadedClasses(),projectPath);
	    XmlParser parse = new XmlParser();
	    parse.parsePackages(filePath);
	    System.out.println(parse.getDirectories());
}
public void exp04() {
	Package p = new Package("hello");
	JFrame frame = new JFrame("Diagramme de classe");
    frame.setSize(300, 400);
    frame.setContentPane(p);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   frame. setExtendedState(JFrame.MAXIMIZED_BOTH);
   frame.setVisible(true);
}
public void exp05() {
	Package p = new Package("hello");
	JFrame frame = new JFrame("Diagramme de classe");
    frame.setSize(300, 400);
    frame.setContentPane(p);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   frame. setExtendedState(JFrame.MAXIMIZED_BOTH);
   frame.setVisible(true);
}
public void  exp06() {
	String projectPath = "C:\\projects java\\AmartiRiffi_El Mehdi_Generics";
	String filePath = "C:\\projects java\\Amarti Riffi El mehdi - UML Diagrams Generator\\resources\\file.xml";
	 ProjectExplorer explorer = new ProjectExplorer();
	 explorer.projectExtractor(projectPath);
	  explorer.loadCLasses(projectPath);
	  XmlWriter write = new  XmlWriter();
	    write.writeXML(explorer.getResult(),explorer.getLoadedClasses(),projectPath);
	    XmlParser parse = new XmlParser();
	     parse.parsePackages(filePath);
	    GenratePackages generate = new GenratePackages(parse.getDirectories(), filePath);
	    JFrame frame = new JFrame("Diagramme de classe");
	    frame.setSize(300, 400);
	    frame.setContentPane(generate);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   frame. setExtendedState(JFrame.MAXIMIZED_BOTH);
	   frame.setVisible(true);
}
public void exp07() {
	
	
	
}
	
	
	
	
	public static void main(String[] args) {
	  new Examples();
	}
}