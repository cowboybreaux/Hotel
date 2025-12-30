package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList; // 1. Added IO imports
import java.util.Date;
import java.util.List;
import javax.swing.*;

public class CheckOut extends JFrame {
    CheckOut(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,790,390);
        panel.setBackground(new Color(222, 248, 255));
        panel.setLayout(null);
        add(panel);

        // ... [UI Labels and Choice remain the same] ...
        JLabel label = new JLabel("Guest Check-Out Menu");
        label.setBounds(100,20,500,30);
        label.setFont(new Font("Arial",Font.BOLD,20));
        label.setForeground(Color.BLACK);
        panel.add(label);

        JLabel UserId = new JLabel("Customer Id");
        UserId.setBounds(30,80,150,30);
        UserId.setFont(new Font("Arial",Font.BOLD,14));
        UserId.setForeground(Color.BLACK);
        panel.add(UserId);

        Choice Customer = new Choice();
        Customer.setBounds(200,80,150,25);
        panel.add(Customer);

        JLabel roomNum = new JLabel("Room Number");
        roomNum.setBounds(30,130,150,30);
        roomNum.setFont(new Font("Arial",Font.BOLD,14));
        roomNum.setForeground(Color.BLACK);
        panel.add(roomNum);

        JLabel labelRoomnumber = new JLabel();
        labelRoomnumber.setBounds(200,130,150,30);
        labelRoomnumber.setFont(new Font("Arial",Font.BOLD,14));
        labelRoomnumber.setForeground(Color.BLACK);
        panel.add(labelRoomnumber);

        JLabel checkintime = new JLabel("Check-In Time");
        checkintime.setBounds(30,180,150,30);
        checkintime.setFont(new Font("Arial",Font.BOLD,14));
        checkintime.setForeground(Color.BLACK);
        panel.add(checkintime);

        JLabel labelcheckintime = new JLabel();
        labelcheckintime.setBounds(200,180,200,30);
        labelcheckintime.setFont(new Font("Arial",Font.BOLD,14));
        labelcheckintime.setForeground(Color.BLACK);
        panel.add(labelcheckintime);

        JLabel checkouttime = new JLabel("Check-Out Time");
        checkouttime.setBounds(30,230,150,30);
        checkouttime.setFont(new Font("Arial",Font.BOLD,14));
        checkouttime.setForeground(Color.BLACK);
        panel.add(checkouttime);

        Date date = new Date();
        JLabel labelcheckouttime = new JLabel(""+date);
        labelcheckouttime.setBounds(200,230,200,30);
        labelcheckouttime.setFont(new Font("Arial",Font.BOLD,14));
        labelcheckouttime.setForeground(Color.BLACK);
        panel.add(labelcheckouttime);

        // 2. Load Customer IDs from text file
        try{
            BufferedReader reader = new BufferedReader(new FileReader("data/customer.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] details = line.split(",");
                Customer.add(details[1]); // Assuming Index 1 is the 'Number/ID'
            }
            reader.close();
        }catch (Exception E){
            System.out.println("No customers found yet.");
        }

        JButton checkOut = new JButton("Confirm Check-Out");
        checkOut.setBounds(20,300,180,50);
        checkOut.setFont(new Font("Arial",Font.BOLD,14));
        checkOut.setForeground(Color.BLACK);
        checkOut.setBackground(Color.BLACK);
        panel.add(checkOut);
        
        checkOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // 3. Delete Customer from customer.txt
                    File inputFile = new File("data/customer.txt");
                    File tempFile = new File("data/customer_temp.txt");
                    BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                    BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
                    
                    String lineToRemove = Customer.getSelectedItem();
                    String currentLine;
                    while((currentLine = reader.readLine()) != null) {
                        String[] details = currentLine.split(",");
                        if(details[1].equals(lineToRemove)) continue; // Skip the line to delete
                        writer.write(currentLine + System.getProperty("line.separator"));
                    }
                    writer.close(); reader.close();
                    inputFile.delete();
                    tempFile.renameTo(inputFile);

                    // 4. Update Room availability in room.txt
                    updateRoomStatus(labelRoomnumber.getText(), "Available");

                    JOptionPane.showMessageDialog(null, "Check-Out Successful");
                    setVisible(false);
                }catch (Exception E ){
                    E.printStackTrace();
                }
            }
        });

        JButton check = new JButton("Check");
        check.setBounds(210,300,180,50);
        check.setForeground(Color.BLACK);
        check.setBackground(Color.BLACK);
        check.setFont(new Font("Arial",Font.BOLD,14));
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    BufferedReader reader = new BufferedReader(new FileReader("data/customer.txt"));
                    String line;
                    while ((line = reader.readLine()) != null){
                        String[] details = line.split(",");
                        if(details[1].equals(Customer.getSelectedItem())){
                            labelRoomnumber.setText(details[5]); // Assuming Index 5 is room
                            labelcheckintime.setText(details[6]); // Assuming Index 6 is check-in time
                        }
                    }
                    reader.close();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton back = new JButton("<");
        back.setBounds(25,25,30,30);
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
        setSize(430,380);
        setLocation(500,210);
        setVisible(true);
    }

    // Helper Method to Update Room Status
    private void updateRoomStatus(String roomNum, String status) throws IOException {
        File roomFile = new File("data/room.txt");
        List<String> lines = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(roomFile));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] details = line.split(",");
            if (details[0].equals(roomNum)) {
                details[1] = status; // Update availability index
                line = String.join(",", details);
            }
            lines.add(line);
        }
        reader.close();
        BufferedWriter writer = new BufferedWriter(new FileWriter(roomFile));
        for (String l : lines) {
            writer.write(l + System.getProperty("line.separator"));
        }
        writer.close();
    }

    public static void main(String[] args) {
        new CheckOut();
    }
}