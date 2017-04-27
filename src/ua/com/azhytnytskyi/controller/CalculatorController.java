package ua.com.azhytnytskyi.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import ua.com.azhytnytskyi.model.CalculatorModel;

public class CalculatorController {

    @FXML
    private Text output;
    private double firstNumber;
    private boolean start = true;
    private String operator = "";

    private CalculatorModel model = CalculatorModel.getInstance();

    @FXML
    private void numbers(ActionEvent actionEvent) {

        if (start) {
            output.setText("");
            start = false;
        }
        String value = ((Button) actionEvent.getSource()).getText();
        output.setText(output.getText() + value);
    }

    @FXML
    private void calculation(ActionEvent actionEvent) {
        String value = ((Button) actionEvent.getSource()).getText();

        if (value.equals("sqrt")) {
            sqrtCalculation(actionEvent);
        } else if (value.equals("C")) {
            cleanCalculation();
        } else if (!value.equals("=")) {
            if (!operator.isEmpty()) return;
            operator = value;
            firstNumber = Double.parseDouble((output.getText()));
            output.setText("");
        } else {
            if (operator.isEmpty()) return;
            double secondNumber = Double.parseDouble(output.getText());
            double result = model.calculate(firstNumber, secondNumber, operator);

            setOutputText(result);

            operator = "";
            start = true;
        }
    }

    private void sqrtCalculation(ActionEvent actionEvent) {
        firstNumber = Double.parseDouble((output.getText()));
        operator = ((Button) actionEvent.getSource()).getText();
        double result = model.calculate(firstNumber, operator);
        setOutputText(result);
        operator = "";
        start = true;
    }

    private void cleanCalculation() {
        output.setText("");
        start = true;
    }

    private void setOutputText(double number) {
        if ((number % 1) == 0) {
            output.setText(String.valueOf((int) number));
        } else {
            output.setText(String.valueOf(number));
        }
    }

}
