package laboratorio_2;

// Contrato general para cualquier metodo de pago aceptado por la tienda
public interface MetodoPago {
    String nombre();
    boolean pagar(double monto);

    // Metodo default: la mayoria de medios no cobra comision extra
    default double comision(double monto) {
        return 0;
    }

    // Metodo default: suma el monto base mas la comision calculada
    default double totalACobrar(double monto) {
        return monto + comision(monto);
    }
}
