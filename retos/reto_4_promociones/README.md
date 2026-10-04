# Reto 4: Promociones Combinables

**Asignatura:** Programacion 1  
**Tema:** Metodos default en Interfaces Funcionales y Composicion  

---

## 1. Descripcion del reto
El objetivo de este reto fue ampliar la interfaz funcional `Promocion` agregando un metodo default:
```java
default Promocion y(Promocion otra)
```
Este metodo permite combinar dos promociones cualesquiera, sumando sus respectivos descuentos pero garantizando con `Math.min(...)` que el descuento total resultante nunca exceda el monto del subtotal.

---

## 2. Analisis de diseño

En Java, muchas interfaces funcionales estandar del JDK incluyen metodos `default` de composicion:
- `Predicate` incluye `and(...)`, `or(...)` y `negate()`.
- `Consumer` incluye `andThen(...)`.
- `Function` incluye `andThen(...)` y `compose(...)`.

Seguimos exactamente ese patron de diseño profesional: el metodo `y(...)` no calcula el descuento directamente, sino que **retorna una nueva lambda** `subtotal -> { ... }` que evalua la promocion actual (`this.descuento(subtotal)`), la otra promocion (`otra.descuento(subtotal)`) y las combina protegiendo el valor con `Math.min(subtotal, d1 + d2)`.

---

## 3. Pruebas realizadas

1. **Prueba solicitada en la guia:**
   `Promocion.porcentaje(10).y(Promocion.fijaDesde(20_000, 1_000))`
   - Con un subtotal de **$25.000**:
     - 10% = $2.500
     - Fija (25.000 >= 20.000) = $1.000
     - Descuento total = $3.500 (Total a pagar = $21.500).
   - Con un subtotal de **$15.000**:
     - 10% = $1.500
     - Fija (15.000 < 20.000) = $0
     - Descuento total = $1.500 (Total a pagar = $13.500).

2. **Prueba de seguridad (descuento excesivo):**
   Combinamos 80% con 40% (teorico 120%) sobre $10.000. El metodo limita el descuento a $10.000 impidiendo saldos negativos.

---

## 4. Salida de ejecucion en consola

```text
=== Reto 4: Promociones Combinables ===
Subtotal: $  25.000 | Descuento: $   3.500 | Total: $  21.500
Subtotal: $  15.000 | Descuento: $   1.500 | Total: $  13.500

Prueba de tope maximo (descuento no supera subtotal):
Subtotal: $  10.000 | Descuento limitado: $  10.000 | Total: $       0
```
