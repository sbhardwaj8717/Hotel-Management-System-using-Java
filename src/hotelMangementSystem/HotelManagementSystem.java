package hotelMangementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;					// action event is used to perform the action of action listener
import java.awt.event.ActionListener;				// action listener is used to add action among the components like buttons

import javax.swing.*;


public class HotelManagementSystem  extends JFrame implements ActionListener{
	public HotelManagementSystem() {
	//	setBounds(300,300,500,500);	// Combination of 2 below methods 	
		setSize(1950,1020); 			// size of the outer frame 
		setLocation(0,0);			// setting the location of the frame when it will be open
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("image/first.jpg"));
		Image i2 = i1.getImage().getScaledInstance(1950, 1000, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l1 = new JLabel(i3);
		l1.setBounds(0, 0, 1950,1000); 			// X,Y ,L ( x-axis ) , B ( y-axis )
		add(l1);
		
		JButton b1 = new JButton("CLICK ME...!!");			// creating a button
		b1.setBackground(Color.LIGHT_GRAY);
		b1.setForeground(Color.BLUE);
		b1.setBounds(550,450 , 200,40);						// setting its location and dimensions 
		b1.setVisible(true);	
		b1.addActionListener(this);							// create the button action
		l1.add(b1);													
		
		JLabel l2 = new JLabel("Hotel Management System");		// to add a label or test on the image
		l2.setBounds(250 , 90, 1000, 100);						// adding the dimensions of the text  //  letters may be half cut in that case increase width of the text
		l2.setForeground(Color.RED);							// awt package has a class named Color for the text color
		l1.add(l2);												// adding text or label on the l1 label or image
		l2.setFont(new Font("Comic Sans MS", Font.ITALIC,70));			// setting the font to the text , font type<plain> , size of the font
		
		setLayout(null);			// DEFAULT IT IS BORDER LAYOUT
		setVisible(true);			// Making the frame visible...by default it is false
		
		// multi-threading starts for dipper in the project
		
//		while(true) {
//			l2.setVisible(false);									// making frame invisible
//			try {
//				Thread.sleep(700);
//			}catch(Exception e) {}
//			l2.setVisible(true);									// making frame visible
//			
//			try {
//				Thread.sleep(700);									// to wait the process
//			}catch(Exception e) {}
//			
//			
//			
//		}
		// end of the threading
		
		
	}
	
	public void actionPerformed( ActionEvent ae) {				// overRidding of actionPerformed method in action listener
		new LoginFrame().setVisible(true);						// calling the constructor 
		this.setVisible(false);									// this will destroy the this current class
	
	}
	

	
	public static void main(String[] args) {
		new  HotelManagementSystem();
	}

}