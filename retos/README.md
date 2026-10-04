# Retos para ir mas alla (Seccion 3.5)

**Asignatura:** Programacion 1  
**Estudiante:** Registro de soluciones a los 5 retos avanzados del capitulo  

En esta carpeta se encuentran desarrollados de forma modular e independiente los cinco retos propuestos al final de la guia de Interfaces y Enums:

---

## Indice de retos resueltos

1. **[Reto 1: Figuras con Perimetro](reto_1_figuras/README.md)**
   - Ampliacion de la jerarquia sellada `Figura` agregando el metodo `perimetro()` con switch de patrones.
   - Incorporacion de `Cuadrado` en la lista `permits` y analisis de la exhaustividad del compilador.

2. **[Reto 2: Baraja Española](reto_2_baraja/README.md)**
   - Modelado de una baraja espanola de 48 cartas con los enums `Palo` y `Valor`, y el record `Carta`.
   - Generacion completa mediante dos ciclos `for` anidados sobre `values()` y mezcla con `Collections.shuffle(...)`.

3. **[Reto 3: Calculadora con Lambdas en el Enum](reto_3_calculadora/README.md)**
   - Reescritura del enum `Operador` usando `DoubleBinaryOperator` y expresiones lambda en el constructor.
   - Incorporacion de `POTENCIA` y `MODULO`.
   - Comparacion y justificacion reflexiva de legibilidad.

4. **[Reto 4: Promociones Combinables](reto_4_promociones/README.md)**
   - Inclusion del metodo default `y(Promocion otra)` en la interfaz funcional `Promocion`.
   - Composicion de descuentos encadenados asegurando con `Math.min(...)` que nunca superen el subtotal.

5. **[Reto 5: Permisos con EnumSet](reto_5_permisos/README.md)**
   - Modelado de permisos (`Permiso`) y roles (`Rol`) utilizando la coleccion especializada `EnumSet`.
   - Metodo `puede(Permiso p)` y comprobacion practica de que el rol `INVITADO` no puede borrar.

---

Cada subcarpeta cuenta con sus respectivos archivos `.java` completamente compilados y un archivo `README.md` con su analisis teorico y salidas de ejecucion.
