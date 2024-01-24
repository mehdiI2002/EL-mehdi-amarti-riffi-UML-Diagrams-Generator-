package org.mql.java.views;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Window;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.mql.java.parser.ParseClasse;
import org.mql.java.parser.XmlParser;

public class EntitiesPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private String filePath;
	HashMap<String, String> heritageMembers;
	String projectPath = "";

	public EntitiesPanel(String projectPath, String filePath) {
		this.projectPath = projectPath;
		this.filePath = filePath;

	}

	public void drawEntities(ArrayList<Class<?>> classLoaded) {
		int nbr = classLoaded.size();
		int cols = 3;
		int rows = (int) Math.ceil((double) nbr / cols);
		setLayout(new GridLayout(rows, cols, 120, 50));
		for (int i = 0; i < classLoaded.size(); i++) {
			XmlParser parse = new XmlParser(filePath);
			ParseClasse classeParse = new ParseClasse(parse);
			classeParse.parseClasse(classLoaded.get(i).getSimpleName());
			Entity e = new Entity(classLoaded.get(i).getSimpleName(), classeParse.getFields(), classeParse.getMethods(),
					classeParse.getTypefields(), classeParse.getTypeMethods());
			e.drawEntity();
			JPanel entityPanel = new JPanel();
			entityPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
			entityPanel.add(e);
			entityPanel.setOpaque(false);
			int x = (i % cols) * (e.getPreferredSize().width + 120);
			int y = (i / cols) * (e.getPreferredSize().height + 50);
			entityPanel.setLocation(x, y);
			add(entityPanel);
		}

		Window window = SwingUtilities.getWindowAncestor(this);
		if (window != null) {
			window.pack();
		}

	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

}
