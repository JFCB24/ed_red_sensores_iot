# Bitácora individual - Juan Felipe

## Semana 2

## 1. Datos de la actividad

- **Estudiante:** Juan Felipe
- **Equipo:** Red de Sensores IoT
- **Semana:** 2
- **Fecha del laboratorio:** 2026-09-14
- **Fecha del taller:** 2026-09-14
- **Tema principal:** TAD RepositorioLecturas, arreglos de objetos y operaciones sobre el repositorio.
- **Pregunta de la semana:** ¿Cómo podemos almacenar, consultar, actualizar y eliminar lecturas de sensores utilizando un repositorio basado en arreglos?

## 2. Predicción antes de ejecutar

### 1. ¿Qué creo que va a ocurrir?

Creo que el repositorio podrá almacenar las lecturas de los sensores y permitir consultar una lectura por estación, actualizarla y eliminarla. También espero que el promedio de PM2.5 siga siendo correcto después de eliminar una lectura.

### 2. ¿Qué parte del programa o del algoritmo puede fallar?

La eliminación puede generar un problema si solamente se coloca null en la posición eliminada, porque podría quedar un espacio vacío dentro del arreglo y afectar los cálculos posteriores.

### 3. ¿Cómo comprobaré mi predicción?

Probaré una eliminación en una posición intermedia del arreglo y comprobaré que las lecturas posteriores se desplacen una posición hacia la izquierda, que la cantidad disminuya y que el promedio de PM2.5 continúe funcionando.

## 3. Evidencia del laboratorio

### Resultado observado

Pendiente de completar después de ejecutar las pruebas del proyecto completo.

### Diferencia entre la predicción y el resultado

Pendiente de completar después de realizar las pruebas.

### Error o comportamiento inesperado

- **¿Qué ocurrió?** Pendiente de completar con el resultado de las pruebas.
- **¿Por qué ocurrió?** Pendiente de completar.
- **¿Cómo lo corregimos o qué falta corregir?** Se corrigió el método `eliminar()` utilizando desplazamiento de los elementos posteriores y disminuyendo la cantidad de lecturas.

## 4. Explicación en lenguaje llano

Un repositorio de lecturas es como una caja donde vamos guardando los datos de los sensores. Cada lectura ocupa una posición. Podemos buscar una lectura, cambiarla o quitarla. Cuando quitamos una lectura del medio, debemos acomodar las siguientes para que no quede un espacio vacío.

### Ejemplo o analogía

Es como una fila de personas. Si una persona sale de la mitad, las personas que estaban detrás avanzan un puesto. De esta forma la fila continúa organizada y sabemos cuántas personas siguen allí.

## 5. El vacío que encontré

- **Mi duda concreta es:** ¿Por qué al eliminar una lectura es necesario desplazar las siguientes posiciones en lugar de simplemente colocar `null`?
- **Lo que ya puedo explicar es:** Que `cantidad` representa el número de lecturas almacenadas y que el arreglo utiliza posiciones para guardar cada objeto `LecturaSensor`.
- **Para resolver la duda consulté:** La guía del taller y la implementación del repositorio.
- **Ahora lo entiendo así:** Si dejo `null` en medio del arreglo, los elementos almacenados dejan de estar organizados de forma continua y otros métodos pueden intentar acceder a una posición vacía. Al desplazar los elementos, el repositorio mantiene sus lecturas consecutivas.

## 6. Trazado de la solución

### Caso: eliminar una lectura de una posición intermedia

| Paso | Estado de los datos o estructura | Decisión o resultado |
|---|---|---|
| 1 | `[A] [B] [C] [D]` | Se selecciona la posición de `B`. |
| 2 | `[A] [B] [C] [D]` | `C` se mueve a la posición de `B`. |
| 3 | `[A] [C] [C] [D]` | `D` se mueve a la posición de `C`. |
| 4 | `[A] [C] [D] [ ]` | La última posición utilizada se coloca en `null`. |
| 5 | Cantidad anterior = 4 | La cantidad disminuye a 3. |

## 7. Decisión de diseño

- **Problema que debíamos resolver:** Eliminar una lectura sin dejar espacios vacíos dentro del repositorio.
- **Estructura, algoritmo o estrategia elegida:** Arreglo de objetos `LecturaSensor[]` con desplazamiento de elementos.
- **Alternativa descartada:** Colocar directamente `null` en la posición eliminada.
- **Por qué elegimos la primera:** Mantiene las lecturas almacenadas de forma consecutiva y permite que `cantidad` represente correctamente cuántas lecturas existen.
- **Qué evidencia respalda la decisión:** La prueba de eliminación deberá comprobar que los elementos posteriores se desplazan y que la cantidad disminuye correctamente.

## 8. Aporte al proyecto

- **Archivo(s) o módulo(s) trabajado(s):** `src/RepositorioLecturas.java`
- **Cambio realizado:** Implementé `buscarPorEstacion()`, `actualizar()` y corregí `eliminar()`. También revisé `promedioPm25()` para manejar correctamente un repositorio vacío.
- **Cómo se conecta con la capa anterior:** `RepositorioLecturas` recibe y almacena objetos `LecturaSensor` que son construidos y validados durante la ingesta.
- **Qué queda pendiente para la siguiente semana:** Integrar y probar mi trabajo con el redimensionamiento del repositorio y con el análisis de la matriz.

## 9. Commits realizados

| Commit | Mensaje | Qué demuestra |
|---|---|---|
| `e7cbe09` | `Completar busqueda actualizacion y eliminacion` | Implementación de búsqueda, actualización, eliminación y revisión del promedio. |

## 10. Reexplicación final

Pendiente de completar después de realizar las pruebas finales del taller.

## 11. Reflexión individual

1. **Lo que ahora puedo hacer y antes no podía:**  
   Implementar operaciones de búsqueda, actualización y eliminación sobre un arreglo de objetos manteniendo organizada la cantidad de elementos.

2. **El error o supuesto que más me enseñó:**  
   Pensar que eliminar una posición significa solamente colocar `null`. Esto puede dejar un espacio dentro de los elementos almacenados y afectar el funcionamiento del repositorio.

3. **La pregunta que llevaría a la próxima clase:**  
   ¿Cómo afecta el tamaño del arreglo y la estrategia de redimensionamiento al rendimiento del repositorio?

4. **Qué parte del trabajo fue realmente mía:**  
   Trabajé en `RepositorioLecturas.java`, específicamente en `buscarPorEstacion()`, `actualizar()`, `eliminar()` y la revisión de `promedioPm25()`.