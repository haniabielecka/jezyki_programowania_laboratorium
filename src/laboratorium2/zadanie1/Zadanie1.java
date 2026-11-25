package laboratorium2.zadanie1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Zadanie1 {
    public static void pokaz_Zadanie1(Scanner scanner) {
        Set<Integer> hashSet = new HashSet<>();
        Set<Integer> treeSet = new TreeSet<>();

        System.out.println("Zadanie 1. Porównanie: HashSet vs TreeSet.\n");
        System.out.println("Ile liczb chcesz wpisać? ");
        int count = wczytajLiczbe(scanner);

        while (count <= 0) {
            System.out.println("Należy podać liczbę dodatnią.");
            count = wczytajLiczbe(scanner);
        }

        System.out.println("Zaraz poproszę o podanie liczb. Poprawny format to: liczba całkowita.");
        for (int i = 0; i < count; i++) {
            System.out.println("Wpisz " + (i + 1) + " liczbę:");
            int liczba = wczytajLiczbe(scanner);
            hashSet.add(liczba);
            treeSet.add(liczba);
        }

        System.out.println("HashSet: " + hashSet);
        System.out.println("TreeSet: " + treeSet);

        if (new ArrayList<>(hashSet).equals(new ArrayList<>(treeSet))) {
            System.out.println("\nKolejność jest taka sama, bo liczby są małe i HashSet przypadkiem ułożył je rosnąco. Wpisz liczby ujemne albo większe od 16, żeby zobaczyć różnicę.");
        } else {
            System.out.println("\nKolejność się różni: TreeSet sortuje rosnąco, a HashSet nie gwarantuje żadnej kolejności.");
        }
    }

    private static int wczytajLiczbe(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Wpisane dane mają niepoprawny format, popraw:");
            scanner.next();
        }
        return scanner.nextInt();
    }
}