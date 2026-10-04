# Reto 5: Control de Permisos con EnumSet

**Asignatura:** Programacion 1  
**Tema:** Colecciones de alto rendimiento (EnumSet) y Modelado de Roles  

---

## 1. Descripcion del reto
El objetivo de este reto fue implementar un sistema de autorizacion y control de acceso basado en roles:
1. Crear el enum `Permiso` con las acciones: `LEER`, `ESCRIBIR`, `BORRAR`, `ADMINISTRAR`.
2. Crear el enum `Rol` (`INVITADO`, `USUARIO`, `MODERADOR`, `ADMINISTRADOR`) donde cada constante encapsula un conjunto `EnumSet<Permiso>`.
3. Implementar el metodo `boolean puede(Permiso p)`.
4. Demostrar y comprobar en el `main` que un usuario con rol `INVITADO` no tiene permiso para `BORRAR`.

---

## 2. Por que usar EnumSet para permisos

Tradicionalmente en programacion se usaban mascaras de bits con enteros (`1`, `2`, `4`, `8`) y operadores a nivel de bits (`&`, `|`) para gestionar permisos, lo cual era dificil de leer y propenso a errores.

En Java, `EnumSet`:
- Ofrece toda la expresividad de la orientacion a objetos (`EnumSet.of(...)`, `contains(...)`).
- Internamente se almacena como un vector de bits compacto (un unico numero `long` para enums de hasta 64 constantes).
- Cada comprobacion con `contains(p)` se resuelve internamente con una operacion bit a bit a maxima velocidad y con consumo de memoria casi nulo.

---

## 3. Salida de ejecucion en consola

```text
=== Reto 5: Permisos con EnumSet ===
INVITADO        Permisos: [LEER]
USUARIO         Permisos: [LEER, ESCRIBIR]
MODERADOR       Permisos: [LEER, ESCRIBIR, BORRAR]
ADMINISTRADOR   Permisos: [LEER, ESCRIBIR, BORRAR, ADMINISTRAR]

Pruebas de autorizacion con el metodo puede(Permiso p):
¿INVITADO puede BORRAR? false
¿INVITADO puede LEER? true
¿USUARIO puede ESCRIBIR? true
¿USUARIO puede BORRAR? false
¿MODERADOR puede BORRAR? true
¿ADMINISTRADOR puede ADMINISTRAR? true
```
