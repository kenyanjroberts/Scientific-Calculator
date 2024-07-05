/*
 Name: Kenyan Roberts
 Class: Comp167
 Section: 003
 Date: 4/29/2024
 Description:Description: This Java Swing calculator application provides basic arithmetic operations such as addition,
 subtraction, multiplication, and division, along with more advanced mathematical functions including square roots, trigonometric functions (sine, cosine, tangent),
 logarithms, and exponentiation.my user interface consists of buttons for numbers and mathematical operators, enabling intuitive input and interaction.
 Behind the scenes, action listeners are employed to handle user interactions with the calculator buttons, ensuring seamless functionality.
 This project aims to offer a versatile and user-friendly tool for performing various mathematical calculations. i was able to get through this project
 by using actionlisteners for my buttons as well as using a couple math functions to calculate answers.

*/

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculating {
    // Variables declaration
    private double result = 0.0;
    private double amount1 = 0.0;
    private double amount2 = 0.0;
    private char math_operator; // Store the selected math operation
    private JPanel Calculator;
    private JTextField Inputfield; // Input field for numbers
    private JButton number2Button; // Buttons for numbers
    private JButton number3Button;
    private JButton equalsButton; // Equals button to calculate result
    private JButton number1Button;
    private JButton NthRootOfXButton;// inverse exponent button
    private JButton number9Button;
    private JButton additionButton; // Math operation buttons
    private JButton number8Button;
    private JButton number7Button;
    private JButton plusminusButton;
    private JButton decimalpointButton;
    private JButton number0Button;
    private JButton multiplicationButton;
    private JButton divisionButton;
    private JButton x2Button;
    private JButton number4Button;
    private JButton number5Button;
    private JButton number6Button;
    private JButton subtractionButton;
    private JButton x3Button;
    private JButton modulusButton;
    private JButton percentageButton;
    private JButton sqrtButton; //square root button
    private JButton cosButton;
    private JButton sinButton;// trig buttons
    private JButton tanButton;
    private JButton logButton;
    private JButton lnButton;
    private JButton asinButton;
    private JButton sinhButton;
    private JButton acosButton;
    private JButton atanButton;
    private JButton coshButton;
    private JButton tanhButton;
    private JButton exitButton;
    private JButton a10caretNButton;// 10^n
    private JButton absButton;// absolute value
    private JTextField outputField; // Output field to display result
    private JButton cButton; // Clear button to reset input and output fields

    // Main method to create and display the GUI
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setContentPane(new Calculating().Calculator);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }



    public Calculating() {

        additionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                math_operator = '+'; // Set the math operator to addition
                amount1 = Double.parseDouble(Inputfield.getText()); // Store the first operand
                Inputfield.setText(""); // Clear the input field for the next number
            }
        });

        subtractionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                math_operator = '-'; // Set the math operator to subtraction
                amount1 = Double.parseDouble(Inputfield.getText()); // Store the first operand
                Inputfield.setText(""); // Clear the input field for the next number
            }
        });

        divisionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                math_operator = '/'; // Set the math operator to division
                amount1 = Double.parseDouble(Inputfield.getText()); // Store the first operand
                Inputfield.setText(""); // Clear the input field for the next number
            }
        });

        multiplicationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                math_operator = '*'; // Set the math operator to multiplication
                amount1 = Double.parseDouble(Inputfield.getText()); // Store the first operand
                Inputfield.setText(""); // Clear the input field for the next number
            }
        });


        decimalpointButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Inputfield.getText().equals("")) {
                    Inputfield.setText("0.");
                } else if (Inputfield.getText().contains(".")) {
                    decimalpointButton.setEnabled(false);
                } else {
                    String Decimal = Inputfield.getText() + decimalpointButton.getText();
                    Inputfield.setText(Decimal);
                    ;
                }
                decimalpointButton.setEnabled(true);
            }
        });

        NthRootOfXButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double num = Double.parseDouble(Inputfield.getText());
                if (num != 0) {
                    result = 1.0 / num;
                    outputField.setText(String.valueOf(result));
                } else {
                    JOptionPane.showMessageDialog(null, "Cannot calculate 1/0!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        percentageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double num = Double.parseDouble(Inputfield.getText());
                double result = num / 100;
                outputField.setText(String.valueOf(result));
            }
        });


        absButton.addActionListener(e -> {
            double num = Double.parseDouble(Inputfield.getText());
            result = Math.abs(num);
            outputField.setText(String.valueOf(result));
        });


        x2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double num = Double.parseDouble(Inputfield.getText());
                result = Math.pow(num, 2);
                outputField.setText(String.valueOf(result));
            }
        });

        plusminusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double num = Double.parseDouble(Inputfield.getText());
                double result = -num;
                Inputfield.setText(String.valueOf(result));
            }
        });


        x3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double num = Double.parseDouble(Inputfield.getText());
                result = Math.pow(num, 3);
                outputField.setText(String.valueOf(result));
            }
        });

        modulusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                math_operator = '%'; // Set the math operator to modulo
                amount1 = Double.parseDouble(Inputfield.getText()); // Store the first operand
                Inputfield.setText(""); // Clear the input field for the next number
            }
        });

        sqrtButton.addActionListener(e -> {
            // Get the number entered by the user from the input field.
            double num = Double.parseDouble(Inputfield.getText());
            // Checks if the number is non-negative (greater than or equal to 0).
            if (num >= 0) {
                /*If the number is non-negative, calculate the square root of the number.
              For example, if the number is 9, the square root is 3, because 3 * 3 = 9.*/
                double result = Math.sqrt(num);
                // Sets the result of the square root operation in the output field to display it.
                outputField.setText(String.valueOf(result));
            } else {
                // If the number is negative, display an error message in the output field
                outputField.setText("Error: Cannot calculate square root of a negative number");
            }
        });

        // Action listener for the sine button
        sinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double num = Double.parseDouble(Inputfield.getText()); // Get the input number
                result = Math.sin(num); // Calculates the sine of the input number
                outputField.setText(String.valueOf(result)); // Displays  result
            }
        });

        // Action listener for the cosine button
        cosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double num = Double.parseDouble(Inputfield.getText()); // Gets the input number
                result = Math.cos(num); // Calculates the cosine of the input number
                outputField.setText(String.valueOf(result)); // Displays the result
            }
        });

        // Action listener for the tangent button
        tanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double num = Double.parseDouble(Inputfield.getText()); // Get the input number
                result = Math.tan(num); // Calculates the tangent of the input number
                outputField.setText(String.valueOf(result)); // Display the result
            }
        });


        logButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double num = Double.parseDouble(Inputfield.getText());
                if (num >= 0) {
                    result = Math.log10(num);// set it to log 10 so it log base 10
                    outputField.setText(String.valueOf(result));
                } else {
                    Inputfield.setText("Error: Invalid input");
                }
            }
        });

        lnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double num = Double.parseDouble(Inputfield.getText());
                if (num >= 0) {
                    double result = Math.log(num);// use the regular one here
                    outputField.setText(String.valueOf(result));
                } else {
                    outputField.setText("Error: Invalid input");
                }
            }
        });

        asinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double num = Double.parseDouble(Inputfield.getText());
                if (num > 0) {
                    result = Math.asin(num);
                    outputField.setText(String.valueOf(result));
                } else {
                    Inputfield.setText("Error: Invalid input");
                }
            }
        });

        acosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double num = Double.parseDouble(Inputfield.getText());
                if (num > 0) {
                    result = Math.acos(num);
                    outputField.setText(String.valueOf(result));
                } else {
                    outputField.setText("Error: Invalid input");
                }
            }
        });

        atanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double num = Double.parseDouble(Inputfield.getText());
                result = Math.atan(num);
                outputField.setText(String.valueOf(result));
            }
        });

        sinhButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!Inputfield.getText().isEmpty()) {
                    double num = Double.parseDouble(Inputfield.getText());
                    result = Math.sinh(num);
                    outputField.setText(String.valueOf(result));
                } else {
                    outputField.setText("Error: Input field is empty");
                }
            }
        });


        coshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double num = Double.parseDouble(Inputfield.getText());
                double result = Math.cosh(num);
                outputField.setText(String.valueOf(result));
            }
        });

        tanhButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double num = Double.parseDouble(Inputfield.getText());
                double result = Math.tanh(num);
                outputField.setText(String.valueOf(result));
            }
        });

        a10caretNButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double num = Double.parseDouble(Inputfield.getText());
                double result = Math.pow(10, num);
                outputField.setText(String.valueOf(result));
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        cButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                outputField.setText("");
                Inputfield.setText("");
            }
        });

        number1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Gets the current text in the input field (where numbers are displayed).
                String currentText = Inputfield.getText();
                /* Concatenate (add) the text of the number 1 button to the current text.
                For example, if the current text is "2" and you click the number 1 button,
                it will become "21".*/
                String newInput = currentText + number1Button.getText();
                // Sets the new text in the input field, which now includes the clicked number.
                Inputfield.setText(newInput);
            }
        });

        // pretty much did the sae thing for every other number button
        number2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Button2 = Inputfield.getText() + number2Button.getText();
                Inputfield.setText(Button2);
            }
        });
        number3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Button3 = Inputfield.getText() + number3Button.getText();
                Inputfield.setText(Button3);
            }
        });
        number4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Button4 = Inputfield.getText() + number4Button.getText();
                Inputfield.setText(Button4);
            }
        });
        number5Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Button5 = Inputfield.getText() + number5Button.getText();
                Inputfield.setText(Button5);
            }
        });
        number6Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Button6 = Inputfield.getText() + number6Button.getText();
                Inputfield.setText(Button6);
            }
        });
        number7Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Button7 = Inputfield.getText() + number7Button.getText();
                Inputfield.setText(Button7);
            }
        });
        number8Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Button8 = Inputfield.getText() + number8Button.getText();
                Inputfield.setText(Button8);
            }
        });
        number9Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Button9 = Inputfield.getText() + number9Button.getText();
                Inputfield.setText(Button9);
            }
        });
        number0Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Button0 = Inputfield.getText() + number0Button.getText();
                Inputfield.setText(Button0);
            }
        });


        equalsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double result = 0.0;
                double num2 = Double.parseDouble(Inputfield.getText()); // Get the second operand
                switch (math_operator) {
                    case '+':
                        result = amount1 + num2; // Perform addition
                        break;
                    case '-':
                        result = amount1 - num2; // Perform subtraction
                        break;
                    case '/':
                        if (num2 != 0) {
                            result = amount1 / num2; // Perform division if the divisor is not zero
                        } else {
                            JOptionPane.showMessageDialog(null, "Cannot divide by zero!", "Error", JOptionPane.ERROR_MESSAGE);
                            return; // Exit early if division by zero is attempted
                        }
                        break;
                    case '*':
                        result = amount1 * num2; // Perform multiplication
                        break;
                    case '%':
                        result = amount1 % num2; // Perform modulo operation
                        break;
                }
                outputField.setText(String.valueOf(result)); // Display the result
                amount1 = result; // Store the result as the new first operand for potential chaining of operations
            }
        });
    }

}
