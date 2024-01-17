package org.mql.java.views;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class LabledTextField extends JPanel {
	private static final long serialVersionUID = 1L;
	 private JTextField t1;
	public LabledTextField(String label, int size) {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		if(!label.contains(":")) label += ":";
		JLabel l1 = new JLabel(label);
		 t1 = new JTextField(size);
		add(l1);
		add(t1);
	}
	public JTextField getT1() {
		return t1;
	}
	public void setT1(JTextField t1) {
		this.t1 = t1;
	}
	public LabledTextField (String label, int size , int labelsize) {
		this(label, size); 
		JLabel l1 = (JLabel) getComponent(0);
		l1.setPreferredSize(new Dimension(labelsize,l1.getPreferredSize().height));
	}
	
	

}



