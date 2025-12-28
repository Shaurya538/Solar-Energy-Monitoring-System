package ui;

import javax.swing.*;
import java.awt.*;
import dao.EnergyDAO;

public class SolarEnergyUI extends JFrame {

    private JTextField productionField, consumptionField, storageField;
    private JProgressBar productionBar, consumptionBar, storageBar;

    // DAO object
    EnergyDAO dao = new EnergyDAO();

    public SolarEnergyUI() {
        setTitle("Solar Energy Monitoring System");
        setSize(900, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        add(createHeader(), BorderLayout.NORTH);
        add(createFormPanel(), BorderLayout.WEST);
        add(createDashboardPanel(), BorderLayout.CENTER);
    }

    private JPanel createHeader() {
        JPanel header = new JPanel();
        header.setBackground(new Color(0, 128, 0));
        JLabel title = new JLabel("🌞 Solar Energy Dashboard");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Segoe UI", Font.BOLD, 26));
        header.add(title);
        return header;
    }

    private JPanel createFormPanel() {
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(300, 0));
        panel.setBackground(new Color(235, 255, 235));
        panel.setLayout(new GridLayout(8, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        productionField = new JTextField();
        consumptionField = new JTextField();
        storageField = new JTextField();

        JButton updateBtn = new JButton("Update Dashboard");
        updateBtn.setBackground(new Color(0, 153, 0));
        updateBtn.setForeground(Color.WHITE);

        updateBtn.addActionListener(e -> updateDashboard());

        panel.add(new JLabel("Energy Produced (kWh)"));
        panel.add(productionField);
        panel.add(new JLabel("Energy Consumed (kWh)"));
        panel.add(consumptionField);
        panel.add(new JLabel("Energy Stored (kWh)"));
        panel.add(storageField);
        panel.add(updateBtn);

        return panel;
    }

    private JPanel createDashboardPanel() {
        JPanel dashboard = new JPanel(new GridLayout(3, 1, 20, 20));
        dashboard.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        dashboard.setBackground(Color.WHITE);

        productionBar = createBar("Production");
        consumptionBar = createBar("Consumption");
        storageBar = createBar("Storage");

        dashboard.add(createCard("Energy Production", productionBar));
        dashboard.add(createCard("Energy Consumption", consumptionBar));
        dashboard.add(createCard("Energy Storage", storageBar));

        return dashboard;
    }

    private JPanel createCard(String title, JProgressBar bar) {
        JPanel card = new JPanel(new BorderLayout());
        card.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        JLabel label = new JLabel(title, JLabel.CENTER);
        label.setFont(new Font("Segoe UI", Font.BOLD, 16));
        card.add(label, BorderLayout.NORTH);
        card.add(bar, BorderLayout.CENTER);
        return card;
    }

    private JProgressBar createBar(String name) {
        JProgressBar bar = new JProgressBar(0, 100);
        bar.setStringPainted(true);
        bar.setFont(new Font("Segoe UI", Font.BOLD, 14));
        bar.setForeground(new Color(0, 153, 0));
        bar.setValue(0);
        bar.setString(name + ": 0 kWh");
        return bar;
    }

    private void updateDashboard() {
        try {
            double prod = Double.parseDouble(productionField.getText());
            double cons = Double.parseDouble(consumptionField.getText());
            double stor = Double.parseDouble(storageField.getText());

            productionBar.setValue((int) Math.min(prod, 100));
            productionBar.setString(prod + " kWh");

            consumptionBar.setValue((int) Math.min(cons, 100));
            consumptionBar.setString(cons + " kWh");

            storageBar.setValue((int) Math.min(stor, 100));
            storageBar.setString(stor + " kWh");

            // SAVE TO DATABASE
            dao.saveEnergy(prod, cons, stor);

            JOptionPane.showMessageDialog(
                    this,
                    "Energy data saved successfully!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE
            );

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Please enter valid numeric values (e.g. 25.5)",
                    "Invalid Input",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public static void main(String[] args) {
        new SolarEnergyUI().setVisible(true);
    }
}
