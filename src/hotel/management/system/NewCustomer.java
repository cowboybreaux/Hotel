package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.*;

public class NewCustomer extends JFrame implements ActionListener {
    JComboBox comboBox;
    JTextField textFieldNumber ,TextName, TextCountry,TextDeposite;
    JRadioButton r1, r2;
    Choice c1;
    JLabel date;

    JButton add,back;
    NewCustomer(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,840,540);
        panel.setLayout(null);
        panel.setBackground(new Color(222, 253, 255));
        add(panel);

        JLabel labelName = new JLabel("Guest Registration Form");
        labelName.setBounds(118,11,260,53);
        labelName.setFont(new Font("Arial", Font.BOLD,20));
        labelName.setForeground(Color.BLACK);
        panel.add(labelName);

        JLabel labelID = new JLabel("Identification Type :");
        labelID.setBounds(35,75,200,14);
        labelID.setForeground(Color.BLACK);
        labelID.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(labelID);

        comboBox = new JComboBox(new String[] {"Click To Choose","Passport", "ID Card", "Voter Id", "Driving License"});
        comboBox.setBounds(250,75,170,20);
        comboBox.setBackground(new Color(255, 255, 255));
        comboBox.setForeground(Color.BLACK);
        comboBox.setFont(new Font("Arial", Font.PLAIN, 12));
        panel.add(comboBox);

        JLabel labelNumber = new JLabel("Identification Number :");
        labelNumber.setBounds(35,105,170,14);
        labelNumber.setForeground(Color.BLACK);
        labelNumber.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(labelNumber);
        textFieldNumber = new JTextField();
        textFieldNumber.setBounds(250,105,170,20);
        panel.add(textFieldNumber);

        JLabel labelname = new JLabel("Name as per ID :");
        labelname.setBounds(35,135,200,14);
        labelname.setForeground(Color.BLACK);
        labelname.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(labelname);
        TextName = new JTextField();
        TextName.setBounds(250,135,170,20);
        panel.add(TextName);


        JLabel labelGender = new JLabel("Gender :");
        labelGender.setBounds(35,165,200,14);
        labelGender.setForeground(Color.BLACK);
        labelGender.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(labelGender);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Arial", Font.BOLD, 14));
        r1.setForeground(Color.BLACK);
        r1.setBackground(new Color(3,45,48));
        r1.setBounds(250,165,80,12);
        panel.add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Arial", Font.BOLD, 14));
        r2.setForeground(Color.BLACK);
        r2.setBackground(new Color(3,45,48));
        r2.setBounds(335,165,200,12);
        panel.add(r2);

        JLabel labelCountry = new JLabel("Country :");
        labelCountry.setBounds(35,195,200,14);
        labelCountry.setForeground(Color.BLACK);
        labelCountry.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(labelCountry);
        TextCountry = new JTextField();
        TextCountry.setBounds(250,195,170,20);
        panel.add(TextCountry);


        JLabel labelRoom = new JLabel("Allocated Room Number :");
        labelRoom.setBounds(35,225,200,14);
        labelRoom.setForeground(Color.BLACK);
        labelRoom.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(labelRoom);

        // c1 = new Choice();
        // try{

        //     conn c = new conn();
        //     ResultSet resultSet = c.statement.executeQuery("select * from room");
        //     while (resultSet.next()){
        //         c1.add(resultSet.getString("roomnumber"));
        //     }

        // }catch (Exception e){
        //     e.printStackTrace();
        // }

        c1 = new Choice();
        try {
            // Read from room.txt to find available rooms
            BufferedReader reader = new BufferedReader(new FileReader("data/room.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] details = line.split(",");
                // If availability (index 1) is "Available", add to choice
                if (details[1].equalsIgnoreCase("Available")) {
                    c1.add(details[0]); // Room Number
                }
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("No rooms available or file missing.");
        }

        c1.setBounds(250,225,170,20);
        c1.setFont(new Font("Arial", Font.BOLD, 14));
        c1.setForeground(Color.BLACK);
        //c1.setBackground(new Color(3,45,48));
        panel.add(c1);

        JLabel labelCIS = new JLabel("Checked-In :");
        labelCIS.setBounds(35,255,200,14);
        labelCIS.setForeground(Color.BLACK);
        labelCIS.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(labelCIS);

        Date date1 = new Date();

        date = new JLabel(""+date1);
        date.setBounds(160,255,500,14);
        date.setForeground(Color.RED);
        date.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(date);


        JLabel labelDeposite = new JLabel("Deposit (RM) :");
        labelDeposite.setBounds(35,285,200,14);
        labelDeposite.setForeground(Color.BLACK);
        labelDeposite.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(labelDeposite);
        TextDeposite = new JTextField();
        TextDeposite.setBounds(250,285,170,20);
        panel.add(TextDeposite);

        add = new JButton("Add Guest");
        add.setBounds(30,315,390,50);
        add.setForeground(Color.BLACK);
        add.setBackground(Color.BLACK);
        add.setFont(new Font("Arial", Font.BOLD, 14));
        add.addActionListener(this);
        panel.add(add);

        back = new JButton("<");
        back.setBounds(35,25,25,25);
        back.setFont(new Font("Arial",Font.BOLD,14));
        back.setForeground(Color.BLACK);
        back.setBackground(Color.BLACK);
        panel.add(back);
        back.addActionListener(e -> setVisible(false));

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/customer.gif"));
        Image image = imageIcon.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel imglabel = new JLabel(imageIcon1);
        imglabel.setBounds(430,60,250,250);
        panel.add(imglabel);

        setLayout(null);
        setLocation(500,150);
        setSize(700,420);
        setVisible(true);
    }

    // @Override
    // public void actionPerformed(ActionEvent e) {
    //     if (e.getSource() == add){
    //         conn c = new conn();
    //         String radioBTn = null;
    //         if (r1.isSelected()){
    //             radioBTn = "Male";
    //         } else if (r2.isSelected()) {
    //             radioBTn = "Female";
    //         }

    //         String s1 = (String)comboBox.getSelectedItem();
    //         String s2 =  textFieldNumber.getText();
    //         String s3 =  TextName.getText();
    //         String s4 =  radioBTn;
    //         String s5 =  TextCountry.getText();
    //         String s6 =  c1.getSelectedItem();
    //         String s7 =  date.getText();
    //         String s8 = TextDeposite.getText();

    //         try {

    //             String q ="insert into customer values ('"+s1+"', '"+s2+"','"+s3+"','"+s4+"', '"+s5+"', '"+s6+"', '"+s7+"', '"+s8+"')";
    //             String q1 = "update room set availability = 'Occupied' where roomnumber = "+s6;
    //             c.statement.executeUpdate(q);
    //             c.statement.executeUpdate(q1);
    //             JOptionPane.showMessageDialog(null, "added Successfully");
    //             setVisible(false);

    //         }catch (Exception E) {
    //             E.printStackTrace();
    //         }
    //     }else {
    //         setVisible(false);
    //     }


    // }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add){
            String radioBTn = r1.isSelected() ? "Male" : "Female";
            String s1 = (String)comboBox.getSelectedItem();
            String s2 = textFieldNumber.getText();
            String s3 = TextName.getText();
            String s4 = radioBTn;
            String s5 = TextCountry.getText();
            String s6 = c1.getSelectedItem(); // The Room Number
            String s7 = date.getText();
            String s8 = TextDeposite.getText();

            try {
                // 1. Save Customer to customer.txt
                String customerData = s1 + "," + s2 + "," + s3 + "," + s4 + "," + s5 + "," + s6 + "," + s7 + "," + s8;
                BufferedWriter writer = new BufferedWriter(new FileWriter("data/customer.txt", true));
                writer.write(customerData);
                writer.newLine();
                writer.close();

                // 2. Update Room status to 'Occupied' in room.txt
                updateRoomAvailability(s6, "Occupied");

                JOptionPane.showMessageDialog(null, "Added Successfully");
                setVisible(false);

            } catch (Exception E) {
                E.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    // Helper method to rewrite the room file with the updated status
    private void updateRoomAvailability(String roomNum, String status) throws IOException {
        File inputFile = new File("data/room.txt");
        List<String> lines = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        String currentLine;

        while ((currentLine = reader.readLine()) != null) {
            String[] parts = currentLine.split(",");
            if (parts[0].equals(roomNum)) {
                parts[1] = status; // Change 'Available' to 'Occupied'
                currentLine = String.join(",", parts);
            }
            lines.add(currentLine);
        }
        reader.close();

        BufferedWriter writer = new BufferedWriter(new FileWriter(inputFile));
        for (String line : lines) {
            writer.write(line + System.getProperty("line.separator"));
        }
        writer.close();
    }

    public static void main(String[] args) {
        new NewCustomer();
    }
}
