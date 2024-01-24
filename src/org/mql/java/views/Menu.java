package org.mql.java.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import org.mql.java.Models.WriteClasses;
import org.mql.java.Models.WriteDirectories;
import org.mql.java.Models.XmlDocumentBuilder;
import org.mql.java.Models.XmlFileCreator;
import org.mql.java.parser.ParsePackages;
import org.mql.java.parser.XmlParser;
import org.mql.java.reflection.ClassLoader;
import org.mql.java.reflection.ProjectExplorer;

public class Menu extends JMenuBar implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JMenu menu;
	JMenuItem i1, i2;
	String d1, d2;
	JTextField textField;
	JMenuBar mb;
	String filePath;

	public Menu(String d1, String d2, JTextField textField, String filePath) {
		this.d1 = d1;
		this.d2 = d2;
		this.textField = textField;
		this.filePath = filePath;

		mb = new JMenuBar();
		menu = new JMenu("Menu Diagrammes");
		i1 = new JMenuItem(d1);
		i2 = new JMenuItem(d2);

	}

	public void addMenu() {
		menu.add(i1);
		menu.add(i2);
		mb.add(menu);
		i1.addActionListener(this);
		i2.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String projectPath = textField.getText();

		ProjectExplorer explorer = new ProjectExplorer();
		explorer.projectExtractor(projectPath);

		ClassLoader load = new ClassLoader();
		load.loadCLasses(projectPath, explorer.getPathClasses());

		XmlDocumentBuilder builder = new XmlDocumentBuilder();
		WriteDirectories directories = new WriteDirectories(builder);
		directories.writeDirectories(explorer.getResult());

		WriteClasses classes = new WriteClasses(builder);
		classes.writeClasses(load.getLoadedClasses());
		XmlFileCreator fileXml = new XmlFileCreator(builder);
		fileXml.createXmlFile(filePath);

		XmlParser parse = new XmlParser(filePath);
		ParsePackages pack = new ParsePackages(parse);
		pack.parsePackages();

		SecondInterface second = new SecondInterface();

		if (e.getSource().equals(i1)) {
			EntitiesPanel panelEntity = new EntitiesPanel(projectPath, filePath);
			panelEntity.drawEntities(load.getLoadedClasses());

			JScrollPane scroll = new JScrollPane(panelEntity);
			scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			second.getContentPane().add(scroll);
		} else if (e.getSource().equals(i2)) {
			System.out.println(pack.getDirectories());
			GeneratePackages packages = new GeneratePackages(pack.getDirectories());
			packages.drawPackages(filePath);
			JScrollPane scroll = new JScrollPane(packages);
			scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			second.getContentPane().add(scroll);

		}

	}

	public JMenuBar getMb() {
		return mb;
	}

	public void setMb(JMenuBar mb) {
		this.mb = mb;
	}
}