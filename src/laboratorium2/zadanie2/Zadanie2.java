package laboratorium2.zadanie2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Zadanie2 {
    public void pokaz_Zadanie2() {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        int count = 10000;

        System.out.println("Zadanie 2. Porównanie czasu wykonywania operacji na elementach ArrayList i LinkedList dla " + count + " elementów");

        dodaj(arrayList, linkedList, count);
        modyfikuj(arrayList, linkedList, count);
        usun(arrayList, linkedList, count);
    }

    private void dodaj(List<Integer> arrayList, List<Integer> linkedList, int count) {
        double a = czas(() -> { for (int i = 0; i < count; i++) arrayList.add(i); });
        double l = czas(() -> { for (int i = 0; i < count; i++) linkedList.add(i); });

        System.out.println("\nCzas dodawania dla ArrayList: " + a + " ms");
        System.out.println("Czas dodawania dla LinkedList: " + l + " ms");
    }

    private void modyfikuj(List<Integer> arrayList, List<Integer> linkedList, int count) {
        double a = czas(() -> { for (int i = 0; i < count; i++) arrayList.set(i, i + 1); });
        double l = czas(() -> { for (int i = 0; i < count; i++) linkedList.set(i, i + 1); });

        System.out.println("\nCzas modyfikowania dla ArrayList: " + a + " ms");
        System.out.println("Czas modyfikowania dla LinkedList: " + l + " ms");
    }

    private void usun(List<Integer> arrayList, List<Integer> linkedList, int count) {
        double a = czas(() -> { for (int i = 0; i < count; i++) arrayList.removeFirst(); });
        double l = czas(() -> { for (int i = 0; i < count; i++) linkedList.removeFirst(); });

        System.out.println("\nCzas odejmowania dla ArrayList: " + a + " ms");
        System.out.println("Czas odejmowania dla LinkedList: " + l + " ms");
    }

    private double czas(Runnable operacja) {
        long start = System.nanoTime();
        operacja.run();
        return (System.nanoTime() - start) / 1000000.0;
    }
}