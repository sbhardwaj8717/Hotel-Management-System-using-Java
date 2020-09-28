package hotelMangementSystem;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AddNewCustumer extends JFrame implements ActionListener{
	
		JTextField t1,t2,t3,t4,t5;
		JRadioButton r1,r2;
		JComboBox c1;
		Choice c2;
		JButton b1,b2;
	
		AddNewCustumer(){
			JLabel j1 = new JLabel("NEW CUSTOMER");
			j1.setBounds(70, 20, 2000, 50);
			j1.setFont(new Font("Tahuma",Font.ITALIC,40));
			j1.setForeground(Color.magenta);
			add(j1);
			
			JLabel j2 = new JLabel("ID");
			j2.setBounds(80, 100, 200, 30);
			add(j2);
			c1 = new JComboBox(new String[] {"------------------","AADHAR CARD","VOTER ID CARD", "PAN CARD"});
			c1.setBounds(180, 100, 200, 30);
			c1.setBackground(Color.WHITE);
			add(c1);
			
			JLabel j3 = new JLabel("NUMBER");
			j3.setBounds(80, 140, 200, 30);
			add(j3);
			t1 = new JTextField();
			t1.setBounds(180,140, 200,30);
			add(t1);
			
			JLabel j4 = new JLabel("NAME");
			j4.setBounds(80, 180, 200, 30);
			add(j4);
			t2 = new JTextField();
			t2.setBounds(180,180, 200,30);
			add(t2);
			
			
			JLabel j5 = new JLabel("GENDER");
			j5.setBounds(80, 220, 200, 30);
			add(j5);
			r1 = new JRadioButton("Male");
			r1.setBounds(180, 220, 60, 30);
			r1.setBackground(Color.WHITE);
			add(r1);

			r2 = new JRadioButton("Female");
			r2.setBounds(240, 220, 70, 30);
			r2.setBackground(Color.WHITE);
			add(r2);
		
			
			JLabel j6 = new JLabel("COUNTRY");
			j6.setBounds(80, 260, 200, 30) ;
			add(j6);
			t3 = new JTextField();
			t3.setBounds(180,260, 200,30);
			add(t3);
			
			JLabel j7 = new JLabel("ROOM NO.    :");
			j7.setBounds(80, 300, 100, 30);
			add(j7); 
			c2 = new Choice();
			try {
				Conn c = new Conn();
				String str ="select * from addroom";
				ResultSet rs = c.s.executeQuery(str);
				while(rs.next()) {
					c2.add(rs.getString("room"));
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			c2.setBounds(180,300, 200, 30);
			add(c2);
		
			JLabel j8 = new JLabel("CHECKED IN");
			j8.setBounds(80, 340, 200, 30);
			add(j8);

			t4 = new JTextField();
			t4.setBounds(180,340, 200,30);
			add(t4);
		
			JLabel j9 = new JLabel("DEPOSITE    ");
			j9.setBounds(80, 380, 200, 30);
			add(j9);

			t5 = new JTextField();
			t5.setBounds(180,380, 200,30);
			add(t5);
			
			
			b1 = new  JButton("ADD CUSTOMER");
			b1.setBackground(Color.BLACK);
			b1.setForeground(Color.WHITE);
			b1.setBounds(80, 450, 150, 40);
			b1.addActionListener(this);
			add(b1);
			

			b2 = new  JButton("CANCLE");
			b2.setBackground(Color.BLACK);
			b2.setForeground(Color.WHITE);
			b2.setBounds(250, 450, 150, 40);
			b2.addActionListener(this);
			add(b2);
			
			ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("image/customer.jpg"));
			Image img1 = img.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
			ImageIcon img2 = new ImageIcon(img1);
			JLabel imgLable = new JLabel(img2); 
			imgLable.setBounds(400, 70, 500, 450);
			add(imgLable);
			getContentPane().setBackground(Color.WHITE);
			setLayout(null);
			setBounds(310, 150, 1000, 600);
			setVisible(true);
			
			
		}
		
		@Override
		public void actionPerformed(ActionEvent ae) {
			if(ae.getSource() == b1) {
				String id =(String) c1.getSelectedItem();
				String number = t1.getText();
				String name = t2.getText();
				String gender = null;
				if(r1.isSelected()) gender = "Male";
				else if(r2.isSelected()) gender = "Female";
				String countary = t3.getText();
				String roomNumber = c2.getSelectedItem();
				String checkedIn= t4.getText();
				String deposite = t5.getText();
				
				String str = "insert into newcustomer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+countary+"','"+roomNumber+"','"+checkedIn+"','"+deposite+"')";
				String str2 ="update addroom set avail = 'Occupied' where room = '"+roomNumber+"'";
				try {
					Conn c = new Conn();
					c.s.executeUpdate(str);
					JOptionPane.showMessageDialog(null, "ADDED");
					c.s.executeUpdate(str2);
					this.setVisible(false);
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				
			}else if(ae.getSource() == b2) {
				this.setVisible(false);
			}
		}
	
	

}
