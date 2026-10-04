package laboratorio_4;

// Enum que modela las bebidas disponibles con su precio base
public enum Bebida {
    TINTO(2_500),
    CAPUCHINO(6_000),
    CHOCOLATE(5_000),
    AROMATICA(3_000);

    private final double precioBase;

    Bebida(double precioBase) {
        this.precioBase = precioBase;
    }

    public double getPrecioBase() {
        return precioBase;
    }
}
