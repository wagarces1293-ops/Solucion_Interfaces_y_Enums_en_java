package parte_1;

public interface Formateador {
    // Metodo abstracto
    String formatear(String texto);

    // Metodo default que usa el abstracto y el metodo privado ayudante
    default String conMarco(String texto) {
        String contenido = "| " + formatear(texto) + " |";
        String borde = linea(contenido.length());
        return borde + "\n" + contenido + "\n" + borde;
    }

    // Metodo static (utilidad perteneciente a la interfaz)
    static String limpiar(String texto) {
        return texto.trim().replaceAll("\\s+", " ");
    }

    // Metodo private (ayudante interno de la interfaz desde Java 9)
    private String linea(int largo) {
        return "+" + "-".repeat(Math.max(0, largo - 2)) + "+";
    }
}
