package hotelMangementSystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import java.sql.*;
//import com.mysql.cj.protocol.Resultset;


//import net.

public class EmpInfo extends JFrame implements ActionListener{

	JTable t1;
	JButton b1,b2;
	
	EmpInfo(){
		t1 = new  JTable();
		t1.setBounds(0, 40, 1000, 500);
		add(t1);
	
		b1 = new JButton("Load Data");
		b1.setBounds(350, 560, 120, 30);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Cancel");
		b2.setBounds(480, 560, 120, 30);
		b2.addActionListener(this);
		add(b2);
		
		setLayout(null);
		setBounds(450, 200, 1000, 650);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == b1 ) {
			try {
				Conn c = new Conn();
				String str = "select * from empinfo";
//				Resultset rs = c.s.executeQuery(str);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}else if(ae.getSource() == b2) {
			new EmpInfo().setVisible(true);
			this.setVisible(false);
		}
	}
	
	public static void main(String[] args) {
		new EmpInfo();
	}

}
