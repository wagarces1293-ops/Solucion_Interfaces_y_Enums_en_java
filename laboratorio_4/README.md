# Laboratorio 4: Cafeteria "El Algoritmo" (Proyecto Integrador)

**Asignatura:** Programacion 1  
**Tema:** Integracion completa de Enums, Records, Interfaces Funcionales, Lambdas y Clases  

---

## 1. Descripcion del proyecto
Este laboratorio integrador une todos los conceptos aprendidos a lo largo de la guia para construir un sistema de gestion de pedidos para una cafeteria.

El sistema modela:
- Un menu cerrado de bebidas y tamanos.
- Reglas de negocio dinamicas para promociones y descuentos.
- Ciclo de vida y transiciones del pedido con validacion de cancelacion.
- Generacion de ticket con detalle de cobro.

---

## 2. Decisiones de diseño y arquitectura

En la guia se explica que cada herramienta de Java tiene su proposito ideal:
1. **`Bebida` y `Tamano` como `enum`:**
   - Representan conjuntos cerrados y conocidos de valores. No admiten valores extraños y cada uno asocia su precio base o recargo fijo.
2. **`EstadoPedido` como `enum` (maquina de estados):**
   - Asegura que el pedido solo pase por secuencias validas de transicion (`RECIBIDO` -> `EN_PREPARACION` -> `LISTO` -> `ENTREGADO`). Controla de forma centralizada si un pedido puede ser cancelado o no.
3. **`Promocion` como interfaz funcional (`@FunctionalInterface`):**
   - El calculo de descuentos cambia constantemente en un negocio. Al definir una interfaz funcional, podemos implementar cualquier promocion con una simple expresion lambda sin tener que tocar la clase `Pedido`. Los metodos estaticos de fabrica (`ninguna`, `porcentaje`, `fijaDesde`) facilitan su creacion inmediata.
4. **`Item` como `record`:**
   - Un item dentro de una comanda es inmutable (lleva la bebida, tamano y cantidad). El record nos da automaticamente constructor, getters compactos (`bebida()`, `tamano()`, `cantidad()`), equals y toString en una sola linea de definicion, agregando el metodo `subtotal()`.
5. **`Pedido` como clase convencional:**
   - Un pedido tiene un ciclo de vida con estado mutable que evoluciona en el tiempo (se agregan items, cambia de estado, se le aplica promocion). Por eso debe ser una clase normal.

---

## 3. Desglose del caso de prueba (Pedido de Camila)

1. **Items agregados:**
   - 2 Capuchinos Grandes: precio base $6.000 + recargo $2.000 = $8.000 x 2 = **$16.000**.
   - 1 Tinto Pequeño: precio base $2.500 + recargo $0 = $2.500 x 1 = **$2.500**.
   - 1 Chocolate Mediano: precio base $5.000 + recargo $1.000 = $6.000 x 1 = **$6.000**.
   - **Subtotal:** $16.000 + $2.500 + $6.000 = **$24.500**.

2. **Aplicacion de promocion:**
   - Se aplico un 10% de descuento: $24.500 x 0.10 = **$2.450**.
   - **Total final a pagar:** $24.500 - $2.450 = **$22.050**.

3. **Ciclo de estados y cancelacion:**
   - Estado inicial: `RECIBIDO`.
   - Primer avance: pasa a `EN_PREPARACION`.
   - Segundo avance: pasa a `LISTO`.
   - Al intentar cancelar en estado `LISTO`, el metodo `puedeCancelarse()` devuelve `false` (solo se permite en `RECIBIDO` o `EN_PREPARACION`), por lo que lanza una excepcion `IllegalStateException` con el mensaje: *"No se puede cancelar en estado LISTO"*, la cual es capturada para imprimir el aviso amigable en consola.

---

## 4. Salida del programa en consola

```text
  == Cafetería El Algoritmo ==
Cliente: Camila | Estado: LISTO
2 x CAPUCHINO  GRANDE   $  16.000
1 x TINTO      PEQUENO  $   2.500
1 x CHOCOLATE  MEDIANO  $   6.000
Subtotal                $  24.500
Descuento               $   2.450
TOTAL                   $  22.050
Aviso: No se puede cancelar en estado LISTO
```
