package org.mql.java.Test;
import java.awt.BorderLayout;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import org.mql.java.Models.XmlWriter;
import org.mql.java.Reflection.ProjectExplorer;
import org.mql.java.controller.XmlParser;
import org.mql.java.views.EntitiesPanel;
import org.mql.java.views.Entity;
import org.mql.java.views.FirstInterface;
public class Examples{
	public Examples() {
		exp05();
	}
	public void exp01() {
		String projectPath = "C:\\projects java\\AmartiRiffi_El Mehdi_Generics";
		 ProjectExplorer explorer = new ProjectExplorer();
	   explorer.projectExtractor(projectPath);
	explorer.extractHeritageRelation(projectPath);
	XmlParser parse = new XmlParser();
	parse.parseRelations("C:\\projects java\\Amarti Riffi El mehdi - UML Diagrams Generator\\resources\\file.xml");
	parse.afficherRelations();
  XmlWriter write = new  XmlWriter();
	   write.writeXML(explorer.getResult(),explorer.getLoadedClasses());
	}
	public void exp02() {
		String projectPath = "C:\\projects java\\Amarti Riffi El mehdi - JUnit";
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
		String projectPath = "C:\\projects java\\Amarti Riffi El mehdi - JUnit";
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
		String projectPath = "C:\\projects java\\AmartiRiffi_El Mehdi_Generics";
		String filePath = "C:\\projects java\\Amarti Riffi El mehdi - UML Diagrams Generator\\resources\\file.xml";
		 ProjectExplorer explorer = new ProjectExplorer();
	    explorer.projectExtractor(projectPath);
	  explorer.loadCLasses(projectPath);
	  XmlWriter write = new  XmlWriter();
	    write.writeXML(explorer.getResult(),explorer.getLoadedClasses());
	  EntitiesPanel panelEntity = new EntitiesPanel(explorer.getLoadedClasses(), filePath);
	   
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
	public void exp05() {
		FirstInterface interfaceF = new FirstInterface();
	}
	public void exp06() {
		String projectPath = "C:\\projects java\\AmartiRiffi_El Mehdi_Generics";
		 ProjectExplorer explorer = new ProjectExplorer();
	   explorer.projectExtractor(projectPath);
	explorer.extractHeritageRelation(projectPath);
 XmlWriter write = new  XmlWriter();
	   write.writeXML(explorer.getResult(),explorer.getLoadedClasses());
		String filePath = "C:\\projects java\\Amarti Riffi El mehdi - UML Diagrams Generator\\resources\\file.xml";
		XmlParser parse = new XmlParser();
		
		System.out.println(parse.getRelations());
		//explorer.extractHeritageRelation(projectPath);
	}
	
	
	public static void main(String[] args) {
	new Examples();
	}
}