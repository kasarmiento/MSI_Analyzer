package edu.csupomona.stilllab.EventHandling;

import javax.swing.JFrame; 

public class Runner {
	
	public static void main(String[] args) {
		EventHandlingPractice myGui = new EventHandlingPractice();
		myGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myGui.setSize(350,100);
		myGui.setVisible(true);
		
	}

}
