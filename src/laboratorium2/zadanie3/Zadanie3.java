package laboratorium2.zadanie3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Zadanie3 {
    public static void pokaz_Zadanie3(Scanner scanner) {
        Map<String, String> hashMap = new HashMap<>();
        Map<String, String> treeMap = new TreeMap<>();

        System.out.println("Zadanie 3: Porównanie kolejności kluczy: HashMap vs TreeMap.\n");
        System.out.println("Ile par klucz-wartość chcesz wpisać?");
        int pairs = wczytajLiczbe(scanner);

        while (pairs < 0) {
            System.out.println("Liczba nie może być ujemna! Podaj liczbę >= 0:");
            pairs = wczytajLiczbe(scanner);
        }

        for (int i = 0; i < pairs; i++) {
            System.out.println("Wpisz klucz nr " + (i + 1) + ":");
            String key = scanner.nextLine();

            System.out.println("Wpisz wartość nr " + (i + 1) + ":");
            String value = scanner.nextLine();

            hashMap.put(key, value);
            treeMap.put(key, value);
        }

        System.out.println("\nKolejność kluczy:");
        System.out.println("    HashMap: " + hashMap);
        System.out.println("    TreeMap: " + treeMap);
    }

    private static int wczytajLiczbe(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Wprowadź liczbę całkowitą!");
            scanner.next();
        }
        int liczba = scanner.nextInt();
        scanner.nextLine();
        return liczba;
    }
}