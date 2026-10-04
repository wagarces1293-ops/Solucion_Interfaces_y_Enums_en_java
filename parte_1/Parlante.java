package parte_1;

public class Parlante implements DispositivoInteligente {
    @Override
    public void encender() {
        System.out.println("Parlante encendido");
    }

    @Override
    public void apagar() {
        System.out.println("Parlante apagado");
    }

    @Override
    public void conectarWifi(String red) {
        System.out.println("Conectado a " + red);
    }

    @Override
    public String asistente() {
        return "Asistente listo para escuchar";
    }
}
