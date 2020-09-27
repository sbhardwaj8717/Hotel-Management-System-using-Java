package hotelMangementSystem;



import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

//import com.mysql.cj.protocol.Resultset;

import java.sql.*;
//import com.mysql.cj.protocol.Resultset;
import net.proteanit.sql.DbUtils;

public class CustomerInfo extends JFrame implements ActionListener{

	JTable t1;
	JButton b1,b2;
	
	CustomerInfo (){ 
		JLabel j1 = new JLabel("ID");
		j1.setBounds(40, 10, 50, 30);
		add(j1);

		JLabel j2 = new JLabel("ID NUMBER");
		j2.setBounds(145, 10, 70, 30);
		add(j2);

		JLabel j3 = new JLabel("NAME");
		j3.setBounds(285, 10, 80, 30);
		add(j3);
		
		JLabel j4 = new JLabel("GENDER");
		j4.setBounds(400, 10, 60, 30);
		add(j4);
		
		JLabel j5 = new JLabel("COUNTRY");
		j5.setBounds(530, 10, 70, 30);
		add(j5);
		
		JLabel j6 = new JLabel("ROOM");
		j6.setBounds(660, 10, 70, 30);
		add(j6);
		
		JLabel j7 = new JLabel("CHECKED IN");
		j7.setBounds(780, 10, 80, 30);
		add(j7);
		
		JLabel j8 = new JLabel("DEPOSITE");
		j8.setBounds(890, 10, 80, 30);
		add(j8);
		
		
		t1 = new  JTable();								// table object with rows and columns
		t1.setBounds(0, 40, 1000, 500);
		add(t1);
	
		b1 = new JButton("LOAD DATA");
		b1.setBounds(350, 560, 130, 30);
		b1.addActionListener(this);
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		
		add(b1);
		
		b2 = new JButton("Cancel");
		b2.setBounds(490, 560, 130, 30);
		b2.addActionListener(this);
		add(b2);
		
		
		getContentPane().setBackground(Color.white);
		setLayout(null);
		setBounds(280, 100, 1020, 650);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == b1 ) {
			try {
				Conn c = new Conn(); 
				String str = "select * from newcustomer";        		// selecting the data form the table
				ResultSet rs = c.s.executeQuery(str);	  							// executeing the query    
				t1.setModel(DbUtils.resultSetToTableModel(rs));				        // showing the data in the table format		
			
			} catch (Exception e) {
				System.out.println(e);
				}
		}else if(ae.getSource() == b2) {
			this.setVisible(false);
		}
	}
	
	public static void main(String[] args) {
		new CustomerInfo ();
	}

}
