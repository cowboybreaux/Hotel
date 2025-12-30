package hotel.management.system;

import java.awt.*;
import java.io.InputStream;

public class CustomFont {

    public static Font loadFont(float size) {
        try {
            InputStream is = CustomFont.class
                .getResourceAsStream("/src/font/SF.otf");

            Font font = Font.createFont(Font.TRUETYPE_FONT, is);
            return font.deriveFont(size);

        } catch (Exception e) {
            e.printStackTrace();
            return new Font("SanFrancisco", Font.PLAIN, (int) 12);
        }
    }
}