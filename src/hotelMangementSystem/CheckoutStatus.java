package hotelMangementSystem;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class CheckoutStatus extends JFrame {
	
	
	CheckoutStatus(){
		
		JLabel j1= new JLabel("Check Out");
		j1.setBounds(30, 20, 100, 30);
		add(j1);

		JLabel j2= new JLabel("Check Out");
		j2.setBounds(30, 60, 100, 30);
		add(j2);

		JLabel j3= new JLabel("Check Out");
		j3.setBounds(30, 100, 100, 30);
		add(j3);
		
		
		setLayout(null);
		setBounds(200, 300, 1000, 600);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new CheckoutStatus();
	}
}
