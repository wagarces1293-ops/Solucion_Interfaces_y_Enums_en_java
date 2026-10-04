package laboratorio_2;

public class Main {
    public static void main(String[] args) {
        // Los cuatro casos de prueba del laboratorio
        Caja.cobrar(new TarjetaCredito(500_000), 120_000);
        Caja.cobrar(new BilleteraDigital(50_000), 80_000);
        Caja.cobrar(new Efectivo(), 35_000);
        Caja.cobrar(new TarjetaCredito(100_000), 99_000);

        // Caso 5 adicional: Quinto metodo de pago sin haber tocado para nada la clase Caja
        System.out.println("\n--- Prueba del quinto metodo (Criptomoneda) ---");
        Caja.cobrar(new Criptomoneda(200_000), 150_000);
    }
}
