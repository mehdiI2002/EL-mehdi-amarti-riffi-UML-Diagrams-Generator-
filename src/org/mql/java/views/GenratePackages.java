package org.mql.java.views;

import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class GenratePackages extends JPanel {
	private static final long serialVersionUID = 1L;
	Vector<String> packageName;
	public GenratePackages(Vector<String> packagesName,String filePath ) {
	        for (int i = 0; i < packagesName.size()-1; i+=2) {
	          Package  p = new Package(packagesName.get(i));
	               add(p);
	               if(packagesName.get(i+1)!=null) {
	                     Package p1 = new Package(packagesName.get(i+1));
	                     p.getBody().add(p1);
	               }
	               else {
	            	   break;
	               }
	               revalidate();
	               repaint(); 

	        }
	}

	
}
