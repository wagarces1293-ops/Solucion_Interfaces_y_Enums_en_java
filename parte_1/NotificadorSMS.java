package parte_1;

public class NotificadorSMS implements Notificador {
    @Override
    public void enviar(String mensaje) {
        System.out.println("SMS → " + mensaje);
    }

    // Sobrescribe el metodo default para personalizarlo
    @Override
    public void enviarUrgente(String mensaje) {
        enviar("!!! " + mensaje + " (responde SI)");
    }
}
