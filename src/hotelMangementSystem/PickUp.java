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

public class PickUp extends JFrame implements ActionListener{

	Choice  c1;
	JButton b1,b2;
	JTable t1;
	PickUp(){
		JLabel l1 = new JLabel("Pick Up Service");
		l1.setFont(new Font("Tahuma", Font.ITALIC, 25));
		l1.setForeground(Color.blue);
		l1.setBounds(90, 20, 250, 40);
		add(l1);
		
		JLabel l2 = new JLabel("Type of Car");
		l2.setBounds(50, 90, 90, 30);
		add(l2);
		Conn c = new Conn();
		c1 = new Choice();
		try {
			ResultSet rs = c.s.executeQuery("select * from driver");
			while(rs.next()) {
				  c1.add(rs.getString("model"));
			}
		} catch (Exception e) {}
		
		c1.setBounds(170, 90, 160, 30);
		c1.setBackground(Color.white);
		add(c1);
		
		
		t1 = new JTable();
		t1.setBounds(0, 170, 1000, 300);
		add(t1);
		
		JLabel name=new JLabel("NAME");
		name.setBounds(65, 135, 50, 30);
		add(name);

		JLabel age =new JLabel("AGE");
		age.setBounds(245, 135, 65, 30);
		add(age);

		JLabel gender=new JLabel("GENDER");
		gender.setBounds(405, 135, 60, 30);
		add(gender);

		JLabel model =new JLabel("MODEL");
		model.setBounds(570, 135, 50, 30);
		add(model);

		JLabel avail =new JLabel("AVAILABLITY");
		avail.setBounds(715, 135, 80, 30);
		add(avail);
		
		JLabel loc =new JLabel("LOCATION");
		loc.setBounds(870, 135, 70, 30);
		add(loc);
		
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
				String str = "select * from driver where model= '"+c1.getSelectedItem()+"'";
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
		new PickUp();
	}

}
