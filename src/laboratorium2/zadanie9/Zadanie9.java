package laboratorium2.zadanie9;

import java.util.HashMap;
import java.util.Map;

public class Zadanie9 {
    public static void pokaz_Zadanie9() {
        Map<Address, String> residents = new HashMap<>();

        residents.put(new Address("Krasickiego", 17), "Agnieszka Lis");
        residents.put(new Address("Ślężna", 64), "Tomasz Walczak");
        residents.put(new Address("Rynek", 3), "Magdalena Dąbrowska");

        System.out.println("Zadanie 9: Niestandardowy klucz w Mapie\n");

        System.out.println("Lokatorzy:");
        residents.forEach((address, name) ->
                System.out.println(address.getStreet() + " " + address.getHouseNumber() + " " + name));

        Address searchAddress = new Address("Ślężna", 64);

        System.out.println("\nSzukany adres: " + searchAddress);
        System.out.println("Znaleziony lokator: " + residents.get(searchAddress));
    }
}