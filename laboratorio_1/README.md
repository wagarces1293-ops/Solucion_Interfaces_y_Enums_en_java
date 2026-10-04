# Laboratorio 1: Mi Playlist Ordenada

**Asignatura:** Programacion 1  
**Tema:** Interfaces del JDK (Comparable, Comparator y Predicate)  

---

## 1. Descripcion del laboratorio
El objetivo de este laboratorio fue aplicar interfaces estandar que ya vienen incluidas en Java para resolver problemas comunes como ordenar colecciones y filtrar datos.

Trabajamos con una lista de canciones y resolvimos tres tareas principales:
1. Definir un orden natural para las canciones basado en su titulo.
2. Aplicar un orden secundario basado en la duracion de las canciones, de mayor a menor.
3. Filtrar canciones de larga duracion (mas de 200 segundos) y obtener sus titulos en mayusculas.

---

## 2. Paso a paso de la solucion

1. **Clase `Cancion`:**
   - Atributos privados: `titulo` (String), `artista` (String) y `duracionSeg` (int).
   - Constructor para inicializar los campos.
   - Metodos de acceso (getters) para cada atributo.
   - Metodo `duracion()`: convierte los segundos a formato `"m:ss"` utilizando division entera (`duracionSeg / 60`) y residuo (`duracionSeg % 60`), formateados con `String.format("%d:%02d", ...)`.

2. **Implementacion de `Comparable<Cancion>`:**
   - La clase firma la interfaz `Comparable<Cancion>`.
   - Se sobrescribe el metodo `compareTo(Cancion otra)` delegando la comparacion alfabetica al metodo `compareTo` de la clase `String`: `this.titulo.compareTo(otra.titulo)`. Esto define el orden "de fabrica" o natural.

3. **Orden alternativo con `Comparator`:**
   - Para no modificar la clase `Cancion`, creamos un criterio externo usando `Comparator.comparingInt(Cancion::getDuracionSeg).reversed()`.
   - `comparingInt` extrae la duracion en segundos y `.reversed()` invierte el orden para que vaya de la cancion mas larga a la mas corta.

4. **Filtrado con `Predicate<Cancion>`:**
   - Se definio una condicion reutilizable mediante una expresion lambda:
     `Predicate<Cancion> esLarga = c -> c.getDuracionSeg() > 200;`
   - Se aplicó sobre la coleccion para extraer los titulos y convertirlos a mayusculas con `.toUpperCase()`.

---

## 3. Aprendizajes y reflexiones

- **Comparable vs. Comparator:**
  - `Comparable` vive **dentro** de la clase y solo permite definir **un unico** orden natural (en este caso, por titulo).
  - `Comparator` vive **fuera** de la clase y nos permite inventar todas las reglas de ordenamiento adicionales que necesitemos (por duracion, por artista, ascendente o descendente) sin tocar el codigo de la clase `Cancion`.

- **Uso de lambdas y referencias a metodo:**
  - El uso de `Cancion::getDuracionSeg` es un atajo muy comodo para la lambda `c -> c.getDuracionSeg()`.
  - Las interfaces funcionales como `Predicate` permiten tratar condiciones de filtrado como si fueran variables comunes.

---

## 4. Salida del programa en consola

```text
Orden natural (título):
 Bailando       Enrique Iglesias  4:03
 Despacito      Luis Fonsi        3:48
 La Bicicleta   Carlos Vives      3:47
 Tusa           Karol G           3:20
De la más larga a la más corta:
 Bailando (4:03)
 Despacito (3:48)
 La Bicicleta (3:47)
 Tusa (3:20)
Canciones largas: [BAILANDO, DESPACITO, LA BICICLETA]
```
