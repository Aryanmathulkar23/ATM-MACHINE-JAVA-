package system;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class Withdraw extends JFrame {

    public Withdraw() {
        setTitle("Pay");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(null);

        JLabel msg = new JLabel("Message : ");
        msg.setBounds(12, 1, 300, 30);
        msg.setFont(new Font("Arial", Font.BOLD, 15));
        add(msg);

        JLabel acl = new JLabel("Enter Account no.:");
        acl.setBounds(40, 30, 130, 30);
        add(acl);

        JTextField ac = new JTextField();
        ac.setBounds(160, 30, 150, 30);
        add(ac);

        String[] categories = {"PersonalCare", "Food & Groceries", "Restaurants", "Entertainment", "Bills and Insurance", "Travel & Vacation", "Home Improvements", "Rent"};
        JLabel catl = new JLabel("Enter Categories :");
        catl.setBounds(50, 70, 100, 30);
        add(catl);

        JComboBox<String> cat = new JComboBox<>(categories);
        cat.setBounds(160, 70, 150, 30);
        cat.setFont(new Font("Arial", Font.BOLD, 15));
        add(cat);

        JLabel aml = new JLabel("Enter amount :");
        aml.setBounds(50, 110, 100, 30);
        add(aml);

        JTextField am = new JTextField();
        am.setBounds(160, 110, 150, 30);
        am.setFont(new Font("Arial", Font.BOLD, 15));
        add(am);

        JButton btn = new JButton("Next");
        btn.setBounds(140, 150, 100, 30);
        btn.setFont(new Font("Arial", Font.BOLD, 15));
        add(btn);

        int targetcolumn = 0;

        btn.addActionListener(e -> {
            String num = ac.getText().trim();
            String amount = am.getText().trim();
            boolean found = false;

            if (num.isEmpty()) {
                msg.setText("⚠️ Please enter account number.");
                return;
            }
            if (amount.isEmpty()) {
                msg.setText("⚠️ Please enter amount.");
                return;
            }
            
            
            try (BufferedReader br = new BufferedReader(new FileReader("data.csv"))) {
                // skip header line if present
            	String line;
                br.readLine(); 

                
                while ((line = br.readLine()) != null) {
                    String[] columns = line.split(",");

                    if (columns.length > targetcolumn) {
                        String cell = columns[targetcolumn].trim();

                        if (num.equals(cell)) {
                            System.out.println("Account found: " + cell);
                            Pay p = new Pay(num);
                            p.setVisible(true);
                            found = true;
                            break;
                        }
                    }
                }

                if (!found) {
                    msg.setText("⚠️ Message : Account not found");
                }

            } catch (IOException ex) {
                msg.setText("⚠️ Error reading file.");
                ex.printStackTrace();
            }
        });

    }

}
