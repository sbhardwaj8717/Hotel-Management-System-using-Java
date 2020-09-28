package hotelMangementSystem;

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

public class SearchRoom extends JFrame implements ActionListener{

	JComboBox c1;
	JCheckBox c2;
	JButton b1,b2;
	JTable t1;
	SearchRoom(){
		JLabel l1 = new JLabel("Search For Room");
		l1.setFont(new Font("Tahuma", Font.ITALIC, 25));
		l1.setForeground(Color.blue);
		l1.setBounds(90, 20, 250, 40);
		add(l1);
		
		JLabel l2 = new JLabel("Room bed Type");
		l2.setBounds(50, 90, 90, 30);
		add(l2);
		c1 = new JComboBox(new String[] {"----------------","Single", "Double"});
		c1.setBounds(170, 90, 160, 30);
		c1.setBackground(Color.white);
		add(c1);
		
		c2 = new JCheckBox("Only show available");
		c2.setBounds(500, 90, 160, 30);
		c2.setBackground(Color.white);
		add(c2);
		
		t1 = new JTable();
		t1.setBounds(0, 170, 1000, 300);
		add(t1);
		
		JLabel tRoom =new JLabel("ROOM");
		tRoom.setBounds(75, 135, 50, 30);
		add(tRoom);

		JLabel avail =new JLabel("AVAILABLE");
		avail.setBounds(260, 135, 65, 30);
		add(avail);

		JLabel clean =new JLabel("CLEAN");
		clean.setBounds(480, 135, 50, 30);
		add(clean);

		JLabel price =new JLabel("PRICE");
		price.setBounds(670, 135, 50, 30);
		add(price);

		JLabel bed =new JLabel("BED TYPE");
		bed.setBounds(870, 135, 70, 30);
		add(bed);
		
		b1 = new JButton("SUBMIT");
		b1.setBounds(300, 540, 120, 30);
		b1.setForeground(Color.WHITE);
		b1.setBackground(Color.black);
		b1.addActionListener(this);
		add(b1);
	
		b2 = new JButton("BACK");
		b2.setBounds(450, 540, 120, 30);
		b2.addActionListener(this);
		add(b2);
	
		
		setLayout(null);
		setVisible(true);
		getContentPane().setBackground(Color.white);
		setBounds(330, 100, 1020, 630);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == b1) {
			try {
				String str = "select * from addroom where bed = '"+c1.getSelectedItem()+"'";
				String str2 ="select * from addroom where avail = 'Available' AND bed= '"+c1.getSelectedItem()+"'";
				Conn c = new Conn();
				
				if(c2.isSelected()) {
					ResultSet rs2 = c.s.executeQuery(str2);
					t1.setModel(DbUtils.resultSetToTableModel(rs2));
				}else {					
					ResultSet rs = c.s.executeQuery(str);
					t1.setModel(DbUtils.resultSetToTableModel(rs));
				}
			} catch (Exception e) {}
			
		}else if(ae.getSource() == b2) {
			new Reception().setVisible(true);
			this.setVisible(false);
		}
	}

	
}
