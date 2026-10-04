package laboratorio_2;

// Quinto metodo de pago agregado para demostrar el polimorfismo sin modificar Caja
public class Criptomoneda implements MetodoPago {
    private double saldoCripto;

    public Criptomoneda(double saldoCripto) {
        this.saldoCripto = saldoCripto;
    }

    @Override
    public String nombre() {
        return "Criptomoneda";
    }

    // Comision de red fija o porcentual (por ejemplo 1%)
    @Override
    public double comision(double monto) {
        return monto * 0.01;
    }

    @Override
    public boolean pagar(double monto) {
        double total = totalACobrar(monto);
        if (total > saldoCripto) {
            return false;
        }
        saldoCripto -= total;
        return true;
    }
}
