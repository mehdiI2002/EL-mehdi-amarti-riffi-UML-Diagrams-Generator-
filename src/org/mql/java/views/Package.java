package org.mql.java.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Package extends JPanel {
	private static final long serialVersionUID = 1L;
	private String name;
	JPanel body;

	public Package(String name) {
		this.name = name;
	}

	public void drawPackage() {
		JLabel nomPackage = new JLabel(name);
		Font font = new Font("Times New Roman", Font.BOLD, 20);
		nomPackage.setFont(font);

		JPanel packageContainer = new JPanel();
		packageContainer.setLayout(new BoxLayout(packageContainer, BoxLayout.Y_AXIS));

		JPanel pannelEntete = new JPanel();
		packageContainer.add(pannelEntete);
		pannelEntete.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

		JPanel entete = new JPanel();
		entete.setLayout(new FlowLayout(FlowLayout.LEFT));
		entete.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		entete.add(nomPackage);
		pannelEntete.add(entete);
		body = new JPanel();

		body.setPreferredSize(new Dimension(400, 200));
		packageContainer.add(body);
		body.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		add(packageContainer);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public JPanel getBody() {
		return body;
	}

	public void setBody(JPanel body) {
		this.body = body;
	}

}
