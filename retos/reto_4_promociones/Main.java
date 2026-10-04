package retos.reto_4_promociones;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Reto 4: Promociones Combinables ===");

        // Combinamos dos promociones usando el metodo default .y(...)
        Promocion promoCombinada = Promocion.porcentaje(10)
                .y(Promocion.fijaDesde(20_000, 1_000));

        // Caso 1: Subtotal de $25.000 (califica para 10% y para los $1.000 fijos)
        double subtotal1 = 25_000;
        double desc1 = promoCombinada.descuento(subtotal1);
        System.out.printf("Subtotal: $%,8.0f | Descuento: $%,8.0f | Total: $%,8.0f%n",
                subtotal1, desc1, (subtotal1 - desc1));

        // Caso 2: Subtotal de $15.000 (solo califica para 10% porque no llega a $20.000)
        double subtotal2 = 15_000;
        double desc2 = promoCombinada.descuento(subtotal2);
        System.out.printf("Subtotal: $%,8.0f | Descuento: $%,8.0f | Total: $%,8.0f%n",
                subtotal2, desc2, (subtotal2 - desc2));

        // Caso 3: Prueba de proteccion para no superar el subtotal
        Promocion promoExcesiva = Promocion.porcentaje(80)
                .y(Promocion.porcentaje(40)); // 120% en teoria
        double subtotal3 = 10_000;
        double desc3 = promoExcesiva.descuento(subtotal3);
        System.out.println("\nPrueba de tope maximo (descuento no supera subtotal):");
        System.out.printf("Subtotal: $%,8.0f | Descuento limitado: $%,8.0f | Total: $%,8.0f%n",
                subtotal3, desc3, (subtotal3 - desc3));
    }
}
