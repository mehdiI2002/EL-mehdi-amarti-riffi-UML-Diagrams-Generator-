package org.mql.java.views;

import java.awt.FlowLayout;
import java.util.Vector;

import javax.swing.JPanel;

public class EntitiesPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	public EntitiesPanel(Vector<String> data) {
		 setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));
		for (int i = 0; i < data.size(); i++) {
			 Entity e =  new Entity (data.get(i));
			 add(e);
		}
	}

}
