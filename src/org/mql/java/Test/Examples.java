package org.mql.java.Test;
import javax.swing.JFrame;

import org.mql.java.Reflection.ProjectExplorer;
import org.mql.java.models.ui.Entité;
public class Examples {
	public Examples() {
		exp02();
	}
	public void exp01() {
		 ProjectExplorer explorer = new ProjectExplorer();
	    explorer.projectExtractor("C:\\projects java\\Amarti riffi El mehdi - Reflection");
	    explorer.extractAll();
	}
	public void exp02() {
		Entité e = new Entité();
		e.addTable();
		JFrame frame = new JFrame(); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(e);
		frame.pack();
		frame.setVisible(true);	
	}
	
	public static void main(String[] args) {
	new Examples();
	}
}
