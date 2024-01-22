package org.mql.java.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import org.mql.java.parser.XmlParser;
public class EntitiesPanelBorder extends JPanel {
	private static final long serialVersionUID = 1L;
	private String filePath;
	 String projectPath = "";
	 HashMap<String, String>  heritageMembers ;
	 HashMap<Entity, Point> entity = new HashMap<>();
public EntitiesPanelBorder(ArrayList<Class<?>> classLoaded, String filePath,String projectPath) {
	    this.projectPath = projectPath;
		this.filePath = filePath;
		setLayout(new BorderLayout());
		JPanel panelContaining = new JPanel();
        panelContaining.setLayout(new BoxLayout(panelContaining, BoxLayout.Y_AXIS));
	    setBackground(Color.RED);
	    XmlParser parse = new XmlParser();
	    heritageMembers = parse.getHeritgeRelation();
	        for (int i = 0; i < classLoaded.size()-1; i+=2) {	  
	            XmlParser parse1 = new XmlParser();
	            XmlParser parse2 = new XmlParser();
	            
	            parse1.parseClasse(filePath, classLoaded.get(i).getSimpleName());
	            parse2.parseClasse(filePath, classLoaded.get(i+1).getSimpleName());
	            Entity e1 = new Entity(classLoaded.get(i).getSimpleName(), parse1.getFields(), parse1.getMethods(),parse1.getTypefields(),parse1.getTypeMethods());
	            Entity e2 = new Entity(classLoaded.get(i+1).getSimpleName(), parse2.getFields(), parse2.getMethods(),parse2.getTypefields(),parse2.getTypeMethods());
	         
	
	            JPanel entityPanel = new JPanel();
	            entityPanel.setLayout(new BorderLayout());
	            entityPanel.add(e1,BorderLayout.EAST);
	            entityPanel.add(e2,BorderLayout.WEST);
	           
	          // entityPanel.add(relation,BorderLayout.CENTER);
	            
	            panelContaining.add(entityPanel);
	            add(panelContaining);
	          
	        }
}

public void paint(ArrayList<Class<?>> classLoaded) {
	XmlParser parse = new XmlParser();
	parse.parseRelations(filePath);
	
	 
	    for (HashMap.Entry<String, String> entry : heritageMembers.entrySet()) {
	    	for (int i = 0; i < classLoaded.size(); i++) {
	    		if(entry.getKey().equals(classLoaded.get(i).getSimpleName())){
	    			
	    			
	    		}
				
			}
	    }
	
}
public String getFilePath() {
	return filePath;
}
public void setFilePath(String filePath) {
	this.filePath = filePath;
}
public String getProjectPath() {
	return projectPath;
}
public void setProjectPath(String projectPath) {
	this.projectPath = projectPath;
}

}
