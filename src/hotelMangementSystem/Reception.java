package hotelMangementSystem;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Reception extends JFrame implements ActionListener {

	JButton b1, b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12;
	Reception(){
		b1 = new JButton("NEW CUSTMER FORM");
		b1.setBackground(Color.black);
		b1.setForeground(Color.WHITE);
		b1.setBounds(10, 30, 250, 30);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("ROOM");
		b2.setBackground(Color.black);
		b2.setForeground(Color.WHITE);
		b2.setBounds(10, 70, 250, 30);
		b2.addActionListener(this);
		add(b2);

		b3 = new JButton("DEPARTMENT");
		b3.setBackground(Color.black);
		b3.setForeground(Color.WHITE);
		b3.setBounds(10, 110, 250, 30);
		b3.addActionListener(this);
		add(b3);
		
		b4 = new JButton("ALL EMPLOYEE INFO");
		b4.setBackground(Color.black);
		b4.setForeground(Color.WHITE);
		b4.setBounds(10, 150, 250, 30);
		b4.addActionListener(this);
		add(b4);
		
		b5 = new JButton("CUSTOMER INFO");
		b5.setBackground(Color.black);
		b5.setForeground(Color.WHITE);
		b5.setBounds(10, 190, 250, 30);
		b5.addActionListener(this);
		add(b5);
		
		b6 = new JButton("MANAGER INFO");
		b6.setBackground(Color.black);
		b6.setForeground(Color.WHITE);
		b6.setBounds(10, 230, 250, 30);
		b6.addActionListener(this);
		add(b6);
		
		b7 = new JButton("CHECK OUT");
		b7.setBackground(Color.black);
		b7.setForeground(Color.WHITE);
		b7.setBounds(10, 270, 250, 30);		
		b7.addActionListener(this);
		add(b7);
		
		b8 = new JButton("UPDATE CHECK STATUS");
		b8.setBackground(Color.black);
		b8.setForeground(Color.WHITE);
		b8.setBounds(10, 310, 250, 30);
		b8.addActionListener(this);
		add(b8);

		b9 = new JButton("UPDATE ROOM STATUS");
		b9.setBackground(Color.black);
		b9.setForeground(Color.WHITE);
		b9.setBounds(10, 350, 250, 30);
		b9.addActionListener(this);
		add(b9);
		
		b10 = new JButton("PICKUP DRIVER");
		b10.setBackground(Color.black);
		b10.setForeground(Color.WHITE);
		b10.setBounds(10, 390, 250, 30);	
		b10.addActionListener(this);
		add(b10);
		
		b11 = new JButton("SEARCH ROOM");
		b11.setBackground(Color.black);
		b11.setForeground(Color.WHITE);
		b11.setBounds(10, 430, 250, 30);
		b11.addActionListener(this);
		add(b11);
		
		b12 = new JButton("LOGOUT");
		b12.setBackground(Color.black);
		b12.setForeground(Color.WHITE);
		b12.setBounds(10, 470, 250, 30);
		b12.addActionListener(this);
		add(b12);
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("image/reception.jpg"));
		JLabel img = new JLabel(i1);
		img.setBounds(265, 10, 490, 500);
		add(img);
		
		setLayout(null);
		setBounds(400, 150, 780, 580);
		getContentPane().setBackground(Color.white);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == b1) {
			
		}else if(ae.getSource() == b2) {
			
		}else if(ae.getSource() == b3) {
			
		}else if(ae.getSource() == b4) {
			new EmpInfo().setVisible(true);
		}else if(ae.getSource() == b5) {
			
		}else if(ae.getSource() == b6) {
			
		}else if(ae.getSource() == b7) {
			
		}else if(ae.getSource() == b8) {
			
		}else if(ae.getSource() == b9) {
			
		}else if(ae.getSource() == b10) {
			
		}else if(ae.getSource() == b11) {
			
		}else if(ae.getSource() == b12) {
			this.setVisible(false);
		}
	}
	
	public static void main(String[] args) {
		new Reception();
		}

}
