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
// import java.sql.ResultSetMetaData;

// public class Department extends JFrame {
//     Department(){
//         JPanel panel = new JPanel();
//         panel.setBackground(new Color(3,45,48));
//         panel.setBounds(5,5,690,490);
//         panel.setLayout(null);
//         add(panel);

//         JTable table = new JTable();
//         table.setBounds(0,40,700,350);
//         table.setBackground(new Color(4,45,48));
//         table.setForeground(Color.BLACK);
//         panel.add(table);

//         try{
//             conn c = new conn();
//             String departmentInfo = "select * from department";
//             ResultSet resultSet = c.statement.executeQuery(departmentInfo);
//             table.setModel(DbUtils.resultSetToTableModel(resultSet));
//         }catch (Exception e){
//             e.printStackTrace();
//         }

//         JButton back = new JButton("BACK");
//         back.setBounds(400,410,120,30);
//         back.setBackground(Color.BLACK);
//         back.setForeground(Color.BLACK);
//         panel.add(back);
//         back.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 setVisible(false);
//             }
//         });

//         JLabel label1 = new JLabel("Department");
//         label1.setBounds(145,11,105,20);
//         label1.setForeground(Color.BLACK);
//         label1.setFont(new Font("Tahoma", Font.BOLD,14));
//         panel.add(label1);

//         JLabel label2 = new JLabel("Budget");
//         label2.setBounds(431,11,105,20);
//         label2.setForeground(Color.BLACK);
//         label2.setFont(new Font("Tahoma", Font.BOLD,14));
//         panel.add(label2);



//         setUndecorated(true);
//         setLayout(null);
//         setLocation(550,150);
//         setSize(700,500);
//         setVisible(true);
//     }

public class Department extends JFrame {
    Department(){
        JPanel panel = new JPanel();
        panel.setBackground(new Color(222, 248, 255));
        panel.setBounds(5,5,690,490);
        panel.setLayout(null);
        add(panel);

        // 2. Setup Column Names and Model
        String[] columnNames = {"Department", "Budget"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        
        JTable table = new JTable(model);
        table.setBackground(new Color(63, 122, 138));
        table.setForeground(Color.BLACK);
        
        // Use JScrollPane to ensure headers (Department, Budget) are visible
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0, 40, 700, 350);
        sp.getViewport().setBackground(new Color(255,255,255)); // Matches panel color
        panel.add(sp);

        // 3. Read from department.txt
        try{
            BufferedReader reader = new BufferedReader(new FileReader("data/department.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] rowData = line.split(",");
                model.addRow(rowData);
            }
            reader.close();
        }catch (Exception e){
            System.out.println("Department file not found. Create data/department.txt");
        }

        JButton back = new JButton("<");
        back.setBounds(0,5,30,30);
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

        // Optional: Keep these labels if you want them above the scroll pane, 
        // though JTable headers usually handle this.
        JLabel label1 = new JLabel("Department Budget");
        label1.setBounds(275,-8,500,50);
        label1.setForeground(Color.BLACK);
        label1.setFont(new Font("Arial", Font.BOLD,18));
        panel.add(label1);

        setUndecorated(true);
        setLayout(null);
        setLocation(550,150);
        setSize(700,400);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Department();
    }
}
