/*package hotel.management.system;

// import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;
// import java.sql.ResultSet;

// public class PickUp extends JFrame {
//     PickUp(){

//         JPanel panel = new JPanel();
//         panel.setBackground(new Color(3,45,48));
//         panel.setBounds(5,5,790,590);
//         panel.setLayout(null);
//         add(panel);

//         JLabel pus = new JLabel("Pick Up Service");
//         pus.setBounds(90,11,160,25);
//         pus.setForeground(Color.WHITE);
//         pus.setFont(new Font("Tahoma", Font.BOLD, 20));
//         panel.add(pus);

//         JLabel TOC = new JLabel("Type of Car");
//         TOC.setBounds(32,97,89,14);
//         TOC.setForeground(Color.WHITE);
//         TOC.setFont(new Font("Tahoma", Font.PLAIN, 14));
//         panel.add(TOC);

//         Choice c = new Choice();
//         c.setBounds(123,94,150,25);
//         panel.add(c);

//         try{
//             conn C = new conn();
//             ResultSet resultSet = C.statement.executeQuery("select * from driver");
//             while (resultSet.next()){
//                 c.add(resultSet.getString("carname"));
//             }

//         }catch (Exception e){
//             e.printStackTrace();
//         }

//         JTable table = new JTable();
//         table.setBounds(10,233,800,250);
//         table.setBackground(new Color(3,45,48));
//         table.setForeground(Color.WHITE);
//         panel.add(table);

//         try{
//             conn C = new conn();
//             String q = "select * from driver";
//             ResultSet resultSet = C.statement.executeQuery(q);
//             table.setModel(DbUtils.resultSetToTableModel(resultSet));
//         }catch (Exception e){
//             e.printStackTrace();
//         }

//         JLabel name = new JLabel("Name");
//         name.setBounds(24,208,46,14);
//         name.setForeground(Color.WHITE);
//         panel.add(name);

//         JLabel age = new JLabel("Age");
//         age.setBounds(165,208,46,14);
//         age.setForeground(Color.WHITE);
//         panel.add(age);

//         JLabel gender = new JLabel("Gender");
//         gender.setBounds(264,208,46,14);
//         gender.setForeground(Color.WHITE);
//         panel.add(gender);

//         JLabel company = new JLabel("Company");
//         company.setBounds(366,208,100,14);
//         company.setForeground(Color.WHITE);
//         panel.add(company);

//         JLabel Carname = new JLabel("Car Name");
//         Carname.setBounds(486,208,100,14);
//         Carname.setForeground(Color.WHITE);
//         panel.add(Carname);

//         JLabel available = new JLabel("Available");
//         available.setBounds(600,208,100,14);
//         available.setForeground(Color.WHITE);
//         panel.add(available);

//         JLabel loacation = new JLabel("Loacation");
//         loacation.setBounds(700,208,100,14);
//         loacation.setForeground(Color.WHITE);
//         panel.add(loacation);

//         JButton display = new JButton("Display");
//         display.setBounds(200,500,120,30);
//         display.setBackground(Color.BLACK);
//         display.setForeground(Color.WHITE);
//         panel.add(display);
//         display.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 String q = "select * from driver where carname = '"+c.getSelectedItem()+"'";
//                 try{
//                     conn c = new conn();
//                     ResultSet resultSet = c.statement.executeQuery(q);
//                     table.setModel(DbUtils.resultSetToTableModel(resultSet));
//                 }catch (Exception E){
//                     E.printStackTrace();
//                 }
//             }
//         });



//         JButton Back = new JButton("Back");
//         Back.setBounds(420,500,120,30);
//         Back.setBackground(Color.BLACK);
//         Back.setForeground(Color.WHITE);
//         panel.add(Back);
//         Back.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 setVisible(false);
//             }
//         });


//         setLayout(null);
//         setSize(800,600);
//         setLocation(500,100);
//         setVisible(true);
//     }

public class PickUp extends JFrame {
    JTable table;
    DefaultTableModel model;

    PickUp(){

        JPanel panel = new JPanel();
        panel.setBackground(new Color(3,45,48));
        panel.setBounds(5,5,790,590);
        panel.setLayout(null);
        add(panel);

        JLabel pus = new JLabel("Pick Up Service");
        pus.setBounds(90,11,160,25);
        pus.setForeground(Color.WHITE);
        pus.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(pus);

        JLabel TOC = new JLabel("Type of Car");
        TOC.setBounds(32,97,89,14);
        TOC.setForeground(Color.WHITE);
        TOC.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(TOC);

        Choice c = new Choice();
        c.setBounds(123,94,150,25);
        panel.add(c);

        // 1. Populate Choice menu with unique Car Names from file
        try {
            BufferedReader reader = new BufferedReader(new FileReader("data/driver.txt"));
            String line;
            Set<String> carTypes = new HashSet<>(); // To avoid duplicate car names in dropdown
            while ((line = reader.readLine()) != null) {
                String[] details = line.split(",");
                carTypes.add(details[4]); // Assuming index 4 is Car Name
            }
            for (String type : carTypes) {
                c.add(type);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Driver file not found.");
        }

        // 2. Setup Table Model
        String[] columnNames = {"Name", "Age", "Gender", "Company", "Car Name", "Available", "Location"};
        model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);
        table.setBackground(new Color(3,45,48));
        table.setForeground(Color.WHITE);

        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(10, 233, 770, 250);
        sp.getViewport().setBackground(new Color(3,45,48));
        panel.add(sp);

        // 3. Initial Load: Show all drivers
        loadDriverData(null);

        // Labels (Optional - JScrollPane headers show these now)
        JLabel name = new JLabel("Name");
        name.setBounds(24,208,46,14);
        name.setForeground(Color.WHITE);
        panel.add(name);
        // ... (Keep other labels if you want them specifically positioned)

        JButton display = new JButton("Display");
        display.setBounds(200,500,120,30);
        display.setBackground(Color.BLACK);
        display.setForeground(Color.WHITE);
        panel.add(display);
        display.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 4. Filter by selected car type
                loadDriverData(c.getSelectedItem());
            }
        });

        JButton Back = new JButton("Back");
        Back.setBounds(420,500,120,30);
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.WHITE);
        panel.add(Back);
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setLayout(null);
        setSize(800,600);
        setLocation(500,100);
        setVisible(true);
    }

    // Helper method to load and filter driver data
    private void loadDriverData(String filter) {
        model.setRowCount(0); // Clear existing table data
        try {
            BufferedReader reader = new BufferedReader(new FileReader("data/driver.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] rowData = line.split(",");
                if (filter == null || rowData[4].equals(filter)) {
                    model.addRow(rowData);
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new PickUp();
    }
}
*/