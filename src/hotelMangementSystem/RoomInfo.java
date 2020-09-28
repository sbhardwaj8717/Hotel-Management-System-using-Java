package hotelMangementSystem;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class RoomInfo extends JFrame implements ActionListener{
	
	JTable t1;
	JButton b1, b2;
	RoomInfo(){
		
		
		t1 = new JTable();
//		t1.setBackground(Color.black);
//		t1.setForeground(Color.WHITE);
		t1.setBounds(0, 50, 600, 300);
		add(t1);
		
		
		
		b1= new JButton("Load Data");
		b1.setBounds(100, 400, 150, 30);
		b1.setForeground(Color.white);
		b1.setBackground(Color.black);
		b1.setVisible(true);
		b1.addActionListener(this);
		add(b1);
		
		b2= new JButton("Cancle");
		b2.setBounds(300,400, 150, 30);
		b2.setForeground(Color.white);
		b2.setBackground(Color.black);
		b2.setVisible(true);
		b2.addActionListener(this);
		add(b2);
		
		JLabel j1 = new JLabel("ROOM NO.");
		j1.setBounds(30, 10, 600, 30);
		add(j1);
	
		JLabel j2 = new JLabel("AVAILABLE");
		j2.setBounds(145, 10, 600, 30);
		add(j2);
		
		JLabel j3 = new JLabel("CLEANING");
		j3.setBounds(270, 10, 600, 30);
		add(j3);
		
		JLabel j4 = new JLabel("PRICE");
		j4.setBounds(395, 10, 600, 30);
		add(j4);
		

		JLabel j5 = new JLabel("BED");
		j5.setBounds(520, 10, 600, 30);
		add(j5);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("image/bed.jpg"));
		Image i2 = i1.getImage().getScaledInstance(400, 450, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel img = new JLabel(i3);
		img.setBounds(600, 0, 400, 500);
		add(img);
		getContentPane().setBackground(Color.white);
		setBounds(280,230,1020,520);
		setLayout(null);
		setVisible(true);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == b1) {
			try {
				Conn c = new Conn();
				String str = "select * from addroom";
				
				ResultSet rs;
				rs = c.s.executeQuery(str);
				t1.setModel(DbUtils.resultSetToTableModel(rs));
			} catch (SQLException e) {
				System.out.println(e);	
			}
		}else if(ae.getSource() == b2) {
			this.setVisible(false);
		}
	}
	
	


}
