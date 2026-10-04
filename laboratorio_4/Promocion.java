package laboratorio_4;

@FunctionalInterface
public interface Promocion {
    // Metodo abstracto funcional
    double descuento(double subtotal);

    // Metodos static de fabrica que retornan expresiones lambda
    static Promocion ninguna() {
        return subtotal -> 0;
    }

    static Promocion porcentaje(double pct) {
        return subtotal -> subtotal * pct / 100.0;
    }

    static Promocion fijaDesde(double minimo, double valor) {
        return subtotal -> subtotal >= minimo ? valor : 0;
    }
}
