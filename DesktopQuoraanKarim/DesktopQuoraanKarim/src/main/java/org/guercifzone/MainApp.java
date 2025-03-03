package org.guercifzone;


import javax.swing.*;
import java.awt.*;

public class MainApp extends JFrame {

    public MainApp() {
        // Set up the JFrame
        setTitle("Java Swing Dashboard");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create a layout for the dashboard
        setLayout(new BorderLayout());

        // Create a side panel (for navigation, etc.)
        JPanel sidePanel = new JPanel();
        sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));
        sidePanel.setBackground(new Color(50, 50, 50));
        sidePanel.setPreferredSize(new Dimension(200, getHeight()));

        // Create buttons for the side panel
        JButton btnDashboard = new JButton("Dashboard");
        JButton btnSettings = new JButton("Settings");
        JButton btnLogout = new JButton("Logout");

        // Style buttons
        btnDashboard.setBackground(new Color(100, 100, 100));
        btnSettings.setBackground(new Color(100, 100, 100));
        btnLogout.setBackground(new Color(100, 100, 100));

        sidePanel.add(btnDashboard);
        sidePanel.add(btnSettings);
        sidePanel.add(btnLogout);

        // Create a content panel to show main content
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(2, 2, 10, 10));

        // Create some sample panels for the dashboard content
        JPanel panel1 = createDashboardPanel("Statistics", Color.CYAN);
        JPanel panel2 = createDashboardPanel("Recent Activities", Color.GREEN);
        JPanel panel3 = createDashboardPanel("Users", Color.ORANGE);
        JPanel panel4 = createDashboardPanel("Performance", Color.PINK);

        // Add panels to contentPanel
        contentPanel.add(panel1);
        contentPanel.add(panel2);
        contentPanel.add(panel3);
        contentPanel.add(panel4);

        // Add components to the frame
        add(sidePanel, BorderLayout.WEST);
        add(contentPanel, BorderLayout.CENTER);
    }

    private JPanel createDashboardPanel(String title, Color color) {
        JPanel panel = new JPanel();
        panel.setBackground(color);
        panel.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel(title, SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setForeground(Color.WHITE);

        panel.add(titleLabel, BorderLayout.NORTH);

        // You can add more components (like charts, graphs, etc.) inside these panels
        JLabel content = new JLabel("Content goes here", SwingConstants.CENTER);
        content.setFont(new Font("Arial", Font.PLAIN, 14));
        content.setForeground(Color.WHITE);
        panel.add(content, BorderLayout.CENTER);

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainApp dashboard = new MainApp();
                dashboard.setVisible(true);
            }
        });
    }
}
