package parte_1;

public class Practicante extends Empleado {
    public Practicante(String nombre, double salarioBase) {
        super(nombre, salarioBase);
    }

    @Override
    public double salarioMensual() {
        return salarioBase;
    }
}
