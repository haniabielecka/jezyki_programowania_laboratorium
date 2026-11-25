package laboratorium2.zadanie5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Zadanie5 {
    public static void pokaz_Zadanie5() {
        List<Person> ludzie = new ArrayList<>(List.of(
                new Person("Kamil", 29),
                new Person("Zofia", 8),
                new Person("Natalia", 45),
                new Person("Bartek", 17),
                new Person("Halina", 82),
                new Person("Oskar", 33),
                new Person("Weronika", 24),
                new Person("Tadeusz", 58)
        ));

        System.out.println("Zadanie 5: Sortowanie osób po wieku z użyciem komparatora.");

        System.out.println("przed sortowaniem:");
        wypisz(ludzie);

        ludzie.sort(Comparator.comparingInt(Person::getAge));

        System.out.println("\npo sortowaniu:");
        wypisz(ludzie);
    }

    private static void wypisz(List<Person> people) {
        for (Person p : people) {
            System.out.println(p.getName() + " " + p.getAge());
        }
    }
}