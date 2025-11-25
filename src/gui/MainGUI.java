package gui;

import javax.swing.*;
import dao.EnergyDAO;
import model.EnergyRecord;
import thread.AutoUpdateThread;

public class MainGUI {
    public static void main(String[] args) {
        JFrame f = new JFrame("Solar Energy Monitoring");

        JLabel l1 = new JLabel("Production:");
        JTextField t1 = new JTextField();

        JLabel l2 = new JLabel("Consumption:");
        JTextField t2 = new JTextField();

        JLabel l3 = new JLabel("Storage:");
        JTextField t3 = new JTextField();

        JButton b = new JButton("Save");

        l1.setBounds(20,20,100,30);
        t1.setBounds(130,20,150,30);

        l2.setBounds(20,60,100,30);
        t2.setBounds(130,60,150,30);

        l3.setBounds(20,100,100,30);
        t3.setBounds(130,100,150,30);

        b.setBounds(100,150,100,30);

        f.add(l1); f.add(t1);
        f.add(l2); f.add(t2);
        f.add(l3); f.add(t3);
        f.add(b);

        f.setSize(350,250);
        f.setLayout(null);
        f.setVisible(true);

        EnergyDAO dao = new EnergyDAO();

        b.addActionListener(e -> {
            double p = Double.parseDouble(t1.getText());
            double c = Double.parseDouble(t2.getText());
            double s = Double.parseDouble(t3.getText());

            dao.addRecord(new EnergyRecord(p,c,s));
            JOptionPane.showMessageDialog(f,"Saved!");
        });

        // Start thread
        new AutoUpdateThread().start();
    }
}
