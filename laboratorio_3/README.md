# Laboratorio 3: Semaforo Inteligente

**Asignatura:** Programacion 1  
**Tema:** Enums con atributos, metodos y maquinas de transicion de estados  

---

## 1. Descripcion del laboratorio
El objetivo de este laboratorio fue modelar el comportamiento de un semaforo de transito utilizando un `enum`. 

Cada luz no es solo un nombre, sino un objeto con estado propio:
- Duracion de tiempo en segundos (`30`, `5`, `35`).
- Accion vial asociada (`"Avance"`, `"Precaución"`, `"Pare"`).

Ademas, el semaforo cuenta con una transicion ciclica ordenada: `VERDE` -> `AMARILLO` -> `ROJO` -> `VERDE`.

---

## 2. Desarrollo paso a paso

1. **Declaracion del Enum con Atributos:**
   - Se crearon las tres constantes: `VERDE(30, "Avance")`, `AMARILLO(5, "Precaución")`, `ROJO(35, "Pare")`.
   - Se declararon dos atributos inmutables: `private final int segundos` y `private final String accion`.
   - Constructor con visibilidad privada por defecto.
   - Metodos getters: `getSegundos()` y `getAccion()`.

2. **Transicion de Estados con Switch (`siguiente()`):**
   - Se utilizo una expresion `switch (this)` moderna con flechas (`->`).
   - Define explicitamente hacia que luz debe avanzar cada estado.

3. **Metodo estatico de acumulacion (`duracionCiclo()`):**
   - Itera sobre todas las constantes del enum usando `Semaforo.values()`.
   - Acumula la cantidad de segundos de cada luz para obtener el tiempo total de un ciclo completo (30 + 5 + 35 = 70 segundos).

4. **Simulacion en el `main`:**
   - Iniciamos en luz `VERDE`.
   - Con un ciclo `for` de 1 a 4, imprimimos el paso actual, el nombre de la luz, los segundos y la accion, y luego actualizamos la variable con `luz = luz.siguiente()`.
   - Finalmente imprimimos la duracion total del ciclo.

---

## 3. Analisis: ¿Por que usar `switch` y no aritmetica de ordinales?

En el cuadro informativo del capitulo se menciona que podriamos haber escrito:
```java
public Semaforo siguiente() {
    return values()[(ordinal() + 1) % values().length];
}
```
Aunque esa formula matematica de una linea funciona para rotar circularmente por los indices, tiene una desventaja grave de diseño:
- Depende ciegamente del orden fisico en que fueron escritas las constantes. Si un companero de equipo reordena las constantes en el codigo (por ejemplo, pone primero `ROJO`), el semaforo pasaria de rojo a verde sin avisar a nadie.
- En cambio, con la expresion `switch`, la transicion entre estados queda escrita de manera explicita y autodocumentada.

---

## 4. Reto extra: ¿Que pasa si agregamos `AMARILLO_INTERMITENTE`?

Si agregamos una cuarta constante al enum:
```java
AMARILLO_INTERMITENTE(0, "Cruce con precaución")
```
Al intentar compilar, el compilador de Java emite de inmediato el siguiente error:
```text
Semaforo.java: error: the switch expression does not cover all possible input values
        return switch (this) {
               ^
```
**Explicacion tecnica del estudiante:**
Este error demuestra la ventaja fundamental de la exhaustividad en Java. Al usar `switch` sobre un enum sin clausula `default`, el compilador revisa que hayamos previsto que pasa con cada una de las constantes existentes. Al agregar una constante nueva, el compilador nos exige de inmediato que actualicemos la logica de `siguiente()` para definir hacia donde debe transicionar la nueva luz. Esto evita por completo errores silenciosos en ejecucion.

---

## 5. Salida del programa en consola

```text
Paso 1: VERDE    30 s → Avance
Paso 2: AMARILLO  5 s → Precaución
Paso 3: ROJO     35 s → Pare
Paso 4: VERDE    30 s → Avance
Duración del ciclo completo: 70 s
```
