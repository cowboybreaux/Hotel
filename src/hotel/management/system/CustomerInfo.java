package hotel.management.system;

//import net.proteanit.sql.DbUtils;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
//import java.sql.ResultSet;

// public class CustomerInfo extends JFrame {
//     CustomerInfo(){

//         JPanel panel = new JPanel();
//         panel.setBounds(5,5,890,590);
//         panel.setBackground(new Color(3,45,48));
//         panel.setLayout(null);
//         add(panel);

//         JTable table = new JTable();
//         table.setBounds(10,40,900,450);
//         table.setBackground(new Color(3,45,48));
//         table.setForeground(Color.BLACK);
//         panel.add(table);

//         try {

//             conn c = new conn();
//             String q = "select * from Customer";
//             ResultSet resultSet = c.statement.executeQuery(q);
//             table.setModel(DbUtils.resultSetToTableModel(resultSet));

//         }catch (Exception e ){
//             e.printStackTrace();
//         }

//         JLabel id = new JLabel("ID");
//         id.setBounds(31,11,100,14);
//         id.setForeground(Color.BLACK);
//         id.setFont( new Font("Arial", Font.BOLD,14));
//         panel.add(id);

//         JLabel number = new JLabel("Number");
//         number.setBounds(150,11,100,14);
//         number.setForeground(Color.BLACK);
//         number.setFont( new Font("Arial", Font.BOLD,14));
//         panel.add(number);

//         JLabel name = new JLabel("Name");
//         name.setBounds(270,11,100,14);
//         name.setForeground(Color.BLACK);
//         name.setFont( new Font("Arial", Font.BOLD,14));
//         panel.add(name);

//         JLabel gender = new JLabel("Gender");
//         gender.setBounds(360,11,100,14);
//         gender.setForeground(Color.BLACK);
//         gender.setFont( new Font("Arial", Font.BOLD,14));
//         panel.add(gender);

//         JLabel country = new JLabel("Country");
//         country.setBounds(480,11,100,25);
//         country.setForeground(Color.BLACK);
//         country.setFont( new Font("Arial", Font.BOLD,14));
//         panel.add(country);

//         JLabel room = new JLabel("Room");
//         room.setBounds(600,11,100,14);
//         room.setForeground(Color.BLACK);
//         room.setFont( new Font("Arial", Font.BOLD,14));
//         panel.add(room);

//         JLabel Time = new JLabel("CI Time");
//         Time.setBounds(680,11,100,14);
//         Time.setForeground(Color.BLACK);
//         Time.setFont( new Font("Arial", Font.BOLD,14));
//         panel.add(Time);

//         JLabel Deposit = new JLabel("Deposit");
//         Deposit.setBounds(800,11,100,25);
//         Deposit.setForeground(Color.BLACK);
//         Deposit.setFont( new Font("Arial", Font.BOLD,14));
//         panel.add(Deposit);

//         JButton back = new JButton("Back");
//         back.setBounds(450,510,120,30);
//         back.setBackground(Color.BLACK);
//         back.setForeground(Color.BLACK);
//         panel.add(back);
//         back.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 setVisible(false);
//             }
//         });


//         setUndecorated(true);
//         setLayout(null);
//         setSize(900,600);
//         setLocation(500,100);
//         setVisible(true);
//     }

public class CustomerInfo extends JFrame {
    CustomerInfo(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,890,590);
        panel.setBackground(new Color(222, 248, 255));
        panel.setLayout(null);
        add(panel);

        // 2. Setup the Table Model manually
        String[] columnNames = {"ID", "Number", "Name", "Gender", "Country", "Room", "CI Time", "Deposit"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(model);
        
        table.setBounds(10,40,900,450);
        table.setBackground(new Color(63, 122, 138));
        table.setForeground(Color.WHITE);
        table.setFont(new Font("Arial", Font.BOLD, 12));

        // Wrap table in a ScrollPane so you can see all customers if the list is long
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(10,40,870,450);
        panel.add(sp);

        // 3. Read from customer.txt instead of Database
        try {
            BufferedReader reader = new BufferedReader(new FileReader("data/customer.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the comma-separated line into an array
                String[] rowData = line.split(",");
                // Add the array as a new row in the table
                model.addRow(rowData);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("No guest data found.");
            // e.printStackTrace();
        }

        // --- Labels (Keep these as they are or remove them since JScrollPane shows headers) ---
        JLabel id = new JLabel("Guest Information");
        id.setBounds(340,6,500,26);
        id.setForeground(Color.BLACK);
        id.setFont( new Font("Arial", Font.BOLD,25));
        panel.add(id);
        // ... (Keep your other labels for Number, Name, etc.)

        JButton back = new JButton("<");
        back.setBounds(10,6,30,30);
        back.setFont(new Font("Arial",Font.BOLD,14));
        back.setForeground(Color.BLACK);
        back.setBackground(Color.BLACK);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setLayout(null);
        setSize(900,510);
        setLocation(500,100);
        setVisible(true);
    }
    public static void main(String[] args) {
        new CustomerInfo();
    }
}
