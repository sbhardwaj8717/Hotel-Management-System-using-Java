package hotelMangementSystem;


import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class DepartmentInfo extends JFrame implements ActionListener{

	JButton b1,b2;
	JTable t1;
	DepartmentInfo (){
		JLabel l1 = new JLabel("DEPARTMENT");
		l1.setFont(new Font("Tahuma", Font.ITALIC, 25));
		l1.setForeground(Color.blue);
		l1.setBounds(30, 20, 250, 40);
		add(l1);
		
		JLabel l2 = new JLabel("BUGDET");
		l2.setFont(new Font("Tahuma", Font.ITALIC, 25));
		l2.setForeground(Color.GREEN);
		l2.setBounds(300, 20, 250, 40);
		add(l2);
		
		t1 = new JTable();
		t1.setBounds(0, 60, 500, 100);
		add(t1);
		
		
		b1 = new JButton("SUBMIT");
		b1.setBounds(100, 540, 120, 30);
		b1.setForeground(Color.WHITE);
		b1.setBackground(Color.black);
		b1.addActionListener(this);
		add(b1);
	
		b2 = new JButton("BACK");
		b2.setBounds(240, 540, 120, 30);
		b2.addActionListener(this);
		add(b2);
	
		
		setLayout(null);
		setVisible(true);
		getContentPane().setBackground(Color.white);
		setBounds(330, 100, 500, 630);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == b1) {
			try {
				String str = "select * from department";
				Conn c = new Conn();
					ResultSet rs = c.s.executeQuery(str);
					t1.setModel(DbUtils.resultSetToTableModel(rs));				
			} catch (Exception e) {}
			
		}else if(ae.getSource() == b2) {
			new Reception().setVisible(true);
			this.setVisible(false);
		}
	}

	public static void main(String[] args) {
		new DepartmentInfo ();
	}

}
