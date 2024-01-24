package org.mql.java.views;

import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.JPanel;

public class GenratePackages extends JPanel {
	private static final long serialVersionUID = 1L;
	Vector<String> packagesName;

	public GenratePackages(Vector<String> packagesName) {
		this.packagesName = packagesName;
	}

	public void drawPackages(String filePath) {
		int nbr = packagesName.size();
		int cols = 3;
		int rows = (int) Math.ceil((double) nbr / cols);
		setLayout(new GridLayout(rows, cols, 120, 50));
		for (int i = 0; i < packagesName.size(); i++) {
			Package p = new Package(packagesName.get(i));
			p.drawPackage();
			add(p);

		}
	}
}
