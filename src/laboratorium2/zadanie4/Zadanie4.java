package laboratorium2.zadanie4;

import java.util.HashSet;
import java.util.Set;

public class Zadanie4 {
    public static void pokaz_Zadanie4() {
        Set<Product> products = new HashSet<>();

        System.out.println("Zadanie 4: Implementacja nadpisywania metod equals() i hashCode().\n");

        Product p1 = new Product("PL-111", 932.12);
        Product p2 = new Product("PL-200", 10345.45);
        Product p3 = new Product("PL-112", 321.21);

        System.out.println("Dodaję p1 (PL-111): " + products.add(p1));
        System.out.println("Dodaję p2 (PL-200): " + products.add(p2));
        System.out.println("Dodaję p3 (PL-112 zduplikowany): " + products.add(p3));

        System.out.println("\nLiczba elementów w zbiorze HashSet: " + products.size());
        System.out.println("Zawartość zbioru: " + products);
    }
}