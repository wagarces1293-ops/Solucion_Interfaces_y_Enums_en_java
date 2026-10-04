# Reto 1: Figuras con Perimetro y Jerarquia Sellada

**Asignatura:** Programacion 1  
**Tema:** Sealed Interfaces, Records y Pattern Matching en Switch  

---

## 1. Descripcion del reto
El reto consiste en:
1. Tomar la jerarquia sellada `Figura` vista en la seccion 1.9.
2. Implementar un metodo `perimetro(Figura f)` utilizando expresiones `switch` con patrones de desestructuracion de records (`case Rectangulo(double b, double h)`, etc.).
3. Agregar la figura `Cuadrado` a la lista `permits` de la interfaz sellada.
4. Observar que partes del codigo nos obliga a actualizar el compilador.

---

## 2. Analisis del compilador al agregar `Cuadrado`

Al agregar `Cuadrado` a la clausula `permits` de `Figura`:
```java
public sealed interface Figura permits Circulo, Rectangulo, Triangulo, Cuadrado {}
```
Si intentamos compilar sin haber actualizado los metodos `area()` y `perimetro()`, el compilador se queja inmediatamente en cada `switch`:
```text
Main.java: error: the switch expression does not cover all possible input values
        return switch (f) {
               ^
```

**Explicacion:**
Dado que la interfaz es sellada (`sealed`), el compilador conoce con exactitud absoluta todas las clases autorizadas para implementarla. Al no existir una clausula `default` en el `switch`, el compilador nos exige cubrir `Cuadrado` de manera obligatoria en todas las funciones que evaluan una `Figura`. Esto garantiza que nunca olvidemos actualizar una parte del programa cuando la jerarquia crece.

---

## 3. Salida de ejecucion

```text
=== Reto 1: Figuras con Perimetro y Jerarquia Sellada ===
Circulo[radio=5.0]                  | Area =  78,54 | Perimetro =  31,42
Rectangulo[base=4.0, altura=6.0]    | Area =  24,00 | Perimetro =  20,00
Triangulo[base=10.0, altura=3.0]    | Area =  15,00 | Perimetro =  21,66
Cuadrado[lado=4.0]                  | Area =  16,00 | Perimetro =  16,00
```
