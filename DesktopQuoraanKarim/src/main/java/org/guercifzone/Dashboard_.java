package org.guercifzone;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;

public class Dashboard_ extends JFrame {
    private JList<String> userList;
    private JLabel nameLabel;
    private JTextPane contentTextPane; // Changed to JTextPane

    public Dashboard_() {
        setTitle("المصحف المحمدي الشريف");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        JSplitPane splitPane = new JSplitPane();
        splitPane.setDividerLocation(600);
        splitPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        JPanel rightPanel  = new JPanel(new BorderLayout());
        rightPanel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        userList = new JList<>();
        userList.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        rightPanel.add(new JScrollPane(userList), BorderLayout.CENTER);

        // Right panel for details
        JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        leftPanel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        nameLabel = new JLabel();
        nameLabel.setHorizontalAlignment(SwingConstants.RIGHT); // Align text to the right

        contentTextPane = new JTextPane(); // Changed to JTextPane
        contentTextPane.setEditable(false);
        contentTextPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        contentTextPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
        contentTextPane.setAlignmentY(Component.TOP_ALIGNMENT);
        JScrollPane scrollPane = new JScrollPane(contentTextPane);
        scrollPane.setPreferredSize(new Dimension(400, 550));

        leftPanel.add(nameLabel, BorderLayout.NORTH);
        leftPanel.add(scrollPane, BorderLayout.CENTER);

        splitPane.setRightComponent(rightPanel);
        splitPane.setLeftComponent(leftPanel);

        add(splitPane);

        // Load data from JSON asynchronously
        loadDataAsync();

        // Add selection listener to the list
        userList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedIndex = userList.getSelectedIndex();
                if (selectedIndex != -1) {
                    displayUserDetails(selectedIndex);
                }
            }
        });

        setVisible(true);
    }

    private void loadDataAsync() {
        // Use a SwingWorker to load data in the background
        SwingWorker<List<String>, Void> worker = new SwingWorker<>() {
            @Override
            protected List<String> doInBackground() throws Exception {
                return loadUserNames();  // Load data in background thread
            }

            @Override
            protected void done() {
                try {
                    List<String> userNames = get();
                    DefaultListModel<String> listModel = new DefaultListModel<>();
                    for (String userName : userNames) {
                        listModel.addElement(userName);
                    }
                    userList.setModel(listModel);  // Update UI with loaded data
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(Dashboard_.this, "خطأ في تحميل البيانات", "خطأ", JOptionPane.ERROR_MESSAGE);
                }
            }
        };
        worker.execute();
    }

    private List<String> loadUserNames() {
        List<String> userNames = new ArrayList<>();
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("data.json");
             InputStreamReader reader = new InputStreamReader(inputStream)) {
            JsonObject jsonObject = JsonParser.parseReader(reader).getAsJsonObject();
            JsonArray users = jsonObject.getAsJsonArray("sowar");

            for (int i = 0; i < users.size(); i++) {
                JsonObject user = users.get(i).getAsJsonObject();
                userNames.add(user.get("name").getAsString());
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error loading data", e);
        }
        return userNames;
    }

    private void displayUserDetails(int index) {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("data.json");
             InputStreamReader reader = new InputStreamReader(inputStream)) {
            JsonObject jsonObject = JsonParser.parseReader(reader).getAsJsonObject();
            JsonArray users = jsonObject.getAsJsonArray("sowar");
            JsonObject user = users.get(index).getAsJsonObject();

            nameLabel.setText("السورة: " + user.get("name").getAsString());
            String content =  user.get("content").getAsString().trim();

            // Apply colorization to numbers
            colorizeNumbers(content);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "خطأ في تحميل البيانات", "× خطأ ×", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void colorizeNumbers(String text) {
        StyledDocument doc = contentTextPane.getStyledDocument();

        // Style for numbers (red color)
        SimpleAttributeSet numberStyle = new SimpleAttributeSet();
        StyleConstants.setForeground(numberStyle, Color.RED);

        // Style for parentheses (green color)
        SimpleAttributeSet parenthesisStyle = new SimpleAttributeSet();
        StyleConstants.setForeground(parenthesisStyle, Color.GREEN);

        try {
            doc.remove(0, doc.getLength()); // Clear existing text

            // Add text with colorized numbers and parentheses
            int length = text.length();
            StringBuilder currentWord = new StringBuilder();
            for (int i = 0; i < length; i++) {
                char c = text.charAt(i);

                // Check if character is a digit
                if (Character.isDigit(c)) {
                    currentWord.append(c);
                } else if (c == '(' || c == ')') {
                    // If we have accumulated digits, apply the red color
                    if (currentWord.length() > 0) {
                        doc.insertString(doc.getLength(), currentWord.toString(), numberStyle);
                        currentWord.setLength(0);
                    }
                    // Insert the parenthesis with green color
                    doc.insertString(doc.getLength(), String.valueOf(c), parenthesisStyle);
                } else {
                    // If we have accumulated digits, apply the red color
                    if (currentWord.length() > 0) {
                        doc.insertString(doc.getLength(), currentWord.toString(), numberStyle);
                        currentWord.setLength(0);
                    }
                    // Insert the non-digit, non-parenthesis character without any color
                    doc.insertString(doc.getLength(), String.valueOf(c), null);
                }
            }

            // Insert any remaining numbers at the end
            if (currentWord.length() > 0) {
                doc.insertString(doc.getLength(), currentWord.toString(), numberStyle);
            }
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Dashboard());
    }
}
