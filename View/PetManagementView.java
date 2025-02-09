package MVC_66050069.View;

import javax.swing.*;
import java.awt.*;
import MVC_66050069.Controller.PetController;

public class PetManagementView extends JFrame {
    public PetManagementView(PetController controller) {
        setTitle("Magic Pet Import System"); // กำหนดชื่อหน้าต่าง
        setSize(600, 500); // กำหนดขนาดหน้าต่าง
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout()); // ใช้ BorderLayout สำหรับการจัดวาง

        JTabbedPane tabbedPane = new JTabbedPane(); // ใช้แท็บเพื่อแยกประเภทสัตว์

        // แท็บสำหรับรายงานสรุป
        JPanel reportPanel = new JPanel(new BorderLayout());
        JTextArea reportArea = new JTextArea();
        reportArea.setEditable(false); // ป้องกันไม่ให้ผู้ใช้แก้ไข
        JButton refreshReportButton = new JButton("Refresh Report");
        refreshReportButton.addActionListener(e -> {
            String report = controller.generateReport(); // ดึงรายงานจาก Controller
            reportArea.setText(report);
        });
        reportPanel.add(new JScrollPane(reportArea), BorderLayout.CENTER);
        reportPanel.add(refreshReportButton, BorderLayout.SOUTH);
        tabbedPane.add("Report", reportPanel);

        // แท็บสำหรับนกฟินิกซ์
        JPanel phoenixPanel = new JPanel(new GridLayout(4, 2));
        JTextField healthCheckPhoenix = new JTextField();
        JTextField vaccineCountPhoenix = new JTextField();
        JCheckBox fireproofPhoenix = new JCheckBox("Fireproof Certificate");
        JButton addPhoenixButton = new JButton("Add Phoenix");
        addPhoenixButton.addActionListener(e -> {
            try {
                int vaccineCount = Integer.parseInt(vaccineCountPhoenix.getText()); // แปลงค่าจำนวนวัคซีนเป็น int
                boolean fireproof = fireproofPhoenix.isSelected(); // ตรวจสอบว่าเลือก Fireproof หรือไม่
                controller.addPhoenix(healthCheckPhoenix.getText(), vaccineCount, fireproof);
                JOptionPane.showMessageDialog(this, "Phoenix added successfully!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid input! Please enter valid numbers.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        phoenixPanel.add(new JLabel("Last Health Check:"));
        phoenixPanel.add(healthCheckPhoenix);
        phoenixPanel.add(new JLabel("Vaccine Count:"));
        phoenixPanel.add(vaccineCountPhoenix);
        phoenixPanel.add(new JLabel(""));
        phoenixPanel.add(fireproofPhoenix);
        phoenixPanel.add(new JLabel(""));
        phoenixPanel.add(addPhoenixButton);
        tabbedPane.add("Phoenix", phoenixPanel);

        // แท็บสำหรับมังกร
        JPanel dragonPanel = new JPanel(new GridLayout(4, 2));
        JTextField healthCheckDragon = new JTextField();
        JTextField vaccineCountDragon = new JTextField();
        JTextField smokeLevelDragon = new JTextField();
        JButton addDragonButton = new JButton("Add Dragon");
        addDragonButton.addActionListener(e -> {
            try {
                int vaccineCount = Integer.parseInt(vaccineCountDragon.getText()); // แปลงค่าจำนวนวัคซีนเป็น int
                double smokeLevel = Double.parseDouble(smokeLevelDragon.getText()); // แปลงค่าระดับมลพิษเป็น double
                controller.addDragon(healthCheckDragon.getText(), vaccineCount, smokeLevel);
                JOptionPane.showMessageDialog(this, "Dragon added successfully!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid input! Please enter valid numbers.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        dragonPanel.add(new JLabel("Last Health Check:"));
        dragonPanel.add(healthCheckDragon);
        dragonPanel.add(new JLabel("Vaccine Count:"));
        dragonPanel.add(vaccineCountDragon);
        dragonPanel.add(new JLabel("Smoke Pollution Level:"));
        dragonPanel.add(smokeLevelDragon);
        dragonPanel.add(new JLabel(""));
        dragonPanel.add(addDragonButton);
        tabbedPane.add("Dragon", dragonPanel);

        // แท็บสำหรับนกฮูก
        JPanel owlPanel = new JPanel(new GridLayout(4, 2));
        JTextField healthCheckOwl = new JTextField();
        JTextField vaccineCountOwl = new JTextField();
        JTextField flightDistanceOwl = new JTextField();
        JButton addOwlButton = new JButton("Add Owl");
        addOwlButton.addActionListener(e -> {
            try {
                int vaccineCount = Integer.parseInt(vaccineCountOwl.getText()); // แปลงค่าจำนวนวัคซีนเป็น int
                double flightDistance = Double.parseDouble(flightDistanceOwl.getText()); // แปลงค่าระยะทางบินเป็น double
                controller.addOwl(healthCheckOwl.getText(), vaccineCount, flightDistance);
                JOptionPane.showMessageDialog(this, "Owl added successfully!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid input! Please enter valid numbers.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        owlPanel.add(new JLabel("Last Health Check:"));
        owlPanel.add(healthCheckOwl);
        owlPanel.add(new JLabel("Vaccine Count:"));
        owlPanel.add(vaccineCountOwl);
        owlPanel.add(new JLabel("Flight Distance:"));
        owlPanel.add(flightDistanceOwl);
        owlPanel.add(new JLabel(""));
        owlPanel.add(addOwlButton);
        tabbedPane.add("Owl", owlPanel);

        add(tabbedPane, BorderLayout.CENTER); // เพิ่มแท็บทั้งหมดลงในหน้าต่างหลัก
    }
}




