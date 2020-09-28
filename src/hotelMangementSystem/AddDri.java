package hotelMangementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AddDri extends JFrame implements ActionListener {
	
	JTextField t1,t2,t3,t4, t5;
	JRadioButton r1 , r2;
	JComboBox c1;
	JButton b1;
	
	AddDri(){
		
		JLabel driver = new JLabel("Add Driver...!!");
		driver.setFont(new Font("Comic Sans MS", Font.LAYOUT_LEFT_TO_RIGHT,70));
		driver.setForeground(Color.RED);	
		driver.setBounds(230, 0, 600, 100);
		add(driver);
		
		JLabel name= new  JLabel("Name          :");
		name.setBounds(70, 100, 100, 30);
		name.setFont(new Font("Tahuma", Font.PLAIN, 17));
		add(name);
		t1 = new JTextField();
		t1.setBounds(185, 100, 150, 30);
		add(t1);
		
		JLabel age= new  JLabel("Age          :");
		age.setBounds(70, 150, 100, 30);
		age.setFont(new Font("Tahuma", Font.PLAIN, 17));
		add(age);
		t2 = new JTextField();
		t2.setBounds(185, 150, 150, 30);
		add(t2);
		
		JLabel gender= new  JLabel("Gender     :");
		gender.setBounds(70, 200, 110, 30);
		gender.setFont(new Font("Tahuma", Font.PLAIN, 17));
		add(gender);
		r1 = new JRadioButton("Male");
		r1.setBounds(185, 200, 60, 30);
		r1.setBackground(Color.white);
		add(r1);
		
		r2 = new JRadioButton("Female");
		r2.setBounds(245, 200, 70, 30);
		r2.setBackground(Color.white);
		add(r2);
	
		
		
		
		JLabel car= new  JLabel("Car           :");
		car.setBounds(70, 250, 100, 30);
		car.setFont(new Font("Tahuma", Font.PLAIN, 17));
		add(car); 
		t3 = new JTextField();
		t3.setBounds(185, 250, 150, 30);
		add(t3);
		
		JLabel model= new  JLabel("Model       :");
		model.setBounds(70, 300, 100, 30);
		model.setFont(new Font("Tahuma", Font.PLAIN, 17));
		add(model);
		t4 = new JTextField();
		t4.setBounds(185, 300, 150, 30);
		add(t4);
		
		JLabel avail= new  JLabel("Available   :");
		avail.setBounds(70, 350, 100, 30);
		avail.setFont(new Font("Tahuma", Font.PLAIN, 17));
		add(avail);
		
		c1 = new JComboBox(new String[] {"---------", "Avalable", "Not-Avalable"});
		c1.setBounds(185, 350, 150, 30);
		c1.setBackground(Color.white);
		add(c1);
		
		JLabel loc = new JLabel("Location    :");
		loc.setBounds(70, 400, 100, 30);
		loc.setFont(new Font("Tahuma", Font.PLAIN, 17));
		add(loc); 
		t5 = new JTextField();
		t5.setBounds(185, 400, 150, 30);
		add(t5);
		
		b1 = new JButton("Add Driver");
		b1.setFont(new Font("Tahuma", Font.BOLD,18));
		b1.setBounds(100, 480, 200, 50);
		b1.setBackground(Color.BLUE);
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);
		add(b1);
		
		
		getContentPane().setBackground(Color.WHITE);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("image/eleven.jpg"));
		Image i2 = i1.getImage().getScaledInstance(550, 500, Image.SCALE_DEFAULT);
		JLabel img = new JLabel(new ImageIcon(i2));
		
		img.setBounds(370, 100, 550, 470);
		add(img);
		setLayout(null);
		setBounds(340, 150, 950, 600);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == b1) {
			String name = t1.getText();
			String age = t2.getText();
			String carModel  = t3.getText() +" "+t4.getText();
			 
			String loc = t5.getText();
			
			String avail = (String)c1.getSelectedItem();
			String gender = null;
			
			if(r1.isSelected()) gender = "Male";
			else if(r2.isSelected()) gender = "Female";
			Conn c = new Conn();
			String str = "insert into driver values('"+name+"','"+age+"','"+gender+"','"+carModel+"','"+avail+"','"+loc+"')";
			
			try {
				c.s.executeUpdate(str);
				JOptionPane.showMessageDialog(null, "Details Added");
				this.setVisible(false);
			} catch (Exception e) {	
				System.out.println(e);
			}
			 
		}
	}

	
}
