package retos.reto_4_promociones;

@FunctionalInterface
public interface Promocion {
    double descuento(double subtotal);

    // Metodo default que combina dos promociones sumando ambos descuentos
    // pero asegurando con Math.min que el descuento total nunca supere el subtotal
    default Promocion y(Promocion otra) {
        return subtotal -> {
            double d1 = this.descuento(subtotal);
            double d2 = otra.descuento(subtotal);
            return Math.min(subtotal, d1 + d2);
        };
    }

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
