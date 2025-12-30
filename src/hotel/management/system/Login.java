package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.*;
// import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JTextField textField1;
    JPasswordField passwordField1;
    JButton b1,b2;

    Login(){
        super("Admin Login");
        JLabel label0 = new JLabel("Admin Login");
        label0.setBounds(120,50,100,30);
        label0.setFont(new Font("Arial",Font.BOLD,16));
        label0.setForeground(Color.BLACK);
        add(label0);

        JLabel label1 = new JLabel("Username");
        label1.setBounds(40,100,100,30);
        label1.setFont(new Font("Arial",Font.BOLD,16));
        label1.setForeground(Color.BLACK);
        add(label1);

        JLabel label2 = new JLabel("Password");
        label2.setBounds(40,130,100,30);
        label2.setFont(new Font("Arial",Font.BOLD,16));
        label2.setForeground(Color.BLACK);
        add(label2);

        textField1 = new JTextField();
        textField1.setBounds(150,100,150,30);
        textField1.setForeground(Color.BLACK);
        textField1.setFont(new Font("Arial", Font.PLAIN,15));
        textField1.setBackground(new Color(255, 255, 255));
        add(textField1);

        passwordField1 = new JPasswordField();
        passwordField1.setBounds(150,130,150,30);
        passwordField1.setForeground(Color.BLACK);
        passwordField1.setBackground(new Color(255, 255, 255));
        add(passwordField1);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image i1 = imageIcon.getImage().getScaledInstance(430,240, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(i1);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(240,10,430,240);
        add(label);

        b1 = new JButton("LOGIN");
        b1.setBounds(50,190,120,30);
        b1.setFont(new Font("Arial", Font.BOLD, 15));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.BLACK);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("CANCEL");
        b2.setBounds(170,190,120,30);
        b2.setFont(new Font("Arial", Font.BOLD, 15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.BLACK);
        b2.addActionListener(this);
        add(b2);


        getContentPane().setBackground(new Color(222, 253, 255));
        setLayout(null);
        setLocation(400,270);
        setSize(600,300);
        setVisible(true);
    }

    @Override
    // public void actionPerformed(ActionEvent e) {
    //     if (e.getSource() == b1){
    //         try {
    //             conn c = new conn();
    //             String user = textField1.getText();
    //             String pass = passwordField1.getText();

    //             String q = "select * from login where username = '"+user+"' and password = '"+pass+"'";
    //             ResultSet resultSet = c.statement.executeQuery(q);
    //             if (resultSet.next()){
    //                 new Dashboard();
    //                 setVisible(false);
    //             }else {
    //                 JOptionPane.showMessageDialog(null,"Invalid");
    //             }

    //         }catch (Exception E){
    //             E.printStackTrace();
    //         }

    //     }else {
    //         System.exit(102);
    //     }
    // }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1){
            String user = textField1.getText();
            String pass = new String(passwordField1.getPassword());
            boolean loginSuccessful = false;

            // 2. Replace SQL logic with File Reading logic
            try {
                // We assume the file is in a folder named "data"
                BufferedReader reader = new BufferedReader(new FileReader("data/login.txt"));
                String line;
                
                while ((line = reader.readLine()) != null) {
                    // Splits the line "admin,12345" into an array ["admin", "12345"]
                    String[] credentials = line.split(",");
                    
                    if (credentials.length >= 2) {
                        if (credentials[0].equals(user) && credentials[1].equals(pass)) {
                            loginSuccessful = true;
                            break;
                        }
                    }
                }
                reader.close();

                if (loginSuccessful) {
                    new Dashboard();
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                }

            } catch (Exception E) {
                // This will trigger if the data/login.txt file is missing
                JOptionPane.showMessageDialog(null, "Error: Could not find login database file.");
                E.printStackTrace();
            }

        } else {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
