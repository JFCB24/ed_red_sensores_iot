# Bitacora individual - Semana 02

## 1. Datos de la actividad

- **Estudiante:** Juan Felipe Castellanos Bran
- **Equipo:** Red de Sensores IoT
- **Semana:** 02
- **Fecha:** 14 de septiembre de 2026
- **Tema trabajado:** TAD RepositorioLecturas, arreglos de objetos, búsqueda, actualización y eliminación.
- **Pregunta de trabajo:** ¿Cómo almacenar, buscar, actualizar y eliminar lecturas de sensores utilizando un repositorio basado en arreglos?

## 2. Prediccion antes de ejecutar

Antes de ejecutar el programa, esperaba que el repositorio permitiera almacenar las lecturas de los sensores y que sus operaciones permitieran buscar una lectura por su identificador, actualizar una posición y eliminar una lectura.

También esperaba que al eliminar una lectura fuera necesario reorganizar las posiciones del arreglo para evitar dejar espacios vacíos entre los elementos almacenados.

## 3. Evidencia del laboratorio

Al ejecutar el programa se obtuvo:

- Lecturas almacenadas: **201**
- Descartadas por formato: **2**
- Descartadas por rango: **8**
- Total de registros procesados: **211**

El promedio de PM2.5 obtenido en el repositorio fue:

**17.050746268656724**

También se obtuvo el perfil horario de PM2.5. Los valores correspondientes a las horas donde se encontraba el problema de datos faltantes fueron:

- Hora 09: **11.18**
- Hora 10: **12.15**
- Hora 11: **11.34**
- Hora 12: **11.83**

El programa terminó correctamente con:

`Process finished with exit code 0`

Durante la ejecución inicialmente apareció un error porque no se encontraba el archivo `lecturas_ampliadas.csv`. El archivo estaba dentro de la carpeta `data`, mientras que el programa lo buscaba desde la ubicación de ejecución. Para solucionarlo se ubicó el archivo en la ubicación desde donde el programa lo podía encontrar, sin modificar `IngestaSensores.java`.

## 4. Explicacion en lenguaje llano

El repositorio funciona como un lugar donde se guardan las lecturas de los sensores.

El arreglo `lecturas` guarda los objetos `LecturaSensor`, mientras que `cantidad` indica cuántas posiciones del arreglo están ocupadas realmente.

La búsqueda recorre las posiciones ocupadas del arreglo y compara el identificador del sensor hasta encontrar la lectura correspondiente.

La actualización reemplaza la lectura que se encuentra en una posición determinada por una nueva lectura.

La eliminación no solamente coloca la posición en `null`, sino que mueve hacia la izquierda las lecturas que están después de la que se quiere eliminar. De esta manera, no quedan espacios vacíos dentro de las posiciones que realmente utiliza el repositorio.

Una analogía sería una fila de personas. Si una persona sale de la fila, las personas que estaban detrás avanzan para ocupar el espacio que quedó vacío.

## 5. El vacio que encontre

El principal punto que tuve que comprender fue por qué al eliminar una lectura no era suficiente con colocar `null` en la posición.

Si solamente se coloca `null`, podrían quedar espacios vacíos entre las lecturas almacenadas. Esto también puede causar problemas al recorrer el arreglo, porque `cantidad` indica cuántas lecturas existen y el arreglo debe mantenerlas organizadas desde la posición 0.

Por eso fue necesario desplazar las lecturas posteriores una posición hacia la izquierda y disminuir `cantidad`.

## 6. Trazado de la solucion

El proceso de eliminación se puede representar de la siguiente manera:

Primero se toma la posición que se quiere eliminar.

Después se recorren las posiciones siguientes y cada elemento se copia una posición hacia la izquierda.

Finalmente, la última posición utilizada se coloca en `null` y se disminuye `cantidad`.

La búsqueda funciona recorriendo desde la posición 0 hasta `cantidad - 1` y comparando el `idSensor`.

La actualización primero verifica que la posición sea válida y después reemplaza la lectura almacenada por la nueva lectura.

## 7. Decision de diseño

Para la eliminación se utilizó la estrategia de compactar el arreglo mediante desplazamiento.

La alternativa sería simplemente colocar `null` en la posición eliminada, pero esta estrategia dejaría espacios vacíos dentro de las posiciones utilizadas.

El desplazamiento permite mantener las lecturas juntas y hace que `cantidad` siga representando correctamente el número de lecturas almacenadas.

También se mantuvo el arreglo como estructura interna privada del TAD, de manera que las operaciones se realizan mediante los métodos públicos del repositorio.

## 8. Aporte al proyecto

Mi aporte al proyecto se realizó principalmente en:

`src/RepositorioLecturas.java`

Las operaciones que trabajé fueron:

* `buscarPorEstacion()`
* `actualizar()`
* `eliminar()`

También se revisó el funcionamiento de `promedioPm25()` para evitar problemas cuando el repositorio no contiene lecturas.

La búsqueda permite encontrar una lectura utilizando el identificador del sensor.

La actualización permite reemplazar una lectura en una posición válida.

La eliminación permite quitar una lectura y reorganizar las siguientes posiciones.

## 9. Commits realizados

### Commit principal de mi parte

```text
e7cbe09
Completar busqueda actualizacion y eliminacion
```

Este commit contiene los cambios realizados en `RepositorioLecturas.java`.

### Commit de las bitácoras

```text
90587c9
Agregar bitacora de Juan Felipe
```

Este commit contiene las bitácoras agregadas al proyecto.

Los cambios fueron enviados al repositorio remoto en la rama `main`.

## 10. Reexplicacion final

El `RepositorioLecturas` utiliza un arreglo de objetos `LecturaSensor` para almacenar las lecturas.

La variable `cantidad` permite saber cuántas lecturas están almacenadas realmente.

Para buscar una lectura, se recorre el arreglo y se compara el identificador del sensor.

Para actualizar, se verifica que la posición sea válida y se reemplaza el objeto de esa posición.

Para eliminar, se desplazan hacia la izquierda todos los elementos que estaban después de la posición eliminada. Luego se coloca `null` en la última posición utilizada y se disminuye `cantidad`.

De esta manera, el repositorio mantiene sus datos organizados y puede continuar trabajando con las lecturas almacenadas.

## 11. Reflexion individual

Durante esta actividad comprendí mejor cómo funciona un TAD utilizando un arreglo de objetos.

También comprendí la diferencia entre la capacidad del arreglo y la cantidad de elementos realmente almacenados.

La parte que más me ayudó a entender el funcionamiento fue la eliminación, porque pude observar que eliminar un elemento de un arreglo no significa solamente borrar su contenido, sino que también puede ser necesario reorganizar los elementos restantes.

Además, pude comprobar el funcionamiento del proyecto mediante la ejecución del programa y verificar que se procesaron correctamente las 201 lecturas válidas.

## Lista de verificacion antes de entregar

* [x] La bitacora tiene nombre y semana.
* [x] Se explica qué actividad se realizó.
* [x] Se incluye la predicción antes de ejecutar.
* [x] Se incluye evidencia de ejecución.
* [x] Se explica el trabajo en lenguaje sencillo.
* [x] Se explica el problema encontrado.
* [x] Se muestra el trazado de la solución.
* [x] Se explica la decisión de diseño.
* [x] Se describe mi aporte al proyecto.
* [x] Se incluyen los commits realizados.
* [x] Se incluye la reexplicación final.
* [x] Se incluye la reflexión individual.

```
