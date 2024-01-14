package org.mql.java.views;
import java.awt.LayoutManager;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import org.mql.java.controller.XmlParser;
public class EntitiesPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	public EntitiesPanel(ArrayList<Class<?>> classLoaded,String filePath) {
		 setLayout((LayoutManager) new BoxLayout(this, BoxLayout.X_AXIS)); 
		for (int i = 0; i < classLoaded.size(); i++) {
			XmlParser parse = new XmlParser();
			parse.parseClasses(filePath,classLoaded.get(i).getSimpleName());
		 Entity e = new Entity(classLoaded.get(i).getSimpleName(),parse.getFields(),parse.getMethods());
		 add(e);
		}
	}

}
