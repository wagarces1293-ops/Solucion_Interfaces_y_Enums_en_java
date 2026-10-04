package parte_1;

public class JuegoArcade implements ReglasJuego {
    @Override
    public int calcularPuntaje(int monedas) {
        // Accede a la constante heredada de la interfaz
        return monedas * PUNTOS_POR_MONEDA;
    }
}
