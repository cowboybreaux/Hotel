package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Reception extends JFrame {
    Reception(){
        super("Reception Menu");
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(280,5,1238,820);
        panel.setBackground(new Color(222, 253, 255));
        add(panel);

        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(5,5,270,820);
        panel1.setBackground(new Color(222, 253, 255));
        add(panel1);

        ImageIcon i111 = new ImageIcon(ClassLoader.getSystemResource("icon/cccc.gif"));
        Image i22 = i111.getImage().getScaledInstance(1048,780, Image.SCALE_DEFAULT);
        ImageIcon imageIcon111 = new ImageIcon(i22);
        JLabel label11 = new JLabel(imageIcon111);
        label11.setBounds(-40,-20,1048,780);
        panel.add(label11);

        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image i2 = i11.getImage().getScaledInstance(350,185, Image.SCALE_DEFAULT);
        ImageIcon imageIcon11 = new ImageIcon(i2);
        JLabel label1 = new JLabel(imageIcon11);
        label1.setBounds(-45,60,350,185);
        panel1.add(label1);

        JButton btnNCF = new JButton("New Guest");
        btnNCF.setBounds(30,300,200,30);
        btnNCF.setFont(new Font("Arial",Font.BOLD,12));
        btnNCF.setBackground(Color.BLACK);
        btnNCF.setForeground(Color.BLACK);
        panel1.add(btnNCF);
        btnNCF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new NewCustomer();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton btnRoom = new JButton("Room");
        btnRoom.setBounds(30,330,200,30);
        btnRoom.setFont(new Font("Arial",Font.BOLD,12));
        btnRoom.setBackground(Color.BLACK);
        btnRoom.setForeground(Color.BLACK);
        panel1.add(btnRoom);
        btnRoom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new Room();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton btnDepartment = new JButton("Department");
        btnDepartment.setBounds(30,360,200,30);
        btnDepartment.setFont(new Font("Arial",Font.BOLD,12));
        btnDepartment.setBackground(Color.BLACK);
        btnDepartment.setForeground(Color.BLACK);
        panel1.add(btnDepartment);
        btnDepartment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new Department();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton btnAEI = new JButton("All Employee Info");
        btnAEI.setBounds(30,390,200,30);
        btnAEI.setFont(new Font("Arial",Font.BOLD,12));
        btnAEI.setBackground(Color.BLACK);
        btnAEI.setForeground(Color.BLACK);
        panel1.add(btnAEI);
        btnAEI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new Employee();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton btnCI = new JButton("Customer Info");
        btnCI.setBounds(30,420,200,30);
        btnCI.setFont(new Font("Arial",Font.BOLD,12));
        btnCI.setBackground(Color.BLACK);
        btnCI.setForeground(Color.BLACK);
        panel1.add(btnCI);
        btnCI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new CustomerInfo();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton btnMI = new JButton("Manager Info");
        btnMI.setBounds(30,450,200,30);
        btnMI.setFont(new Font("Arial",Font.BOLD,12));
        btnMI.setBackground(Color.BLACK);
        btnMI.setForeground(Color.BLACK);
        panel1.add(btnMI);
        btnMI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new ManagerInfo();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton btnCO = new JButton("Check Out");
        btnCO.setBounds(30,480,200,30);
        btnCO.setFont(new Font("Arial",Font.BOLD,12));
        btnCO.setBackground(Color.BLACK);
        btnCO.setForeground(Color.BLACK);
        panel1.add(btnCO);
        btnCO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new CheckOut();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton btnUC = new JButton("Update Check-In Details");
        btnUC.setBounds(30,510,200,30);
        btnUC.setFont(new Font("Arial",Font.BOLD,12));
        btnUC.setBackground(Color.BLACK);
        btnUC.setForeground(Color.BLACK);
        panel1.add(btnUC);
        btnUC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new UpdateCheck();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton btnURS = new JButton("Update Room Status");
        btnURS.setBounds(30,540,200,30);
        btnURS.setFont(new Font("Arial",Font.BOLD,12));
        btnURS.setBackground(Color.BLACK);
        btnURS.setForeground(Color.BLACK);
        panel1.add(btnURS);
        btnURS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new UpdateRoom();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        /*JButton btnPUS = new JButton("Pick up Service");
        btnPUS.setBounds(30,570,200,30);
        btnPUS.setFont(new Font("Arial",Font.BOLD,12));
        btnPUS.setBackground(Color.BLACK);
        btnPUS.setForeground(Color.BLACK);
        panel1.add(btnPUS);
        btnPUS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new PickUp();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });*/

        JButton btnSR = new JButton("Search Room");
        btnSR.setBounds(30,570,200,30);
        btnSR.setFont(new Font("Arial",Font.BOLD,12));
        btnSR.setBackground(Color.BLACK);
        btnSR.setForeground(Color.BLACK);
        panel1.add(btnSR);
        btnSR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new SearchRoom();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton logout = new JButton("Logout");
        logout.setBounds(30,640,200,30);
        logout.setFont(new Font("Arial",Font.BOLD,12));
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.BLACK);
        panel1.add(logout);
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                  System.exit(500);
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton back = new JButton("Back");
        back.setBounds(30,670,200,30);
        back.setFont(new Font("Arial",Font.BOLD,12));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.BLACK);
        panel1.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                   setVisible(false);
                   new Dashboard();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(1238,780);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Reception();
    }
}
