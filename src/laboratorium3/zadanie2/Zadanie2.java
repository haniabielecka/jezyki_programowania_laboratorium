package laboratorium3.zadanie2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Zadanie2 extends JFrame {
    private final JLabel label = new JLabel("Etykieta", SwingConstants.CENTER);
    private final JButton button = new JButton("Przycisk");
    private final JComboBox<String> choose = new JComboBox<>(new String[]{"Etykieta", "Przycisk"});

    public Zadanie2() {
        super("Zadanie 2 - zmiana wyglądu");
        setSize(600, 450);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        add(createCanvas(), BorderLayout.CENTER);
        add(createControls(), BorderLayout.SOUTH);
    }

    private JPanel createCanvas() {
        JPanel canvas = new JPanel(null);
        label.setOpaque(true);
        label.setBackground(Color.LIGHT_GRAY);
        label.setBounds(50, 50, 120, 40);
        button.setBounds(250, 150, 120, 40);
        canvas.add(label);
        canvas.add(button);
        return canvas;
    }

    private JPanel createControls() {
        JPanel controls = new JPanel(new FlowLayout());
        controls.add(choose);
        addButton(controls, "Kolor", e -> changeColor());
        addButton(controls, "Większy", e -> resizeTarget(1.2));
        addButton(controls, "Mniejszy", e -> resizeTarget(1 / 1.2));
        addButton(controls, "←", e -> moveTarget(-15, 0));
        addButton(controls, "→", e -> moveTarget(15, 0));
        addButton(controls, "↑", e -> moveTarget(0, -15));
        addButton(controls, "↓", e -> moveTarget(0, 15));
        return controls;
    }

    private void addButton(JPanel panel, String text, ActionListener action) {
        JButton b = new JButton(text);
        b.addActionListener(action);
        panel.add(b);
    }

    private JComponent target() {
        return choose.getSelectedIndex() == 0 ? label : button;
    }

    private void changeColor() {
        Color picked = JColorChooser.showDialog(this, "Wybierz kolor", Color.WHITE);
        if (picked != null) {
            JComponent t = target();
            t.setOpaque(true);
            t.setBackground(picked);
            t.repaint();
        }
    }

    private void resizeTarget(double factor) {
        JComponent t = target();
        int w = Math.max(30, (int) (t.getWidth() * factor));
        int h = Math.max(20, (int) (t.getHeight() * factor));
        t.setSize(w, h);
    }

    private void moveTarget(int dx, int dy) {
        JComponent t = target();
        t.setLocation(t.getX() + dx, t.getY() + dy);
    }
}