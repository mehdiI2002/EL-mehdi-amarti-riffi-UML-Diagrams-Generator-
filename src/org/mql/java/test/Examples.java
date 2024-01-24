package org.mql.java.test;

import org.mql.java.views.FirstInterface;

public class Examples {
	public Examples() {
		exp02();
	}

	public void exp02() {
		FirstInterface interfaceF = new FirstInterface();
		interfaceF.drawFirstInterface(
				"C:\\projects java\\Amarti Riffi El mehdi - UML Diagrams Generator\\resources\\file.xml");

	}

	public static void main(String[] args) {
		new Examples();
	}
}