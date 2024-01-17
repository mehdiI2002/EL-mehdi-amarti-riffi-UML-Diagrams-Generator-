package org.mql.java.views;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Window;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.mql.java.controller.XmlParser;
public class EntitiesPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	Vector<EntityInfo> info = new Vector<EntityInfo>();
	private String filePath;
	public EntitiesPanel() {
		
		
	}
	
	 public EntitiesPanel(ArrayList<Class<?>> classLoaded, String filePath) {
		this.filePath = filePath;
	        int nbr = classLoaded.size();
	        int cols = 3; // Spécifiez le nombre de colonnes souhaité
	        int rows = (int) Math.ceil((double) nbr / cols); // Calcul du nombre de lignes nécessaires
	        setLayout(new GridLayout(rows, cols,120,50));
	        for (int i = 0; i < classLoaded.size(); i++) {
	            XmlParser parse = new XmlParser();
	            parse.parseClasses(filePath, classLoaded.get(i).getSimpleName());
	            Entity e = new Entity(classLoaded.get(i).getSimpleName(), parse.getFields(), parse.getMethods());
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
	            window.repaint();
	        }  
	    }
	   public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}  
	   @Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        XmlParser parse = new XmlParser();
	        Vector<String> relation = parse.parseRelations(filePath);
	        //tableau
	        for (int i = 0; i <=relation.size()-2; i += 2) {
	            String childClassName = relation.get(i);
	            String parentClassName = relation.get(i+1);
	            EntityInfo childInfo = null;
	            EntityInfo parentInfo = null;
	            System.out.println("Trying to find Child: " + childClassName + " and Parent: " + parentClassName);
	            for (EntityInfo infoItem : info) {
	                if (infoItem.getEntityName().equals(childClassName)) {
	                    childInfo = infoItem;
	                } else if (infoItem.getEntityName().equals(parentClassName)) {
	                    parentInfo = infoItem;
	                }
	               
	            }
	            if (childInfo != null && parentInfo != null) {
	            	Point parentLocation = parentInfo.getPanel().getComponent(0).getLocation();
	            	Point childLocation = childInfo.getPanel().getComponent(0).getLocation();
	                g.setColor(Color.BLUE);
	                g.drawLine(parentLocation.x + parentInfo.getPanel().getComponent(0).getWidth() / 2,
	                        parentLocation.y + parentInfo.getPanel().getComponent(0).getHeight() / 2,
	                        childLocation.x + childInfo.getPanel().getComponent(0).getWidth() / 2,
	                        childLocation.y + childInfo.getPanel().getComponent(0).getHeight() / 2);
	              
	            }
	           
	        }
	    }
}
	   


	
	

