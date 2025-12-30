package hotel.management.system;

import java.io.File;
import javax.swing.*;

public class Splash extends JFrame {
    Splash(){

        super("Loading...");
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/splash.gif"));
        JLabel label = new JLabel(imageIcon);
        label.setBounds(0,-50,492,280);
        add(label);

        setLayout(null);
        setLocation(492,280);
        setSize(492,258);
        setVisible(true);

        // try {
        //     Thread.sleep(5000);
        //     new Login();
        //     setVisible(false);
        // }catch (Exception e){
        //     e.printStackTrace();
        // }

        try {
            File dataDir = new File("data");
            if (!dataDir.exists()) {
                dataDir.mkdir();
            }

            Thread.sleep(5000);
            
            new Login();
            setVisible(false);
            
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Splash();
    }
}
