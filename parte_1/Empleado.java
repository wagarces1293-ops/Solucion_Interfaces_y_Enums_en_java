package parte_1;

// Clase abstracta: representa una relacion "es un" (familia) y comparte estado
public abstract class Empleado {
    protected final String nombre;
    protected final double salarioBase;

    protected Empleado(String nombre, double salarioBase) {
        this.nombre = nombre;
        this.salarioBase = salarioBase;
    }

    public abstract double salarioMensual();

    public String resumen() {
        return String.format("%-7s $%,.0f", nombre, salarioMensual());
    }
}
