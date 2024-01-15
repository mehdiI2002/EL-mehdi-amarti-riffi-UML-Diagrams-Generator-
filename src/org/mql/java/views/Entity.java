package org.mql.java.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.w3c.dom.html.HTMLFieldSetElement;

public class Entity extends JPanel {
	private static final long serialVersionUID = 1L;
	private String nom;
	private Vector<String> attributs;
	private Vector<String> methods;
	public Entity(String nom ,Vector<String> attributs,Vector<String> methods) {
		 this.nom = nom;
	       this.attributs = attributs;
	        this.setMethods(methods);
		  setPreferredSize(new Dimension(400, 200));
		  setLayout(new FlowLayout(FlowLayout.CENTER));
		  JPanel panelGlobal = new JPanel();
		    panelGlobal.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		    panelGlobal.setPreferredSize(new Dimension(200, 250)); 
		    panelGlobal.setLayout(new BoxLayout(panelGlobal, BoxLayout.Y_AXIS));
		   add(panelGlobal);
		   JPanel panelLocal1 = new JPanel();
		   JLabel labelNom = new JLabel(nom);
		   panelLocal1.add(labelNom);
		   panelLocal1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		   panelLocal1.setPreferredSize(new Dimension(200, 30));
		   panelGlobal.add(panelLocal1);
		   JPanel panelLocal2 = new JPanel();
		   for (int i = 0; i < attributs.size(); i++) {
			 JLabel  labelAttributs = new JLabel("+"+attributs.get(i));
			 panelLocal2.add(labelAttributs);
		}
		   panelLocal2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		   panelLocal2.setPreferredSize(new Dimension(200, 100));
		   panelGlobal.add(panelLocal2);
		   JPanel panelLocal3 = new JPanel();
		   for (int i = 0; i < methods.size(); i++) {
				 JLabel labelMehods = new JLabel("+ "+methods.get(i)+"\n");
				 panelLocal3.add(labelMehods);
			
		}
		   panelLocal3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		   panelLocal3.setPreferredSize(new Dimension(200, 100));
		   panelGlobal.add(panelLocal3);
		  
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Vector<String> getAttributs() {
		return attributs;
	}
	public void setAttributs(Vector<String> attributs) {
		this.attributs = attributs;
	}
	public Vector<String> getMethods() {
		return methods;
	}
	public void setMethods(Vector<String> methods) {
		this.methods = methods;
	}

	
		
		
	
	
	
}

