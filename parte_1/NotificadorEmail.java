package parte_1;

public class NotificadorEmail implements Notificador {
    @Override
    public void enviar(String mensaje) {
        System.out.println("Email → " + mensaje);
    }
    // No sobrescribe enviarUrgente: usa el metodo default de la interfaz
}
