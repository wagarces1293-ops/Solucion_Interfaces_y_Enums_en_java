package laboratorio_3;

public class Main {
    public static void main(String[] args) {
        Semaforo luz = Semaforo.VERDE;

        // Simulacion de 4 pasos de transicion
        for (int paso = 1; paso <= 4; paso++) {
            System.out.printf("Paso %d: %-8s %2d s → %s%n",
                    paso, luz, luz.getSegundos(), luz.getAccion());
            luz = luz.siguiente();
        }

        // Duracion del ciclo completo sumando todas las luces
        System.out.println("Duración del ciclo completo: " + Semaforo.duracionCiclo() + " s");
    }
}
