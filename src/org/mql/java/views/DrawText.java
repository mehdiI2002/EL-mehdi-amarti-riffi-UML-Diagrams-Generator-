package org.mql.java.views;

import java.awt.Graphics;

import javax.swing.JPanel;

public class DrawText extends JPanel {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String nom;

	public DrawText(String nom) {
		this.nom = nom;
		
		
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString(nom,10 ,10);
		
	}


}
