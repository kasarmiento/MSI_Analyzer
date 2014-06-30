package edu.csupomona.stilllab;

import java.awt.FlowLayout; //how things are placed. default layout managing.
import javax.swing.JFrame; //gives all basic windows features: title bar, minimize, maximize, close.
import javax.swing.JLabel; //output text and images to the screen

public class Gui2 extends JFrame { //inherits stuff from JFrame
	
	private JLabel item1; //the item that we are adding
	
	//constructor
	public Gui2() {
		super("My Window"); //title of the window
		setLayout(new FlowLayout()); //gives us our default layout
		
		item1 = new JLabel("This is a JLabel sentence");
		item1.setToolTipText("This is gonna show up on hover");//make a "tip" box when you hover over it.
		
		//add the item to the window!
		add(item1);
		
	}
	

}
