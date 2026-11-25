package laboratorium2.zadanie6;

import java.util.Map;
import java.util.TreeMap;

public class Zadanie6 {
    public static void pokaz_Zadanie6() {
        Map<String, Integer> cities = new TreeMap<>(Map.of(
                "Łódź", 650000,
                "Szczecin", 390000,
                "Lublin", 330000,
                "Katowice", 290000,
                "Białystok", 295000
        ));

        System.out.println("Zadanie 6: sortowanie miast pod względem mieszkańców.\n");

        System.out.println("nieposortowane:");
        wypisz(cities.entrySet());

        System.out.println("\nposortowane:");
        wypisz(cities.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .toList());
    }

    private static void wypisz(Iterable<Map.Entry<String, Integer>> miasta) {
        for (var entry : miasta) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}