package laboratorium3.zadanie5;

import javax.swing.*;
import java.awt.*;

public class Zadanie5 extends JFrame {
    private static final String[] NAMES = {"Bardzo słabe", "Słabe", "Średnie", "Dobre", "Silne"};
    private static final Color[] COLORS = {Color.RED, Color.ORANGE, Color.YELLOW.darker(),
            new Color(120, 180, 0), new Color(0, 150, 0)};

    private final JPasswordField field = new JPasswordField();
    private final JLabel result = new JLabel(" ", SwingConstants.CENTER);

    public Zadanie5() {
        super("Zadanie 5 - siła hasła");
        setSize(400, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JCheckBox show = new JCheckBox("Pokaż hasło");
        char defaultEcho = field.getEchoChar();
        show.addActionListener(e -> field.setEchoChar(show.isSelected() ? (char) 0 : defaultEcho));

        JButton check = new JButton("Sprawdź siłę hasła");
        check.addActionListener(e -> checkPassword());

        JPanel panel = new JPanel(new GridLayout(4, 1, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.add(field);
        panel.add(show);
        panel.add(check);
        panel.add(result);
        add(panel);
    }

    private void checkPassword() {
        int score = score(new String(field.getPassword()));
        result.setText("Siła hasła: " + NAMES[score]);
        result.setForeground(COLORS[score]);
        JOptionPane.showMessageDialog(this, NAMES[score] + " (" + score + "/4)",
                "Wynik", JOptionPane.INFORMATION_MESSAGE);
    }

    // zwraca 0..4
    private static int score(String p) {
        if (p.isEmpty()) return 0;
        int pts = 0;
        if (p.length() >= 8) pts++;
        if (p.length() >= 12) pts++;
        if (p.chars().anyMatch(Character::isLowerCase) && p.chars().anyMatch(Character::isUpperCase)) pts++;
        if (p.chars().anyMatch(Character::isDigit)) pts++;
        if (p.chars().anyMatch(ch -> !Character.isLetterOrDigit(ch))) pts++;
        return Math.min(pts, 4);
    }
}