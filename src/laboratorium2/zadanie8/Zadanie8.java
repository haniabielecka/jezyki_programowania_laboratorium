package laboratorium2.zadanie8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Zadanie8 {
    public static void pokaz_Zadanie8() {
        List<Product> products = new ArrayList<>(List.of(
                new Product("Słuchawki", 450.00),
                new Product("Tablet", 2100.00),
                new Product("Głośnik", 220.00),
                new Product("Drukarka", 780.00)
        ));

        System.out.println("Zadanie 8: Porównanie interfejsu Comparable z własnym komparatorem");

        System.out.println("\nSortowanie Comparable po cenie:");
        Collections.sort(products);
        wypisz(products);

        System.out.println("\nSortowanie własnym komparatorem po nazwie:");
        products.sort(Comparator.comparing(Product::getName));
        wypisz(products);
    }

    private static void wypisz(List<Product> products) {
        for (Product p : products) {
            System.out.println(p.getName() + " " + p.getPrice());
        }
    }
}