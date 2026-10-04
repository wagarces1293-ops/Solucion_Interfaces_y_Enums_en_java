package parte_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class MainParte1 {

    // Metodo estatico para switch con patrones de record (seccion 1.9)
    public static double calcularArea(Figura f) {
        return switch (f) {
            case Circulo c -> Math.PI * c.radio() * c.radio();
            case Rectangulo(double b, double h) -> b * h;
            case Triangulo t -> t.base() * t.altura() / 2.0;
        };
    }

    public static void main(String[] args) {
        System.out.println("=== 1.2 Tu primera interfaz ===");
        Sonoro firulais = new Perro();
        Sonoro michi = new Gato();
        System.out.println(firulais.hacerSonido());
        System.out.println(michi.hacerSonido());

        System.out.println("\n=== 1.3 Constantes y reglas implicitas ===");
        System.out.println("Vidas: " + ReglasJuego.VIDAS_INICIALES);
        ReglasJuego juego = new JuegoArcade();
        System.out.println("Puntaje con 7 monedas: " + juego.calcularPuntaje(7));

        System.out.println("\n=== 1.4 Polimorfismo e implementacion multiple ===");
        List<Sonoro> granja = List.of(new Perro(), new Gato(), new Vaca());
        for (Sonoro animal : granja) {
            String nombre = animal.getClass().getSimpleName();
            System.out.println(nombre + " dice " + animal.hacerSonido());
        }

        Pato lucas = new Pato();
        lucas.nadar();
        lucas.volar();
        Avion avion = new Avion();
        avion.volar();

        DispositivoInteligente parlante = new Parlante();
        parlante.encender();
        parlante.conectarWifi("Casa_5G");
        System.out.println(parlante.asistente());
        parlante.apagar();

        System.out.println("\n=== 1.5 Metodos default, static y private ===");
        Notificador[] canales = { new NotificadorEmail(), new NotificadorSMS() };
        for (Notificador n : canales) {
            n.enviar("Tu pedido fue enviado");
            n.enviarUrgente("Tu clave expira hoy");
        }

        Artista artista = new Artista();
        System.out.println(artista.presentarse());

        String entrada = Formateador.limpiar("  hola   mundo  java  ");
        Formateador formateador = new Mayusculas();
        System.out.println(formateador.conMarco(entrada));

        System.out.println("=== 1.6 Interfaces funcionales y lambdas ===");
        Operacion suma = (a, b) -> a + b;
        Operacion resta = (a, b) -> a - b;
        Operacion potencia = (base, exponente) -> {
            int resultado = 1;
            for (int i = 0; i < exponente; i++) {
                resultado *= base;
            }
            return resultado;
        };

        System.out.println("8 + 2 = " + suma.aplicar(8, 2));
        System.out.println("8 - 2 = " + resta.aplicar(8, 2));
        System.out.println("2 ^ 10 = " + potencia.aplicar(2, 10));

        Predicate<String> esLarga = s -> s.length() > 5;
        Function<String, Integer> longitud = String::length;
        Consumer<String> imprimir = System.out::println;
        Supplier<String> saludo = () -> "¡Bienvenido al laboratorio!";
        UnaryOperator<String> gritar = s -> s.toUpperCase() + "!";
        BiFunction<Integer, Integer, Integer> mayor = Math::max;

        imprimir.accept(saludo.get());
        System.out.println("¿'interfaz' es larga? " + esLarga.test("interfaz"));
        System.out.println("Longitud de 'enum': " + longitud.apply("enum"));
        System.out.println("Mayor entre 17 y 42: " + mayor.apply(17, 42));

        System.out.println("\n=== 1.7 Comparable y Comparator ===");
        List<Estudiante> curso = new ArrayList<>(List.of(
                new Estudiante("Valentina", 4.5),
                new Estudiante("Andrés", 3.8),
                new Estudiante("Sofía", 4.5),
                new Estudiante("Mateo", 4.1)
        ));
        Collections.sort(curso);
        System.out.println("Alfabético: " + curso);

        curso.sort(Comparator.comparingDouble(Estudiante::getPromedio)
                .reversed()
                .thenComparing(Estudiante::getNombre));
        System.out.println("Por promedio: " + curso);

        System.out.println("\n=== 1.8 Interfaz vs Clase Abstracta ===");
        List<Empleado> nomina = List.of(
                new Desarrollador("Laura", 6_000_000),
                new Practicante("Tomás", 1_750_000)
        );
        for (Empleado e : nomina) {
            System.out.println(e.resumen());
        }

        System.out.println("\n=== 1.9 Interfaces selladas y records ===");
        List<Figura> figuras = List.of(
                new Circulo(5),
                new Rectangulo(4, 6),
                new Triangulo(10, 3)
        );
        for (Figura f : figuras) {
            System.out.printf("%-30s área = %.2f%n", f, calcularArea(f));
        }
    }
}
