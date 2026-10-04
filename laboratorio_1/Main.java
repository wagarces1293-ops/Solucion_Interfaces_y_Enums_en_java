package laboratorio_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        // Creamos la lista de canciones para la prueba
        List<Cancion> playlist = new ArrayList<>(List.of(
                new Cancion("Tusa", "Karol G", 200),
                new Cancion("La Bicicleta", "Carlos Vives", 227),
                new Cancion("Despacito", "Luis Fonsi", 228),
                new Cancion("Bailando", "Enrique Iglesias", 243)
        ));

        // 1. Orden natural por titulo usando Comparable<Cancion>
        Collections.sort(playlist);
        System.out.println("Orden natural (título):");
        for (Cancion c : playlist) {
            System.out.printf(" %-14s %-17s %s%n", c.getTitulo(), c.getArtista(), c.duracion());
        }

        // 2. Orden alternativo usando Comparator (de mas larga a mas corta)
        playlist.sort(Comparator.comparingInt(Cancion::getDuracionSeg).reversed());
        System.out.println("De la más larga a la más corta:");
        for (Cancion c : playlist) {
            System.out.println(" " + c.getTitulo() + " (" + c.duracion() + ")");
        }

        // 3. Filtrado con Predicate para identificar canciones con duracion mayor a 200 segundos
        Predicate<Cancion> esLarga = c -> c.getDuracionSeg() > 200;
        List<String> largas = playlist.stream()
                .filter(esLarga)
                .map(c -> c.getTitulo().toUpperCase())
                .toList();

        System.out.println("Canciones largas: " + largas);
    }
}
