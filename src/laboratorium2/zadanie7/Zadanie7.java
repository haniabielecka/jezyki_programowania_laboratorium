package laboratorium2.zadanie7;

import java.util.HashSet;
import java.util.Set;

public class Zadanie7 {
    public static void pokaz_Zadanie7() {
        Set<Book> books = new HashSet<>();

        Book b1 = new Book("Quo Vadis", "Henryk Sienkiewicz", "978-83-240-1111-1");
        Book b2 = new Book("Lalka", "Bolesław Prus", "978-83-240-2222-2");
        Book b3 = new Book("Pan Tadeusz", "Adam Mickiewicz", "978-83-240-3333-3");
        Book b1Duplicate = new Book("Quo Vadis (wydanie 2)", "Henryk Sienkiewicz", "978-83-240-1111-1");

        System.out.println("Zadanie 7: Testowanie HashSet dla klasy Book\n");

        System.out.println("Dodaję książkę : 978-83-240-1111-1 " + books.add(b1));
        System.out.println("Dodaję książkę : 978-83-240-2222-2 " + books.add(b2));
        System.out.println("Dodaję książkę : 978-83-240-3333-3 " + books.add(b3));
        System.out.println("Dodaję książkę : 978-83-240-1111-1 " + books.add(b1Duplicate));

        System.out.println("\nLiczba książek w zbiorze: " + books.size());
    }
}