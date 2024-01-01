package org.mql.java.models.ui;

import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Table extends JPanel {
	private static final long serialVersionUID = 1L;

    public Table() {
        setLayout(new FlowLayout(FlowLayout.LEFT));
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawRect(50, 50, 100, 50); 
        g.drawString("MaClasse", 75, 80);
       
    }
	
}
