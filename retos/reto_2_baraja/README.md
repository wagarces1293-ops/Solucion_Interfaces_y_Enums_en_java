# Reto 2: Baraja Española Completa

**Asignatura:** Programacion 1  
**Tema:** Enums, Records y Colecciones (Collections.shuffle)  

---

## 1. Descripcion del reto
El objetivo de este reto fue modelar una baraja espanola tradicional de 48 cartas combinando:
1. Un enum `Palo` con los 4 palos tradicionales: `OROS`, `COPAS`, `ESPADAS`, `BASTOS`.
2. Un enum `Valor` con los 12 valores numericos y sus nombres tipicos (`UNO/As`, `DOS`, `TRES`, ..., `SOTA`, `CABALLO`, `REY`).
3. Un `record Carta` inmutable que encapsula un valor y un palo.
4. Generar las 48 cartas mediante dos ciclos `for` anidados sobre `values()`.
5. Mezclar aleatoriamente el mazo usando el metodo estatico `Collections.shuffle(...)`.

---

## 2. Explicacion de la solucion

- **Por que dos enums y un record:**
  Tanto los palos como los valores son conjuntos fijos y cerrados. No existen palos fuera de los 4 ni valores fuera de los 12. Modelarlos con enums nos da total seguridad de tipos. Cada carta individual no necesita mutar su estado, por lo que un `record` es la estructura mas limpia y compacta.

- **Generacion con `values()`:**
  Al iterar sobre `Palo.values()` (4 elementos) y para cada uno iterar sobre `Valor.values()` (12 elementos), el producto cartesiano genera exactamente 4 x 12 = 48 cartas sin posibilidad de omitir o duplicar ninguna.

- **Mezcla con `Collections.shuffle()`:**
  `Collections.shuffle` es un algoritmo del JDK que permuta aleatoriamente los elementos de una lista con una distribucion uniforme, simulando el acto de barajar las cartas fisicas.

---

## 3. Salida de ejecucion en consola

```text
=== Reto 2: Baraja Española (48 Cartas) ===
Total de cartas creadas: 48

Primeras 5 cartas en orden ordenado:
 - As de OROS
 - Dos de OROS
 - Tres de OROS
 - Cuatro de OROS
 - Cinco de OROS

Primeras 5 cartas despues de barajar con Collections.shuffle:
 - Sota de COPAS
 - Rey de BASTOS
 - Tres de ESPADAS
 - Siete de OROS
 - As de BASTOS
```
