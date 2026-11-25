package menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuItem {
    private String title;
    private List<MenuItem> subItems = new ArrayList<>();
    private Runnable action;

    public MenuItem(String title) {
        this.title = title;
    }

    public MenuItem(String title, Runnable action) {
        this.title = title;
        this.action = action;
    }

    public void addSubItem(MenuItem item) {
        this.subItems.add(item);
    }

    public boolean isSubMenu() {
        return !subItems.isEmpty();
    }

    private void showMenu(Scanner scanner) {
        while (true) {
            System.out.println("\n" + title);
            System.out.println("\nPodaj numer:");
            for (int i = 0; i < subItems.size(); i++) {
                System.out.println((i + 1) + ". " + subItems.get(i).title);
            }
            System.out.println("0.EXIT");

            while (!scanner.hasNextInt()) {
                System.out.println("Podaj poprawny numer");
                scanner.next();
            }
            int choice = scanner.nextInt();

            if (choice == 0) {
                return;
            }
            if (choice > 0 && choice <= subItems.size()) {
                subItems.get(choice - 1).runOption(scanner);
            } else {
                System.out.println("Niepoprawny numer");
            }
        }
    }

    public void runOption(Scanner scanner) {
        if (isSubMenu()) {
            showMenu(scanner);
        } else if (action != null) {
            action.run();

            scanner.nextLine();
            waitForEnter(scanner);
        }
    }

    private static void waitForEnter(Scanner scanner) {
        System.out.println("\n\n ENTER");
        scanner.nextLine();
    }
}