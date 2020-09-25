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

public class ManagerInfo extends JFrame implements ActionListener{

	JTable t1;
	JButton b1,b2;
	
	ManagerInfo (){ 
		JLabel j1 = new JLabel("NAME");
		j1.setBounds(34, 10, 50, 30);
		add(j1);

		JLabel j2 = new JLabel("AGE");
		j2.setBounds(175, 10, 50, 30);
		add(j2);

		JLabel j3 = new JLabel("GENDER");
		j3.setBounds(279, 10, 70, 30);
		add(j3);
		
		JLabel j4 = new JLabel("JOB");
		j4.setBounds(413, 10, 50, 30);
		add(j4);
		
		JLabel j5 = new JLabel("SALARY");
		j5.setBounds(540, 10, 50, 30);
		add(j5);
		
		JLabel j6 = new JLabel("PHONE NO.");
		j6.setBounds(650, 10, 70, 30);
		add(j6);
		
		JLabel j7 = new JLabel("AADHAR");
		j7.setBounds(780, 10, 50, 30);
		add(j7);
		
		JLabel j8 = new JLabel("EMAIL");
		j8.setBounds(905, 10, 50, 30);
		add(j8);
		
		
		t1 = new  JTable();
		t1.setBounds(0, 40, 1000, 500);
		add(t1);
	
		b1 = new JButton("Load Data");
		b1.setBounds(350, 560, 120, 30);
		b1.addActionListener(this);
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		
		add(b1);
		
		b2 = new JButton("Cancel");
		b2.setBounds(480, 560, 120, 30);
		b2.addActionListener(this);
		add(b2);
		
		
		getContentPane().setBackground(Color.white);
		setLayout(null);
		setBounds(300, 100, 1020, 650);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == b1 ) {
			try {
				Conn c = new Conn(); 
				String str = "select * from emp where job = 'Manager'";
				ResultSet rs = c.s.executeQuery(str);
				t1.setModel(DbUtils.resultSetToTableModel(rs));
			
			
			} catch (Exception e) {
				System.out.println(e);
				}
		}else if(ae.getSource() == b2) {
			this.setVisible(false);
		}
	}
	
	public static void main(String[] args) {
		new ManagerInfo ();
	}

}
