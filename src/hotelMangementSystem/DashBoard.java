package hotelMangementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class DashBoard extends JFrame implements ActionListener{
	// globally dicrearing the options				 										
	JMenuBar mb;					// nav bar type
	JMenu m1,m2;						//  menus
	JMenuItem i1,i2,i3,i4;				// dropdowm items
	public DashBoard(){
		
		mb = new JMenuBar();
		add(mb);
		m1 = new JMenu("Hotel Management");										// menu Buttons or dropdown
		m1.setForeground(Color.RED);
		mb.add(m1);
		
		m2 = new JMenu("Admin");
		m2.setForeground(Color.blue);
		mb.add(m2);
		
		i1 = new JMenuItem("Reception");										// Items in Menu
		i1.addActionListener(this);
		m1.add(i1);
		
		i2 = new JMenuItem("ADD NEW EMPLOYEE");
		i2.addActionListener(this);
		m2.add(i2);
		
		i3 = new JMenuItem("ADD ROOMS");
		i3.addActionListener(this);
		m2.add(i3);
		
		i4 = new JMenuItem("ADD DRIVERS");
		i4.addActionListener(this);
		m2.add(i4);
		
		mb.setBounds(0, 0, 1950, 30);
		
		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("image/dash.jpg"));
		Image img2 = img.getImage().getScaledInstance(1950, 1000, Image.SCALE_DEFAULT);
		ImageIcon img3 = new ImageIcon(img2);
		JLabel l1 = new JLabel(img3);
		l1.setBounds(0,0,1950, 1000);
		add(l1);
		
		JLabel l2 = new JLabel("A Java Project by S.8717");
		l2.setBounds(500, 700, 1000, 80);
		l2.setForeground(Color.blue);
		l2.setFont(new Font("Tahoma", Font.PLAIN, 50));
		l1.add(l2);
		
		setLayout(null);
		setBounds(-10, 0, 1950, 1020);
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == i2) {																// We may use ae.getActionCommand too for the menu items
			new AddEmp().setVisible(true);
		}else if(ae.getActionCommand().equals("ADD ROOMS")) {
			new AddRooms().setVisible(true);
		}else if(ae.getActionCommand().equals("ADD DRIVERS")) {
			new AddDri().setVisible(true);
		}else if(ae.getActionCommand().equals("Reception")){
			new Reception().setVisible(true);
		}
	}
	
	
	public static void main(String[] args) {
		new DashBoard().setVisible(true);
	}


} 
