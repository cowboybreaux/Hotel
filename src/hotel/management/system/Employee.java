package hotel.management.system;

// import net.proteanit.sql.DbUtils;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
// import java.sql.ResultSet;

// public class Employee extends JFrame {
//     Employee(){

//         JPanel panel = new JPanel();
//         panel.setBounds(5,5,990,590);
//         panel.setBackground(new Color(3,45,48));
//         panel.setLayout(null);
//         add(panel);

//         JTable table = new JTable();
//         table.setBounds(10,34,980,450);
//         table.setForeground(Color.BLACK);
//         table.setBackground(new Color(3,45,48));
//         panel.add(table);

//         try{
//             conn c = new conn();
//             String EmployeeSQL = "select * from Employee";
//             ResultSet resultSet = c.statement.executeQuery(EmployeeSQL);
//             table.setModel(DbUtils.resultSetToTableModel(resultSet));
//         }catch (Exception e){
//             e.printStackTrace();
//         }

//         JButton back = new JButton("BACK");
//         back.setBounds(350,500,120,30);
//         back.setBackground(Color.BLACK);
//         back.setForeground(Color.BLACK);
//         panel.add(back);
//         back.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 setVisible(false);
//             }
//         });

//         JLabel name = new JLabel("Name");
//         name.setBounds(41,11,70,19);
//         name.setForeground(Color.BLACK);
//         name.setFont(new Font("Arial", Font.BOLD,14));
//         panel.add(name);

//         JLabel Age = new JLabel("Age");
//         Age.setBounds(159,11,70,19);
//         Age.setForeground(Color.BLACK);
//         Age.setFont(new Font("Arial", Font.BOLD,14));
//         panel.add(Age);

//         JLabel gender = new JLabel("Gender");
//         gender.setBounds(273,11,70,19);
//         gender.setForeground(Color.BLACK);
//         gender.setFont(new Font("Arial", Font.BOLD,14));
//         panel.add(gender);

//         JLabel job = new JLabel("Job");
//         job.setBounds(416,11,70,19);
//         job.setForeground(Color.BLACK);
//         job.setFont(new Font("Arial", Font.BOLD,14));
//         panel.add(job);

//         JLabel salary = new JLabel("Salary");
//         salary.setBounds(536,11,70,19);
//         salary.setForeground(Color.BLACK);
//         salary.setFont(new Font("Arial", Font.BOLD,14));
//         panel.add(salary);

//         JLabel phone = new JLabel("Phone");
//         phone.setBounds(656,11,70,19);
//         phone.setForeground(Color.BLACK);
//         phone.setFont(new Font("Arial", Font.BOLD,14));
//         panel.add(phone);

//         JLabel gmail = new JLabel("Gmail");
//         gmail.setBounds(786,11,70,19);
//         gmail.setForeground(Color.BLACK);
//         gmail.setFont(new Font("Arial", Font.BOLD,14));
//         panel.add(gmail);

//         JLabel ID = new JLabel("ID");
//         ID.setBounds(896,11,70,19);
//         ID.setForeground(Color.BLACK);
//         ID.setFont(new Font("Arial", Font.BOLD,14));
//         panel.add(ID);

//         setUndecorated(true);
//         setLayout(null);
//         setLocation(430,100);
//         setSize(1000,600);
//         setVisible(true);
//     }

public class Employee extends JFrame {
    Employee(){

        JPanel panel = new JPanel();
        panel.setBounds(5,10,990,590);
        panel.setBackground(new Color(222, 248, 255));
        panel.setLayout(null);
        add(panel);

        // 1. Define column headers for the table
        String[] columnNames = {"Name", "Age", "Gender", "Job", "Salary", "Phone", "Email", "ID"};
        
        // 2. Initialize the model with column names and 0 initial rows
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(model);
        
        table.setForeground(Color.BLACK);
        table.setBackground(new Color(63, 122, 138));
        table.setFont(new Font("Arial", Font.PLAIN, 12));

        // 3. Add table to a JScrollPane for scrollability and header visibility
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(10,34,980,450);
        sp.getViewport().setBackground(new Color(255,255,255));
        panel.add(sp);

        // 4. Read data from the text file
        try {
            BufferedReader reader = new BufferedReader(new FileReader("data/employee.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line by commas and add to the table model
                String[] rowData = line.split(",");
                model.addRow(rowData);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Employee data file not found.");
            // e.printStackTrace();
        }

        JButton back = new JButton("<");
        back.setBounds(10,0,30,30);
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

        // The labels you had (Name, Age, etc.) are technically optional now 
        // because the JScrollPane shows the column headers automatically.
        // I have kept them in case you prefer the visual style.

        JLabel name = new JLabel("Employee Information");
        name.setBounds(380,6,300,26);
        name.setForeground(Color.BLACK);
        name.setFont(new Font("Arial", Font.BOLD,25));
        panel.add(name);

        // ... (Keep other labels if desired)

        setUndecorated(true);
        setLayout(null);
        setLocation(430,100);
        setSize(1010,510);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Employee();
    }
}
