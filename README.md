# Taller Completo: Interfaces y Enums en Java

**Asignatura:** Programacion 1  
**Documento base:** Guia "Interfaces y Enums en Java" (Java 21 LTS)  
**Estudiante:** Solucion integral de ejercicios, laboratorios, puntos de control, autoevaluacion y retos  

---

## 1. Presentacion del proyecto

Este repositorio contiene la resolucion completa, detallada y estructurada de la guia de estudio **Interfaces y Enums en Java**. Todo el codigo fue escrito y probado respetando las pautas fundamentales de la asignatura Programacion 1:
- Uso de sintaxis limpia y estandar de Java orientada a objetos basica e intermedia (Java 21+).
- Separacion estricta en carpetas modulares por cada seccion, laboratorio y reto.
- Explicaciones teoricas redactadas con palabras propias y comprension conceptual en cada carpeta.
- Cero emoticones o emojis en todo el proyecto (codigo, comentarios y documentacion).

---

## 2. Mapa general de carpetas y contenidos

```text
Interfaces y Enums en java/
├── parte_1/
│   ├── README.md               # Teoria de interfaces, apuntes y respuestas a puntos de control 1, 2, 3 y 4
│   ├── Sonoro.java             # Interfaz basica de contrato
│   ├── Perro.java              # Implementacion concreta 1
│   ├── Gato.java               # Implementacion concreta 2
│   ├── Vaca.java               # Implementacion concreta 3
│   ├── ReglasJuego.java        # Constantes en interfaz y reglas implicitas
│   ├── JuegoArcade.java        # Uso de constantes de interfaz
│   ├── Volador.java            # Capacidad 1
│   ├── Nadador.java            # Capacidad 2
│   ├── Pato.java               # Implementacion multiple (Volador y Nadador)
│   ├── Avion.java              # Implementacion de Volador
│   ├── Encendible.java         # Interfaz para herencia multiple de interfaces
│   ├── Conectable.java         # Interfaz para herencia multiple de interfaces
│   ├── DispositivoInteligente.java # Extends multiple de interfaces
│   ├── Parlante.java           # Implementacion de DispositivoInteligente
│   ├── Notificador.java        # Metodo default
│   ├── NotificadorEmail.java   # Herencia de default
│   ├── NotificadorSMS.java     # Sobrescritura de default
│   ├── Cantante.java           # Conflicto del diamante (default)
│   ├── Bailarin.java           # Conflicto del diamante (default)
│   ├── Artista.java            # Resolucion del diamante con Interfaz.super.metodo()
│   ├── Formateador.java        # Metodos default, static y private en interfaces
│   ├── Mayusculas.java         # Implementacion de Formateador
│   ├── Operacion.java          # Interfaz funcional (@FunctionalInterface)
│   ├── Estudiante.java         # Interfaz Comparable del JDK
│   ├── Empleado.java           # Clase abstracta ("es un")
│   ├── Bonificable.java        # Interfaz de capacidad ("puede hacer")
│   ├── Desarrollador.java      # Empleado que implementa Bonificable
│   ├── Practicante.java        # Empleado base sin Bonificable
│   ├── Figura.java             # Sealed interface (permits Circulo, Rectangulo, Triangulo)
│   ├── Circulo.java            # Record permitido
│   ├── Rectangulo.java         # Record permitido
│   ├── Triangulo.java          # Record permitido
│   └── MainParte1.java         # Ejecucion y prueba de todos los conceptos de la Parte 1
│
├── laboratorio_1/
│   ├── README.md               # Informe del Laboratorio 1 (Comparable, Comparator y Predicate)
│   ├── Cancion.java            # Clase con Comparable y metodo duracion()
│   └── Main.java               # Ordenamiento natural, alternativo y filtrado
│
├── laboratorio_2/
│   ├── README.md               # Informe del Laboratorio 2 (Pasarela de pagos polimorfica)
│   ├── MetodoPago.java         # Contrato con metodos default (comision y totalACobrar)
│   ├── TarjetaCredito.java     # Cobro con 3% de comision y control de cupo
│   ├── BilleteraDigital.java   # Cobro con saldo sin comision
│   ├── Efectivo.java           # Cobro siempre aprobado
│   ├── Criptomoneda.java       # Quinto metodo agregado sin modificar Caja
│   ├── Caja.java               # Caja registradora desacoplada
│   └── Main.java               # Pruebas de los 4 casos originales mas el caso de Criptomoneda
│
├── parte_2/
│   ├── README.md               # Teoria de enums, apuntes y respuestas a puntos de control 5 y 6
│   ├── DiaSemana.java          # Primer enum basico
│   ├── Moneda.java             # Enum con atributos, constructor y metodo de busqueda
│   ├── Operador.java           # Metodo abstracto en enum con cuerpos por constante
│   ├── Calculable.java         # Interfaz funcional
│   ├── Impuesto.java           # Enum que implementa Calculable
│   ├── EstadoPedido.java       # Enum como maquina de estados finita
│   ├── Configuracion.java      # Enum como patron Singleton
│   └── MainParte2.java         # Ejecucion y prueba de todos los conceptos de la Parte 2
│
├── laboratorio_3/
│   ├── README.md               # Informe del Laboratorio 3 (Semaforo inteligente y reto extra)
│   ├── Semaforo.java           # Enum con segundos, accion, switch siguiente y duracionCiclo
│   └── Main.java               # Simulacion de 4 pasos de luz
│
├── laboratorio_4/
│   ├── README.md               # Informe del Laboratorio 4 (Cafeteria "El Algoritmo" - Proyecto Integrador)
│   ├── Bebida.java             # Enum de bebidas con precio base
│   ├── Tamano.java             # Enum de tamaños con recargo
│   ├── EstadoPedido.java       # Maquina de estados del pedido
│   ├── Promocion.java          # Interfaz funcional con metodos estaticos de fabricacion de lambdas
│   ├── Item.java               # Record inmutable con calculo de subtotal
│   ├── Pedido.java             # Clase con estado mutable y flujo de cobro
│   └── Main.java               # Caso de Camila con 10% de descuento y control de cancelacion
│
├── autoevaluacion/
│   └── README.md               # Las 10 preguntas de seleccion multiple explicadas y sustentadas
│
└── retos/
    ├── README.md               # Indice y resumen de los 5 retos
    ├── reto_1_figuras/         # Reto 1: Figuras con perimetro y exhaustividad con Cuadrado
    ├── reto_2_baraja/          # Reto 2: Baraja espanola de 48 cartas y Collections.shuffle
    ├── reto_3_calculadora/     # Reto 3: Calculadora con lambdas y DoubleBinaryOperator
    ├── reto_4_promociones/     # Reto 4: Promociones combinables con metodo default y()
    └── reto_5_permisos/        # Reto 5: Permisos y roles con EnumSet
```

---

## 3. Como compilar y ejecutar los programas

Cada carpeta es un paquete independiente y autocontenido. Desde la raiz del proyecto se puede compilar y ejecutar cualquier seccion utilizando la consola:

### Ejecutar Parte 1 (Demostracion de conceptos de interfaces):
```bash
javac parte_1/*.java
java parte_1.MainParte1
```

### Ejecutar Laboratorio 1 (Mi playlist ordenada):
```bash
javac laboratorio_1/*.java
java laboratorio_1.Main
```

### Ejecutar Laboratorio 2 (Pasarela de pagos):
```bash
javac laboratorio_2/*.java
java laboratorio_2.Main
```

### Ejecutar Parte 2 (Demostracion de conceptos de enums):
```bash
javac parte_2/*.java
java parte_2.MainParte2
```

### Ejecutar Laboratorio 3 (Semaforo inteligente):
```bash
javac laboratorio_3/*.java
java laboratorio_3.Main
```

### Ejecutar Laboratorio 4 (Cafeteria "El Algoritmo"):
```bash
javac laboratorio_4/*.java
java laboratorio_4.Main
```

### Ejecutar los Retos:
- **Reto 1 (Figuras con perimetro):**
  ```bash
  javac retos/reto_1_figuras/*.java
  java retos.reto_1_figuras.Main
  ```
- **Reto 2 (Baraja espanola):**
  ```bash
  javac retos/reto_2_baraja/*.java
  java retos.reto_2_baraja.Main
  ```
- **Reto 3 (Calculadora con lambdas):**
  ```bash
  javac retos/reto_3_calculadora/*.java
  java retos.reto_3_calculadora.Main
  ```
- **Reto 4 (Promociones combinables):**
  ```bash
  javac retos/reto_4_promociones/*.java
  java retos.reto_4_promociones.Main
  ```
- **Reto 5 (Permisos con EnumSet):**
  ```bash
  javac retos/reto_5_permisos/*.java
  java retos.reto_5_permisos.Main
  ```
