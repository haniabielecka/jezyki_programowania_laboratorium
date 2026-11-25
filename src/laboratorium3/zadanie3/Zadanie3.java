package laboratorium3.zadanie3;

import javax.swing.*;
import java.awt.*;

public class Zadanie3 extends JFrame {
    private final JLabel greeting = new JLabel("Kliknij przycisk, aby się przedstawić", SwingConstants.CENTER);

    public Zadanie3() {
        super("Zadanie 3 - powitanie");
        setSize(400, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        greeting.setFont(greeting.getFont().deriveFont(16f));
        JButton button = new JButton("Podaj imię");
        button.addActionListener(e -> askName());

        add(greeting, BorderLayout.CENTER);
        add(button, BorderLayout.SOUTH);
    }

    private void askName() {
        String name = new NameDialog(this).showDialog();
        if (name != null) {
            greeting.setText("Witaj, " + name + "!");
            JOptionPane.showMessageDialog(this, "Miło Cię poznać, " + name + "!");
        }
    }

    private static class NameDialog extends JDialog {
        private final JTextField field = new JTextField(15);
        private String result = null;

        NameDialog(JFrame parent) {
            super(parent, "Twoje imię", true);
            setLayout(new FlowLayout());

            JButton ok = new JButton("OK");
            JButton cancel = new JButton("Anuluj");
            ok.addActionListener(e -> accept());
            cancel.addActionListener(e -> dispose());
            field.addActionListener(e -> accept());

            getRootPane().setDefaultButton(ok);
            getRootPane().registerKeyboardAction(e -> dispose(),
                    KeyStroke.getKeyStroke("ESCAPE"), JComponent.WHEN_IN_FOCUSED_WINDOW);

            add(new JLabel("Imię:"));
            add(field);
            add(ok);
            add(cancel);
            pack();
            setLocationRelativeTo(parent);
        }

        private void accept() {
            if (field.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Wpisz imię!", "Błąd", JOptionPane.WARNING_MESSAGE);
            } else {
                result = field.getText().trim();
                dispose();
            }
        }

        String showDialog() {
            setVisible(true);
            return result;
        }
    }
}