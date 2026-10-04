package parte_1;

// Implementa Comparable para definir el orden natural (alfabetico por nombre)
public class Estudiante implements Comparable<Estudiante> {
    private final String nombre;
    private final double promedio;

    public Estudiante(String nombre, double promedio) {
        this.nombre = nombre;
        this.promedio = promedio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPromedio() {
        return promedio;
    }

    @Override
    public int compareTo(Estudiante otro) {
        // Devuelve negativo si va antes, cero si es igual, positivo si va despues
        return this.nombre.compareTo(otro.nombre);
    }

    @Override
    public String toString() {
        return nombre + " (" + promedio + ")";
    }
}
