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

// public class Room extends JFrame {

//     JTable table;
//     JButton back;

//     Room(){
//         JPanel panel = new JPanel();
//         panel.setBounds(5,5,890,590);
//         panel.setBackground(new Color(3,45,48));
//         panel.setLayout(null);
//         add(panel);

//         ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/roomm.png"));
//         Image image = imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
//         ImageIcon imageIcon1 = new ImageIcon(image);
//         JLabel label = new JLabel(imageIcon1);
//         label.setBounds(600,200,200,200);
//         panel.add(label);

//         table = new JTable();
//         table.setBounds(10,40,500,400);
//         table.setBackground(new Color(3,45,48));
//         table.setForeground(Color.WHITE);
//         panel.add(table);

//         try{
//             conn c = new conn();
//             String RoomInfo = "select * from room";
//             ResultSet resultSet = c.statement.executeQuery(RoomInfo);
//             table.setModel(DbUtils.resultSetToTableModel(resultSet));
//         }catch (Exception e ){
//             e.printStackTrace();
//         }

//         back = new JButton("BACK");
//         back.setBackground(Color.BLACK);
//         back.setForeground(Color.WHITE);
//         back.setBounds(200,500,120,30);
//         panel.add(back);
//         back.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 setVisible(false);
//             }
//         });

//         JLabel room = new JLabel("Room No.");
//         room.setBounds(12,15,80,19);
//         room.setForeground(Color.WHITE);
//         room.setFont(new Font("Tahoma", Font.BOLD, 14));
//         panel.add(room);


//         JLabel availability = new JLabel("Availability");
//         availability.setBounds(119,15,80,19);
//         availability.setForeground(Color.WHITE);
//         availability.setFont(new Font("Tahoma", Font.BOLD, 14));
//         panel.add(availability);

//         JLabel Clean = new JLabel("Clean Status");
//         Clean.setBounds(216,15,150,19);
//         Clean.setForeground(Color.WHITE);
//         Clean.setFont(new Font("Tahoma", Font.BOLD, 14));
//         panel.add(Clean);


//         JLabel Price = new JLabel("Price");
//         Price.setBounds(330,15,80,19);
//         Price.setForeground(Color.WHITE);
//         Price.setFont(new Font("Tahoma", Font.BOLD, 14));
//         panel.add(Price);

//         JLabel Bed = new JLabel("Bed Type");
//         Bed.setBounds(417,15,80,19);
//         Bed.setForeground(Color.WHITE);
//         Bed.setFont(new Font("Tahoma", Font.BOLD, 14));
//         panel.add(Bed);


//         setUndecorated(true);
//         setLayout(null);
//         setLocation(500,100);
//         setSize(900,600);
//         setVisible(true);
//     }

public class Room extends JFrame {

    JTable table;
    JButton back;
    DefaultTableModel model; // Added to manage rows manually

    Room(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,890,590);
        panel.setBackground(new Color(196, 233, 255));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/roomm.gif"));
        Image image = imageIcon.getImage().getScaledInstance(270,200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(550,200,270,200);
        panel.add(label);

        // 1. Setup the Table Model with Column Names
        String[] columnNames = {"Room No.", "Availability", "Clean Status", "Price", "Bed Type"};
        model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);
        
        table.setBackground(new Color(255,255,255));
        table.setForeground(Color.BLACK);
        table.setFont(new Font("Tahoma", Font.PLAIN, 12));

        // 2. Add table to a JScrollPane
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(30,80,500,400);
        sp.getViewport().setBackground(new Color(255,255,255));
        panel.add(sp);

        // 3. Read data from room.txt instead of Database
        try {
            BufferedReader reader = new BufferedReader(new FileReader("data/room.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                // Split each line by the comma delimiter
                String[] rowData = line.split(",");
                // Add the data to the table
                model.addRow(rowData);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("No room data found. Please add rooms in Admin section.");
            // e.printStackTrace();
        }

        back = new JButton("<");
        back.setBounds(30,25,30,30);
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

        // Optional: Manual labels if you want them styled differently above the ScrollPane
        JLabel room = new JLabel("Room Availability");
        room.setBounds(150,15,500,50);
        room.setForeground(Color.BLACK);
        room.setFont(new Font("Arial", Font.BOLD, 28));
        panel.add(room);

        /*JLabel availability = new JLabel("Availability");
        availability.setBounds(119,15,80,19);
        availability.setForeground(Color.BLACK);
        availability.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(availability);*/

        // ... [Price and Bed labels omitted for brevity, same as your original]

        setUndecorated(true);
        setLayout(null);
        setLocation(500,100);
        setSize(870,515);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Room();
    }
}
