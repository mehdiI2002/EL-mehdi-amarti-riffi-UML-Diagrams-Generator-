package org.mql.java.views;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.util.ArrayList;
import javax.swing.JPanel;
import org.mql.java.controller.XmlParser;
public class EntitiesPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	 public EntitiesPanel(ArrayList<Class<?>> classLoaded, String filePath) {
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
	            add(entityPanel);
	        }
	    }

}
