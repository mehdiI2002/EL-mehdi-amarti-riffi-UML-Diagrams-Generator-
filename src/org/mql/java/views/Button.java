package org.mql.java.views;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import org.mql.java.Models.XmlWriter;
import org.mql.java.Reflection.ProjectExplorer;
public class Button extends JButton implements ActionListener{
	private static final long serialVersionUID = 1L;
	private String label;
	private JTextField textField ;
	public Button(String label,JTextField textField) {
		super(label);
    this.label = label;
    this.textField = textField;
    addActionListener(this);
}
	public Button(String label) {
		super(label);
		 this.label = label;
		 addActionListener(this);
	}
@Override
public void actionPerformed(ActionEvent e) {
    if ("Browse".equals(label)) {
        showDirectoryChooser(); 
    }
    if("Generate".equals(label)) {
    	String projectPath = textField.getText();
		String filePath = "C:\\projects java\\Amarti Riffi El mehdi - UML Diagrams Generator\\resources\\file.xml";
		ProjectExplorer explorer = new ProjectExplorer();
	    explorer.projectExtractor(projectPath);
	    explorer.loadCLasses(projectPath);
	  XmlWriter write = new  XmlWriter();
	    write.writeXML(explorer.getResult(),explorer.getLoadedClasses());
	  EntitiesPanel panelEntity = new EntitiesPanel(explorer.getLoadedClasses(), filePath);
	  JFrame frame = new JFrame("Diagramme de classe");
      frame.setSize(300, 400);
      JScrollPane scroll = new JScrollPane(panelEntity);
      scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
      frame.getContentPane().add(scroll);
      frame.pack();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
	 
    	
    }
}
private void showDirectoryChooser() {
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    int result = fileChooser.showOpenDialog(this);
    if (result == JFileChooser.APPROVE_OPTION) {
        textField.setText(fileChooser.getSelectedFile().getAbsolutePath());
    }
}

}