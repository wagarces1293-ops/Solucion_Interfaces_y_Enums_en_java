# Parte 1: Interfaces - El Contrato de tus Clases

Apuntes de clase y solucion a los puntos de control de la primera parte del modulo de Programacion 1.

---

## 1. Conceptos fundamentales aprendidos

### ¿Que es una interfaz?
En clase vimos la metafora del tomacorriente de la pared: a la toma de corriente no le importa si enchufas una lampara, un ventilador o un cargador; la toma solo exige que el aparato tenga clavijas compatibles. 

En Java, una interfaz es exactamente eso: un contrato formal. Define **que** metodos debe ofrecer una clase, pero no le importa **como** lo hace por dentro. 

### Bajo acoplamiento
Cuando programamos contra una interfaz en lugar de una clase concreta, nuestro codigo queda desacoplado. Por ejemplo, si tenemos una lista de objetos que implementan `Sonoro`, podemos recorrerla y llamar a `hacerSonido()` sin necesidad de preguntar si es un `Perro`, un `Gato` o una `Vaca`. Si el dia de manana agregamos la clase `Pato`, el codigo que recorre la granja no necesita modificarse en absoluto.

---

## 2. Experimentos de error (Paso 4 de la guia)

Para entender bien como funciona el compilador de Java, hicimos los dos experimentos sugeridos:

1. **Borrar el metodo `hacerSonido()` en la clase `Gato`:**
   El compilador arroja el siguiente error:
   `Gato is not abstract and does not override abstract method hacerSonido() in Sonoro`
   *Explicacion:* Al escribir `implements Sonoro`, la clase `Gato` firmo un contrato donde prometia darle cuerpo al metodo abstracto. Si no lo escribe, incumple el contrato y Java no deja compilar a menos que declaremos la clase como abstracta.

2. **Intentar instanciar directamente la interfaz: `Sonoro s = new Sonoro();`:**
   El compilador arroja el siguiente error:
   `Sonoro is abstract; cannot be instantiated`
   *Explicacion:* Una interfaz no es una plantilla completa de un objeto, solo contiene especificaciones. No existe codigo en memoria para ejecutar un objeto "Sonoro" por si solo; forzosamente necesitamos una clase concreta que lo implemente.

---

## 3. Respuestas a los Puntos de Control

### Punto de Control 1 (Secciones 1.2 y 1.3 - Pagina 4)

1. **¿Que palabra clave usa una clase para "firmar" una interfaz?**
   - **Respuesta:** Se utiliza la palabra clave `implements`.
   - *Nota personal:* Si fuera herencia de otra clase usariamos `extends`, pero con interfaces es `implements` porque nos comprometemos a implementar los metodos.

2. **¿Por qué el metodo de una interfaz termina en `;` y no tiene llaves?**
   - **Respuesta:** Porque un metodo abstracto de una interfaz solo declara la firma (nombre, parametros y tipo de retorno). No lleva llaves `{}` porque no tiene implementacion ni cuerpo de codigo; cada clase que lo implemente es la encargada de escribir el bloque de codigo.

3. **¿Es valido escribir `Sonoro s = new Sonoro();`? ¿Por que?**
   - **Respuesta:** No es valido.
   - *Explicacion:* Las interfaces son tipos abstractos por definicion y no pueden ser instanciadas con el operador `new`. Solo se pueden usar como tipo de referencia para guardar objetos de clases concretas que implementen la interfaz (por ejemplo, `Sonoro s = new Perro();`).

---

### Punto de Control 2 (Seccion 1.4 - Pagina 8)

1. **¿Cuantas clases puede extender una clase? ¿Cuantas interfaces puede implementar?**
   - **Respuesta:** Una clase solo puede heredar de **una sola clase** (Java no admite herencia multiple de clases con `extends`). Sin embargo, una clase puede implementar **todas las interfaces que necesite** separandolas por comas (por ejemplo: `class Pato implements Volador, Nadador`).

2. **Si `Volador v = new Pato();`, ¿puedes escribir `v.nadar()`?**
   - **Respuesta:** No, el compilador no lo permite.
   - *Explicacion:* Aunque en la memoria el objeto real es un `Pato` (tipo real), la variable fue declarada como `Volador` (tipo declarado). El compilador solo revisa los metodos que existen dentro del contrato `Volador`, y en ese contrato unicamente existe `volar()`. Para poder llamar a `nadar()`, necesitariamos declarar la variable como `Pato`, o verificar con `if (v instanceof Pato p)` para usarlo a traves de la variable del tipo real.

3. **¿Que modificadores tiene implicitamente `int LIMITE = 5;` dentro de una interfaz?**
   - **Respuesta:** Tiene implicitamente los modificadores `public static final`.
   - *Explicacion:* Toda variable declarada en una interfaz se convierte de manera automatica en una constante accesible por todos (`public`), compartida por la interfaz (`static`) y cuyo valor no puede ser modificado (`final`).

---

### Punto de Control 3 (Seccion 1.6 - Pagina 13)

1. **¿Cuantos metodos abstractos tiene una interfaz funcional?**
   - **Respuesta:** Exactamente **uno**. Puede tener todos los metodos `default` o `static` que quiera, pero solo puede tener un unico metodo abstracto. Por eso se pueden representar de forma concisa mediante expresiones lambda.

2. **Reescribe como lambda: una `Function<Integer, Integer>` que devuelva el cuadrado.**
   - **Respuesta:**
     ```java
     Function<Integer, Integer> cuadrado = n -> n * n;
     ```

3. **¿Que interfaz de `java.util.function` usarias para "¿el numero es positivo?"?**
   - **Respuesta:** Usaria `Predicate<Integer>`.
   - *Explicacion:* `Predicate<T>` es la interfaz funcional diseñada para evaluaciones de verdadero o falso; recibe un argumento de tipo `T` y su metodo `test()` devuelve un valor primitivo `boolean`.

---

### Punto de Control 4 (Secciones 1.8 a 1.10 - Pagina 19)

1. **¿Que devuelve `compareTo` si el objeto actual debe ir despues del otro?**
   - **Respuesta:** Devuelve un numero entero positivo (mayor que 0). Si debiera ir antes devolveria un numero negativo, y si son iguales devolveria 0.

2. **Tienes `Ave`, `Avion` y `Superheroe`. ¿Clase abstracta o interfaz para "volar"? ¿Por que?**
   - **Respuesta:** Se debe usar una **interfaz** (por ejemplo, `Volador`).
   - *Explicacion:* Un ave, un avion y un superheroe no pertenecen a la misma familia genealogica ("es un"); un avion es una maquina, un ave es un animal y un superheroe es una persona. No comparten atributos comunes ni codigo base, pero si comparten una habilidad o capacidad comun: pueden volar ("puede hacer").

3. **¿Que ventaja da `sealed` al usar `switch`?**
   - **Respuesta:** Garantiza la exhaustividad del analisis en tiempo de compilacion. Al definir una interfaz sellada con la clausula `permits`, el compilador sabe exactamente que clases pueden implementarla. Por lo tanto, en una expresion `switch`, el compilador verifica que estemos cubriendo todos los casos posibles y no nos exige colocar una clausula `default`. Ademas, si manana agregamos una nueva subclase permitida, el switch dejara de compilar inmediatamente, avisandonos donde falta agregarla.

---

## 4. Notas sobre temas especiales

### El problema del diamante con metodos default
Si una clase implementa dos interfaces distintas (`Cantante` y `Bailarin`) y ambas ofrecen una implementacion `default` con el mismo nombre y firma (`presentarse()`), Java detecta un conflicto de ambiguedad y rehusa compilar. Para solucionarlo, la clase implementadora debe sobrescribir obligatoriamente el metodo y decidir cual llamar explicitamente usando la sintaxis `NombreInterfaz.super.metodo()`, o bien combinar ambas respuestas como hicimos en `Artista.java`.

### Metodos default, static y private en interfaces
- **`default` (Java 8):** Permite agregar metodos con cuerpo a una interfaz sin romper las clases ya existentes que la implementaban.
- **`static` (Java 8):** Metodos de utilidad asociados a la interfaz, no a las instancias. Se llaman como `NombreInterfaz.metodo()`.
- **`private` (Java 9):** Metodos auxiliares internos con cuerpo dentro de la interfaz para no repetir codigo entre metodos default. No son visibles fuera de la interfaz.

### Antipatron: Interfaz de constantes
No debemos crear interfaces vacias que contengan unicamente constantes numericas o textos solo para que nuestras clases las implementen y ahorrarnos escribir el prefijo. Eso rompe la semantica de tipos orientada a objetos (por ejemplo, decir que una Factura "es" ConstantesContables). Las constantes en una interfaz solo tienen sentido si son parte integral del contrato del comportamiento que se modela.
