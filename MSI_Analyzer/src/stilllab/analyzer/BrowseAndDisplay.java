package stilllab.analyzer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.activation.MimetypesFileTypeMap;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class BrowseAndDisplay extends JFrame {
	
	public JPanel container;
	private JButton browse;
	private ActionHandler handler;
	public BufferedImage msi;
	public JButton analyze;
	public JPanel imageHolder;
	
	
	public BrowseAndDisplay() {
		super("MSI Analyzer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(300,100);
		//setPreferredSize(new Dimension(100,80));
		
		handler = new ActionHandler();
		
		container = new JPanel(new BorderLayout()); // This JPanel will act as a container for all things related to "Browse and Display" component of my software
		container.setPreferredSize(new Dimension(240,360)); // Browse and Display component will be 230x400 size in my software
		container.setBorder(new EmptyBorder(5, 5, 5, 5)); // Acts as 5px padding all around
		setContentPane(container); // This JPanel called 'container' will be my top-level content pane
		
		JPanel browseComponent = createBrowseComponent();
		container.add(browseComponent, BorderLayout.NORTH);
		
		JPanel imageComponent = createImageComponent();
		container.add(imageComponent, BorderLayout.CENTER);
		
		
		JPanel analyzeButtonHolder = new JPanel();
		analyze = new JButton("Analyze");
		analyze.setPreferredSize(new Dimension(100,50));
		analyzeButtonHolder.add(analyze);
		container.add(analyzeButtonHolder, BorderLayout.SOUTH);
		
		pack();
		setVisible(true);
		
	}
	
	private JPanel createBrowseComponent() {
		JPanel browseComponent = new JPanel();
		browseComponent.setPreferredSize(new Dimension(240, 40));
		
		JLabel browseIntro = new JLabel("Select target...");
		browseComponent.add(browseIntro);
		
		browse = new JButton("Browse");
		browse.addActionListener(handler);
		browseComponent.add(browse);
		
		return browseComponent;
	}
	
	private JPanel createImageComponent() {
		JPanel imageComponent = new JPanel();
		
		imageHolder = new JPanel();
		imageHolder.setBorder(new LineBorder(new Color(0,0,0), 1, true));
		imageHolder.setPreferredSize(new Dimension(200,230)); 
		imageComponent.add(imageHolder);
			
		return imageComponent;
	}
	
	private class ActionHandler implements ActionListener {
		
		public void actionPerformed(ActionEvent event) {
			
			if(event.getSource() == browse) {
				try {
					browseAndSelect();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
		
		private void browseAndSelect() throws IOException {
			JFileChooser fileChooser = new JFileChooser();
			int returnVal = fileChooser.showOpenDialog(BrowseAndDisplay.this);
			
			// If the user selects a file...
			if(returnVal == JFileChooser.APPROVE_OPTION) { 
				File file = fileChooser.getSelectedFile();
				boolean isImage = checkIfImage(file);
				
				// If the file is an image file
				if(isImage == true) {
					msi = ImageIO.read(file);
					JOptionPane.showMessageDialog(null, "You selected a valid image file. Cool!");
					JLabel pic = new JLabel(new ImageIcon(msi));
					imageHolder.add(pic);
					//displayImage(msi);
				} 
				
				// If the file is NOT an image file
				else {
					JOptionPane.showMessageDialog(null, "You did not select a valid image file.");
				}
			} 
			
			// If the user hits CANCEL...
			else {
				JOptionPane.showMessageDialog(null, "Open command cancelled by user.");
			}
		}
		
		private void displayImage(BufferedImage image) {
			JLabel pic = new JLabel(new ImageIcon(image));
			imageHolder.add(pic);
		}
		
		private boolean checkIfImage(File file) {
			MimetypesFileTypeMap mimetypesFileTypeMap = new MimetypesFileTypeMap();
			mimetypesFileTypeMap.addMimeTypes("image png PNG tif TIF jpg JPG jpeg JPEG bmp BMP"); //accepted file types!!! :D
			
			String mimetype = mimetypesFileTypeMap.getContentType(file);
			String type = mimetype.split("/")[0];
			if(type.equals("image")) { return true; } 
			else { return false; }			
		}
		
	}
	
	
}
