package hotelMangementSystem;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class AddRooms extends JFrame implements ActionListener{
	
	JTextField t1,t2;
	JComboBox c1, c2, c3;
	JButton b1,b2;
	AddRooms(){
		
		JLabel l1 = new JLabel("Add Room...!!");
		l1.setBounds(110, 30, 500, 50);
		l1.setFont(new Font("Comic Sans MS", Font.LAYOUT_LEFT_TO_RIGHT,50));
		l1.setForeground(Color.red);
		add(l1);
		
		
		JLabel room = new JLabel("Room No.              :"); 
		room.setBounds(50, 120, 200, 30);
		room.setFont(new Font("Tahuma", Font.PLAIN,20));
		room.setForeground(Color.black);
		add(room);
		
		t1 = new JTextField();
		t1.setBounds(250, 120, 200, 30);
		add(t1);
		
		
		JLabel avail = new JLabel("Available               :");
		avail.setBounds(50, 170, 200, 30);
		avail.setFont(new Font("Tahuma", Font.PLAIN,20));
		avail.setForeground(Color.black);
		add(avail);
		c1 = new JComboBox(new String[] {"-------","Available" , "Occupied"});
		c1.setBounds(250, 170, 200, 30);
		c1.setBackground(Color.white);
		add(c1);
		
		

		JLabel clean = new JLabel("Cleaning Status    :");
		clean.setBounds(50, 220, 200, 30);
		clean.setFont(new Font("Tahuma", Font.PLAIN,20));
		clean.setForeground(Color.black);
		add(clean);
		
		c2 = new JComboBox(new String[] {"-------","Clean" , "Dirty"});
		c2.setBounds(250,  220, 200, 30);
		c2.setBackground(Color.white);
		add(c2);
		
		
	
		JLabel price = new JLabel("Price                     :");
		price.setBounds(50, 270, 200, 30);
		price.setFont(new Font("Tahuma", Font.PLAIN,20));
		price.setForeground(Color.black);
		add(price);
		
		
		t2 = new JTextField();
		t2.setBounds(250, 270, 200, 30);
		add(t2);
		
		JLabel bed = new JLabel("Bed Type              :");
		bed.setBounds(50, 320, 200, 30);
		bed.setFont(new Font("Tahuma", Font.PLAIN,20));
		bed.setForeground(Color.black);
		add(bed);
		
		c3 = new JComboBox(new String[] {"-------","Single" , "Double"});
		c3.setBounds(250, 320, 200, 30);
		c3.setBackground(Color.white);
		add(c3);
		
		
		b1 = new JButton("ADD");
		b1.setBounds(130, 395, 90, 30);
		b1.setForeground(Color.white);
		b1.setBackground(Color.blue);
		b1.addActionListener(this);
		add(b1);
		
			
		b2 = new JButton("Cancle");
		b2.setBounds(250, 395, 90, 30);
		b2.setForeground(Color.white);
		b2.setBackground(Color.red);
		b2.addActionListener(this);
		add(b2);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("image/bed.jpg"));
		Image i2 = i1.getImage().getScaledInstance(550, 480, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel j2 = new JLabel(i3);
		j2.setBounds(460, 25, 550, 480);
		add(j2);
		
		getContentPane().setBackground(Color.white);
		
		setBounds(270, 160, 1050, 567);
		setLayout(null);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == b1) {
			 String room = t1.getText();
			 String avail = (String) c1.getSelectedItem();
			 String clean = (String) c2.getSelectedItem();
			 String price = t1.getText();
			 String bed = (String) c3.getSelectedItem();
			 
			 Conn c = new Conn();
			 String str = "insert into addroom values('"+room+"','"+avail+"','"+clean+"','"+price+"','"+bed+"')";
			 
			 try {
				c.s.executeUpdate(str);
				JOptionPane.showMessageDialog(null, "Details Added");
				this.setVisible(false);
			} catch (Exception e) {	}
			 
			 
		}else if(ae.getSource() == b2) {
			this.setVisible(false);
		}
	}

	public static void main(String[] args) {
		new AddRooms().setVisible(true);
	}

}
