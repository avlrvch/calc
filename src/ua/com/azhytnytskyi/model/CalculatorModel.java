package ua.com.azhytnytskyi.model;

import ua.com.azhytnytskyi.utils.CalculatorOperations;

import javax.swing.*;

public class CalculatorModel {
    private static CalculatorModel instance;

    private CalculatorModel() {
    }

    public static CalculatorModel getInstance() {
        if (instance == null) return new CalculatorModel();
        return instance;
    }

    public double calculate(double firstNumber, double secondNumber, String operator) {
        switch (operator) {
            case "+":
                return CalculatorOperations.add(firstNumber, secondNumber);
            case "-":
                return CalculatorOperations.sub(firstNumber, secondNumber);
            case "*":
                return CalculatorOperations.multiple(firstNumber, secondNumber);
            case "/":
                return CalculatorOperations.divide(firstNumber, secondNumber);
            case "^":
                return CalculatorOperations.pow(firstNumber, secondNumber);
            case "%":
                return CalculatorOperations.percent(firstNumber, secondNumber);
            default:
                JOptionPane.showMessageDialog(null, "Wrong operator");
                return 0;
        }
    }

    public double calculate(double number, String operator) {
        switch (operator) {
            case "sqrt":
                return CalculatorOperations.sqrt(number);
        }
        return number;
    }
}
