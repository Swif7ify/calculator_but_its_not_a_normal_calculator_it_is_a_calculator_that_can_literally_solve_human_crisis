package calculator;

import javax.swing.JTextField;

public class Functions {

    // Method to handle digit buttons
    public static void handleDigit(JTextField numwrapper, String digit) {
        numwrapper.setText(numwrapper.getText() + digit);
    }

    // Method to handle operator buttons
    public static void handleOperator(JTextField numwrapper, String operator) {
        numwrapper.setText(numwrapper.getText() + operator);
    }

    // Method to handle the DEL button
    public static void handleDelete(JTextField numwrapper) {
        String currentText = numwrapper.getText();
        if (!currentText.isEmpty()) {
            numwrapper.setText(currentText.substring(0, currentText.length() - 1));
        }
    }

    // Method to handle the AC button
    public static void handleClear(JTextField numwrapper) {
        numwrapper.setText("");
    }

    // Method to handle the equals button
    public static void handleEquals(JTextField numwrapper) {
        numwrapper.setText(numwrapper.getText() + "=");
    }
}
