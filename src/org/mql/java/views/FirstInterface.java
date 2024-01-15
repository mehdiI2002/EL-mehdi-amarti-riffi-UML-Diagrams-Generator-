package org.mql.java.views;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FirstInterface extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel container;
	private JPanel containerButton;
	
	public FirstInterface() {
		 container = new JPanel();
		 containerButton = new JPanel();
	        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
	        containerButton.setLayout(new FlowLayout(FlowLayout.CENTER));
	        container.add(Box.createVerticalGlue());
	        JLabel titre = new JLabel("Welcome to UML Diagrams Generator");
	        titre.setFont(new Font("Arial", Font.ITALIC, 20));
	        titre.setAlignmentX(Component.CENTER_ALIGNMENT); // Aligner le label au centre horizontalement
	        container.add(titre);
	        LabledTextField labeled = new LabledTextField("Projet Path", 30, 100);
	        container.add(labeled);
	        container.add(Box.createVerticalGlue());
	       Button button1 = new Button("Browse",labeled.getT1());
	       Button button2 = new Button("Generate",labeled.getT1());
	       containerButton.add(button2);
	       containerButton.add(button1);
	       container.add(containerButton);
	        add(container);
	        pack();
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLocationRelativeTo(null);
	        setVisible(true);
	        setResizable(false);
	}

}
