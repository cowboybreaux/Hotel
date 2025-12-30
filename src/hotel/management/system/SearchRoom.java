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
// import java.util.ResourceBundle;

// public class SearchRoom extends JFrame implements ActionListener {
//     JCheckBox checkBox;
//     Choice choice;
//     JTable table;
//     JButton add, back;
//     SearchRoom(){
//         JPanel panel = new JPanel();
//         panel.setBackground(new Color(3,45,48));
//         panel.setBounds(5,5,690,490);
//         panel.setLayout(null);
//         add(panel);

//         JLabel searchForRoom = new JLabel("Search For Room");
//         searchForRoom.setBounds(250,11,186,31);
//         searchForRoom.setForeground(Color.BLACK);
//         searchForRoom.setFont(new Font("Arial", Font.BOLD,20));
//         panel.add(searchForRoom);

//         JLabel rbt = new JLabel("Room Bed Type:");
//         rbt.setBounds(50,73,120,20);
//         rbt.setForeground(Color.BLACK);
//         rbt.setFont(new Font("Arial", Font.BOLD,14));
//         panel.add(rbt);

//         JLabel rn = new JLabel("Room Number");
//         rn.setBounds(23,162,150,20);
//         rn.setForeground(Color.BLACK);
//         rn.setFont(new Font("Arial", Font.BOLD,14));
//         panel.add(rn);

//         JLabel available = new JLabel("Availability");
//         available.setBounds(175,162,150,20);
//         available.setForeground(Color.BLACK);
//         available.setFont(new Font("Arial", Font.BOLD,14));
//         panel.add(available);

//         JLabel price = new JLabel("Price");
//         price.setBounds(458,162,150,20);
//         price.setForeground(Color.BLACK);
//         price.setFont(new Font("Arial", Font.BOLD,14));
//         panel.add(price);

//         JLabel BT = new JLabel("Bed Type");
//         BT.setBounds(580,162,150,20);
//         BT.setForeground(Color.BLACK);
//         BT.setFont(new Font("Arial", Font.BOLD,14));
//         panel.add(BT);

//         JLabel SS = new JLabel("Clean Status");
//         SS.setBounds(306,162,150,20);
//         SS.setForeground(Color.BLACK);
//         SS.setFont(new Font("Arial", Font.BOLD,14));
//         panel.add(SS);



//         checkBox = new JCheckBox("Only Display Available");
//         checkBox.setBounds(400,69,205,23);
//         checkBox.setForeground(Color.BLACK);
//         checkBox.setBackground(new Color(3,45,48));
//         panel.add(checkBox);

//         choice = new Choice();
//         choice.add("Single Bed");
//         choice.add("Double Bed");
//         choice.setBounds(170,70,120,20);
//         panel.add(choice);

//         table = new JTable();
//         table.setBounds(0,187,700,150);
//         table.setBackground(new Color(3,45,48));
//         table.setForeground(Color.BLACK);
//         panel.add(table);

//         try{
//             conn c = new conn();
//             String q = "select * from room";
//             ResultSet resultSet = c.statement.executeQuery(q);
//             table.setModel(DbUtils.resultSetToTableModel(resultSet));
//         }catch (Exception e){
//             e.printStackTrace();
//         }

//         add = new JButton("Search");
//         add.setBounds(200,400,120,30);
//         add.setBackground(Color.BLACK);
//         add.setForeground(Color.BLACK);
//         add.addActionListener(this);
//         panel.add(add);

//         back = new JButton("Back");
//         back.setBounds(380,400,120,30);
//         back.setBackground(Color.BLACK);
//         back.setForeground(Color.BLACK);
//         back.addActionListener(this);
//         panel.add(back);


//         setUndecorated(true);
//         setLayout(null);
//         setLocation(500,200);
//         setSize(700,500);
//         setVisible(true);
//     }

//     @Override
//     public void actionPerformed(ActionEvent e) {

//         if (e.getSource()==add){
//             String Q = "select * from Room where bed_type = '"+choice.getSelectedItem()+"'";
//             String Q1 = "select * from Room where availability = 'Available'  And bed_type = '"+choice.getSelectedItem()+"'";
//             try {
//                 conn c = new conn();
//                 ResultSet resultSet = c.statement.executeQuery(Q);
//                 table.setModel(DbUtils.resultSetToTableModel(resultSet));

//                 if (checkBox.isSelected()){
//                     ResultSet resultSet1 = c.statement.executeQuery(Q1);
//                     table.setModel(DbUtils.resultSetToTableModel(resultSet1));
//                 }
//             }catch (Exception E){
//                 E.printStackTrace();
//             }
//         }else {
//             setVisible(false);
//         }

//     }

public class SearchRoom extends JFrame implements ActionListener {
    JCheckBox checkBox;
    Choice choice;
    JTable table;
    DefaultTableModel model;
    JButton search, back;

    SearchRoom() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(222, 248, 255));
        panel.setBounds(5, 5, 710, 490);
        panel.setLayout(null);
        add(panel);

        JLabel searchForRoom = new JLabel("Room Search");
        searchForRoom.setBounds(270, 11, 186, 31);
        searchForRoom.setForeground(Color.BLACK);
        searchForRoom.setFont(new Font("Arial", Font.BOLD, 25));
        panel.add(searchForRoom);

        JLabel rbt = new JLabel("Room Bed Type:");
        rbt.setBounds(10, 70, 120, 20);
        rbt.setForeground(Color.BLACK);
        rbt.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(rbt);

        // --- Choice & Checkbox ---
        choice = new Choice();
        choice.add("Single Bed");
        choice.add("Queen Bed");
        choice.setBounds(130, 70, 120, 20);
        panel.add(choice);

        checkBox = new JCheckBox("Only Display Available");
        checkBox.setBounds(500, 70, 205, 23);
        checkBox.setForeground(Color.BLACK);
        checkBox.setBackground(new Color(255,255,255));
        panel.add(checkBox);

        // --- Table Setup ---
        String[] columnNames = {"Room No", "Availability", "Clean Status", "Price", "Bed Type"};
        model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);
        table.setBackground(new Color(3, 45, 48));
        table.setForeground(Color.BLACK);

        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0, 100, 700, 250);
        sp.getViewport().setBackground(new Color(255,255,255));
        panel.add(sp);

        // --- Buttons ---
        search = new JButton("Search");
        search.setBounds(250, 65, 120, 30);
        search.setBackground(Color.BLACK);
        search.setForeground(Color.BLACK);
        search.addActionListener(this);
        panel.add(search);

        JButton back = new JButton("<");
        back.setBounds(10,11,30,30);
        back.setFont(new Font("Arial",Font.BOLD,14));
        back.setForeground(Color.BLACK);
        back.setBackground(Color.BLACK);
        panel.add(back);
        back.addActionListener(e -> setVisible(false));

        // Load all rooms by default
        loadRoomData();

        setUndecorated(true);
        setLayout(null);
        setLocation(500, 200);
        setSize(710, 360);
        setVisible(true);
    }

    private void loadRoomData() {
        model.setRowCount(0); // Clear current table
        String selectedBed = choice.getSelectedItem();
        boolean onlyAvailable = checkBox.isSelected();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("data/room.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] details = line.split(",");
                // roomNum=0, avail=1, status=2, price=3, bedType=4
                
                boolean matchBed = details[4].equalsIgnoreCase(selectedBed);
                boolean matchAvail = !onlyAvailable || details[1].equalsIgnoreCase("Available");

                if (matchBed && matchAvail) {
                    model.addRow(details);
                }
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Error reading room file.");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == search) {
            loadRoomData();
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new SearchRoom();
    }
}
