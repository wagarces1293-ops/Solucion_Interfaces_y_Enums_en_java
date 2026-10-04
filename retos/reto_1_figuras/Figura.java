package retos.reto_1_figuras;

// Interfaz sellada con lista permits ampliada para incluir Cuadrado
public sealed interface Figura permits Circulo, Rectangulo, Triangulo, Cuadrado {
}
