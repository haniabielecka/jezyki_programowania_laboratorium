package laboratorium3.zadanie4;

import javax.swing.*;
import java.awt.*;

public class Zadanie4 extends JFrame {
    private final JTextField display = new JTextField("0");
    private double acc = 0;
    private String op = "";
    private boolean newInput = true;

    public Zadanie4() {
        super("Zadanie 4 - kalkulator");
        setSize(300, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setFont(new Font("Monospaced", Font.BOLD, 28));

        JButton clear = new JButton("C");
        clear.addActionListener(e -> clear());

        add(display, BorderLayout.NORTH);
        add(createKeys(), BorderLayout.CENTER);
        add(clear, BorderLayout.SOUTH);
    }

    private JPanel createKeys() {
        String[] keys = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+"};
        JPanel grid = new JPanel(new GridLayout(4, 4, 5, 5));
        grid.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        for (String k : keys) {
            JButton b = new JButton(k);
            b.setFont(b.getFont().deriveFont(20f));
            b.addActionListener(e -> press(k));
            grid.add(b);
        }
        return grid;
    }

    private void clear() {
        acc = 0;
        op = "";
        newInput = true;
        display.setText("0");
    }

    private void press(String k) {
        if (k.matches("\\d")) {
            display.setText(newInput ? k : display.getText() + k);
            newInput = false;
        } else if (k.equals(".")) {
            if (newInput) {
                display.setText("0.");
                newInput = false;
            } else if (!display.getText().contains(".")) {
                display.setText(display.getText() + ".");
            }
        } else if (k.equals("=")) {
            calculate();
            op = "";
            newInput = true;
        } else {
            if (!newInput) calculate();
            else if (op.isEmpty()) acc = Double.parseDouble(display.getText());
            op = k;
            newInput = true;
        }
    }

    private void calculate() {
        double x = Double.parseDouble(display.getText());
        if (op.isEmpty()) {
            acc = x;
        } else {
            switch (op) {
                case "+": acc += x; break;
                case "-": acc -= x; break;
                case "*": acc *= x; break;
                case "/":
                    if (x == 0) {
                        display.setText("Błąd: dzielenie przez 0");
                        acc = 0;
                        op = "";
                        newInput = true;
                        return;
                    }
                    acc /= x;
                    break;
            }
        }
        display.setText(acc == (long) acc ? String.valueOf((long) acc) : String.valueOf(acc));
    }
}