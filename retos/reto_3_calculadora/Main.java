package retos.reto_3_calculadora;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Reto 3: Calculadora con Lambdas en el Enum ===");

        double a = 12.0;
        double b = 4.0;

        for (Operador op : Operador.values()) {
            double resultado = op.aplicar(a, b);
            System.out.printf("%.0f %s %.0f = %.2f%n", a, op.simbolo(), b, resultado);
        }

        // Prueba adicional de POTENCIA (2 ^ 10)
        System.out.println("\nPrueba de potencia extra:");
        System.out.printf("2 ^ 10 = %.0f%n", Operador.POTENCIA.aplicar(2, 10));

        // Prueba de division por cero
        System.out.println("\nPrueba de control de division por cero:");
        try {
            Operador.DIVISION.aplicar(10, 0);
        } catch (ArithmeticException e) {
            System.out.println("Excepción capturada: " + e.getMessage());
        }
    }
}
