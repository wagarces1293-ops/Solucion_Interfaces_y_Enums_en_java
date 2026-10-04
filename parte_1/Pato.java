package parte_1;

// Un pato puede implementar varias interfaces: vuela y nada
public class Pato implements Volador, Nadador {
    @Override
    public void volar() {
        System.out.println("Pato: aleteo sobre el lago");
    }

    @Override
    public void nadar() {
        System.out.println("Pato: remo con mis patas");
    }
}
