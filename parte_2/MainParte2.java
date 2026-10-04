package parte_2;

import java.util.EnumMap;
import java.util.EnumSet;

public class MainParte2 {

    // Seccion 2.5: Switch exhaustivo con expresion flecha
    public static String tipoDia(DiaSemana dia) {
        return switch (dia) {
            case SABADO, DOMINGO -> "fin de semana";
            case LUNES, MARTES, MIERCOLES, JUEVES, VIERNES -> "día laboral";
        };
    }

    public static int horasDeClase(DiaSemana dia) {
        return switch (dia) {
            case LUNES, MIERCOLES -> 4;
            case MARTES, JUEVES -> 6;
            case VIERNES -> {
                int teoria = 1;
                int laboratorio = 2;
                yield teoria + laboratorio;
            }
            case SABADO, DOMINGO -> 0;
        };
    }

    // Seccion 2.8: Polimorfismo con Calculable
    public static void cobrar(String concepto, double base, Calculable regla) {
        System.out.printf("%-12s base $%,9.0f recargo $%,7.0f%n",
                concepto, base, regla.calcular(base));
    }

    public static void main(String[] args) {
        System.out.println("=== 2.2 y 2.4 Metodos basicos de un Enum ===");
        DiaSemana hoy = DiaSemana.VIERNES;
        System.out.println("Hoy es " + hoy);
        if (hoy == DiaSemana.VIERNES) {
            System.out.println("¡Por fin viernes!");
        }

        // 1. values() y ordinal()
        for (DiaSemana d : DiaSemana.values()) {
            System.out.print(d.ordinal() + ":" + d.name() + " ");
        }
        System.out.println();

        // 2. valueOf()
        DiaSemana dMartes = DiaSemana.valueOf("MARTES");
        System.out.println("valueOf(\"MARTES\") → " + dMartes);

        // 3. compareTo()
        boolean antes = DiaSemana.LUNES.compareTo(DiaSemana.JUEVES) < 0;
        System.out.println("¿LUNES va antes que JUEVES? " + antes);
        System.out.println("Cantidad de días: " + DiaSemana.values().length);

        // 4. valueOf() con error
        try {
            DiaSemana.valueOf("lunes");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n=== 2.5 Switch con Enums ===");
        for (DiaSemana d : DiaSemana.values()) {
            System.out.printf("%-10s %-14s %d h%n", d, tipoDia(d), horasDeClase(d));
        }

        System.out.println("\n=== 2.6 Enums con atributos y metodos (Moneda) ===");
        for (Moneda m : Moneda.values()) {
            System.out.printf("%s %-21s %s%n", m, m.getNombre(), m.formatear(1));
        }
        double pesos = Moneda.USD.convertirA(Moneda.COP, 25);
        System.out.println(Moneda.USD.formatear(25) + " = " + Moneda.COP.formatear(pesos));
        double mxn = Moneda.EUR.convertirA(Moneda.MXN, 100);
        System.out.println(Moneda.EUR.formatear(100) + " = " + Moneda.MXN.formatear(mxn));
        System.out.println("Símbolo € → " + Moneda.desdeSimbolo("€").getNombre());

        System.out.println("\n=== 2.7 Comportamiento abstracto por constante (Operador) ===");
        double a = 12, b = 4;
        for (Operador op : Operador.values()) {
            System.out.printf("%.0f %s %.0f = %.1f%n", a, op.simbolo(), b, op.aplicar(a, b));
        }
        try {
            Operador.DIVISION.aplicar(1, 0);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n=== 2.8 Enums implementando interfaces (Impuesto) ===");
        cobrar("Audífonos", 200_000, Impuesto.IVA_GENERAL);
        cobrar("Producto B", 40_000, Impuesto.IVA_REDUCIDO);
        cobrar("Libro", 60_000, Impuesto.EXENTO);
        cobrar("Propina", 80_000, base -> base * 0.10);

        System.out.println("\n=== 2.9 Enums como maquina de estados (EstadoPedido) ===");
        EstadoPedido estado = EstadoPedido.RECIBIDO;
        while (!estado.esFinal()) {
            String cancelable = estado.puedeCancelarse() ? "sí" : "no";
            System.out.printf("%-15s ¿cancelable? %s%n", estado, cancelable);
            estado = estado.siguiente();
        }
        System.out.println(estado + " → fin del recorrido");
        try {
            EstadoPedido.LISTO.cancelar();
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n=== 2.10 Colecciones especializadas: EnumSet y EnumMap ===");
        EnumSet<DiaSemana> finde = EnumSet.of(DiaSemana.SABADO, DiaSemana.DOMINGO);
        EnumSet<DiaSemana> laborales = EnumSet.complementOf(finde);
        EnumSet<DiaSemana> mitad = EnumSet.range(DiaSemana.MARTES, DiaSemana.JUEVES);
        System.out.println("Fin de semana: " + finde);
        System.out.println("Laborales: " + laborales);
        System.out.println("Mitad: " + mitad);
        System.out.println("¿VIERNES es laboral? " + laborales.contains(DiaSemana.VIERNES));

        EnumMap<DiaSemana, String> horario = new EnumMap<>(DiaSemana.class);
        horario.put(DiaSemana.VIERNES, "Laboratorio de Java");
        horario.put(DiaSemana.LUNES, "Teoria de interfaces");
        horario.put(DiaSemana.MIERCOLES, "Taller de enums");
        horario.forEach((dia, clase) -> System.out.printf("%-10s %s%n", dia, clase));

        System.out.println("\n=== 2.11 Enum como Singleton ===");
        Configuracion c1 = Configuracion.INSTANCIA;
        Configuracion c2 = Configuracion.INSTANCIA;
        c1.setIdioma("en");
        c1.setVolumen(140); // Math.clamp lo limita a 100
        System.out.println("c2 ve: " + c2.getIdioma() + ", volumen " + c2.getVolumen());
        System.out.println("¿Mismo objeto? " + (c1 == c2));
    }
}
