package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.*;
// import java.sql.ResultSet;

public class Login2 extends JFrame implements ActionListener {
    JTextField textField1;
    JPasswordField passwordField1;
    JButton b1,b2;
    Login2(){
        super("Admin Login");
        JLabel label1 = new JLabel("Username");
        label1.setBounds(20,20,100,30);
        label1.setFont(new Font("Arial",Font.BOLD,16));
        label1.setForeground(Color.BLACK);
        add(label1);

        JLabel label2 = new JLabel("Password");
        label2.setBounds(20,60,100,30);
        label2.setFont(new Font("Arial",Font.BOLD,16));
        label2.setForeground(Color.BLACK);
        add(label2);

        textField1 = new JTextField();
        textField1.setBounds(130,20,150,30);
        textField1.setForeground(Color.BLACK);
        textField1.setFont(new Font("Arial", Font.PLAIN,15));
        textField1.setBackground(new Color(255,255,255));
        add(textField1);

        passwordField1 = new JPasswordField();
        passwordField1.setBounds(130,60,150,30);
        passwordField1.setForeground(Color.BLACK);
        passwordField1.setBackground(new Color(255,255,255));
        add(passwordField1);

        /*ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/login.jpg"));
        Image i1 = imageIcon.getImage().getScaledInstance(400,400,Image.SCALE_DEFAULT);
        JLabel label = new JLabel(imageIcon);
        label.setBounds(318,-30,255,300);
        add(label);
*/
        b1 = new JButton("Login");
        b1.setBounds(20,100,120,30);
        b1.setFont(new Font("Arial", Font.BOLD, 15));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.BLACK);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Back");
        b2.setBounds(160,100,120,30);
        b2.setFont(new Font("Arial", Font.BOLD, 15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.BLACK);
        add(b2);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


        getContentPane().setBackground(new Color(232, 255, 252));
        setLayout(null);
        setLocation(400,270);
        setSize(300,170);
        setVisible(true);

    }

    @Override
    // public void actionPerformed(ActionEvent e) {
    //     if (e.getSource() == b1){
    //         try {
    //             conn c = new conn();
    //             String user = textField1.getText();
    //             String pass = passwordField1.getText();

    //             String q = "select * from login2 where user_name = '"+user+"' and password = '"+pass+"'";
    //             ResultSet resultSet = c.statement.executeQuery(q);
    //             if (resultSet.next()){
    //                 new admin();
    //                 setVisible(false);
    //             }else {
    //                 JOptionPane.showMessageDialog(null,"Invalid");
    //             }

    //         }catch (Exception E){
    //             E.printStackTrace();
    //         }

    //     }else {
    //          new Dashboard();
    //          setVisible(false);
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
                    new admin();
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
        new Login2();
    }
}
