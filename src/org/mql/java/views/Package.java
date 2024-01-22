package org.mql.java.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Package   extends JPanel{
	private static final long serialVersionUID = 1L;
	private String name;
	JPanel body;
		public Package(String name) {			
				this.name = name ;
				JLabel nomPackage = new JLabel(name);
				Font font = new Font("Times New Roman",Font.BOLD,20);
			     nomPackage.setFont(font);
				JPanel packageContainer = new JPanel();
				packageContainer.setPreferredSize(new Dimension(400,300));
				packageContainer. setLayout(new BoxLayout(packageContainer, BoxLayout.Y_AXIS));
				JPanel	pannelEntete = new JPanel();
				packageContainer.add(pannelEntete);
				 pannelEntete.setPreferredSize(new Dimension(400,100));
			     pannelEntete.setLayout(new FlowLayout(FlowLayout.LEFT,0,50));
				JPanel entete = new JPanel();
		        entete.setLayout(new FlowLayout(FlowLayout.LEFT, 0,0));
		        entete.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		        entete.setPreferredSize(new Dimension(70, 60));
		        pannelEntete.add(entete);
		        entete.add(nomPackage);
				 body = new JPanel();
				 body.setPreferredSize(new Dimension(400, 200));
				 packageContainer. add(body);
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
	
	
	

