package org.guercifzone;

import javax.swing.*;
import java.awt.Font;

public class Main {
    public static void main(String[] args) {
        // Load the custom font
        Font customFont = FontLoader.loadFont("aalmaghribi_v4.9.otf", 14f); // Adjust the size as needed

        if (customFont != null) {
            // Set the font globally for all Swing components
            UIManager.put("Button.font", customFont);
            UIManager.put("Label.font", customFont);
            UIManager.put("TextField.font", customFont);
            UIManager.put("TextArea.font", customFont);
            UIManager.put("Table.font", customFont);
            UIManager.put("List.font", customFont);
            UIManager.put("ComboBox.font", customFont);
            UIManager.put("Menu.font", customFont);
            UIManager.put("MenuItem.font", customFont);
            UIManager.put("CheckBox.font", customFont);
            UIManager.put("RadioButton.font", customFont);
            // Add more components as needed
        } else {
            System.err.println("Custom font could not be loaded. Using default font.");
        }

        // Start your application
     //  SwingUtilities.invokeLater(() -> new Dashboard_JSON());
     //   SwingUtilities.invokeLater(() -> new Dashboard_sql());
       SwingUtilities.invokeLater(() -> new Dashboard_DOCX());
    }
}