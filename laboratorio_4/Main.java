package laboratorio_4;

public class Main {
    public static void main(String[] args) {
        // Creacion y armado del pedido de Camila con encadenamiento de metodos
        Pedido pedido = new Pedido("Camila")
                .agregar(Bebida.CAPUCHINO, Tamano.GRANDE, 2)
                .agregar(Bebida.TINTO, Tamano.PEQUENO, 1)
                .agregar(Bebida.CHOCOLATE, Tamano.MEDIANO, 1);

        // Se aplica un 10% de descuento mediante la interfaz funcional y lambda
        pedido.aplicarPromocion(Promocion.porcentaje(10));

        // Transicion de estados:
        pedido.avanzar(); // RECIBIDO -> EN_PREPARACION
        pedido.avanzar(); // EN_PREPARACION -> LISTO

        // Impresion de la tirilla de pago
        pedido.imprimirTicket();

        // Intento de cancelacion cuando ya esta listo (debe fallar y atrapar la excepcion)
        try {
            pedido.cancelar();
        } catch (IllegalStateException e) {
            System.out.println("Aviso: " + e.getMessage());
        }
    }
}
