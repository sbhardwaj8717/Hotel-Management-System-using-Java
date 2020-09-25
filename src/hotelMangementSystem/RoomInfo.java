package hotelMangementSystem;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class RoomInfo extends JFrame implements ActionListener{
	
	JTable t1;
	JButton b1, b2;
	RoomInfo(){
		t1 = new JTable();
//		t1.setBackground(Color.black);
//		t1.setForeground(Color.WHITE);
		setBounds(0, 30, 100, 300);
		add(t1);
		
		
		b1= new JButton("Load Data");
		b1.setBounds(300, 400, 150, 30);
		b1.setForeground(Color.white);
		b1.setBackground(Color.black);
		b1.setVisible(true);
		b1.addActionListener(this);
		add(b1);
		
		b2= new JButton("Cancle");
		b2.setBounds(500,400, 150, 30);
		b2.setForeground(Color.white);
		b2.setBackground(Color.black);
		b2.setVisible(true);
		b2.addActionListener(this);
		add(b2);
		
		
		
		setBounds(300,230,1000,500);
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
	
	
	public static void main(String[] args) {
		new RoomInfo();
	}

}
