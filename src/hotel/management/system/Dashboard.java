package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Dashboard extends JFrame implements ActionListener {
    JButton add,rec;
    Dashboard(){
        super("Yakyakyay Hotel Dashboard");

        JLabel label0 = new JLabel("Login Dashboard");
        label0.setBounds(300,-420,1920,1080);
        label0.setFont(new Font("Arial",Font.BOLD,60));
        label0.setForeground(Color.WHITE);
        add(label0);
        
        JLabel label01 = new JLabel("Please Choose Your Login:");
        label01.setBounds(410,-360,1920,1080);
        label01.setFont(new Font("Arial",Font.BOLD,20));
        label01.setForeground(Color.WHITE);
        add(label01);

        rec = new JButton("RECEPTION");
        rec.setBounds(170,450,200,30);
        rec.setFont(new Font("Arial", Font.BOLD,15));
        rec.setBackground(new Color(255,98,0));
        rec.setForeground(Color.BLACK);
        rec.addActionListener(this);
        add(rec);

        add = new JButton("ADMIN");
        add.setBounds(720,450,200,30);
        add.setFont(new Font("Arial", Font.BOLD,15));
        add.setBackground(new Color(255,98,0));
        add.setForeground(Color.BLACK);
        add.addActionListener(this);
        add(add);

        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icon/boss.png"));
        Image i2 = i11.getImage().getScaledInstance(400,390, Image.SCALE_DEFAULT);
        ImageIcon imageIcon11 = new ImageIcon(i2);
        JLabel label1 = new JLabel(imageIcon11);
        label1.setBounds(720,250,200,195);
        add(label1);

        ImageIcon i111 = new ImageIcon(ClassLoader.getSystemResource("icon/Reception.png"));
        Image i22 = i111.getImage().getScaledInstance(400,390, Image.SCALE_DEFAULT);
        ImageIcon imageIcon111 = new ImageIcon(i22);
        JLabel label11 = new JLabel(imageIcon111);
        label11.setBounds(170,250,200,195);
        add(label11);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/Dashboard.gif"));
        Image i1 = imageIcon.getImage().getScaledInstance(1080,720, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(i1);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(0,0,1080,720);
        add(label);

        setLayout(null);
        setSize(1080,720);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==rec){
            new Reception();
            setVisible(false);
        }else {
            new Login2();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Dashboard();
    }
}
