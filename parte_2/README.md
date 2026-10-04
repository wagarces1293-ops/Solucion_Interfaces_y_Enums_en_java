# Parte 2: Enums - Constantes con Superpoderes

Apuntes de clase y solucion a los puntos de control de la segunda parte del modulo de Programacion 1.

---

## 1. Conceptos fundamentales aprendidos

### El problema de los numeros y textos "magicos"
Antes de conocer los enums, para representar cosas como los dias de la semana o estados de un pedido soliamos usar enteros (`1 = LUNES`, `2 = MARTES`) o cadenas de texto (`"LUNES"`, `"ENVIADO"`). Esto tenia dos problemas graves:
1. **Con enteros:** Nada impedia pasar un numero absurdo como `42` o mezclar conceptos pasando un mes como enero (`1`) a una funcion que esperaba un dia.
2. **Con cadenas:** Cualquier error de digitacion (por ejemplo, escribir `"lunes"` en minuscula o `"Lunes "` con espacio) provocaba errores silenciosos en ejecucion.

### ¿Que es un enum en Java?
Un `enum` define un conjunto cerrado, fijo y seguro de constantes con nombre. Pero en Java no son simples enteros como en C: **un enum es una clase completa**. 
Cada constante declarada es una instancia unica (un objeto) creada de forma estatica en memoria cuando el programa arranca. Por eso podemos comparar con `==` con total seguridad y rapidez.

---

## 2. Metodos incluidos en todo Enum

Todo enum en Java hereda de forma automatica de la clase `java.lang.Enum`, por lo que incorpora los siguientes metodos:
- `values()`: Devuelve un arreglo con todas las constantes en el orden exacto en que fueron declaradas.
- `valueOf(String)`: Convierte un texto con el nombre exacto de la constante a su referencia correspondiente. Es sensible a mayusculas y lanza `IllegalArgumentException` si no existe.
- `name()`: Devuelve el nombre de la constante tal cual se declaro (como String).
- `ordinal()`: Devuelve la posicion numerica (indice base cero) de la constante segun el orden de declaracion.
- `compareTo(otro)`: Compara dos constantes segun su posicion (`ordinal`). Devuelve negativo si va antes, cero si es la misma, y positivo si va despues.

---

## 3. Respuestas a los Puntos de Control

### Punto de Control (Seccion 2.5 - Pagina 23)

1. **¿Por que es seguro comparar enums con `==` en lugar de `equals`?**
   - **Respuesta:** Porque cada constante de un enum existe exactamente una sola vez en la memoria durante la ejecucion de la aplicacion (patron singleton por constante). Al haber una unica instancia de cada valor, la comparacion de direcciones de memoria con `==` es 100% segura, mas rapida y ademas nos protege de posibles errores `NullPointerException`.

2. **¿Que imprime `DiaSemana.DOMINGO.ordinal()`?**
   - **Respuesta:** Imprime el numero entero `6`.
   - *Explicacion:* Los indices en `ordinal()` empiezan a contar desde `0`. Como los dias se declararon como:
     - `LUNES` = 0
     - `MARTES` = 1
     - `MIERCOLES` = 2
     - `JUEVES` = 3
     - `VIERNES` = 4
     - `SABADO` = 5
     - `DOMINGO` = 6
     El ordinal de `DOMINGO` es 6.

3. **¿Que pasa si en una expresion switch sobre `DiaSemana` olvidas el caso `JUEVES` y no hay default?**
   - **Respuesta:** El codigo **no compila**.
   - *Explicacion:* El compilador de Java realiza una comprobacion de exhaustividad en las expresiones `switch`. Al detectar que falta una de las constantes del conjunto cerrado y no existir una clausula `default`, genera el error de compilacion: `the switch expression does not cover all possible input values`.

---

### Punto de Control (Seccion 2.12 - Pagina 29)

1. **¿En que orden deben ir las constantes y los atributos dentro de un enum?**
   - **Respuesta:** Las constantes del enum deben ir obligatoriamente de **primeras**, separadas por comas. Si el enum contiene atributos, constructores o metodos, la lista de constantes debe terminar obligatoriamente con un punto y coma (`;`). Luego se declaran los atributos (preferiblemente `private final`), seguidos del constructor (implícitamente privado) y finalmente los metodos.

2. **¿Puede un enum usar `extends`? ¿Y `implements`?**
   - **Respuesta:**
     - **`extends` NO puede usarlo:** porque todo enum ya hereda implicitamente de la clase `java.lang.Enum`, y Java no admite herencia multiple de clases.
     - **`implements` SI puede usarlo:** un enum puede implementar tantas interfaces como necesite, cumpliendo sus contratos como cualquier otra clase.

3. **¿Por que `EnumMap` imprime las claves en orden de la semana?**
   - **Respuesta:** Porque `EnumMap` es una coleccion altamente especializada que internamente no utiliza tablas hash tradicionales, sino un arreglo indexado por el `ordinal()` de las constantes del enum. Al iterar sobre el mapa, siempre recorre las claves en su orden natural de declaracion en el enum, sin importar el orden en que hayamos hecho los llamados a `put()`.

---

## 4. Patrones y estructuras avanzadas con Enums

### Enums con atributos y metodos propios (`Moneda`)
En el archivo `Moneda.java` vimos como cada constante (`COP`, `USD`, `EUR`, `MXN`) llama a su constructor enviando el nombre legible, el simbolo de moneda y la tasa de cambio en pesos. Ademas, incluimos un metodo estatico de busqueda `desdeSimbolo(...)` para encontrar la constante a partir de su simbolo, lo cual es mucho mas robusto que usar el `ordinal()`.

### Comportamiento polimorfico por constante (`Operador`)
En lugar de escribir un `switch` gigantesco dentro de un metodo, el enum `Operador` declara un metodo abstracto `aplicar(double a, double b)`. Cada constante (`SUMA`, `RESTA`, `MULTIPLICACION`, `DIVISION`) proporciona su propio cuerpo de codigo con llaves `{}`. Si agregamos una nueva constante, el compilador nos obligara a darle implementacion a ese metodo.

### Maquinas de estado finitas (`EstadoPedido`)
Modelamos el ciclo de vida de un pedido comercial (`RECIBIDO` -> `EN_PREPARACION` -> `LISTO` -> `ENTREGADO`). 
- Las transiciones validas se gestionan con un `switch` en el metodo `siguiente()`.
- Se valida si un estado permite cancelacion con `puedeCancelarse()`.
- Cualquier transicion o cancelacion invalida (como cancelar un pedido cuando ya esta `LISTO`) lanza de inmediato una excepcion explicativa `IllegalStateException`.

### Colecciones especializadas: `EnumSet` y `EnumMap`
- `EnumSet`: Representa internamente un vector de bits (un bit por constante). Operaciones como `contains()` se resuelven a nivel de instrucciones de bits de la CPU, siendo muchisimo mas rapidas y ligeras que un `HashSet`.
- `EnumMap`: Mapea constantes de enum a valores usando un arreglo compacto indexado por ordinal.

### Patron Singleton con Enum (`Configuracion`)
La forma mas recomendada en Java para crear un Singleton (un unico objeto en toda la aplicacion) es mediante un enum con una sola constante (`INSTANCIA`). La maquina virtual de Java garantiza que solo se creara una vez, incluso frente a concurrencia o serializacion.
