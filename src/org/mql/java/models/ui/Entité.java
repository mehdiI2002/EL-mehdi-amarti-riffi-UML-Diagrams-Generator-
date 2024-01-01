package org.mql.java.models.ui;

import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
public class Entité extends JPanel {
	private static final long serialVersionUID = 1L;
	private JPanel container ;
	
	public Entité() {
			setLayout(new FlowLayout(FlowLayout.LEFT));
			container = new JPanel();
			add(container);
			container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));
			container.setBorder(new TitledBorder(new EtchedBorder(), " " +" "));
			}
			public void addTable() {
				Table table = new Table();
				container.add(table);
						}
}


