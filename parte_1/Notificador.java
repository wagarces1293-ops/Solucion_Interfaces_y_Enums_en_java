package parte_1;

public interface Notificador {
    // Metodo abstracto: cada clase debe implementar como enviar
    void enviar(String mensaje);

    // Metodo default: ya viene con implementacion por defecto desde Java 8
    default void enviarUrgente(String mensaje) {
        enviar("[URGENTE] " + mensaje.toUpperCase());
    }
}
