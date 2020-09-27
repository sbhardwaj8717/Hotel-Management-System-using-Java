package hotelMangementSystem;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UpdateRoom extends JFrame implements ActionListener{
	
	Choice c1;
	JTextField t1,t2,t3;
	JButton b1,b2,b3;
	
	UpdateRoom(){
		JLabel j1 = new JLabel("UPDATE   ROOM   STATUS");
		j1.setBounds(60, 30, 400, 40);
		j1.setFont(new Font("Tahuma" , Font.ITALIC, 25));
		j1.setForeground(Color.blue);
		add(j1);
		
		
		JLabel j2 = new JLabel("GUEST ID");
		j2.setBounds(50, 90, 60, 40);
		add(j2);
		c1 = new Choice();
		try {
			Conn c = new  Conn();
			ResultSet rs = c.s.executeQuery("select * from newcustomer");
			while(rs.next()) {
				c1.add(rs.getString("number"));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		c1.setBounds(230, 90, 170, 40);
		add(c1);
		
		JLabel j3 = new JLabel("ROOM NO.");
		j3.setBounds(50, 130, 400, 40);
		add(j3);
		t1 = new JTextField();
		t1.setBounds(230, 130, 170, 30);
		add(t1);
		
		JLabel j4 = new JLabel("AVAILABLITY");
		j4.setBounds(50, 170, 400, 40);
		add(j4);
		t2 = new JTextField();
		t2.setBounds(230, 170, 170, 30);
		add(t2);
		
		JLabel j5 = new JLabel("CLEANING STATUS");
		j5.setBounds(50, 210, 400, 40);
		add(j5);
		t3 = new JTextField();
		t3.setBounds(230, 210, 170, 30);
		add(t3);
		
		b1 = new JButton("CHECK");
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.setBounds(70, 280, 100, 35);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("UPDATE");
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		b2.setBounds(180, 280, 100, 35);
		b2.addActionListener(this);
		add(b2);
		
		b3 = new JButton("BACK");
		b3.setBounds(290, 280, 100, 35);
		b3.addActionListener(this);
		add(b3);
		
		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("image/bed.jpg"));
		Image img1 = img.getImage().getScaledInstance(550, 300, Image.SCALE_DEFAULT);
		ImageIcon img2 = new ImageIcon(img1);
		JLabel image = new JLabel(img2);
		image.setBounds(340, 20 , 700, 300);
		add(image);
		
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setBounds(300, 300, 1000, 380);
		setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == b1) {
			String id =  c1.getSelectedItem();
			String room = null;
			try {
				Conn c = new Conn();
				ResultSet rs = c.s.executeQuery("select * from newcustomer where number = '"+id+"'");
				while(rs.next()) {
					   t1.setText(rs.getString("roomalocated"));
					   room = rs.getString("roomalocated");
				}
				ResultSet rs2 = c.s.executeQuery("select * from addroom where room = '"+room+"'");
				while(rs2.next()) {
					t2.setText(rs2.getString("avail"));
					t3.setText(rs2.getString("clean"));
				}
			} catch (Exception e) {
					System.out.println(e);
			}
		}else if(ae.getSource() == b2) {
			try {
				Conn c = new Conn();
				String room  =t1.getText();
				String avail =t2.getText();
				String clean =t3.getText();
				
				String str = "update addroom set avail = '"+avail+"', clean='"+clean+"' where room='"+room+"'";
				c.s.executeUpdate(str);
				JOptionPane.showMessageDialog(null, "STATUS UPDATED");
				new Reception().setVisible(true);
				this.setVisible(false);
			} catch (Exception e) {
				System.out.println(e);
			}
			
		}else if(ae.getSource() == b3) {
			new Reception().setVisible(true);
			this.setVisible(false);
		}
	}
	
	public static void main(String[] args) {
		new UpdateRoom();
	}
}
