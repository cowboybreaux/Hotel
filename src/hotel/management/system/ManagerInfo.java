package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ManagerInfo extends JFrame {
    ManagerInfo(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,990,590);
        panel.setBackground(new Color(222, 248, 255));
        panel.setLayout(null);
        add(panel);

        // 1. Setup Table and Model
        String[] columnNames = {"Name", "Age", "Gender", "Job", "Salary", "Phone", "Email", "ID"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(model);
        table.setForeground(Color.BLACK);
        table.setBackground(new Color(63, 122, 138));

        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(10,43,980,450);
        sp.getViewport().setBackground(new Color(255,255,255));
        panel.add(sp);

        // 2. Filter Logic: Read file and only add rows where Job == Manager
        try {
            BufferedReader reader = new BufferedReader(new FileReader("data/employee.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] rowData = line.split(",");
                
                // Assuming "Job" is stored at index 3 (Name=0, Age=1, Gender=2, Job=3)
                if (rowData[3].equalsIgnoreCase("Manager")) {
                    model.addRow(rowData);
                }
            }
            reader.close();
        } catch (Exception e ){
            System.out.println("Error reading employee file.");
        }

        JButton back = new JButton("<");
        back.setBounds(10,5,30,30);
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

        // Labels (Optional since JScrollPane provides headers)
        JLabel name = new JLabel("Management Information");
        name.setBounds(365,8,500,26);
        name.setForeground(Color.BLACK);
        name.setFont(new Font("Arial", Font.BOLD,25));
        panel.add(name);

        // ... (Repeat for other labels as per your design)

        setUndecorated(true);
        setLayout(null);
        setLocation(430,100);
        setSize(1010,510);
        setVisible(true);

    }
    public static void main(String[] args) {
        new ManagerInfo();
    }
}