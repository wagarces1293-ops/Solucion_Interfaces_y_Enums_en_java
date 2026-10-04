package laboratorio_2;

public class Caja {
    // Metodo que depende unicamente de la interfaz MetodoPago.
    // Desconoce los detalles internos de cada medio de pago.
    public static void cobrar(MetodoPago m, double monto) {
        String resultado = m.pagar(monto) ? "APROBADO" : "RECHAZADO";
        System.out.printf("%-20s $%,10.0f comisión $%,7.0f %s%n",
                m.nombre(), monto, m.comision(monto), resultado);
    }
}
