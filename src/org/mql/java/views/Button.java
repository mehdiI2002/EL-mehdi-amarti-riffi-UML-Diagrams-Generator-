package org.mql.java.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Button extends JButton implements ActionListener {
	private static final long serialVersionUID = 1L;
	private String label;
	private JTextField textField;
	private String filePath;

	public Button(String label, JTextField textField, String filePath) {
		super(label);
		this.label = label;
		this.textField = textField;
		this.filePath = filePath;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ("Browse".equals(label)) {
			showDirectoryChooser();
		}
		if ("Generate".equals(label)) {
			if (textField.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Please insert a path!!", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				SecondInterface second = new SecondInterface();
				Menu menu = new Menu("diagramme de classe", "diagramme de package", textField, filePath, second);
				menu.addMenu();

				second.setJMenuBar(menu.getMb());
			}
		}
	}

	private JTextField showDirectoryChooser() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int result = fileChooser.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
			textField.setText(fileChooser.getSelectedFile().getAbsolutePath());
		}
		return textField;
	}

}