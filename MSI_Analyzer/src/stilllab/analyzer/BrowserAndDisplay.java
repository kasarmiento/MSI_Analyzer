package stilllab.analyzer;

import java.awt.Color;
import java.awt.FlowLayout; //lets the layout of my gui items flow from left to right, up then down.
import java.awt.Graphics;
import java.awt.event.ActionListener; //polling to wait for actions from the user
import java.awt.event.ActionEvent; //allows me to do something after the actionlistener is activated
import java.awt.Image; //superclass that represents graphical images as rectulangular arrays of pixels
import java.awt.image.BufferedImage; //extends the Imae class and allows me to operate directly with the image data
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame; //Container
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class BrowserAndDisplay extends JFrame {
	
	private JPanel container;
	private File targetFile;
	private BufferedImage msi; //a buffered image is an Image with an accessible data buffer, therefore it is easy to access
	
	private JLabel myImage;
	private JButton browseButton;
	private JFileChooser fileChooser;
	private int w, h;
	
	public BrowserAndDisplay() {
		super("MSI Browser");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,300);
		setVisible(true);
		setLayout(new FlowLayout());
		
		container = new JPanel();
		container.setBorder(new LineBorder(new Color(0,0,0),1,true));
		add(container);
		
		myImage = new JLabel();
		myImage.setIcon(new ImageIcon("C:\\Users\\Khamille\\Desktop\\red.png"));
		container.add(myImage);
		
		browseButton = new JButton("Browse...");
		container.add(browseButton);
		
		HandlerClass myHandler = new HandlerClass();
		browseButton.addActionListener(myHandler);
		
		
	}
	
	private class HandlerClass implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			fileChooser = new JFileChooser();
			
			if(event.getSource() == browseButton) {
				int returnVal = fileChooser.showOpenDialog(BrowserAndDisplay.this);
				
				//if the user successfully selects a file
				if(returnVal == JFileChooser.APPROVE_OPTION) {
					File file = fileChooser.getSelectedFile();
					
					try { //if the file is an image...
						msi = ImageIO.read(file);
						w = msi.getWidth(null);
						h = msi.getHeight(null);
						Graphics big = msi.getGraphics();
						big.drawImage(msi, 0, 0, null);
						
						
						
					} catch (IOException e) {
						
					}				

					
					JOptionPane.showMessageDialog(null, "Selected: " + file.getName() + ".");
				}
				
				//if the user 
				else {
					JOptionPane.showMessageDialog(null, "Open command cancelled by user.");
				}
			}
			
		}
	}
	
	

}
