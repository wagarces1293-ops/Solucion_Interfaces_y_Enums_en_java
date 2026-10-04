package laboratorio_3;

// Enum que modela las luces de un semaforo con duracion en segundos y accion vial
public enum Semaforo {
    VERDE(30, "Avance"),
    AMARILLO(5, "Precaución"),
    ROJO(35, "Pare");

    private final int segundos;
    private final String accion;

    Semaforo(int segundos, String accion) {
        this.segundos = segundos;
        this.accion = accion;
    }

    public int getSegundos() {
        return segundos;
    }

    public String getAccion() {
        return accion;
    }

    // Transicion ciclica de estados con switch exhaustivo
    public Semaforo siguiente() {
        return switch (this) {
            case VERDE -> AMARILLO;
            case AMARILLO -> ROJO;
            case ROJO -> VERDE;
        };
    }

    // Calcula la duracion total sumando los segundos de cada estado
    public static int duracionCiclo() {
        int total = 0;
        for (Semaforo s : values()) {
            total += s.segundos;
        }
        return total;
    }
}
