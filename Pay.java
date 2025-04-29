package system;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.*;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class Pay extends JFrame {
	
	public Pay(String num){
		setTitle("Pay");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
//        JPanel panel = new JPanel();
//        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
//        panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        setLayout(null);
        JLabel msg = new JLabel("Message : ");
		msg.setBounds(12, 1, 300, 30);
		msg.setFont(new Font("Arial", Font.BOLD, 15));
		add(msg);
		
        JLabel psl = new JLabel("Enter Password");
		psl.setBounds(40, 30, 130, 30);
//		psl.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(psl);
		
		JPasswordField ps = new JPasswordField();
		ps.setFont(new Font("Arial", Font.BOLD, 15));
		ps.setBounds(160, 30, 150, 30);
		ps.setAlignmentX(CENTER_ALIGNMENT);
		add(ps);
		
		JButton btn = new JButton("Pay");
		btn.setBounds(140, 150, 100, 30);
		btn.setFont(new Font("Arial", Font.BOLD, 15));
		add(btn);
		
		int targetcolumn = 1;
		
		btn.addActionListener(e -> {
			boolean  found = false;
			int count = 0;
			char [] pass = ps.getPassword();
			String passwordInput = new String(pass);
		
			try (BufferedReader br = new BufferedReader(new FileReader("data.csv"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String [] columns = line.split(",");
                    count++;
                    if (columns.length > targetcolumn) {
                    	String userpass = columns[targetcolumn]; //user password column value save in 'userpss' variable one by one 
                    	String tcell = columns[0]; // user account num column value save in 'tcell' variable one by one 
                    	if (passwordInput.equals(userpass) && num.equals(tcell)){
                 
                    		System.out.println("program run successfully");
                    		found = true;
//                    		UpdateCSV u = new UpdateCSV(amount,count);
                    		break;
                    		
                    	}
                    }
               }
               if(!found) {
            	   msg.setText("Message : Incorrect password");
               }
			 
            }catch (IOException ex) {
                msg.setText("⚠️ Error reading file.");
                ex.printStackTrace();
			}
		});

	}
}
