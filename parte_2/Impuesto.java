package parte_2;

// Un enum puede implementar interfaces (pero no puede usar extends porque ya hereda de Enum)
public enum Impuesto implements Calculable {
    IVA_GENERAL(0.19),
    IVA_REDUCIDO(0.05),
    EXENTO(0.0);

    private final double tasa;

    Impuesto(double tasa) {
        this.tasa = tasa;
    }

    @Override
    public double calcular(double base) {
        return base * tasa;
    }
}
