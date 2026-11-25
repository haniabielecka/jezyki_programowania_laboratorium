package menu;

import laboratorium2.zadanie1.Zadanie1;
import laboratorium2.zadanie2.Zadanie2;
import laboratorium2.zadanie3.Zadanie3;
import laboratorium2.zadanie4.Zadanie4;
import laboratorium2.zadanie5.Zadanie5;
import laboratorium2.zadanie6.Zadanie6;
import laboratorium2.zadanie7.Zadanie7;
import laboratorium2.zadanie8.Zadanie8;
import laboratorium2.zadanie9.Zadanie9;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.util.Scanner;
import java.util.function.Supplier;

public class Menu {

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);

        MenuItem mainMenu = new MenuItem("MAIN MENU");

        MenuItem lab2 = new MenuItem("Laboratorium 2");
        addLab2(lab2, scanner);

        MenuItem lab3 = new MenuItem("Laboratorium 3");
        addLab3(lab3);

        mainMenu.addSubItem(lab2);
        mainMenu.addSubItem(lab3);

        mainMenu.runOption(scanner);
    }

    private void addLab2(MenuItem lab2, Scanner scanner) {
        lab2.addSubItem(new MenuItem("Zadanie 1", () -> Zadanie1.pokaz_Zadanie1(scanner)));
        lab2.addSubItem(new MenuItem("Zadanie 2", new Zadanie2()::pokaz_Zadanie2));
        lab2.addSubItem(new MenuItem("Zadanie 3", () -> Zadanie3.pokaz_Zadanie3(scanner)));
        lab2.addSubItem(new MenuItem("Zadanie 4", Zadanie4::pokaz_Zadanie4));
        lab2.addSubItem(new MenuItem("Zadanie 5", Zadanie5::pokaz_Zadanie5));
        lab2.addSubItem(new MenuItem("Zadanie 6", Zadanie6::pokaz_Zadanie6));
        lab2.addSubItem(new MenuItem("Zadanie 7", Zadanie7::pokaz_Zadanie7));
        lab2.addSubItem(new MenuItem("Zadanie 8", Zadanie8::pokaz_Zadanie8));
        lab2.addSubItem(new MenuItem("Zadanie 9", Zadanie9::pokaz_Zadanie9));
    }

    private void addLab3(MenuItem lab3) {
        lab3.addSubItem(new MenuItem("Zadanie 1", () -> openWindow(laboratorium3.zadanie1.Zadanie1::new)));
        lab3.addSubItem(new MenuItem("Zadanie 2", () -> openWindow(laboratorium3.zadanie2.Zadanie2::new)));
        lab3.addSubItem(new MenuItem("Zadanie 3", () -> openWindow(laboratorium3.zadanie3.Zadanie3::new)));
        lab3.addSubItem(new MenuItem("Zadanie 4", () -> openWindow(laboratorium3.zadanie4.Zadanie4::new)));
        lab3.addSubItem(new MenuItem("Zadanie 5", () -> openWindow(laboratorium3.zadanie5.Zadanie5::new)));
        lab3.addSubItem(new MenuItem("Zadanie 6", () -> openWindow(laboratorium3.zadanie6.Zadanie6::new)));
    }

    private void openWindow(Supplier<JFrame> window) {
        SwingUtilities.invokeLater(() -> window.get().setVisible(true));
    }
}