package hotel.management.system;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
// import java.sql.ResultSet;

// public class UpdateCheck extends JFrame {
//     UpdateCheck(){

//         JPanel panel = new JPanel();
//         panel.setBounds(5,5,940,490);
//         panel.setBackground(new Color(3,45,48));
//         panel.setLayout(null);
//         add(panel);

//         ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/updated.png"));
//         Image image = imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
//         ImageIcon imageIcon1 = new ImageIcon(image);
//         JLabel label = new JLabel(imageIcon1);
//         label.setBounds(500,60,300,300);
//         panel.add(label);

//         JLabel label1  = new JLabel("Check-In Details");
//         label1.setBounds(124,11,222,25);
//         label1.setFont(new Font("Arial", Font.BOLD, 20));
//         label1.setForeground(Color.BLACK);
//         panel.add(label1);

//         JLabel label2  = new JLabel("ID :");
//         label2.setBounds(25,88,46,14);
//         label2.setFont(new Font("Arial", Font.PLAIN, 14));
//         label2.setForeground(Color.BLACK);
//         panel.add(label2);

//         Choice c = new Choice();
//         c.setBounds(240,85,140,20);
//         panel.add(c);

//         try {
//             conn C = new conn();
//             ResultSet resultSet = C.statement.executeQuery("select * from customer");
//             while (resultSet.next()){
//                 c.add(resultSet.getString("number"));
//             }
//         }catch (Exception e){
//             e.printStackTrace();
//         }

//         JLabel label3  = new JLabel("Room Number :");
//         label3.setBounds(25,129,107,14);
//         label3.setFont(new Font("Arial", Font.PLAIN, 14));
//         label3.setForeground(Color.BLACK);
//         panel.add(label3);

//         JTextField textField3 = new JTextField();
//         textField3.setBounds(240,129,140,20);
//        panel.add(textField3);

//         JLabel label4  = new JLabel("Name :");
//         label4.setBounds(25,174,97,14);
//         label4.setFont(new Font("Arial", Font.PLAIN, 14));
//         label4.setForeground(Color.BLACK);
//         panel.add(label4);

//         JTextField textField4 = new JTextField();
//         textField4.setBounds(240,174,140,20);
//         panel.add(textField4);

//         JLabel label5  = new JLabel("Checked-in :");
//         label5.setBounds(25,216,97,14);
//         label5.setFont(new Font("Arial", Font.PLAIN, 14));
//         label5.setForeground(Color.BLACK);
//         panel.add(label5);

//         JTextField textField5 = new JTextField();
//         textField5.setBounds(240,216,140,20);
//         panel.add(textField5);

//         JLabel label6  = new JLabel("Amount Paid (Rs) :");
//         label6.setBounds(25,261,150,14);
//         label6.setFont(new Font("Arial", Font.PLAIN, 14));
//         label6.setForeground(Color.BLACK);
//         panel.add(label6);

//         JTextField textField6 = new JTextField();
//         textField6.setBounds(240,261,140,20);
//         panel.add(textField6);

//         JLabel label7  = new JLabel("Pending Amount (Rs) :");
//         label7.setBounds(25,302,150,14);
//         label7.setFont(new Font("Arial", Font.PLAIN, 14));
//         label7.setForeground(Color.BLACK);
//         panel.add(label7);

//         JTextField textField7 = new JTextField();
//         textField7.setBounds(240,302,140,20);
//         panel.add(textField7);


//         JButton update = new JButton("Update");
//         update.setBounds(56,378,89,23);
//         update.setBackground(Color.BLACK);
//         update.setForeground(Color.BLACK);
//         panel.add(update);
//         update.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//              try {
//                  conn C  = new conn();
//                  String q = c.getSelectedItem();
//                  String room = textField3.getText();
//                  String name = textField4.getText();
//                  String check = textField5.getText();
//                  String amount = textField6.getText();
//                  C.statement.executeUpdate("update customer  set room = '"+room+"', name = '"+name+"', checkintime = '"+check+"', deposit = '"+amount+"' where number = '"+q+"'");
//                  JOptionPane.showMessageDialog(null, "Updated Successfully");
//                  setVisible(false);

//              }catch (Exception E){
//                  E.printStackTrace();
//              }
//             }
//         });



//         JButton back = new JButton("Back");
//         back.setBounds(168,378,89,23);
//         back.setBackground(Color.BLACK);
//         back.setForeground(Color.BLACK);
//         panel.add(back);
//         back.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 setVisible(false);
//             }
//         });

//         JButton check = new JButton("Check");
//         check.setBounds(281,378,89,23);
//         check.setBackground(Color.BLACK);
//         check.setForeground(Color.BLACK);
//         panel.add(check);
//         check.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 String id = c.getSelectedItem();
//                 String q = "select * from customer where number = '"+id+"'";
//                 try{
//                     conn c = new conn();
//                     ResultSet resultSet = c.statement.executeQuery(q);

//                     while (resultSet.next()){
//                         textField3.setText(resultSet.getString("room"));
//                         textField4.setText(resultSet.getString("name"));
//                         textField5.setText(resultSet.getString("checkintime"));
//                         textField6.setText(resultSet.getString("deposit"));
//                     }

//                     ResultSet resultSet1 = c.statement.executeQuery("select * from room where roomnumber =  '"+textField3.getText()+"'");

//                     while (resultSet1.next()){
//                         String price = resultSet1.getString("price");
//                         int amountPaid = Integer.parseInt(price) - Integer.parseInt(textField6.getText());
//                         textField7.setText(""+amountPaid);
//                     }
//                 }catch (Exception E ){
//                     E.printStackTrace();
//                 }
//             }
//         });

//         setLayout(null);
//         setSize(950,500);
//         setLocation(400,200);
//         setVisible(true);
//     }

public class UpdateCheck extends JFrame {
    Choice c;
    JTextField textField3, textField4, textField5, textField6, textField7;

    UpdateCheck(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,940,490);
        panel.setBackground(new Color(222, 248, 255));
        panel.setLayout(null);
        add(panel);

        // ... [UI Image and Title Labels Same as Original] ...
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/updated.gif"));
        Image image = imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(420,60,300,300);
        panel.add(label);

        JLabel label1  = new JLabel("Check-In Information");
        label1.setBounds(94,15,500,30);
        label1.setFont(new Font("Arial", Font.BOLD, 25));
        label1.setForeground(Color.BLACK);
        panel.add(label1);

        JLabel label2  = new JLabel("ID :");
        label2.setBounds(25,80,46,14);
        label2.setFont(new Font("Arial", Font.PLAIN, 14));
        label2.setForeground(Color.BLACK);
        panel.add(label2);

        c = new Choice();
        c.setBounds(240,80,140,20);
        panel.add(c);

        // 1. Load Customer IDs from file
        try {
            BufferedReader reader = new BufferedReader(new FileReader("data/customer.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                c.add(parts[1]); // Assuming 'number' is at index 1
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Customer file not found.");
        }

        // ... [TextField Setups Same as Original] ...
        JLabel label3  = new JLabel("Room Number :");
        label3.setBounds(25,121,107,14);
        label3.setFont(new Font("Arial", Font.PLAIN, 14));
        label3.setForeground(Color.BLACK);
        panel.add(label3);
        textField3 = new JTextField();
        textField3.setBounds(240,121,140,20);
        panel.add(textField3);

        JLabel label4  = new JLabel("Name :");
        label4.setBounds(25,166,97,14);
        label4.setFont(new Font("Arial", Font.PLAIN, 14));
        label4.setForeground(Color.BLACK);
        panel.add(label4);
        textField4 = new JTextField();
        textField4.setBounds(240,166,140,20);
        panel.add(textField4);

        JLabel label5  = new JLabel("Checked-in :");
        label5.setBounds(25,210,97,14);
        label5.setFont(new Font("Arial", Font.PLAIN, 14));
        label5.setForeground(Color.BLACK);
        panel.add(label5);
        textField5 = new JTextField();
        textField5.setBounds(240,210,140,20);
        panel.add(textField5);

        JLabel label6  = new JLabel("Amount Paid (RM) :");
        label6.setBounds(25,255,150,14);
        label6.setFont(new Font("Arial", Font.PLAIN, 14));
        label6.setForeground(Color.BLACK);
        panel.add(label6);
        textField6 = new JTextField();
        textField6.setBounds(240,255,140,20);
        panel.add(textField6);

        JLabel label7  = new JLabel("Pending Amount (RM) :");
        label7.setBounds(25,296,150,14);
        label7.setFont(new Font("Arial", Font.PLAIN, 14));
        label7.setForeground(Color.BLACK);
        panel.add(label7);
        textField7 = new JTextField();
        textField7.setBounds(240,296,140,20);
        panel.add(textField7);

        JButton update = new JButton("UPDATE");
        update.setBounds(20,340,170,60);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.BLACK);
        update.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(update);
        update.addActionListener(e -> updateCustomerData());

        JButton back = new JButton("<");
        back.setBounds(20,15,30,30);
        back.setFont(new Font("Arial",Font.BOLD,14));
        back.setForeground(Color.BLACK);
        back.setBackground(Color.BLACK);
        panel.add(back);
        back.addActionListener(e -> setVisible(false));
           
        JButton check = new JButton("CHECK");
        check.setBounds(212,340,170,60);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.BLACK);
        check.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(check);
        check.addActionListener(e -> checkCustomerDetails());

        setLayout(null);
        setSize(750,455);
        setLocation(400,200);
        setVisible(true);
    }

    private void checkCustomerDetails() {
        String id = c.getSelectedItem();
        try {
            // Read customer file to fill basic info
            BufferedReader reader = new BufferedReader(new FileReader("data/customer.txt"));
            String line;
            String roomNum = "";
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[1].equals(id)) {
                    textField3.setText(parts[5]); // Room
                    textField4.setText(parts[2]); // Name
                    textField5.setText(parts[6]); // Check-in time
                    textField6.setText(parts[7]); // Deposit
                    roomNum = parts[5];
                    break;
                }
            }
            reader.close();

            // Read room file to calculate pending amount
            BufferedReader roomReader = new BufferedReader(new FileReader("data/room.txt"));
            while ((line = roomReader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(roomNum)) {
                    int price = Integer.parseInt(parts[3]);
                    int paid = Integer.parseInt(textField6.getText());
                    textField7.setText(String.valueOf(price - paid));
                    break;
                }
            }
            roomReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateCustomerData() {
        String id = c.getSelectedItem();
        List<String> updatedLines = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("data/customer.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[1].equals(id)) {
                    parts[5] = textField3.getText(); // Update room
                    parts[2] = textField4.getText(); // Update name
                    parts[6] = textField5.getText(); // Update check-in
                    parts[7] = textField6.getText(); // Update deposit
                    line = String.join(",", parts);
                }
                updatedLines.add(line);
            }
            reader.close();

            BufferedWriter writer = new BufferedWriter(new FileWriter("data/customer.txt"));
            for (String l : updatedLines) {
                writer.write(l);
                writer.newLine();
            }
            writer.close();
            JOptionPane.showMessageDialog(null, "Updated Successfully");
            setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new UpdateCheck();
    }
}
