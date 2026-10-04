package retos.reto_5_permisos;

import java.util.EnumSet;

public enum Rol {
    INVITADO(EnumSet.of(Permiso.LEER)),
    USUARIO(EnumSet.of(Permiso.LEER, Permiso.ESCRIBIR)),
    MODERADOR(EnumSet.of(Permiso.LEER, Permiso.ESCRIBIR, Permiso.BORRAR)),
    ADMINISTRADOR(EnumSet.allOf(Permiso.class));

    private final EnumSet<Permiso> permisos;

    Rol(EnumSet<Permiso> permisos) {
        this.permisos = permisos;
    }

    public EnumSet<Permiso> getPermisos() {
        return permisos;
    }

    // Verifica si el rol posee un permiso especifico utilizando contains de EnumSet
    public boolean puede(Permiso p) {
        return permisos.contains(p);
    }
}
