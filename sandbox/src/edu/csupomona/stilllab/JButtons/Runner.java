package edu.csupomona.stilllab.JButtons;

import javax.swing.JFrame;

public class Runner extends JFrame {

	public static void main(String[] args) {
		MyGui g = new MyGui();
		g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		g.setSize(300,200);
		g.setVisible(true);
	}
	
}
