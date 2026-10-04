package laboratorio_2;

public class Efectivo implements MetodoPago {
    @Override
    public String nombre() {
        return "Efectivo";
    }

    @Override
    public boolean pagar(double monto) {
        // En efectivo siempre se aprueba el pago
        return true;
    }
}
