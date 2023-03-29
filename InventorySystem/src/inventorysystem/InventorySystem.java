/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package inventorysystem;

/**
 *
 * @author HP
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class InventorySystem extends JFrame {
    // GUI Components
    private JPanel mainPanel;
    private JLabel titleLabel;
    private JLabel itemLabel;
    private JLabel quantityLabel;
    private JLabel priceLabel;
    private JTextField itemField;
    private JTextField quantityField;
    private JTextField priceField;
    private JButton addButton;
    private JButton clearButton;
    private JTextArea inventoryArea;
    
    // Data
    private String inventory = "";

    public InventorySystem() {
        super("Inventory System");

        // Create GUI Components
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));

        titleLabel = new JLabel("Inventory System");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        itemLabel = new JLabel("Item:");
        itemLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        itemField = new JTextField(20);
        itemField.setMaximumSize(itemField.getPreferredSize());

        quantityLabel = new JLabel("Quantity:");
        quantityLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        quantityField = new JTextField(20);
        quantityField.setMaximumSize(quantityField.getPreferredSize());

        priceLabel = new JLabel("Price:");
        priceLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        priceField = new JTextField(20);
        priceField.setMaximumSize(priceField.getPreferredSize());

        addButton = new JButton("Add Item");
        addButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addItem();
            }
        });

        clearButton = new JButton("Clear");
        clearButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });

        inventoryArea = new JTextArea(20, 40);
        inventoryArea.setEditable(false);

        // Add Components to Main Panel
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(titleLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(itemLabel);
        mainPanel.add(itemField);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(quantityLabel);
        mainPanel.add(quantityField);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(priceLabel);
        mainPanel.add(priceField);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(addButton);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(clearButton);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(new JScrollPane(inventoryArea));

        // Add Main Panel to Frame
        getContentPane().add(mainPanel);

        // Set Window Properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void addItem() {
        String item = itemField.getText();
        int quantity = Integer.parseInt(quantityField.getText());
        double price = Double.parseDouble(priceField.getText());

        inventory += item + "\t" + quantity + "\t$" + price + "\n";
        inventoryArea.setText(inventory);
        clearFields();
    }

    private void clearFields() {
        itemField.setText("");
        quantityField.setText("");
        priceField.setText("");
    }

    public static void main(String[] args) {
        InventorySystem inventorySystem = new InventorySystem();
    }
}

