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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CheckoutStatus extends JFrame implements ActionListener {
	Choice c1;
	JTextField t1;
	JButton b1,b2,imgBtn;
	
	CheckoutStatus(){
		
		JLabel j1= new JLabel("Check Out");
		j1.setBounds(130, 20, 200, 30);
		j1.setFont(new Font("Tahuma", Font.ITALIC, 25));
		j1.setForeground(Color.blue);
		add(j1);
		
		JLabel j2= new JLabel("CUSTOMER ID");
		j2.setBounds(50, 60, 100, 30);
		add(j2);
		
		c1 = new Choice();
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from newcustomer");
			while(rs.next()) {
				c1.add(rs.getString("number"));
				
			}
		
		} catch (Exception e) {}
		c1.setBounds(200, 60, 150, 30);
		add(c1);
	
		
		JLabel j3= new JLabel("ROOM NO.");
		j3.setBounds(50, 100, 100, 30);
		add(j3);
		t1 = new JTextField();
		t1.setBounds(200, 100, 150, 30);
		add(t1);
		
		b1 = new JButton("Check Out");
		b1.setBounds(50, 150, 140, 30);
		b1.setBackground(Color.black);
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);
		add(b1);
		b2 = new JButton("Cancel");
		b2.setBounds(210, 150, 140, 30);
		b2.setBackground(Color.black);
		b2.setForeground(Color.WHITE);
		b2.addActionListener(this);
		add(b2);
		
		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("image/tick.png"));
		Image img1 = img.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		ImageIcon img2 = new ImageIcon(img1);
		imgBtn = new JButton(img2);
		imgBtn.setBounds(370, 60, 20, 20);
		imgBtn.setLayout(null);
		imgBtn.addActionListener(this);
		add(imgBtn);
		
		
		setLayout(null);
		setBounds(550, 300, 450,230);
		setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == b1) {
			String id = c1.getSelectedItem();
			Conn c = new Conn();
			String room = t1.getText();
			try {
				c.s.executeUpdate("delete from newcustomer where number = '"+id+"'");
				c.s.executeUpdate("update addroom set avail = 'Available' where room = '"+room+"'");
				JOptionPane.showMessageDialog(null, "UPDATED STATUS \n Thank you...!!");
				this.setVisible(false);
			} catch (Exception e) {}
			
		}else if(ae.getSource() == b2) {
			this.setVisible(false);
		}else if(ae.getSource() == imgBtn) {
			Conn c = new Conn();
			String id = c1.getSelectedItem();
			try {
				ResultSet rs = c.s.executeQuery("select * from newcustomer where number = '"+id+"'");
				while(rs.next()) {
					t1.setText(rs.getString("roomalocated"));
				}
			} catch (Exception e) {}
			
		}
		
	}
	
	public static void main(String[] args) {
		new CheckoutStatus();
	}
}
