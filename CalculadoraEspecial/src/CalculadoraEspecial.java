import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraEspecial extends JFrame implements ActionListener {
    private JTextField displayField;
    private double num1;
    private String operator;
    private boolean newInput;

    public CalculadoraEspecial() {
        super("Calculadora Especial");

        // Configuración de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(16, 52, 77));

        // Creación de los componentes
        displayField = new JTextField(15);
        displayField.setHorizontalAlignment(JTextField.RIGHT);
        displayField.setEditable(false);
        displayField.setFont(new Font("Arial", Font.PLAIN, 32));
        displayField.setBackground(Color.WHITE);
        displayField.setForeground(new Color(16, 52, 77));
        displayField.setBorder(new EmptyBorder(10, 10, 10, 10));

        JButton[] numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(new Font("Arial", Font.BOLD, 24));
            numberButtons[i].setBackground(new Color(0, 59, 92));
            numberButtons[i].setForeground(Color.BLACK);
            numberButtons[i].addActionListener(this);
        }

        JButton clearButton = new JButton("C");
        clearButton.setFont(new Font("Arial", Font.BOLD, 20));
        clearButton.setBackground(new Color(153, 0, 0));
        clearButton.setForeground(Color.WHITE);
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayField.setText("");
                num1 = 0;
                operator = "";
                newInput = false;
            }
        });

        JButton equalButton = new JButton("=");
        equalButton.setFont(new Font("Arial", Font.BOLD, 24));
        equalButton.setBackground(new Color(0, 123, 255));
        equalButton.setForeground(Color.WHITE);
        equalButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!operator.isEmpty()) {
                    double num2 = Double.parseDouble(displayField.getText());
                    double result = calcularResultado(num1, num2, operator);
                    displayField.setText(String.valueOf(result));
                    num1 = result;
                    operator = "";
                }
                newInput = true;
            }
        });

        JButton sqrtButton = new JButton("√");
        sqrtButton.setFont(new Font("Arial", Font.BOLD, 24));
        sqrtButton.setBackground(new Color(0, 59, 92));
        sqrtButton.setForeground(Color.BLACK);
        sqrtButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double num = Double.parseDouble(displayField.getText());
                double result = Math.sqrt(num);
                displayField.setText(String.valueOf(result));
                newInput = true;
            }
        });

        JButton primeButton = new JButton("Primo");
        primeButton.setFont(new Font("Arial", Font.BOLD, 16));
        primeButton.setBackground(new Color(0, 59, 92));
        primeButton.setForeground(Color.BLACK);
        primeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int num = Integer.parseInt(displayField.getText());
                boolean isPrime = esPrimo(num);
                displayField.setText(isPrime ? "Es primo" : "No es primo");
                newInput = true;
            }
        });

        JButton powerButton = new JButton("^");
        powerButton.setFont(new Font("Arial", Font.BOLD, 24));
        powerButton.setBackground(new Color(0, 59, 92));
        powerButton.setForeground(Color.BLACK);
        powerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                num1 = Double.parseDouble(displayField.getText());
                operator = "^";
                newInput = true;
            }
        });

        JButton absButton = new JButton("Abs");
        absButton.setFont(new Font("Arial", Font.BOLD, 16));
        absButton.setBackground(new Color(0, 59, 92));
        absButton.setForeground(Color.BLACK);
        absButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double num = Double.parseDouble(displayField.getText());
                double result = Math.abs(num);
                displayField.setText(String.valueOf(result));
                newInput = true;
            }
        });

        JButton sinButton = new JButton("Sin");
        sinButton.setFont(new Font("Arial", Font.BOLD, 16));
        sinButton.setBackground(new Color(0, 59, 92));
        sinButton.setForeground(Color.BLACK);
        sinButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double num = Double.parseDouble(displayField.getText());
                double result = Math.sin(num);
                displayField.setText(String.valueOf(result));
                newInput = true;
            }
        });

        JButton cosButton = new JButton("Cos");
        cosButton.setFont(new Font("Arial", Font.BOLD, 16));
        cosButton.setBackground(new Color(0, 59, 92));
        cosButton.setForeground(Color.BLACK);
        cosButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double num = Double.parseDouble(displayField.getText());
                double result = Math.cos(num);
                displayField.setText(String.valueOf(result));
                newInput = true;
            }
        });

        JButton tanButton = new JButton("Tan");
        tanButton.setFont(new Font("Arial", Font.BOLD, 16));
        tanButton.setBackground(new Color(0, 59, 92));
        tanButton.setForeground(Color.BLACK);
        tanButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double num = Double.parseDouble(displayField.getText());
                double result = Math.tan(num);
                displayField.setText(String.valueOf(result));
                newInput = true;
            }
        });

        JButton logButton = new JButton("Log");
        logButton.setFont(new Font("Arial", Font.BOLD, 16));
        logButton.setBackground(new Color(0, 59, 92));
        logButton.setForeground(Color.BLACK);
        logButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double num = Double.parseDouble(displayField.getText());
                double result = Math.log10(num);
                displayField.setText(String.valueOf(result));
                newInput = true;
            }
        });
        
        // Botones de operaciones básicas
        JButton addButton = new JButton("+");
        addButton.setFont(new Font("Arial", Font.BOLD, 20));
        addButton.setBackground(new Color(0, 59, 92));
        addButton.setForeground(Color.BLACK);
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                num1 = Double.parseDouble(displayField.getText());
                operator = "+";
                newInput = true;
            }
        });

        JButton subtractButton = new JButton("-");
        subtractButton.setFont(new Font("Arial", Font.BOLD, 20));
        subtractButton.setBackground(new Color(0, 59, 92));
        subtractButton.setForeground(Color.BLACK);
        subtractButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                num1 = Double.parseDouble(displayField.getText());
                operator = "-";
                newInput = true;
            }
        });

        JButton multiplyButton = new JButton("x");
        multiplyButton.setFont(new Font("Arial", Font.BOLD, 20));
        multiplyButton.setBackground(new Color(0, 59, 92));
        multiplyButton.setForeground(Color.BLACK);
        multiplyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                num1 = Double.parseDouble(displayField.getText());
                operator = "x";
                newInput = true;
            }
        });

        JButton divideButton = new JButton("/");
        divideButton.setFont(new Font("Arial", Font.BOLD, 20));
        divideButton.setBackground(new Color(0, 59, 92));
        divideButton.setForeground(Color.BLACK);
        divideButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                num1 = Double.parseDouble(displayField.getText());
                operator = "/";
                newInput = true;
            }
        });

        // Configuración del diseño de la calculadora
        JPanel contentPane = new JPanel(new BorderLayout(10, 10));
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        contentPane.setBackground(new Color(16, 52, 77));

        JPanel buttonPanel = new JPanel(new GridLayout(4, 5, 10, 10));
        buttonPanel.setBackground(new Color(16, 52, 77));

        buttonPanel.add(sqrtButton);
        buttonPanel.add(primeButton);
        buttonPanel.add(powerButton);
        buttonPanel.add(absButton);
        buttonPanel.add(sinButton);
        buttonPanel.add(cosButton);
        buttonPanel.add(tanButton);
        buttonPanel.add(logButton);
        buttonPanel.add(addButton);
        buttonPanel.add(subtractButton);
        buttonPanel.add(multiplyButton);
        buttonPanel.add(divideButton);

        buttonPanel.add(clearButton);
        for (int i = 9; i >= 0; i--) {
            buttonPanel.add(numberButtons[i]);
        }
        buttonPanel.add(equalButton);

        contentPane.add(displayField, BorderLayout.NORTH);
        contentPane.add(buttonPanel, BorderLayout.CENTER);

        setContentPane(contentPane);
        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (newInput) {
            displayField.setText("");
            newInput = false;
        }
        String input = ((JButton) e.getSource()).getText();
        displayField.setText(displayField.getText() + input);
    }

    private double calcularResultado(double num1, double num2, String operator) {
        double result = 0;
        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "x":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            case "^":
                result = Math.pow(num1, num2);
                break;
        }
        return result;
    }

    private boolean esPrimo(int num) {
        if (num <= 1)
            return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CalculadoraEspecial();
            }
        });
    }
}
