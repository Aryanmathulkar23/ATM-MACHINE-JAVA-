
import javax.swing.*;
import java.awt.*;

public class checkBal extends JFrame {
	
	public checkBal(String atmnumber, String atmpin) {
		setTitle("Check Balance ");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setLayout(null);
        JLabel msg = new JLabel("Message : ");
		msg.setBounds(12, 1, 300, 30);
		msg.setFont(new Font("Arial", Font.BOLD, 15));
		add(msg);
		
        JLabel acl = new JLabel("Enter Account no. :");
		acl.setBounds(40, 30, 120, 30);
		add(acl);
		JTextField ac = new JTextField();
		ac.setBounds(160, 30, 150, 30);
		add(ac);
		
        JLabel psl = new JLabel("Enter Password :");
		psl.setBounds(50, 70, 100, 30);
		add(psl);
		JPasswordField ps = new JPasswordField();
		ps.setBounds(160, 70, 150, 30);
		ps.setFont(new Font("Arial", Font.BOLD, 15));
		add(ps);


		// Optional: Add a submit button
		JButton btn = new JButton("Check");
		btn.setBounds(140, 110, 100, 30);
		btn.setFont(new Font("Arial", Font.BOLD, 15));
		add(btn);
		
		 btn.addActionListener(e -> {
	            String acn = ac.getText();
	            String psn = ps.getText();
	            if ((acn == atmnumber) && (psn == atmpin)){
	            	
	            	System.out.println("password "+psn);
	            	System.out.println("account number "+acn);
	            }
	            
	            
	        });
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String atmnumber = "12345";
        String atmpin = "124";
        AtmoperationsInterf op = new AtmOperationImpl();
		checkBal b = new checkBal(atmnumber,atmpin);
		
		b.setVisible(true);

	}

}
