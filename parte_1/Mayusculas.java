package parte_1;

public class Mayusculas implements Formateador {
    @Override
    public String formatear(String texto) {
        return texto.toUpperCase();
    }
}
