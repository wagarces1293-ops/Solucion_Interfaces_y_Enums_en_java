# Autoevaluacion del Capitulo: Interfaces y Enums en Java

**Asignatura:** Programacion 1  
**Estudiante:** Taller de repaso y autoevaluacion (Seccion 3.4)  

A continuacion presento el desarrollo de las 10 preguntas de autoevaluacion planteadas en la guia, con la explicacion detallada de cada una redactada con mis propias palabras.

---

### Pregunta 1
**¿Que modificadores tiene implicitamente un metodo abstracto de una interfaz?**  
a) `private abstract`  
b) `public abstract`  
c) `protected`  
d) `static final`  

- **Respuesta correcta:** **b) `public abstract`**
- **Justificacion:** En Java, cualquier metodo declarado sin cuerpo dentro de una interfaz es considerado de forma automatica por el compilador como publico y abstracto (`public abstract`), incluso si omitimos escribir esas dos palabras. No puede ser `private` (a menos que tenga cuerpo desde Java 9), no se permite `protected` en interfaces, y `static final` aplica a constantes pero no a metodos abstractos.
- **Referencia en la guia:** Seccion 1.3 (Anatomia de una interfaz y sus reglas implicitas).

---

### Pregunta 2
**¿Cual linea compila si `Sonoro` es una interfaz y `Perro` la implementa?**  
a) `Sonoro s = new Sonoro();`  
b) `Perro p = new Sonoro();`  
c) `Sonoro s = new Perro();`  
d) Ninguna  

- **Respuesta correcta:** **c) `Sonoro s = new Perro();`**
- **Justificacion:** Las interfaces son tipos abstractos y Java no permite instanciarlas directamente usando `new` (por lo que las opciones a y b dan error de compilacion: `Sonoro is abstract; cannot be instantiated`). Lo correcto es declarar una variable del tipo de la interfaz (`Sonoro`) y asignarle una instancia de una clase concreta que la implemente (`new Perro()`).
- **Referencia en la guia:** Seccion 1.2 (Paso 3: Usa la interfaz como tipo).

---

### Pregunta 3
**Una clase implementa dos interfaces con el mismo metodo `default`. ¿Que ocurre?**  
a) Gana la primera de la lista  
b) Gana la segunda  
c) Error: la clase debe sobrescribirlo  
d) Se ejecutan ambas  

- **Respuesta correcta:** **c) Error: la clase debe sobrescribirlo**
- **Justificacion:** Este es el clasico "problema del diamante". Java no asume preferencias arbitrarias ni adivina cual de los dos metodos default debe usar. El compilador marca error de incompatibilidad y obliga a la clase a sobrescribir el metodo para resolver la ambiguedad (pudiendo elegir una con `Interfaz.super.metodo()` o combinando ambas).
- **Referencia en la guia:** Seccion 1.5 (El problema del diamante).

---

### Pregunta 4
**¿Cual es una interfaz funcional valida para usar con lambda?**  
a) Una con dos metodos abstractos  
b) Una con un metodo abstracto y tres default  
c) Una sin metodos  
d) Una con solo metodos static  

- **Respuesta correcta:** **b) Una con un metodo abstracto y tres default**
- **Justificacion:** Por definicion, una interfaz funcional debe tener **exactamente un metodo abstracto**. La cantidad de metodos `default` o `static` que contenga no afecta su condicion de interfaz funcional, ya que estos ultimos ya tienen cuerpo y no necesitan ser implementados por la lambda. Si tuviera dos abstractos, o ninguno, no podria ser implementada como una lambda.
- **Referencia en la guia:** Seccion 1.6 (Interfaces funcionales y expresiones lambda).

---

### Pregunta 5
**¿Que interfaz de `java.util.function` recibe un valor y no devuelve nada?**  
a) `Supplier`  
b) `Function`  
c) `Consumer`  
d) `Predicate`  

- **Respuesta correcta:** **c) `Consumer`**
- **Justificacion:** 
  - `Consumer<T>` recibe un valor de tipo `T` a traves de su metodo `accept(T t)` y devuelve `void` (se usa para imprimir o guardar datos).
  - `Supplier<T>` no recibe nada y devuelve un valor `T`.
  - `Function<T, R>` recibe un valor `T` y devuelve un valor transformado `R`.
  - `Predicate<T>` recibe un valor `T` y devuelve un `boolean`.
- **Referencia en la guia:** Seccion 1.6 (Las interfaces funcionales que ya trae Java).

---

### Pregunta 6
**¿Que imprime `DiaSemana.MIERCOLES.ordinal()` con el enum del capitulo?**  
a) 3  
b) 2  
c) "MIERCOLES"  
d) Error  

- **Respuesta correcta:** **b) 2**
- **Justificacion:** El metodo `ordinal()` devuelve el indice numerico de la constante en base cero, segun el orden en que fueron listadas en el enum:
  - `LUNES` -> 0
  - `MARTES` -> 1
  - `MIERCOLES` -> 2
  Por tanto, el valor devuelto es 2.
- **Referencia en la guia:** Seccion 2.3 (¿Que hay detras de un enum?).

---

### Pregunta 7
**¿Que lanza `DiaSemana.valueOf("Lunes")`?**  
a) Devuelve `LUNES`  
b) Devuelve `null`  
c) `IllegalArgumentException`  
d) `NullPointerException`  

- **Respuesta correcta:** **c) `IllegalArgumentException`**
- **Justificacion:** El metodo `valueOf(String)` busca una coincidencia exacta de caracteres respetando mayusculas y minusculas. Como la constante fue declarada como `LUNES` en mayusculas completas, al pasarle `"Lunes"` no encuentra la constante y Java lanza inmediatamente una excepcion `IllegalArgumentException`.
- **Referencia en la guia:** Seccion 2.4 (Trampas clasicas).

---

### Pregunta 8
**¿Cual afirmacion sobre el constructor de un enum es correcta?**  
a) Puede ser `public`  
b) Es siempre privado  
c) No existe  
d) Se llama con `new`  

- **Respuesta correcta:** **b) Es siempre privado**
- **Justificacion:** El constructor de un enum no puede ser publico ni protegido (`modifier public not allowed here`), ya que las unicas instancias que deben existir son las declaradas al inicio del enum. Por definicion de Java, el constructor de un enum es siempre privado, se le coloque o no la palabra `private`. Tampoco se puede invocar manualmente con `new`.
- **Referencia en la guia:** Seccion 2.6 (Cuidado: constructor de un enum).

---

### Pregunta 9
**¿Que debes guardar en una base de datos para representar una constante de enum?**  
a) `ordinal()`  
b) `hashCode()`  
c) `name()` o un codigo propio  
d) La referencia al objeto  

- **Respuesta correcta:** **c) `name()` o un codigo propio**
- **Justificacion:** Guardar el `ordinal()` es muy peligroso porque si en el futuro alguien agrega una nueva constante en medio de la lista o cambia el orden de declaracion, todos los indices se desplazan y los datos guardados en la base de datos quedarian corruptos. Por ello se recomienda almacenar el nombre textual (`name()`) o un codigo de negocio propio e inmutable (como el codigo ISO o simbolo).
- **Referencia en la guia:** Seccion 2.4 y Seccion 2.12 (Errores comunes).

---

### Pregunta 10
**Tienes `Tarjeta`, `Nequi` y `Efectivo` sin estado en comun y quieres agregar mas en el futuro. ¿Que usas?**  
a) Un enum  
b) Una interfaz `MetodoPago`  
c) Constantes `int`  
d) Una clase `final`  

- **Respuesta correcta:** **b) Una interfaz `MetodoPago`**
- **Justificacion:** Como no comparten atributos ni codigo en comun (no son una familia con herencia de estado) y se trata de un conjunto abierto que va a seguir creciendo en el futuro con nuevos medios de pago, lo correcto es definir una interfaz que capture la capacidad compartida de cobrar y pagar. Un enum no serviria bien aqui porque un enum representa un conjunto cerrado y fijo, y las clases finales o constantes int no proveen polimorfismo.
- **Referencia en la guia:** Seccion 1.8 y Seccion 3.1 (Arbol de decision).
