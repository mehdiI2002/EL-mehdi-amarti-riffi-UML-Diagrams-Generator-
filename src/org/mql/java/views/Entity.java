package org.mql.java.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Window;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class Entity extends JPanel {
	private static final long serialVersionUID = 1L;
	private String nom;
	private Vector<String> attributs;
	private Vector<String> methods;
	private Color panelColor;
	private JPanel panelGlobal;
	private Vector<String> attributsType;
	private Vector<String> methodsType;

	public Entity(String nom, Vector<String> attributs, Vector<String> methods, Vector<String> attributsType,
			Vector<String> methodsType) {
		this.nom = nom;
		this.attributs = attributs;
		this.methods = methods;
		this.attributsType = attributsType;
		this.setPanelColor(panelColor);
		this.methodsType = methodsType;
	}

	public void drawEntity() {
		setLayout(new FlowLayout(FlowLayout.CENTER));
		panelGlobal = new JPanel();
		panelGlobal.setBackground(panelColor);
		panelGlobal.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panelGlobal.setLayout(new BoxLayout(panelGlobal, BoxLayout.Y_AXIS));
		add(panelGlobal);
		JPanel panelLocal1 = new JPanel();
		JLabel labelNom = new JLabel(nom);
		panelLocal1.add(labelNom);
		panelLocal1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panelLocal1.setPreferredSize(new Dimension(200, 30));
		panelGlobal.add(panelLocal1);
		JPanel panelLocal2 = new JPanel();
		panelLocal2.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelLocal2.setAlignmentY(JPanel.TOP_ALIGNMENT);
		JTextArea attributsTextArea = new JTextArea();
		attributsTextArea.setEditable(false);
		attributsTextArea.setBackground(panelLocal2.getBackground());
		int j = 0;
		for (String attribut : attributs) {
			attributsTextArea.append("+" + attribut + " :  " + attributsType.get(j) + "\n");
			j++;
		}
		panelLocal2.add(attributsTextArea);
		panelLocal2.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, Color.BLACK));
		panelGlobal.add(panelLocal2);

		JPanel panelLocal3 = new JPanel();
		panelLocal3.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelLocal3.setAlignmentY(JPanel.TOP_ALIGNMENT);

		JTextArea methodsTextArea = new JTextArea();
		methodsTextArea.setEditable(false);
		methodsTextArea.setBackground(panelLocal3.getBackground());
		int k = 0;
		for (String method : methods) {
			methodsTextArea.append("+ " + method + "()" + " : " + methodsType.get(k) + "\n");
			k++;
		}
		panelLocal3.add(methodsTextArea);

		panelLocal3.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, Color.BLACK));
		panelGlobal.add(panelLocal3);
		Window window = SwingUtilities.getWindowAncestor(this);
		if (window != null) {
			window.pack();
		}
	}

	public String getNom() {
		return nom;
	}

	public Vector<String> getAttributs() {
		return attributs;
	}

	public Vector<String> getMethods() {
		return methods;
	}

	public Color getPanelColor() {
		return panelColor;
	}

	public void setPanelColor(Color panelColor) {
		this.panelColor = panelColor;
	}

	public JPanel getPanelGlobal() {
		return panelGlobal;
	}

}
