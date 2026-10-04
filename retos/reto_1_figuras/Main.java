package retos.reto_1_figuras;

import java.util.List;

public class Main {

    // Switch con patrones de record para calcular el area
    public static double area(Figura f) {
        return switch (f) {
            case Circulo c -> Math.PI * c.radio() * c.radio();
            case Rectangulo(double b, double h) -> b * h;
            case Triangulo t -> t.base() * t.altura() / 2.0;
            case Cuadrado c -> c.lado() * c.lado();
        };
    }

    // Switch con patrones de record para calcular el perimetro (solicitado en el Reto 1)
    public static double perimetro(Figura f) {
        return switch (f) {
            case Circulo c -> 2 * Math.PI * c.radio();
            case Rectangulo(double b, double h) -> 2 * (b + h);
            case Triangulo t -> {
                // Para un triangulo isosceles: base + 2 * lado
                double lado = Math.sqrt(Math.pow(t.base() / 2.0, 2) + Math.pow(t.altura(), 2));
                yield t.base() + 2 * lado;
            }
            case Cuadrado c -> 4 * c.lado();
        };
    }

    public static void main(String[] args) {
        System.out.println("=== Reto 1: Figuras con Perimetro y Jerarquia Sellada ===");

        List<Figura> figuras = List.of(
                new Circulo(5),
                new Rectangulo(4, 6),
                new Triangulo(10, 3),
                new Cuadrado(4)
        );

        for (Figura f : figuras) {
            System.out.printf("%-35s | Area = %6.2f | Perimetro = %6.2f%n",
                    f, area(f), perimetro(f));
        }
    }
}
