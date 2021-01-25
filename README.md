# Juego-en-java
Software que gestiona elementos y dinámicas propias de los juegos para incorporar al aprendizaje en base a los temas que que sean subidos al al programa. El sistem posee dos formas de jugar basadas en la gamificación: Flash y Memory

##  Decisiones de diseño:
Con base en lo trabajado en clase diseñamos el programa para que sea lo más sencillo e intuitivo posible, intentando
que las opciones sean claras y a su vez dirijan al usuario hacia lo que este desee realizar.
En la ventana principal se irán habilitando las opciones a medida que el usuario cumpla con las condiciones
establecidas por el sistema y necesarias para poder realizar las tareas. Luego de cargar temas en el programa, ya sea,
manualmente, desde un archivo previamente guardado o por la opción de generarlos automáticamente. El usuario
podrá utilizar las opciones que determine convenientes para jugar al modo “Flash” o modo “Memory”.
Estas opciones se encuentran distribuidas en los menús de la barra superior y las opciones que corresponden a la
elección de temas para los juegos se encuentran disponibles en la ventana principal separando así, la organización del
sistema de los juegos.
#### Modo Flash:
El modo fomenta la memoria, se seleccionan preguntas al azar de los temas elegidos en la ventana principal para crear
tarjetas. Cliqueando en las tarjeta alternamos entre su pregunta y su respuesta, podemos avanzar hacia la siguiente
pregunta y volver a la pregunta anterior. En cualquier momento tenemos la opción de volver hacia el menú principal.
#### Modo Memory:
Si en el menú principal los temas seleccionados tienen al menos seis preguntas, se activará la opción de jugar Memory
este juego contribuye a la atención así como a la memoria. El sistema selecciona al azar 6 preguntas y respuestas y las
distribuye en el tablero generando doce tarjetas. El usuario debe unir las Preguntas con su respuesta para así sumar
puntos. Dentro de este modo generamos botones de ayuda para el usuario.
Dentro del menú principal el sistema posee un sencillo pero poderoso sistema para gestionar los temas y las preguntas,
el programa tiene una interfaz para agregar Temas o preguntas a los temas ya existentes, modificar la descripción de
los temas creados o las respuestas de las preguntas ya cargadas en el sistema y por último, también eliminar preguntas
y temas de forma sencilla y cómoda.

###### Todos los temas cargados en el sistema se guardarán automáticamente al cerrar el programa, teniendo la posibilidad
###### de exportarlos del programa para abrirlos en otro ordenador.
