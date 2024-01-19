package org.mql.java.views;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Window;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.mql.java.parser.XmlParser;
public class EntitiesPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	Vector<EntityInfo> info = new Vector<EntityInfo>();
	private String filePath;
	//private Vector<Stri	ng> relation;
	
	 DrawRelations relations ;
	 public EntitiesPanel(ArrayList<Class<?>> classLoaded, String filePath) {
		this.filePath = filePath;
		relations =  new DrawRelations(filePath);
	        int nbr = classLoaded.size();
	        int cols = 3; 
	        int rows = (int) Math.ceil((double) nbr / cols); 
	        setLayout(new GridLayout(rows, cols,120,50));
	        for (int i = 0; i < classLoaded.size(); i++) {
	            XmlParser parse = new XmlParser();
	            parse.parseClasses(filePath, classLoaded.get(i).getSimpleName());
	            Entity e = new Entity(classLoaded.get(i).getSimpleName(), parse.getFields(), parse.getMethods(),parse.getTypefields(),parse.getTypeMethods());
	            JPanel entityPanel = new JPanel();
	            entityPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
	            entityPanel.add(e);
	            entityPanel.setOpaque(false);
	            String name = classLoaded.get(i).getSimpleName();
	            add(entityPanel);
	            EntityInfo infos = new EntityInfo(name,entityPanel, i);
	            info.add(infos);
	        }
	       
	        
	        Window window = SwingUtilities.getWindowAncestor(this);
	        if (window != null) {
	            window.pack();
	        }  
	    }
	 public EntitiesPanel() {
		 
	 }
	 /*@Override
	public void  paintComponent(Graphics g) {
		super.paintComponent(g);
		relations.drawRelation(g); mn b3de w nrsme 
	}*/
	   public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public Vector<EntityInfo> getInfo() {
		return info;
	}
	public void setInfo(Vector<EntityInfo> info) {
		this.info = info;
	}  
	 
	
	    

	   	  
	
}
	   


	
	

