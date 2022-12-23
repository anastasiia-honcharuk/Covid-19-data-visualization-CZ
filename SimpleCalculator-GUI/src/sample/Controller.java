package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

public class Controller {
    public TextField operand1TextField;
    public TextField operand2TextField;
    public TextField resultTextField;

    enum Operation {
        ADD,
        SUB,
        MUL,
        DIV
    }

    public void onAddButtonPressed(ActionEvent actionEvent) {
        makeOperation(Operation.ADD);
    }

    public void onSubButtonPressed(ActionEvent actionEvent) {
        makeOperation(Operation.SUB);
    }

    public void onMulButtonPressed(ActionEvent actionEvent) {
        makeOperation(Operation.MUL);
    }

    public void onDivButtonPressed(ActionEvent actionEvent) {
        makeOperation(Operation.DIV);
    }

    private void makeOperation(Operation operation){
        double op1 = 0;
        double op2 = 0;
        double result = 0;

        String operand1 = operand1TextField.getText();
        String operand2 = operand2TextField.getText();
        try {
            op1 = Double.parseDouble(operand1);
        } catch (NumberFormatException e){
            new Alert(Alert.AlertType.ERROR,"Operand 1 should be a number!", ButtonType.OK).showAndWait();
            return;
        }

        try {
            op2 = Double.parseDouble(operand2);
        } catch (NumberFormatException e){
            new Alert(Alert.AlertType.ERROR,"Operand 2 should be a number!", ButtonType.OK).showAndWait();
            return;
        }



        switch(operation){
            case ADD:
                result = op1 + op2;
                break;
            case SUB:
                result = op1 - op2;
                break;
            case MUL:
                result = op1 * op2;
                break;
            case DIV:
                if(op2 == 0){
                    new Alert(Alert.AlertType.ERROR,"Cannot divide by 0!",ButtonType.OK).showAndWait();
                    return;
                }
                result = op1 / op2;
                break;
        }

        resultTextField.setText(Double.toString(result));

    }
}
