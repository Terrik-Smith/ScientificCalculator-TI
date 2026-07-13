package com.zipcodewilmington.scientificcalculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class CalculatorGUI {

    private static final Color PINK = new Color(255, 105, 180);
    private static final Color YELLOW = new Color(255, 215, 0);
    private static final Color LIGHT_PINK = new Color(255, 230, 240);

    private final ScientificCalculator calculator;
    private final JTextField displayField;

    private String pendingOperator = "";
    private boolean startNewNumber = true;

    public CalculatorGUI() {
        calculator = new ScientificCalculator();
        displayField = new JTextField("0");

        createWindow();
    }

    private void createWindow() {
        JFrame frame = new JFrame("Team TI Scientific Calculator");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 560);
        frame.setLayout(new BorderLayout(10, 10));

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBackground(LIGHT_PINK);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JLabel title = new JLabel(
                "Team TI SCIENTIFIC CALCULATOR",
                SwingConstants.CENTER
        );

        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setOpaque(true);
        title.setBackground(YELLOW);
        title.setForeground(Color.BLACK);
        title.setBorder(BorderFactory.createEmptyBorder(12, 8, 12, 8));

        displayField.setEditable(false);
        displayField.setHorizontalAlignment(JTextField.RIGHT);
        displayField.setFont(new Font("Arial", Font.BOLD, 34));
        displayField.setBackground(Color.WHITE);
        displayField.setBorder(
                BorderFactory.createLineBorder(PINK, 4)
        );

        JPanel topPanel = new JPanel(new BorderLayout(0, 10));
        topPanel.setBackground(LIGHT_PINK);
        topPanel.add(title, BorderLayout.NORTH);
        topPanel.add(displayField, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(6, 4, 8, 8));
        buttonPanel.setBackground(LIGHT_PINK);

        String[] buttons = {
                "7", "8", "9", "÷",
                "4", "5", "6", "×",
                "1", "2", "3", "−",
                "0", ".", "=", "+",
                "C", "x²", "√", "+/−",
                "1/x", "xʸ", "", ""
        };

        for (String label : buttons) {
            JButton button = new JButton(label);

            if (label.isEmpty()) {
                button.setEnabled(false);
            }

            button.setFont(new Font("Arial", Font.BOLD, 18));
            button.setFocusPainted(false);

            if (isOperator(label)) {
                button.setBackground(PINK);
                button.setForeground(Color.WHITE);
            } else {
                button.setBackground(YELLOW);
                button.setForeground(Color.BLACK);
            }

            button.addActionListener(event -> handleButton(label));
            buttonPanel.add(button);
        }

        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        frame.add(mainPanel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private boolean isOperator(String label) {
        return label.equals("+")
                || label.equals("−")
                || label.equals("×")
                || label.equals("÷")
                || label.equals("=")
                || label.equals("C");
    }

    private void handleButton(String label) {
        if (label.matches("[0-9]") || label.equals(".")) {
            enterNumber(label);
            return;
        }

        switch (label) {
            case "+":
            case "−":
            case "×":
            case "÷":
            case "xʸ":
                chooseOperator(label);
                break;

            case "=":
                calculateResult();
                break;

            case "C":
                clearCalculator();
                break;

            case "x²":
                calculator.setDisplay(readDisplay());
                calculator.square();
                updateDisplay();
                break;

            case "√":
                calculator.setDisplay(readDisplay());
                calculator.squareRoot();
                updateDisplay();
                break;

            case "+/−":
                calculator.setDisplay(readDisplay());
                calculator.switchSign();
                updateDisplay();
                break;

            case "1/x":
                calculator.setDisplay(readDisplay());
                calculator.inverse();
                updateDisplay();
                break;
        }
    }

    private void enterNumber(String value) {
        if (startNewNumber) {
            displayField.setText("");
            startNewNumber = false;
        }

        if (value.equals(".") && displayField.getText().contains(".")) {
            return;
        }

        displayField.setText(displayField.getText() + value);
    }

    private void chooseOperator(String operator) {
        calculator.setDisplay(readDisplay());
        pendingOperator = operator;
        startNewNumber = true;
    }

    private void calculateResult() {
        double secondNumber = readDisplay();

        switch (pendingOperator) {
            case "+":
                calculator.add(secondNumber);
                break;

            case "−":
                calculator.subtract(secondNumber);
                break;

            case "×":
                calculator.multiply(secondNumber);
                break;

            case "÷":
                calculator.divide(secondNumber);
                break;

            case "xʸ":
                calculator.power(secondNumber);
                break;
        }

        updateDisplay();
        pendingOperator = "";
    }

    private void clearCalculator() {
        calculator.clear();
        displayField.setText("0");
        pendingOperator = "";
        startNewNumber = true;
    }

    private double readDisplay() {
        return Double.parseDouble(displayField.getText());
    }

    private void updateDisplay() {
        displayField.setText(
                String.valueOf(calculator.getDisplay())
        );

        startNewNumber = true;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CalculatorGUI::new);
    }
}