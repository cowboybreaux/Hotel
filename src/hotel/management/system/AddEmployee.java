package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File; // Added this import
import java.io.FileWriter;
import javax.swing.*;

public class AddEmployee extends JFrame implements ActionListener {

    JTextField nameText, ageText, salaryText, phoneText, IDText, emailText;
    JRadioButton radioButtonM, radioButtonF;
    JComboBox comboBox;
    JButton add, back;

    // --- Custom Colors & Font ---
    Color backgroundColor = new Color(240, 250, 255); // #f0faff
    Color textColor = new Color(0, 19, 87);           // #001357
    Color buttonColor = new Color(0, 19, 87);         // Dark blue for buttons
    String fontName = "Arial";                        // Arial Font

    AddEmployee() {
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 890, 490);
        panel.setLayout(null);
        panel.setBackground(backgroundColor); 
        add(panel);

        // --- NAME ---
        JLabel name = new JLabel("Name");
        name.setBounds(60, 100, 150, 27);
        name.setFont(new Font(fontName, Font.BOLD, 17));
        name.setForeground(textColor);
        panel.add(name);
        
        nameText = new JTextField();
        nameText.setBounds(200, 100, 150, 27);
        nameText.setBackground(Color.WHITE);
        nameText.setFont(new Font(fontName, Font.BOLD, 14));
        nameText.setForeground(textColor);
        panel.add(nameText);

        // --- AGE ---
        JLabel Age = new JLabel("Age");
        Age.setBounds(60, 130, 150, 27);
        Age.setFont(new Font(fontName, Font.BOLD, 17));
        Age.setForeground(textColor);
        panel.add(Age);
        
        ageText = new JTextField();
        ageText.setBounds(200, 130, 150, 27);
        ageText.setBackground(Color.WHITE);
        ageText.setFont(new Font(fontName, Font.BOLD, 14));
        ageText.setForeground(textColor);
        panel.add(ageText);

        // --- GENDER ---
        JLabel gender = new JLabel("Gender");
        gender.setBounds(60, 160, 150, 27);
        gender.setFont(new Font(fontName, Font.BOLD, 17));
        gender.setForeground(textColor);
        panel.add(gender);

        radioButtonM = new JRadioButton("Male");
        radioButtonM.setBounds(200, 160, 70, 27);
        radioButtonM.setBackground(backgroundColor);
        radioButtonM.setFont(new Font(fontName, Font.BOLD, 14));
        radioButtonM.setForeground(textColor);
        panel.add(radioButtonM);

        radioButtonF = new JRadioButton("Female");
        radioButtonF.setBounds(200, 190, 100, 27);
        radioButtonF.setBackground(backgroundColor);
        radioButtonF.setFont(new Font(fontName, Font.BOLD, 14));
        radioButtonF.setForeground(textColor);
        panel.add(radioButtonF);

        // --- JOB ---
        JLabel job = new JLabel("Designation");
        job.setBounds(60, 230, 150, 27);
        job.setFont(new Font(fontName, Font.BOLD, 17));
        job.setForeground(textColor);
        panel.add(job);

        comboBox = new JComboBox(new String[]{"Front Desk", "Housekeeping", "Kitchen Staff", "Room Service", "Manager", "Accountant", "Chef"});
        comboBox.setBackground(Color.WHITE);
        comboBox.setBounds(200, 230, 150, 30);
        comboBox.setFont(new Font(fontName, Font.BOLD, 14));
        comboBox.setForeground(textColor);
        panel.add(comboBox);

        // --- SALARY ---
        /*JLabel salary = new JLabel("SALARY");
        salary.setBounds(60, 220, 150, 27);
        salary.setFont(new Font(fontName, Font.BOLD, 17));
        salary.setForeground(textColor);
        panel.add(salary);
        
        salaryText = new JTextField();
        salaryText.setBounds(200, 220, 150, 27);
        salaryText.setBackground(Color.WHITE);
        salaryText.setFont(new Font(fontName, Font.BOLD, 14));
        salaryText.setForeground(textColor);
        panel.add(salaryText);*/

        // --- PHONE ---
        JLabel phone = new JLabel("Contact No");
        phone.setBounds(60, 260, 150, 27);
        phone.setFont(new Font(fontName, Font.BOLD, 17));
        phone.setForeground(textColor);
        panel.add(phone);
        
        phoneText = new JTextField();
        phoneText.setBounds(200, 260, 150, 27);
        phoneText.setBackground(Color.WHITE);
        phoneText.setFont(new Font(fontName, Font.BOLD, 14));
        phoneText.setForeground(textColor);
        panel.add(phoneText);

        // --- ID ---
        JLabel ID = new JLabel("ID");
        ID.setBounds(60, 290, 150, 27);
        ID.setFont(new Font(fontName, Font.BOLD, 17));
        ID.setForeground(textColor);
        panel.add(ID);
        
        IDText = new JTextField();
        IDText.setBounds(200, 290, 150, 27);
        IDText.setBackground(Color.WHITE);
        IDText.setFont(new Font(fontName, Font.BOLD, 14));
        IDText.setForeground(textColor);
        panel.add(IDText);

        // --- EMAIL ---
        JLabel email = new JLabel("Email Address");
        email.setBounds(60, 320, 150, 27);
        email.setFont(new Font(fontName, Font.BOLD, 17));
        email.setForeground(textColor);
        panel.add(email);
        
        emailText = new JTextField();
        emailText.setBounds(200, 320, 150, 27);
        emailText.setBackground(Color.WHITE);
        emailText.setFont(new Font(fontName, Font.BOLD, 14));
        emailText.setForeground(textColor);
        panel.add(emailText);

        // --- HEADER ---
        JLabel AED = new JLabel("Employee Registration");
        AED.setBounds(80, 24, 445, 35);
        AED.setFont(new Font(fontName, Font.BOLD, 23));
        AED.setForeground(textColor);
        panel.add(AED);

        // --- BUTTONS ---
        add = new JButton("ADD");
        add.setBounds(60, 390, 290, 50);
        add.setBackground(buttonColor);
        add.setForeground(Color.BLACK);
        add.setFont(new Font("Arial",Font.BOLD,14));
        add.addActionListener(this);
        panel.add(add);

        back = new JButton("<");
        back.setBounds(20,25,30,30);
        back.setFont(new Font("Arial",Font.BOLD,14));
        back.setBackground(buttonColor);
        back.setBackground(Color.BLACK);
        panel.add(back);
        back.addActionListener(this);

        /* * OPTIONAL IMAGE SECTION
         * ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/addemp.png"));
         * Image image = imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
         * ImageIcon imageIcon1 = new ImageIcon(image);
         * JLabel label = new JLabel(imageIcon1);
         * label.setBounds(500,100,300,300);
         * panel.add(label);
         */

        setUndecorated(true);
        setLocation(60, 160);
        setLayout(null);
        setSize(430, 500);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {
            String name = nameText.getText();
            String age = ageText.getText();
            String salary = salaryText.getText();
            String phone = phoneText.getText();
            String email = emailText.getText();
            String ID = IDText.getText();
            String job = (String) comboBox.getSelectedItem();
            String gender = null;
            if (radioButtonM.isSelected()) {
                gender = "Male";
            } else if (radioButtonF.isSelected()) {
                gender = "Female";
            }

            try {
                // Formatting data
                String employeeData = name + "," + age + "," + gender + "," + job + "," + salary + "," + phone + "," + email + "," + ID;
                
                // --- FIX STARTS HERE ---
                File file = new File("data/employee.txt");
                
                // If the "data" folder doesn't exist, create it!
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                
                // Now we can safely write the file
                BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
                writer.write(employeeData);
                writer.newLine(); 
                writer.close();
                // --- FIX ENDS HERE ---

                JOptionPane.showMessageDialog(null, "Employee Added Successfully");
                setVisible(false);

            } catch (Exception E) {
                JOptionPane.showMessageDialog(null, "Error: Could not save employee data.");
                E.printStackTrace();
            }

        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}