package parte_2;

public enum Moneda {
    COP("Peso colombiano", "$", 1),
    USD("Dólar estadounidense", "US$", 4_000),
    EUR("Euro", "€", 4_400),
    MXN("Peso mexicano", "MX$", 220); // El punto y coma es obligatorio cuando hay miembros adicionales

    private final String nombre;
    private final String simbolo;
    private final double enPesos; // Tasa de referencia en pesos colombianos

    // Constructor implícitamente privado
    Moneda(String nombre, String simbolo, double enPesos) {
        this.nombre = nombre;
        this.simbolo = simbolo;
        this.enPesos = enPesos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public double getEnPesos() {
        return enPesos;
    }

    public String formatear(double cantidad) {
        return simbolo + String.format("%,.2f", cantidad);
    }

    public double convertirA(Moneda destino, double cantidad) {
        return cantidad * this.enPesos / destino.enPesos;
    }

    // Busqueda segura por simbolo propio en lugar de usar ordinal
    public static Moneda desdeSimbolo(String simbolo) {
        for (Moneda m : values()) {
            if (m.simbolo.equals(simbolo)) {
                return m;
            }
        }
        throw new IllegalArgumentException("Símbolo desconocido: " + simbolo);
    }
}
