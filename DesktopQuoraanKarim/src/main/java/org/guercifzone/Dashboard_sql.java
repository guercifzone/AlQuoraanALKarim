package org.guercifzone;



import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Dashboard_sql extends JFrame {
    private JList<String> userList;
    private JLabel nameLabel;
    private JTextPane contentTextPane;

    public Dashboard_sql() {
        setTitle("المصحف المحمدي الشريف");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        JSplitPane splitPane = new JSplitPane();
        splitPane.setDividerLocation(600);
        splitPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        JPanel rightPanel = new JPanel(new BorderLayout());
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

        // Load data from MySQL
        loadData();

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

    private void loadData() {
        List<String> userNames = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sowar_db", "username", "password");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT name FROM sowar")) {

            while (resultSet.next()) {
                userNames.add(resultSet.getString("name"));
            }

            DefaultListModel<String> listModel = new DefaultListModel<>();
            for (String userName : userNames) {
                listModel.addElement(userName);
            }
            userList.setModel(listModel);

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "خطأ في تحميل البيانات من قاعدة البيانات", "خطأ", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void displayUserDetails(int index) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sowar_db", "username", "password");
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT name, content FROM sowar WHERE id = ?")) {

            // Get the ID based on the selected index (in this case, just using index as id for simplicity)
            preparedStatement.setInt(1, index + 1);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String name = resultSet.getString("name");
                    String content = resultSet.getString("content").trim();

                    nameLabel.setText("السورة: " + name);
                    colorizeNumbers(content);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "خطأ في تحميل التفاصيل من قاعدة البيانات", "خطأ", JOptionPane.ERROR_MESSAGE);
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
