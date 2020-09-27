package hotelMangementSystem;

import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class UpdateCheck extends JFrame implements ActionListener {
	
	JButton b1,b2,b3;
	JTextField t1,t2,t3,t4,t5,t6;
	Choice c1;
	
	public UpdateCheck() {
		JLabel j1 = new JLabel("CHECKED-IN DETAILS");
		j1.setFont(new Font("Tahuma", Font.ITALIC, 25));
		j1.setForeground(Color.BLUE);
		j1.setBounds(30, 20, 300, 40);
		add(j1);
		
		JLabel j2 = new JLabel("CUSTOMER ID");
		j2.setBounds(30, 90, 160, 30);
		add(j2);  
//		t1 = new JTextField();
//		t1.setBounds(220, 90, 150, 30);
//		add(t1);
		try {
			Conn c = new Conn();
			c1 = new Choice();
			ResultSet rs = c.s.executeQuery("select * from newcustomer");
			while(rs.next()) {
				c1.add(rs.getString("number"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		c1.setBounds(220, 90, 150, 30);
		add(c1);
		
		
		JLabel j3 =  new JLabel("ROOM");
		j3.setBounds(30, 130, 160, 30);
		add(j3);
		t2 = new JTextField();
		t2.setBounds(220, 130, 150, 30);
		add(t2);
	
		JLabel j4 = new JLabel("NAME");
		j4.setBounds(30, 170, 160, 30);
		add(j4);

		t3 = new JTextField();
		t3.setBounds(220, 170, 150, 30);
		add(t3);
		JLabel j5 = new JLabel("CHECKED-IN ");
		j5.setBounds(30, 210, 160, 30);
		add(j5);

		t4 = new JTextField();
		t4.setBounds(220, 210, 150, 30);
		add(t4);
		JLabel j6 = new JLabel("PAID AMOUNT");
		j6.setBounds(30, 250, 160, 30);
		add(j6);

		t5 = new JTextField();
		t5.setBounds(220, 250, 150, 30);
		add(t5);
		
		
		
		JLabel j7 = new JLabel("PENDING AMOUNT");
		j7.setBounds(30, 290, 160, 30);
		add(j7);

		t6 = new JTextField();
		t6.setBounds(220, 290, 150, 30);
		add(t6);
		
		b1 =new JButton("CHECK");
		b1.setBounds(40, 350, 100, 35);
		b1.setForeground(Color.white);
		b1.setBackground(Color.black);
		b1.addActionListener(this);
		add(b1);
		
		b2 =new JButton("UPDATE");
		b2.setBounds(150, 350, 100, 35);
		b2.setForeground(Color.white);
		b2.setBackground(Color.black);
		b2.addActionListener(this);
		add(b2);
		
		b3 =new JButton("BACK");
		b3.setBounds(260, 350, 100, 35);
		b3.addActionListener(this);
		add(b3);
		
		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("image/checkin.jpg"));
		Image img1 = img.getImage().getScaledInstance(430, 430, Image.SCALE_DEFAULT);
		ImageIcon img2 = new ImageIcon(img1);
		JLabel imgLab = new JLabel(img2);
		imgLab.setBounds(400, 10, 430, 430);
		add(imgLab);
		
		
		getContentPane().setBackground(Color.white);
		setLayout(null);
		setBounds(350, 230, 880, 480);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == b1) {
			try {
				Conn c = new Conn();
				String id = c1.getSelectedItem();
				String str = "select * from newcustomer where number = '"+id+"'";
				String room = null;
				ResultSet rs = c.s.executeQuery(str);
				
				String deposite= null;
				int amountPaid= 0;
				String price= null;
				while(rs.next()) {
					t2.setText(rs.getString("roomalocated"));
					room = rs.getString("roomalocated");
					t3.setText(rs.getString("name"));
					t4.setText(rs.getString("checkedin"));
					t5.setText(rs.getString("deposite"));
					deposite = rs.getString("deposite");
				}
				ResultSet rs2 = c.s.executeQuery("select * from addroom where room = '"+room+"'");
				while(rs2.next()) {
					price = rs2.getString("price");
					amountPaid = Integer.parseInt(price) - Integer.parseInt(deposite);
					t6.setText(Integer.toString(amountPaid));
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}else if(ae.getSource() == b2) {
			
		}else if(ae.getSource() == b3) {
			new Reception().setVisible(true);
			this.setVisible(false);
		}
	}
	
	public static void main(String[] args) {
		new UpdateCheck();
	}
}
