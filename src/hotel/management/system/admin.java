package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class admin extends JFrame implements ActionListener {
    JButton add_Employee, add_Room, add_Drivers, logout, back;
    admin(){
        super("Admin Panel");

        ImageIcon l1 = new ImageIcon(ClassLoader.getSystemResource("icon/employees.gif"));
        Image l11 = l1.getImage().getScaledInstance(120,120, Image.SCALE_DEFAULT);
        ImageIcon imageIcon = new ImageIcon(l11);
        JLabel label = new JLabel(imageIcon);
        label.setBounds(330,100,120,140);
        add(label);

        add_Employee = new JButton("Add Employee");
        add_Employee.setBounds(300,60,200,220);
        add_Employee.setBackground(Color.WHITE);
        add_Employee.setForeground(Color.BLACK);
        add_Employee.setFont(new Font("Arial", Font.BOLD, 15));
        add_Employee.addActionListener(this);
        add_Employee.setVerticalAlignment(SwingConstants.BOTTOM);
        add_Employee.setHorizontalAlignment(SwingConstants.CENTER);
        add(add_Employee);

        ImageIcon imageIcon1 = new ImageIcon(ClassLoader.getSystemResource("icon/room.gif"));
        Image image = imageIcon1.getImage().getScaledInstance(160,70, Image.SCALE_DEFAULT);
        ImageIcon imageIcon11 = new ImageIcon(image);
        JLabel label1 = new JLabel(imageIcon11);
        label1.setBounds(530,140,160,70);
        add(label1);

        add_Room = new JButton( "Add Room");
        add_Room.setBounds(510,60,200,220);
        add_Room.setBackground(Color.WHITE);
        add_Room.setForeground(Color.BLACK);
        add_Room.setFont(new Font("Arial", Font.BOLD, 15));
        add_Room.addActionListener(this);
        add_Room.setVerticalAlignment(SwingConstants.BOTTOM);
        add_Room.setHorizontalAlignment(SwingConstants.CENTER);
        add(add_Room);

        /* ImageIcon imageIcon2 = new ImageIcon(ClassLoader.getSystemResource("icon/driver.gif"));
        Image image1 = imageIcon2.getImage().getScaledInstance(120,120, Image.SCALE_DEFAULT);
        ImageIcon imageIcon12 = new ImageIcon(image1);
        JLabel label2 = new JLabel(imageIcon12);
        label2.setBounds(750,120,140,120);
        add(label2);

        add_Drivers = new JButton( "Add Driver");
        add_Drivers.setBounds(720,60,200,220);
        add_Drivers.setBackground(Color.WHITE);
        add_Drivers.setForeground(Color.BLACK);
        add_Drivers.setFont(new Font("Arial", Font.BOLD, 15));
        add_Drivers.addActionListener(this);
        add_Drivers.setVerticalAlignment(SwingConstants.BOTTOM);
        add_Drivers.setHorizontalAlignment(SwingConstants.CENTER);
        add(add_Drivers);*/

        logout = new JButton( "Logout");
        logout.setBounds(10,800,95,30);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        logout.setFont(new Font("Tahoma", Font.BOLD, 15));
        logout.addActionListener(this);
        add(logout);

        back = new JButton("<");
        back.setBounds(30,15,30,30);
        back.setFont(new Font("Arial",Font.BOLD,14));
        back.setForeground(Color.BLACK);
        back.setBackground(Color.BLACK);
        back.addActionListener(e -> setVisible(false));
        add(back);

        ImageIcon imageIcon3 = new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image image2 = imageIcon3.getImage().getScaledInstance(400,220, Image.SCALE_DEFAULT);
        ImageIcon imageIcon13 = new ImageIcon(image2);
        JLabel label3 = new JLabel(imageIcon13);
        label3.setBounds(-60,50,400,220);
        add(label3);

        /*ImageIcon imageIcon0 = new ImageIcon(ClassLoader.getSystemResource("icon/adminbg.png"));
        Image image4 = imageIcon0.getImage().getScaledInstance(1080,720, Image.SCALE_DEFAULT);
        ImageIcon imageIcon14 = new ImageIcon(image4);
        JLabel label4 = new JLabel(imageIcon14);
        label4.setBounds(0,0,1080,720);
        add(label4);*/

        getContentPane().setBackground(new Color(214, 251, 255));
        setLayout(null);
        setSize(750,360);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == add_Employee){
            new AddEmployee();
        } else if (e.getSource() == add_Room) {
            new AddRoom();
        } else if (e.getSource() == logout){
            // System.exit(102);
            new Login();
            setVisible(false);
        } else if (e.getSource() == back) {
            new Dashboard();
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new admin();
    }
}
