import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Arrays;
public class withdraw extends JFrame {
	
	public withdraw() {
		setTitle("Wthdraw");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setLayout(null);
        JLabel msg = new JLabel("Message : ");
		msg.setBounds(12, 1, 100, 30);
		msg.setFont(new Font("Arial", Font.BOLD, 15));
		add(msg);
		
        JLabel acl = new JLabel("Enter Account no.:");
		acl.setBounds(40, 30, 130, 30);
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
		
		JLabel aml = new JLabel("Enter amount :");
		aml.setBounds(50, 110, 100, 30);
		add(aml);
		JTextField am = new JTextField();
		am.setBounds(160, 110, 150, 30);
		am.setFont(new Font("Arial", Font.BOLD, 15));
		add(am);


		// Optional: Add a submit button
		JButton btn = new JButton("Withdraw");
		btn.setBounds(140, 150, 100, 30);
		btn.setFont(new Font("Arial", Font.BOLD, 15));
		add(btn);
		
		int targetcolumn = 0;
		btn.addActionListener(e -> {
			String num = ac.getText();
			char [] pass = ps.getPassword();
			String passwordInput = new String(pass);
			try (BufferedReader br = new BufferedReader(new FileReader("data.csv"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String [] columns = line.split(",");
                   
                    if (columns.length > targetcolumn) {
                    	String cell = columns[targetcolumn];
                    	String password = columns[1];
                    	if(cell.equalsIgnoreCase(num) && password.equalsIgnoreCase(passwordInput)){
                    		System.out.println("program run seccessfully");
                    		
                    		break;
                    	}
                    
                   
                    }
               }
			 
            }catch (IOException ex) {
                msg.setText("⚠️ Error reading file.");
                ex.printStackTrace();
			}
			
//			String num = ac.getText();
//			System.out.println(num);
//			char[] password = ps.getPassword();
//			System.out.println(password);
//			String amount = am.getText();
//			System.out.println(amount);
        });
        
        
        

	}
//
//	for (String cell : cells) {
//      if (cell.trim().equalsIgnoreCase(num)) {
//      	System.out.println("program run successefully");
//      	break;
//          
//      }
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		
//		withdraw w = new withdraw();
//		w.setVisible(true);
//	}

}
