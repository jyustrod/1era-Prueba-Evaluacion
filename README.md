# 1era-Prueba-Evaluacion

[![GitHub Repo](https://img.shields.io/badge/GitHub-Repository-blue?logo=github)](https://github.com/jyustrod/1era-Prueba-Evaluacion.git)

## Descripción
Este proyecto contiene varias implementaciones en Java relacionadas con algoritmos fundamentales en computacion:

1. **Aproximación de Pi con Montecarlo**: Usa el metodo de Montecarlo para estimar el valor de pi.
2. **Juego de la Vida**: Implementa la evolucion de celulas en un tablero según las reglas del Juego de la Vida de Conway.
3. **Búsqueda en Grafos**: Implementa una estructura de datos de grafo y un algoritmo para encontrar un camino entre dos nodos.

## Contenido del Proyecto
El proyecto está dividido en los siguientes paquetes:

- `aplicacion`: Contiene los paquetes `mates`, `dominio`, y `pr2`.
- `mates`: Contiene la clase `Matematicas.java` con el metodo `generarNumeroPi()`.
- `dominio`: Contiene la clase `Tablero.java` que maneja el estado del Juego de la Vida y el fichero `matriz.txt` que contiene el estado inicial del tablero.
- `pr2`: Contiene la clase `Graph.java` con la implementacion de un grafo y la busqueda de caminos.
- `tests`: Contiene las pruebas unitarias con JUnit.

## Instalación y Uso

### Requisitos
- Java 11 o superior
- Maven (opcional, para la gestion del proyecto)

### Compilación
Si usas Maven, puedes compilar el proyecto con:
```sh
mvn compile
```

### Ejecución
Ejecutar el programa Principal con un numero de puntos generados para el metodo de Montecarlo:
```sh
java aplicacion.Principal 1000000
```

## Complejidad Algorítmica

### Aproximación de Pi
El algoritmo de Montecarlo para estimar pi tiene una complejidad de **O(n)**, donde *n* es el numero de puntos generados.

### Juego de la Vida
La actualización de cada celda depende de sus 8 vecinos, lo que resulta en una complejidad de **O(n²)**, donde *n* es el tamaño del tablero.

### Búsqueda de Caminos en Grafos
El algoritmo implementado es una búsqueda en profundidad (DFS), cuya complejidad en el peor caso es **O(V + E)**, donde *V* es el numero de vértices y *E* el número de aristas.

## Licencia
Este proyecto está licenciado bajo la **Apache License 2.0**. Ver el archivo `LICENSE` para más detalles.

