# Reto 3: Calculadora con Lambdas en el Enum

**Asignatura:** Programacion 1  
**Tema:** Enums con Lambdas y la interfaz DoubleBinaryOperator  

---

## 1. Descripcion del reto
En la seccion 2.7 habiamos implementado el enum `Operador` usando un metodo abstracto y sobreescribiendo el cuerpo de cada constante de manera individual.

En este reto se pide:
1. Reimplementar `Operador` guardando una instancia de la interfaz funcional `DoubleBinaryOperator` como atributo privado final.
2. Pasar una expresion lambda directamente en el constructor de cada constante.
3. Agregar dos nuevas operaciones: `POTENCIA` (usando `Math::pow`) y `MODULO` (residuo con `%`).
4. Responder a la pregunta reflexiva: *¿Que version te parece mas legible y por que?*

---

## 2. Analisis comparativo: ¿Cual version es mas legible?

### Comparacion entre ambos enfoques

- **Version 1 (Metodo abstracto con cuerpo por constante - Seccion 2.7):**
  - Cada constante declara su propio bloque `{ public double aplicar(...) { ... } }`.
  - **Ventaja:** Muy clara cuando la logica tiene multiples lineas, condiciones complejas o manejo de excepciones, porque no recarga la lista de argumentos del constructor.
  - **Desventaja:** Mucho codigo repetitivo ("boilerplate"); se debe repetir la firma completa del metodo en cada una de las constantes.

- **Version 2 (Atributo `DoubleBinaryOperator` con lambdas - Reto 3):**
  - Cada constante pasa una funcion corta en una linea: `SUMA("+", (a, b) -> a + b)`, o incluso una referencia a metodo: `POTENCIA("^", Math::pow)`.
  - **Ventaja:** Mucho mas compacta, limpia y declarativa. Se lee directamente la relacion entre el operador y su calculo matematico sin ruido sintactico.
  - **Desventaja:** Si una operacion requiere varias sentencias (como verificar division por cero con `if`), la lambda dentro de los parentesis del constructor puede volverse un poco mas densa de leer.

### Conclusion del estudiante
Para una calculadora o conjunto de operaciones matematicas simples, **la version con lambdas y `DoubleBinaryOperator` me parece notablemente mas legible**. Permite ver todas las operaciones de un solo vistazo en pocas lineas de codigo, y aprovechar referencias a metodos existentes del JDK como `Math::pow`.

---

## 3. Salida de ejecucion en consola

```text
=== Reto 3: Calculadora con Lambdas en el Enum ===
12 + 4 = 16,00
12 - 4 = 8,00
12 × 4 = 48,00
12 ÷ 4 = 3,00
12 ^ 4 = 20736,00
12 % 4 = 0,00

Prueba de potencia extra:
2 ^ 10 = 1024

Prueba de control de division por cero:
Excepción capturada: división por cero
```
