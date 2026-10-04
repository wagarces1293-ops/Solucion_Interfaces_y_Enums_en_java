package retos.reto_5_permisos;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Reto 5: Permisos con EnumSet ===");

        // Listar todos los roles y su conjunto de permisos
        for (Rol r : Rol.values()) {
            System.out.printf("%-15s Permisos: %s%n", r, r.getPermisos());
        }

        System.out.println("\nPruebas de autorizacion con el metodo puede(Permiso p):");

        // Prueba solicitada especificamente en la guia: INVITADO no puede borrar
        boolean invitadoPuedeBorrar = Rol.INVITADO.puede(Permiso.BORRAR);
        System.out.println("¿INVITADO puede BORRAR? " + invitadoPuedeBorrar);

        // Pruebas complementarias para comprobar los demas roles
        System.out.println("¿INVITADO puede LEER? " + Rol.INVITADO.puede(Permiso.LEER));
        System.out.println("¿USUARIO puede ESCRIBIR? " + Rol.USUARIO.puede(Permiso.ESCRIBIR));
        System.out.println("¿USUARIO puede BORRAR? " + Rol.USUARIO.puede(Permiso.BORRAR));
        System.out.println("¿MODERADOR puede BORRAR? " + Rol.MODERADOR.puede(Permiso.BORRAR));
        System.out.println("¿ADMINISTRADOR puede ADMINISTRAR? " + Rol.ADMINISTRADOR.puede(Permiso.ADMINISTRAR));
    }
}
