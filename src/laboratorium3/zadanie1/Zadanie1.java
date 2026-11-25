package laboratorium3.zadanie1;

import javax.swing.*;
import java.awt.*;

public class Zadanie1 extends JFrame {
    private final JTextField loginField = new JTextField(15);
    private final JPasswordField passField = new JPasswordField(15);
    private final JTextArea area = new JTextArea(8, 25);

    public Zadanie1() {
        super("Zadanie 1 - formularz");
        setSize(450, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        add(createPanel());
    }

    private JPanel createPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);
        c.fill = GridBagConstraints.HORIZONTAL;

        JButton button = new JButton("Pokaż dane");
        button.addActionListener(e -> showData());
        area.setEditable(false);

        c.gridx = 0; c.gridy = 0; panel.add(new JLabel("Login:"), c);
        c.gridx = 1; panel.add(loginField, c);
        c.gridx = 0; c.gridy = 1; panel.add(new JLabel("Hasło:"), c);
        c.gridx = 1; panel.add(passField, c);
        c.gridx = 0; c.gridy = 2; c.gridwidth = 2; panel.add(button, c);
        c.gridy = 3; panel.add(new JScrollPane(area), c);
        return panel;
    }

    private void showData() {
        String pass = new String(passField.getPassword());
        area.append("Login: " + loginField.getText() + ", hasło: " + "*".repeat(pass.length()) + "\n");
        loginField.setText("");
        passField.setText("");
    }
}