package parte_1;

// Interfaz sellada: solo las clases autorizadas en permits pueden implementarla
public sealed interface Figura permits Circulo, Rectangulo, Triangulo {
}
