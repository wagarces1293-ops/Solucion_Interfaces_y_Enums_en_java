package parte_1;

public interface ReglasJuego {
    // Por regla implicita en interfaces, estas variables son public static final
    int VIDAS_INICIALES = 3;
    int PUNTOS_POR_MONEDA = 10;

    // Metodo abstracto (public abstract implicito)
    int calcularPuntaje(int monedas);
}
