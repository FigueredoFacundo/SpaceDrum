# Juego-TCP

#Metodología de trabajo

La realización del juego, tendrá tres etapas con sus respectivas entregas:

| Fecha | Contenido de la entrega                                                                                        |
|-------|----------------------------------------------------------------------------------------------------------------|
| 02/10 | Diagrama de clases del modelo del juego, implementado y testeado (código)                                      |
| 30/10 | Posibilidad de interactuar con los elementos del juego en tiempo real en un entorno simulado, de forma gráfica |
| 04/12 | Capacidad de ser jugado a través de cliente-servidor                                                           |


_Se espera que las prácticas de programación sean buenas, y adecuadas al conocimiento adquirido en la materia.
Esto incluye evitar el código aglomerado, tener una buena interacción de clases, no duplicar funcionalidades, tener el código indentado y prolijo, entre otras._

# Mecánica del juego

La mecánica del juego como mencionamos anteriormente, es con desplazamiento constante y debe mantener las siguientes reglas:
* La mecánica del juego debe elegirse de uno o más juegos del estilo anteriormente mencionado
* Una partida debe contar como mínimo con 2 participantes (1 humano) y soportar al menos 4 jugadores humanos
* Una partida debe contar con múltiples rondas, o con una única ronda, si la misma es suficientemente larga, y no repetitiva
* Una partida debe tener un fin claro, donde se declaren uno o varios ganadores
* El mapa puede ser finito o infinito, autogenerado o con mapas creados
* Todos los jugadores deben estar jugando e interactuando con el entorno al mismo tiempo de una u otra forma


# Requisitos generales

1. Como usuario quiero ingresar al juego con mi nombre de usuario y contraseña, para poder jugar contra otros jugadores en una sala
2. Como usuario quiero seleccionar una sala de las existentes, para poder ingresar y jugar con los participantes (*1)
3. Como usuario quiero crear nuevas salas para que ingresen otros jugadores (*2)
4. Como usuario quiero poder salir de una sala, incluso si en la misma el juego se encuentra en ejecución
5. Como usuario quiero poder identificar cada jugador (saber quién lo maneja, y ver su puntaje)

# Notas:
_(*1) Una sala puede estar activa para que ingresen jugadores mientras un juego no esté activo en la misma. Aún así, debe aparecer en la lista de juegos como que el juego ya inició
(*2) La partida podrá ser iniciada por el creador de la sala, o cuando todos los jugadores estén listos, o cualquier otra condición que consideren_
