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
		name.setBounds(70, 80, 100, 30);
		name.setFont(new Font("Tahuma", Font.PLAIN, 17));
		add(name);
		t4 = new JTextField();
		t4.setBounds(185, 80, 150, 30);
		add(t4);
		
		JLabel age= new  JLabel("Age          :");
		age.setBounds(70, 130, 100, 30);
		age.setFont(new Font("Tahuma", Font.PLAIN, 17));
		add(age);
		t1 = new JTextField();
		t1.setBounds(185, 130, 150, 30);
		add(t1);
		
		JLabel gender= new  JLabel("Gender     :");
		gender.setBounds(70, 180, 110, 30);
		gender.setFont(new Font("Tahuma", Font.PLAIN, 17));
		add(gender);
		r1 = new JRadioButton("Male");
		r1.setBounds(185, 180, 60, 30);
		add(r1);
		
		r2 = new JRadioButton("Female");
		r2.setBounds(245, 180, 70, 30);
		add(r2);
	
		
		
		
		JLabel car= new  JLabel("Car           :");
		car.setBounds(70, 230, 100, 30);
		car.setFont(new Font("Tahuma", Font.PLAIN, 17));
		add(car); 
		t2 = new JTextField();
		t2.setBounds(185, 230, 150, 30);
		add(t2);
		
		JLabel model= new  JLabel("Model       :");
		model.setBounds(70, 280, 100, 30);
		model.setFont(new Font("Tahuma", Font.PLAIN, 17));
		add(model);
		t3 = new JTextField();
		t3.setBounds(185, 280, 150, 30);
		add(t3);
		
		JLabel avail= new  JLabel("Available   :");
		avail.setBounds(70, 330, 100, 30);
		avail.setFont(new Font("Tahuma", Font.PLAIN, 17));
		add(avail);
		
		c1 = new JComboBox(new String[] {"---------", "Avalable", "Not-Avalable"});
		c1.setBounds(185, 330, 150, 30);
		c1.setBackground(Color.white);
		add(c1);
		
		JLabel loc = new JLabel("Location    :");
		loc.setBounds(70, 380, 100, 30);
		loc.setFont(new Font("Tahuma", Font.PLAIN, 17));
		add(loc); 
		t5 = new JTextField();
		t5.setBounds(185, 380, 150, 30);
		add(t5);
		
		b1 = new JButton("Add Driver");
		b1.setFont(new Font("Tahuma", Font.BOLD,18));
		b1.setBounds(100, 460, 200, 50);
		b1.setBackground(Color.BLUE);
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);
		add(b1);
		
		
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("image/eleven.jpg"));
		Image i2 = i1.getImage().getScaledInstance(550, 500, Image.SCALE_DEFAULT);
		JLabel img = new JLabel(new ImageIcon(i2));
		img.setBounds(370, 100, 550, 470);
		add(img);
		
		setLayout(null);
		setBounds(400, 200, 950, 600);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == b1) {
			String name = t1.getText();
			String age = t2.getText();
			String gender = null;
			
			if(r1.isSelected())gender= "Male";
			else if(r2.isSelected()) gender = "Female";
			
			String car = t3.getText();
			String model = t4.getText();
			String avail =(String) c1.getSelectedItem();
			String loc = t5.getText();
			
			String str = "insert into driver values('"+name+"','"+age+"','"+gender+"','"+car+"','"+model+"','"+avail+"','"+loc+"')";
			
			Conn c = new Conn();
			
			try {
				c.s.executeUpdate(str);
				JOptionPane.showConfirmDialog(null, "Driver is added");
			} catch (Exception e) {
				System.out.println(e);
			}
			
		}
	}

	public static void main(String[] args) {
		new AddDri();

	}

}
