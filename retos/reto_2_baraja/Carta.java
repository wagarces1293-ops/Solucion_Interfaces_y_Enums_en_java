package retos.reto_2_baraja;

// Record inmutable que representa una carta individual de la baraja
public record Carta(Valor valor, Palo palo) {
    @Override
    public String toString() {
        return valor.getNombre() + " de " + palo.name();
    }
}
