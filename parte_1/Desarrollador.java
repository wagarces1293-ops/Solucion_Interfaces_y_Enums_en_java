package parte_1;

public class Desarrollador extends Empleado implements Bonificable {
    public Desarrollador(String nombre, double salarioBase) {
        super(nombre, salarioBase);
    }

    @Override
    public double bono() {
        return salarioBase * 0.15;
    }

    @Override
    public double salarioMensual() {
        return salarioBase + bono();
    }
}
