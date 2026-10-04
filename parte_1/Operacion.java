package parte_1;

@FunctionalInterface
public interface Operacion {
    // Un unico metodo abstracto para poder ser usada como lambda
    int aplicar(int a, int b);
}
