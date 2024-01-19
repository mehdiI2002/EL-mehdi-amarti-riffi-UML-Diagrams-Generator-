package org.mql.java.views;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Vector;

import org.mql.java.parser.XmlParser;

public class DrawRelations {
	private Vector<String> relation;
	private String filePath;
public DrawRelations( String filePath) {
	this.filePath = filePath;
	 XmlParser parse1 = new XmlParser();
     relation = parse1.parseRelations(filePath);
     
}
	public Vector<String> getRelation() {
	return relation;
}
public String getFilePath() {
	return filePath;
}
	public void drawRelation( Graphics g) {
	    System.out.println("Dessiner les relations");
	    EntitiesPanel e = new EntitiesPanel();
	    Vector<EntityInfo> info = e.getInfo();
	    EntityInfo childInfo = null;
	    EntityInfo parentInfo = null;
	    String childClassName = null;
	    String parentClassName = null;

	    for (int i = 0; i <= relation.size() - 2; i += 2) {
	        childClassName = relation.get(i);
	        parentClassName = relation.get(i + 1);
	        System.out.println("Trying to find Child: " + childClassName + " and Parent: " + parentClassName);

	        for (EntityInfo infoItem : info) {
	            if (childClassName.equals(infoItem.getEntityName())) {
	                childInfo = infoItem;
	            } else if (parentClassName.equals(infoItem.getEntityName())) {
	                parentInfo = infoItem;
	            }
	        }
	        if (childInfo != null && parentInfo != null) {
	            Point parentLocation = ((Container) parentInfo.getPanel().getComponent(0)).getLocation();
	            Point childLocation = ((Container) childInfo.getPanel().getComponent(0)).getLocation();
	            g.setColor(Color.BLUE);
	            g.drawLine(parentLocation.x + parentInfo.getPanel().getComponent(0).getWidth() / 2,
	                    parentLocation.y + parentInfo.getPanel().getComponent(0).getHeight() / 2,
	                    childLocation.x + childInfo.getPanel().getComponent(0).getWidth() / 2,
	                    childLocation.y + childInfo.getPanel().getComponent(0).getHeight() / 2);
	        }
	    }
   }
}