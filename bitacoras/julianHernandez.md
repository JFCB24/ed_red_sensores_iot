# Bitacora individual - Semana 2

**Nombre del archivo:** `s02-julian-hernandez.md`

## 1. Datos de la actividad

- **Estudiante:** Julian Hernandez
- **Equipo:** Equipo del proyecto Red de Sensores IoT
- **Semana:** 2
- **Fecha del laboratorio:** 2026-09-15
- **Fecha del taller:** 2026-09-16
- **Tema principal:** Arreglos, matrices, almacenamiento y análisis de datos de sensores.
- **Pregunta de la semana:** Los datos ya llegan limpios. ¿Dónde viven ahora y qué podemos preguntarles?

## 2. Prediccion antes de ejecutar

Antes de abrir o ejecutar el programa, responde:

1. **Que creo que va a ocurrir?**  
   Creo que el programa va a recorrer los promedios de PM2.5 de las 24 horas y va a identificar correctamente cuál de ellas presenta el promedio más alto de contaminación.

2. **Que parte del programa o del algoritmo puede fallar?**  
   Puede fallar el resultado si `promedioDeHora()` calcula incorrectamente los promedios cuando alguna estación no tiene datos registrados. Esto podría hacer que `horaMasContaminada()` compare valores que no representan correctamente la información real.

3. **Como comprobare mi prediccion?**  
   Ejecutaré el programa, observaré los promedios calculados para cada una de las 24 horas y comprobaré que `horaMasContaminada()` retorne la hora que tenga el promedio más alto mostrado en consola.

## 3. Evidencia del laboratorio

### Resultado observado

Al ejecutar el programa se mostraron los promedios de PM2.5 para las 24 horas. El valor más alto mostrado fue el de la hora 18, con un promedio de 34,01, seguido por la hora 19 con 33,21. El método `horaMasContaminada()` retornó correctamente la hora 18 y el programa terminó con `Process finished with exit code 0`.

### Diferencia entre la prediccion y el resultado

La predicción coincidió con el resultado observado, porque esperaba que el programa recorriera los promedios horarios y devolviera la hora con el valor más alto. En la prueba realizada, la hora 18 presentó el mayor promedio y fue la misma hora retornada por el método.

### Error o comportamiento inesperado

- **Que ocurrio?** Al realizar inicialmente la prueba, el programa produjo un `FileNotFoundException` porque no encontraba el archivo `lecturas_ampliadas.csv`.
- **Por que ocurrio?** El archivo se encontraba dentro de la carpeta `data`, mientras que la ruta usada por el programa buscaba el archivo directamente desde la carpeta principal del proyecto.
- **Como lo corregimos o que falta corregir?** Para realizar la prueba se utilizó temporalmente la ruta `data/lecturas_ampliadas.csv`. Después de obtener la evidencia, `IngestaSensores.java` se dejó nuevamente en su estado original.

## 4. Explicacion en lenguaje llano

Una matriz es parecida a una tabla formada por filas y columnas. En este proyecto, cada fila representa una estación y cada columna representa una hora del día. En cada espacio se guarda la medición de PM2.5 correspondiente a esa estación y a esa hora.

### Ejemplo o analogia

Se puede comparar con un horario del colegio. Las filas serían los estudiantes y las columnas serían las horas de clase. En cada espacio se guarda lo que corresponde a una persona en una hora específica. En nuestro proyecto, en lugar de clases se guardan mediciones de PM2.5. La comparación deja de ser exacta porque una estación puede no reportar información en una hora determinada.

## 5. El vacio que encontre

- **Mi duda concreta es:** ¿Cómo se puede diferenciar correctamente una lectura real de `0.0` de una posición en la matriz en la que una estación no reportó ningún dato?
- **Lo que ya puedo explicar es:** Puedo explicar cómo recorrer las 24 horas, utilizar sus promedios y comparar los resultados para encontrar el mayor.
- **Para resolver la duda consulte:** La guía de la Semana 2, el código de `AnalizadorMatriz.java` y las pruebas realizadas durante el proyecto.
- **Ahora lo entiendo asi:** Un valor `0.0` puede ser una medición real y por eso no debería utilizarse automáticamente para representar que falta un dato. La ausencia debe representarse de una forma que permita distinguirla de una medición válida de cero.

## 6. Trazado de la solucion

Escoge una ejecucion, recorrido o caso representativo y trazalo paso a paso.
Incluye los valores importantes despues de cada paso.

| Paso | Estado de los datos o estructura | Decision o resultado |
|---|---|---|
| 1 | `horaMayor = 0` y se obtiene `promedioDeHora(0)` | La hora 0 se toma inicialmente como la hora con mayor promedio |
| 2 | Se recorren las horas desde 1 hasta 23 | Para cada hora se obtiene su promedio mediante `promedioDeHora(hora)` |
| 3 | Se encuentra un promedio superior al almacenado | Se actualizan `mayorPromedio` y `horaMayor` |
| 4 | La hora 18 presenta un promedio de 34,01 | Se convierte en la hora con mayor promedio encontrado |
| 5 | Se terminan de recorrer las 24 horas | El método retorna 18 |

## 7. Decision de diseño

Relaciona lo aprendido con la Plataforma de Monitoreo Ambiental Urbano.

- **Problema que debiamos resolver:** Identificar cuál hora del día presenta la mayor contaminación promedio de PM2.5.
- **Estructura, algoritmo o estrategia elegida:** Recorrer las 24 horas y reutilizar el método `promedioDeHora()` para comparar los promedios.
- **Alternativa descartada:** Repetir dentro de `horaMasContaminada()` toda la lógica necesaria para recorrer las estaciones y calcular nuevamente cada promedio.
- **Por que elegimos la primera:** Reutilizar `promedioDeHora()` evita duplicar código, hace más sencillo entender el método y permite que cada parte del programa tenga una responsabilidad específica.
- **Que evidencia respalda la decision:** Al ejecutar el programa, `horaMasContaminada()` retornó la hora 18, que también correspondía al mayor promedio mostrado en consola, con un valor de 34,01.

## 8. Aporte al proyecto

- **Archivo(s) o modulo(s) trabajado(s):** `src/AnalizadorMatriz.java`
- **Cambio realizado:** Implementé el método `horaMasContaminada()`, encargado de recorrer las 24 horas del día, comparar sus promedios de PM2.5 y retornar la hora con el valor más alto.
- **Como se conecta con la capa anterior:** Utiliza `promedioDeHora()`, que trabaja con los datos almacenados en la matriz estación por hora. De esta forma, los datos almacenados pueden convertirse en información útil para el análisis ambiental.
- **Que queda pendiente para la siguiente semana:** Continuar utilizando las estructuras construidas y trabajar en métodos de búsqueda más eficientes a medida que aumente la cantidad de datos y estaciones.

## 9. Commits realizados

Registra los commits que muestran tu aporte individual.

| Commit | Mensaje | Que demuestra |
|---|---|---|
| `d732711` | `Implementar hora mas contaminada` | Implementación individual del método `horaMasContaminada()` en `src/AnalizadorMatriz.java` |

## 10. Reexplicacion final

Despues del taller, vuelve a responder la pregunta de la semana en cinco lineas
o menos. Esta respuesta debe ser mas precisa que la de la seccion 4 y debe
incluir la razon de tu decision tecnica.

> Los datos que llegan al sistema se almacenan en estructuras que permiten conservarlos y analizarlos. En este proyecto utilizamos una matriz para relacionar estaciones con horas del día. A partir de esa organización podemos calcular promedios y encontrar la hora con mayor contaminación. Reutilizar `promedioDeHora()` evita repetir lógica y mantiene el código organizado.

## 11. Reflexion individual

Responde con honestidad:

1. **Lo que ahora puedo hacer y antes no podia:**  
   Ahora puedo recorrer información almacenada en una matriz, utilizar métodos existentes para analizarla y encontrar un valor máximo junto con la posición a la que pertenece.

2. **El error o supuesto que mas me enseno:**  
   El supuesto que más me enseñó fue pensar que un `0.0` podía significar automáticamente que no había información. Entendí que cero puede ser una medición real y que la ausencia de un dato debe representarse de una manera diferente.

3. **La pregunta que llevaria a la proxima clase:**  
   ¿Cómo podríamos encontrar una estación o una lectura de forma más rápida si el sistema tuviera miles de estaciones y una cantidad mucho mayor de datos?

4. **Que parte del trabajo fue realmente mia:**  
   Mi aporte individual fue implementar `horaMasContaminada()` en `AnalizadorMatriz.java`, probar su funcionamiento, comprobar que retornara la hora con el promedio más alto y registrar el cambio en Git mediante el commit `d732711`.

## Lista de verificacion antes de entregar

- [x] Escribi la prediccion antes de consultar el resultado.
- [x] Inclui evidencia concreta del laboratorio.
- [x] Explique un concepto sin depender de jerga.
- [x] Registre un vacio, una duda o un error real.
- [x] Trace al menos un caso paso a paso.
- [x] Justifique una decision del proyecto y una alternativa descartada.
- [x] Registre mis commits y mi aporte individual.
- [x] Deje claro que queda pendiente.
- [x] Renombre el archivo exactamente como `s02-julian-hernandez.md`.