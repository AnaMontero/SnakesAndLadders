# Voxel Technical Interview - SnakesAndLadders Solution

## Índice

- [Casos de uso](#casos-de-uso-a-conseguir)
- [Herramientas y stack](#herramientas-y-stack-utilizado)
- [¿Cómo es el proyecto?](#descripcion-del-proyecto)
- [¿Cómo se presenta?](#presentacion-del-proyecto)
- [¿Dónde encontrar los tests?](#clases-de-test)

---

### ☑ Casos de uso a conseguir

* US 1 - La ficha se puede mover a lo largo del tablero
* US 2 - Un jugador puede ganar el juego
* US 3 - Los movimientos se determinan por tiradas de dado

---

### ♨️ Herramientas y stack utilizado

* IntelliJ IDEA 2022.1.2 (Ultimate Edition)
* Java 17
* Maven 3.8.6
* JUnit 5

---

### 💻 Presentacion del proyecto

1. Hay dos ramas - master y gameImprovement.
2. En `master` se puede encontrar una primera versión, mientras que en `gameImprovement` **se han aplicado mejoras**
   originadas gracias al proceso de formación en el que me encuentro actualmente.
3. La primera versión muestra una aplicación para la que apenas hay tests, originado principalmente por la **falta de
   una
   mejor implementación del diseño del juego**.
4. La segunda versión **mejora la testeabilidad de la aplicación** gracias a la incorporación del principio de
   responsabilidad única(SRP). Se ha desglosado en diferentes partes los procesos que componen el juego (como la
   creación de jugadoras, tirada de dados, avance de turnos ,etc).
5. Desde esta [*Pull Request*](https://github.com/AnaMontero/SnakesAndLadders/pull/1/files) se pueden ver rápidamente
   los cambios de mejora frente a la primera versión
6. De cara a una siguiente versión, trabajaría tanto en **mejorar la cohesión y como en reducir el acoplamiento** del
   código, ya que de no hacer ésto, cada cambio requerido por el juego tendrá que pasar o bien por la clase DashBoard o
   la clase Game.

---

### 📃 Descripcion del proyecto

* El proyecto se encuentra dividido en diferentes paquetes, con idea de presentar una clara estructura
* Dicha división se intenta adaptar el SRP, separando las clases en:
    * paquete `application`: estas clases manejan la ejecución del juego, una controla la lógica de presentación (
      Dashboard) y la otra la del progreso del juego (Game)
    * paquete `classes`: contiene aquellas clases que servirán para la creación de objetos diversos que tengas una
      repsesentación en el juego, como Player. Debido a la sencillez de la aplicación no se han valorado otras, pero de
      cara a mejoras futuras se podrían añadir otras, por ejemplo un tablero, en el que se definan en qué casillas se
      encontrará escaleras o serpientes
    * paquete `utilities`: clases de apoyo al progreso del juego, en éste caso para crear elementos aleatorios como son
      las tiradas del dado, o la asignación de un color a cada jugador creado
* Las características del juego son:
    * Selección de número de jugadoras - de elegir menos de 2, se reestablece a 2 para permitir que la partida pueda
      ejecutarse.
    * Se crean el número de jugadoras elegidas, con un color aleatorio (que representa a una ficha), y un nombre o bien
      elegido por la usuario, o por defecto como PLAYER#
        * ▶️️ Dar opción a poder elegir el nombre puede enriquecer la
          experiencia de usuaria.
    * Se inicia el juego en el que turno a turno se va viendo el progreso de la partida, las tiradas y posiciones de
      cada jugadora
    * Finalmente, la primera en llegar a la casilla 100 gana. Si no se alcanza la casilla 100 con una tirada justa, la
      jugadora permanece en la misma casillas
    * Se ha implementado el método sleep() para que la impresión del progreso de la partida en la consola sea más lenta
      de lo normal y así poder disfrutar más entre turno y turno

---

### 🔍 Clases de test

En la carpeta [test](src/test/java) se encuentra:

* GameTest: comprueba que siempre existan 2 jugadoras, que se crean correctamente, que el movimiento se ejecuta como se
  esper, y que puedan proclamarse como ganadoras
* RandomCreatorTest: asegura que tnato la tirada de dados como la selección aleatoria de primera jugadora generan datos
  que se encuentran dentro de un rango esperado