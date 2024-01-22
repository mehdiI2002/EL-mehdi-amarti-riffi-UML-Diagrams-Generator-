package org.mql.java.views;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import org.mql.java.Models.XmlWriter;
import org.mql.java.Reflection.ProjectExplorer;
public class Menu extends JMenuBar  implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JMenu menu;
	 JMenuItem i1, i2;
	 String d1,d2;
	 JTextField textField;
	 JMenuBar mb;
	public Menu(String d1,String d2,JTextField textField) {
		this.d1 = d1;
		this.d2 = d2;
		this.textField = textField;
		mb =new JMenuBar();  
		 menu=new JMenu("Menu Diagrammes");  
        i1=new JMenuItem(d1);  
        i2=new JMenuItem(d2);  
        menu.add(i1); 
        menu.add(i2);
       mb.add(menu); 
       i1.addActionListener(this);
}
	@Override
	public void actionPerformed(ActionEvent e) {
		if("diagramme de classe".equals(d1)) {
			String projectPath = textField.getText();
			String filePath = "C:\\projects java\\Amarti Riffi El mehdi - UML Diagrams Generator\\resources\\file.xml";
			ProjectExplorer explorer = new ProjectExplorer();
		    explorer.projectExtractor(projectPath);
		    explorer.loadCLasses(projectPath);
		  XmlWriter write = new  XmlWriter();
		    write.writeXML(explorer.getResult(),explorer.getLoadedClasses(),projectPath);
		  EntitiesPanel panelEntity = new EntitiesPanel(explorer.getLoadedClasses(), filePath,projectPath);
		  SecondInterface second = new SecondInterface();
	     JScrollPane scroll = new JScrollPane(panelEntity);
	      scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	      second.getContentPane().add(scroll);
		}
		
		
	}
	public JMenuBar getMb() {
		return mb;
	}
	public void setMb(JMenuBar mb) {
		this.mb = mb;
	}
}