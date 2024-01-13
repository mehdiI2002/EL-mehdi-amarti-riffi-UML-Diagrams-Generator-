package org.mql.java.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Entity extends JPanel {
	private static final long serialVersionUID = 1L;
	private String nom;
	public Entity(String nom) {
		this.nom = nom;
		  setPreferredSize(new Dimension(400, 200));
	}
	@Override
    protected void paintComponent(Graphics g){
		 super.paintComponent(g);
		 g.setColor(Color.LIGHT_GRAY);
	        g.fillRect(50, 50, 400, 200);
	        g.setColor(Color.DARK_GRAY);
	        g.drawRect(50, 50, 400, 200);
	        g.drawString(nom, 70, 70);
	        g.setColor(Color.BLACK);
	        g.drawLine(50, 100, 450, 100);
	        g.drawLine(50, 170, 450, 170);
	}
}

