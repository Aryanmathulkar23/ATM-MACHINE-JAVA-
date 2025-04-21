import javax.swing.*;
import java.awt.*;
public class gui extends JFrame{
	
	public gui() {
			setTitle("ATM Machine");
	        setSize(400, 200);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        // Set GridLayout with 2 rows and 2 columns
//	        setLayout(new GridLayout(3, 3)); // rows, columns
//	        setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 30));
	        // Create buttons
	        setLayout(null);
	        JLabel jl = new JLabel("Welcome to ATM Machine ");
	        JButton b1 = new JButton("Withdraw");
	        JButton b2 = new JButton("Diposite");
	        JButton b3 = new JButton("Check Bal");
	        JButton b4 = new JButton("Clear");
	        
	        jl.setBounds(100, 10, 200, 30);
	        b1.setBounds(60, 50, 120,40);
	        b2.setBounds(210, 50, 120,40);
	        b3.setBounds(60, 100, 120,40);
	        b4.setBounds(210, 100, 120,40);
	        
	        b1.setFont(new Font("Arial", Font.BOLD, 15));
	        b2.setFont(new Font("Arial", Font.BOLD, 15));
	        b3.setFont(new Font("Arial", Font.BOLD, 15));
	        b4.setFont(new Font("Arial", Font.BOLD, 15));
	        jl.setFont(new Font("Arial", Font.BOLD, 15));
	        // Add buttons to the frame
	        add(jl);
	        add(b1);
	        add(b2);
	        add(b3);
	        add(b4);
	        
	        b1.addActionListener(e -> {
	        	withdraw w = new withdraw();
	    		w.setVisible(true);
	        });
	        	

		
	}

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		
		gui g = new gui();
		g.setVisible(true);

	}

}
