package edu.csupomona.stilllab.JButtons; 

import java.awt.FlowLayout; //lets the layout of my gui items flow from left to right, up then down.
import java.awt.event.ActionListener; //polling to wait for actions from the user
import java.awt.event.ActionEvent; //allows me to do something after the actionlistener is activated
import javax.swing.JFrame; //Container
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;

public class MyGui extends JFrame {
	
	private JButton reg; //a regular button
	private JButton custom; // a button that will have my own images!
	
	public MyGui() { //constructor, so that whenever I create an object, this will pop up.
		super("My Java GUI with Buttons!"); //super == adds a title! comes from JFrame's constructor, which takes in a string for the window name.
		setLayout(new FlowLayout());
		
		reg = new JButton("reg button");
		add(reg);
		
		Icon red = new ImageIcon(getClass().getResource("red.png"));
		Icon green = new ImageIcon(getClass().getResource("green.png"));
		custom = new JButton("Custom Button", red); //2nd parameter is optional and my image
		custom.setRolloverIcon(green); //creating rollover image...
		add(custom);
		
		HandlerClass handler = new HandlerClass();
		reg.addActionListener(handler); //addActionListener takes in the parameter of the handler that I customly created
		custom.addActionListener(handler);
		
	}
	
	private class HandlerClass implements ActionListener { //my custom handler class will ALWAYS implement action listener
		//implements means that I must overwrite every method in the class.
		
		public void actionPerformed(ActionEvent event) {
			JOptionPane.showMessageDialog(null, String.format("%s", event.getActionCommand()));
		}
		
	}

}
