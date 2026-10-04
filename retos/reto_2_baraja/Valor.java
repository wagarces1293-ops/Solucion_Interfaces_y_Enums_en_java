package retos.reto_2_baraja;

public enum Valor {
    UNO("As", 1),
    DOS("Dos", 2),
    TRES("Tres", 3),
    CUATRO("Cuatro", 4),
    CINCO("Cinco", 5),
    SEIS("Seis", 6),
    SIETE("Siete", 7),
    OCHO("Ocho", 8),
    NUEVE("Nueve", 9),
    SOTA("Sota", 10),
    CABALLO("Caballo", 11),
    REY("Rey", 12);

    private final String nombre;
    private final int numero;

    Valor(String nombre, int numero) {
        this.nombre = nombre;
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumero() {
        return numero;
    }
}
