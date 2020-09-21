package hotelMangementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class AddEmp extends JFrame implements ActionListener {
	JTextField t1,t2,t3,t4,t5,t6;
	JRadioButton r1, r2;
	JComboBox c1;
	JButton b1;
	AddEmp(){
		JLabel name = new JLabel("NAME            :");	
		name.setFont(new Font("Tahuma", Font.PLAIN, 17));
		name.setBounds(60,30,120,30);
		add(name);
		t1 = new JTextField();
		t1.setBounds(200, 30, 160, 30);
		add(t1);
		
		JLabel age = new JLabel("AGE              :");	
		age.setFont(new Font("Tahuma", Font.PLAIN, 17));
		age.setBounds(60,80,120,30);
		add(age);
		t2 = new JTextField();
		t2.setBounds(200, 80, 160, 30);
		add(t2);
		
		JLabel gender = new JLabel("GENDER       :");	
		gender.setFont(new Font("Tahuma", Font.PLAIN, 17));
		gender.setBounds(60,130,120,30);
		add(gender);
		
		r1 = new JRadioButton("Male");
		r1.setBounds(200, 120, 70, 30);
		r1.setFont(new Font("Tahuma", Font.PLAIN, 15));
		r1.setBackground(Color.white);
		add(r1);
		r2 = new JRadioButton("Female");
		r2.setBounds(270, 120, 100, 30);
		r2.setFont(new Font("Tahuma", Font.PLAIN, 15));
		r2.setBackground(Color.white);
		add(r2);
		
		
		JLabel job = new JLabel("JOB              :");	
		job.setFont(new Font("Tahuma", Font.PLAIN, 17));
		job.setBounds(60,180,120,30);
		add(job);
		String str[] =  {"-----","Manager", "Chef", "Sweeper", "Cleaner Boy", "Waiter" , "Compounder", "Receptionist, MR"};
		c1 = new JComboBox(str);
		c1.setBounds(200, 180, 160, 30);
		c1.setBackground(Color.white);
		add(c1);
		
		
		JLabel salary = new JLabel("SALARY        :");	
		salary.setFont(new Font("Tahuma", Font.PLAIN, 17));
		salary.setBounds(60,230,120,30);
		add(salary);
		t3 = new JTextField();
		t3.setBounds(200, 230, 160, 30);
		add(t3);
		
		JLabel phone = new JLabel("PHONE         :");	
		phone.setFont(new Font("Tahuma", Font.PLAIN, 17));
		phone.setBounds(60,280,120,30);
		add(phone);
		t4 = new JTextField();
		t4.setBounds(200, 280, 160, 30);
		add(t4);

		JLabel aadhar = new JLabel("AADHAR       :");	
		aadhar.setFont(new Font("Tahuma", Font.PLAIN, 17));
		aadhar.setBounds(60,320,120,30);
		add(aadhar);
		t5 = new JTextField();
		t5.setBounds(200, 320, 160, 30);
		add(t5);
		
		JLabel email = new JLabel("EMAIL           :");	
		email.setFont(new Font("Tahuma", Font.PLAIN, 17));
		email.setBounds(60,370,120,30);
		add(email);
		t6 = new JTextField();
		t6.setBounds(200, 370, 160, 30);
		add(t6);
		
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("image/emp.png"));
		Image i2 = i1.getImage().getScaledInstance(500, 460, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l1 = new JLabel(i3);
		l1.setBounds(390, 115, 470, 420);
		add(l1);
		
		JLabel j1 = new JLabel("Details...!!");
		j1.setFont(new Font("Comic Sans MS", Font.LAYOUT_LEFT_TO_RIGHT,70));
		j1.setForeground(Color.RED);	
		j1.setBounds(400, 10, 400, 100);
		add(j1);
		
		b1 = new JButton("Submit");
		b1.setBackground(Color.blue);
		b1.setForeground(Color.white);
		b1.setBounds(150, 420, 120, 40);
		b1.setFont(new Font("Tahuma", Font.HANGING_BASELINE, 15));
		b1.addActionListener(this);
		add(b1);
		
		
		
		getContentPane().setBackground(Color.white);
		setLayout(null);
		setBounds(350, 140, 900, 600);
		setVisible(true);
		}
	
	public void actionPerformed(ActionEvent ae) {
		String name = t1.getText(); 
		String age  = t2.getText(); 
		String salary = t3.getText(); 
		String phone = t4.getText(); 
		String adhar  = t5.getText(); 
		String email = t6.getText(); 
		
		String gender = null;
		if(r1.isSelected()) gender = "male";
		else if(r2.isSelected())  gender = "female";
		
		String job =(String) c1.getSelectedItem();
		
		
		
		
		Conn c = new Conn();
		String str  = "insert into emp values('"+name+"', '"+age+"', '"+gender+"' ,'"+job+"', '"+salary+"', '"+phone+"', '"+adhar+"', '"+email+"')";
		try {
			c.s.executeUpdate(str);
			JOptionPane.showMessageDialog(null, "Details Added");
			this.setVisible(false);
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
	
	}
	
	public static void main(String[] args) {
		new AddEmp();
	}
}
