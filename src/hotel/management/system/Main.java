package hotel.management.system;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Font Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Serving custom font realness ✨");
        label.setFont(CustomFont.loadFont(24f));

        frame.add(label);
        frame.setSize(400, 200);
        frame.setVisible(true);
        
        GraphicsEnvironment ge =
        GraphicsEnvironment.getLocalGraphicsEnvironment();
        Font font = new Font("SanFrancisco", Font.PLAIN, 24);
        ge.registerFont(font);

        label.setFont(new Font("SanFrancisco", Font.PLAIN, 24));
    }
}