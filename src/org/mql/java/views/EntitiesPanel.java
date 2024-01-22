package org.mql.java.views;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Window;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.mql.java.parser.XmlParser;
public class EntitiesPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	Vector<EntityInfo> info = new Vector<EntityInfo>();
	private String filePath;
	 HashMap<String, String>  heritageMembers ;
	 String projectPath = "";
    public EntitiesPanel(ArrayList<Class<?>> classLoaded, String filePath, String projectPath) {
    	this.projectPath = projectPath;
		this.filePath = filePath;
	        int nbr = classLoaded.size();
        int cols = 3;
        int rows = (int) Math.ceil((double) nbr / cols);
        setLayout(new GridLayout(rows, cols, 120, 50));
        for (int i = 0; i < classLoaded.size(); i++) {
        	XmlParser parse = new XmlParser();
            parse.parseClasse(filePath, classLoaded.get(i).getSimpleName());
            Entity e = new Entity(classLoaded.get(i).getSimpleName(), parse.getFields(), parse.getMethods(),parse.getTypefields(),parse.getTypeMethods());
            JPanel entityPanel = new JPanel();
            entityPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
            entityPanel.add(e);
            entityPanel.setOpaque(false);
            int x = (i % cols) * (e.getPreferredSize().width + 120);
            int y = (i / cols) * (e.getPreferredSize().height + 50);
            entityPanel.setLocation(x, y);
            add(entityPanel);
            String name = classLoaded.get(i).getSimpleName();
            EntityInfo infos = new EntityInfo(name, entityPanel, i);
            info.add(infos);
           
        }
       
        
        Window window = SwingUtilities.getWindowAncestor(this);
        if (window != null) {
            window.pack();
        }
 
}
    /*public void paint() {
    	XmlParser parse1 = new XmlParser();
    	parse1.parseRelations(filePath);
	    heritageMembers = parse1.getHeritgeRelation();
	    System.out.println(heritageMembers);
    	  for (HashMap.Entry<String, String> entry : heritageMembers.entrySet()) {
          	System.out.println("lwl de hashmap");
          	String key = entry.getKey();
              String value = entry.getValue();
              JPanel  e1 = null;
             JPanel  e2 = null;
              for (int j = 0; j < info.size(); j++) {
                  if (key.equals(info.get(j).getEntityName())) {
                     e1 =  info.get(j).getPanel();
                  }

                  if (value.equals(info.get(j).getEntityName())) {
                     e2 = info.get(j).getPanel();
                  }
          }
              if (e1 != null && e2 != null) {
              
             
             
             
      	}
    	  }
    	
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
	public  void drawReltion() {
		
	}
	
	   	  
	
}
	   


	
	

