package org.guercifzone;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;

public class FontLoader {
    public static Font loadFont(String fontPath, float size) {
        try (InputStream fontStream = FontLoader.class.getClassLoader().getResourceAsStream(fontPath)) {
            if (fontStream == null) {
                throw new IOException("Font file not found: " + fontPath);
            }
            Font font = Font.createFont(Font.TRUETYPE_FONT, fontStream);
            return font.deriveFont(size); // Set the desired size
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
            return null; // Fallback to default font if loading fails
        }
    }
}