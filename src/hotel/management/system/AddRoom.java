package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import javax.swing.*;

public class AddRoom extends JFrame implements ActionListener {
    JTextField t2,t4;
    JComboBox t3,t5,t6;
    JButton b1,b2;
    AddRoom(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,875,490);
        panel.setBackground(new Color(222, 248, 255));
        panel.setLayout(null);
        add(panel);

        JLabel l1 = new JLabel("Add Rooms");
        l1.setBounds(100,-55,560,200);
        l1.setFont(new Font("Arial", Font.BOLD,32));
        l1.setForeground(Color.BLACK);
        panel.add(l1);

        JLabel l2 = new JLabel("Room Number");
        l2.setBounds(30,90,152,22);
        l2.setFont(new Font("Arial", Font.BOLD, 14));
        l2.setForeground(Color.BLACK);
        panel.add(l2);
        t2 =new JTextField();
        t2.setBounds(200,90,156,20);
        t2.setFont(new Font("Arial", Font.PLAIN, 14));
        t2.setForeground(Color.BLACK);
        t2.setBackground(new Color(255, 255, 255));
        panel.add(t2);

        JLabel l3 = new JLabel("Availability");
        l3.setBounds(30,130,152,22);
        l3.setFont(new Font("Arial", Font.BOLD, 14));
        l3.setForeground(Color.BLACK);
        panel.add(l3);

        t3 =new JComboBox(new String[] {"Available", "Occupied"});
        t3.setBounds(200,130,156,20);
        t3.setFont(new Font("Arial", Font.PLAIN, 14));
        t3.setForeground(Color.BLACK);
        t3.setBackground(new Color(255, 255, 255));
        panel.add(t3);

        JLabel l4 = new JLabel("Price");
        l4.setBounds(30,170,152,22);
        l4.setFont(new Font("Arial", Font.BOLD, 14));
        l4.setForeground(Color.BLACK);
        panel.add(l4);

        t4 =new JTextField();
        t4.setBounds(200,170,156,20);
        t4.setFont(new Font("Arial", Font.PLAIN, 14));
        t4.setForeground(Color.BLACK);
        t4.setBackground(new Color(255, 255, 255));
        panel.add(t4);


        JLabel l5 = new JLabel("Cleaning Status");
        l5.setBounds(30,210,152,22);
        l5.setFont(new Font("Arial", Font.BOLD, 14));
        l5.setForeground(Color.BLACK);
        panel.add(l5);

        t5 =new JComboBox(new String[]{"Cleaned","Dirty"});
        t5.setBounds(200,210,157,20);
        t5.setFont(new Font("Arial", Font.PLAIN, 14));
        t5.setForeground(Color.BLACK);
        t5.setBackground(new Color(255, 255, 255));
        panel.add(t5);

        JLabel l6 = new JLabel("Bed Type");
        l6.setBounds(30,250,152,22);
        l6.setFont(new Font("Arial", Font.BOLD, 14));
        l6.setForeground(Color.BLACK);
        panel.add(l6);

        t6 =new JComboBox(new String[]{"Single Bed","Double Bed"});
        t6.setBounds(200,250,157,20);
        t6.setFont(new Font("Arial", Font.PLAIN, 14));
        t6.setForeground(Color.BLACK);
        t6.setBackground(new Color(255, 255, 255));
        panel.add(t6);

        b1 = new JButton("Add");
        b1.setBounds(25,290,330,40);
        b1.setFont(new Font("Arial", Font.BOLD, 14));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.BLACK);
        b1.addActionListener(this);
        panel.add(b1);

        b2 = new JButton("<");
        b2.setBounds(30,30,30,30);
        b2.setFont(new Font("Arial",Font.BOLD,14));
        b2.setForeground(Color.BLACK);
        b2.setBackground(Color.BLACK);
        panel.add(b2);
        b2.addActionListener(this);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/roomser.gif"));
        Image image = imageIcon.getImage().getScaledInstance(350,250,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(360,60,350,250);
        panel.add(label);

        setUndecorated(true);
        setLocation(20,200);
        setLayout(null);
        setSize(715,360);
        setVisible(true);
    }

    @Override
    // public void actionPerformed(ActionEvent e) {

    //     if (e.getSource() == b1){
    //         try{
    //             conn c = new conn();
    //             String room = t2.getText();
    //             String ava = (String) t3.getSelectedItem();
    //             String status = (String)  t5.getSelectedItem();
    //             String price = t4.getText();
    //             String type =  (String) t6.getSelectedItem();

    //             String q = "insert into room values('"+room+"', '"+ava+"', '"+status+"', '"+price+"', '"+type+"')";
    //             c.statement.executeUpdate(q);

    //             JOptionPane.showMessageDialog(null,"Room Successfully Added");
    //             setVisible(false);

    //         }catch (Exception E){
    //             E.printStackTrace();
    //         }
    //     }else {
    //         setVisible(false);
    //     }

    // }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b1){
            try{
                // 2. Remove 'conn c = new conn();'
                String room = t2.getText();
                String ava = (String) t3.getSelectedItem();
                String status = (String)  t5.getSelectedItem();
                String price = t4.getText();
                String type =  (String) t6.getSelectedItem();

                // 3. File Writing Logic
                // Structure: RoomNumber,Availability,Status,Price,Type
                String roomData = room + "," + ava + "," + status + "," + price + "," + type;
                
                BufferedWriter writer = new BufferedWriter(new FileWriter("data/room.txt", true));
                writer.write(roomData);
                writer.newLine(); 
                writer.close();

                JOptionPane.showMessageDialog(null,"Room Successfully Added to File");
                setVisible(false);

            }catch (Exception E){
                JOptionPane.showMessageDialog(null, "Error: Could not save room data.");
                E.printStackTrace();
            }
        }else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddRoom();
    }
}
