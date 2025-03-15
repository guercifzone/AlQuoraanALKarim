package org.guercifzone;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.io.InputStream;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Dashboard_DOCX extends JFrame {
    private JList<String> userList;
    private JLabel nameLabel;
    private JTextPane contentTextPane;

    public Dashboard_DOCX() {
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
        nameLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        contentTextPane = new JTextPane();
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

        // Load data from DOCX files asynchronously
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
                return loadUserNamesFromDOCX();  // Load data from DOCX files
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
                    JOptionPane.showMessageDialog(Dashboard_DOCX.this, "خطأ في تحميل البيانات", "خطأ", JOptionPane.ERROR_MESSAGE);
                }
            }
        };
        worker.execute();
    }

    private List<String> loadUserNamesFromDOCX() {
        List<String> userNames = new ArrayList<>();
        try {
            // List all DOCX files to load
            List<String> docxFiles = Arrays.asList("data1.docx", "data2.docx");  // Example of two DOCX files

            for (String fileName : docxFiles) {
                InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
                XWPFDocument document = new XWPFDocument(inputStream);

                // Extract paragraphs
                List<XWPFParagraph> paragraphs = document.getParagraphs();
                for (XWPFParagraph paragraph : paragraphs) {
                    userNames.add(paragraph.getText());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error loading data from DOCX", e);
        }
        return userNames;
    }

    private void displayUserDetails(int index) {
        try {
            // Load the DOCX files
            List<String> docxFiles = Arrays.asList("data1.docx", "data2.docx");
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(docxFiles.get(index % docxFiles.size()));  // Choose DOCX file based on index
            XWPFDocument document = new XWPFDocument(inputStream);

            // Extract paragraphs
            List<XWPFParagraph> paragraphs = document.getParagraphs();
            XWPFParagraph selectedParagraph = paragraphs.get(index);

            // Set the name and content
            nameLabel.setText("السورة: " + selectedParagraph.getText());
            String content = selectedParagraph.getText().trim();

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
        SwingUtilities.invokeLater(() -> new Dashboard_DOCX());
    }
}
