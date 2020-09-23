package hotelMangementSystem;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;								// Contains java label, java button, java text..etc

public class LoginFrame extends JFrame implements ActionListener{
	
	JLabel l1,l2;									// labels 
	JTextField t1;									// input text fields
	JPasswordField t2;								// input passwords field
	JButton b1, b2;									// buttons
	
	public LoginFrame() {							// class constructor 
		l1 = new JLabel("User Name");				// user name tag 
		l1.setBounds(40, 20, 100, 30);				// location and dimensions 
		add(l1);
		
		l2 = new JLabel("Password");				// password tag
		l2.setBounds(40, 70, 100, 30);				// location and dimensions
		add(l2);
		
		t1 = new JTextField();						// text block
		t1.setBounds(130, 25, 150, 25);				
		add(t1);
		
		t2 = new JPasswordField();					// password block
		t2.setBounds(130, 77, 150, 25);
		add(t2);
		
		b1 = new JButton("LOGIN");					// login button
		b1.setBackground(Color.blue);				// background color
		b1.setForeground(Color.white);				// text color
		b1.setBounds(100 , 145 , 80, 30);			// button dimensions
		b1.addActionListener(this);
		add(b1);			
	
		
		b2 = new JButton("CANCEL");					// cancel button
		//b2.setBackground(Color.WHITE);			
		b2.setForeground(Color.BLACK);				// text color
		b2.setBounds(200 , 145 , 100, 30);
		b2.addActionListener(this);
		add(b2);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("image/second.jpg"));  		// adding a image i1
		Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);				// changing the dimensions of the original image to i2
		ImageIcon i3 = new ImageIcon(i2);														// creating image icon of image i2 bcz JLable only accepts ImageIcons					
		JLabel l3 = new JLabel(i3);																// providing a label to i3
		l3.setBounds(350,10,200,200);															
		add(l3);
		
		getContentPane().setBackground(Color.white);											// setting the background color of the whole page				
		
		setLayout(null);																		// setting page layout as null...it is border by default
		
		setBounds(450,300,600,250);																// setting the size and location of the frame
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == b1) {																// ae.getSource() is used to get the data which button is pressed
			String username =  t1.getText();													// getText() is used to get the data of a text box
			String password =  t2.getText();
			Conn con = new Conn();																// object of connection class
			
			String str =  "select * from login where username = '" + username+"' and password = '"+password+"'";				// creating the password and username  string to comapare			
			try {																										// use try catch for external files like JDBC sql
				ResultSet rs =con.s.executeQuery(str);																	// checking whethre our data is in the database or not
				if(rs.next()) {
				
					this.setVisible(false);
					new DashBoard().setVisible(true);
					
				}else {
					JOptionPane.showMessageDialog(null, "Invalid Username or Password");
					//this.setVisible(false);
				}
				
			} catch (Exception e) {
				System.out.println(e);
			}
			
		}else if(ae.getSource() == b2) {
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		new LoginFrame();																		// calling the class login frame 
	}

	
}
