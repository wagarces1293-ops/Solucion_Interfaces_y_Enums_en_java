package retos.reto_2_baraja;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Reto 2: Baraja Española (48 Cartas) ===");

        List<Carta> baraja = new ArrayList<>();

        // Dos ciclos for sobre values() para combinar palos y valores
        for (Palo p : Palo.values()) {
            for (Valor v : Valor.values()) {
                baraja.add(new Carta(v, p));
            }
        }

        System.out.println("Total de cartas creadas: " + baraja.size());
        System.out.println("\nPrimeras 5 cartas en orden ordenado:");
        for (int i = 0; i < 5; i++) {
            System.out.println(" - " + baraja.get(i));
        }

        // Barajamos la coleccion usando Collections.shuffle
        Collections.shuffle(baraja);

        System.out.println("\nPrimeras 5 cartas despues de barajar con Collections.shuffle:");
        for (int i = 0; i < 5; i++) {
            System.out.println(" - " + baraja.get(i));
        }
    }
}
