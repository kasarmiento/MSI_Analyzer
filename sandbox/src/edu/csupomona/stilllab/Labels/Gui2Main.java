package edu.csupomona.stilllab.Labels;

import javax.swing.JFrame;

public class Gui2Main {
	
	public static void main(String[] args) {
		
		Gui2 firstGui = new Gui2();
		firstGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //how we want our program to close: whenever we hit the x button, then our program terminates.
		firstGui.setSize(275,180); //275x180 px
		firstGui.setVisible(true);
		
		
	}

}
