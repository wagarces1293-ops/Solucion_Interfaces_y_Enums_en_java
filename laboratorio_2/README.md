# Laboratorio 2: Pasarela de Pagos

**Asignatura:** Programacion 1  
**Tema:** Diseño de contratos, metodos default y polimorfismo  

---

## 1. Descripcion del laboratorio
El objetivo de este laboratorio fue diseñar e implementar una pasarela de pagos desacoplada para una tienda en linea. 

El requerimiento central de diseño es que la caja registradora (`Caja`) no debe conocer los detalles internos de como cobra cada medio de pago ni que medio esta utilizando el cliente. La caja solo le pide al objeto que se cobre a si mismo mediante el contrato `MetodoPago`.

---

## 2. Estructura de la solucion

1. **Interfaz `MetodoPago`:**
   - Define los metodos abstractos `nombre()` y `pagar(double monto)`.
   - Incorpora el metodo default `comision(double monto)` que retorna `0` por defecto.
   - Incorpora el metodo default `totalACobrar(double monto)` que suma `monto + comision(monto)`.

2. **Implementaciones:**
   - **`TarjetaCredito`:** tiene un atributo `cupoDisponible`. Sobrescribe `comision` para calcular el 3% (`monto * 0.03`). En `pagar()`, calcula el total sumando la comision; si supera el cupo retorna `false`, y si alcanza, descuenta el total del cupo y retorna `true`.
   - **`BilleteraDigital`:** tiene un atributo `saldo`. No cobra comision (usa el default). Si el monto supera el saldo retorna `false`; si alcanza, descuenta y retorna `true`.
   - **`Efectivo`:** no cobra comision y siempre retorna `true` en `pagar()`.
   - **`Criptomoneda`:** clase extra agregada en el paso 6 para demostrar polimorfismo. Maneja saldo de criptomonedas y aplica una comision de red del 1%.

3. **Clase `Caja`:**
   - Contiene el metodo estatico `cobrar(MetodoPago m, double monto)`.
   - No contiene ningun condicional tipo `if (m instanceof TarjetaCredito)`. Simplemente invoca `m.pagar(monto)` y lee `m.nombre()` y `m.comision(monto)`.

---

## 3. Analisis del caso 4 (Tarjeta con cupo 100.000 y monto 99.000)

En la prueba 4, intentamos cobrar $99.000 con una tarjeta de cupo $100.000.
A primera vista pareceria que si alcanza porque 99.000 es menor que 100.000. Sin embargo:
- La comision del 3% sobre 99.000 es: $2.970.
- El total real a cobrar es: $99.000 + $2.970 = $101.970.
- Como $101.970 supera el cupo de $100.000, la transaccion es correctamente RECHAZADA.

---

## 4. El verdadero poder del polimorfismo

En el paso 6 creamos la clase `Criptomoneda`. Pudimos pasarle una instancia de `Criptomoneda` al metodo `Caja.cobrar(...)` y funciono inmediatamente sin tener que alterar ni una sola linea del codigo de la clase `Caja`. Esto demuestra el principio de bajo acoplamiento: el sistema esta abierto a nuevos medios de pago sin requerir modificar los componentes existentes.

---

## 5. Salida del programa en consola

```text
Tarjeta de crédito   $   120.000 comisión $  3.600 APROBADO
Billetera digital    $    80.000 comisión $      0 RECHAZADO
Efectivo             $    35.000 comisión $      0 APROBADO
Tarjeta de crédito   $    99.000 comisión $  2.970 RECHAZADO

--- Prueba del quinto metodo (Criptomoneda) ---
Criptomoneda         $   150.000 comisión $  1.500 APROBADO
```
