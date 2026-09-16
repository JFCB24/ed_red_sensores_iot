**Estudiante:** Juan Pablo Lozada Lopez
**Rol asignado:** AnalizadorMatriz.java, promedioDeEstacion() y manejo de datos faltantes (ceros fantasma).
**Semana:** 02 – ¿Dónde viven los datos?

## Respuestas a las Preguntas de la Semana

### 1. Definición de TAD
Un Tipo Abstracto de Datos (TAD) define conceptualmente un conjunto de datos y las operaciones permitidas sobre ellos, encapsulando la estructura interna y protegiendo la integridad de la información frente a operaciones inválidas.

### 2. Comparativa de Estrategias de Redimensionamiento
* **Crecimiento de uno en uno:** Genera un alto costo computacional y un número excesivo de copias de referencias en memoria a medida que el arreglo se llena.
* **Estrategia por Duplicación:** Optimiza drásticamente el rendimiento al reducir la cantidad de redimensionamientos necesarios, aunque requiera un uso temporal de memoria adicional.

### 3. Estrategia de Eliminación Elegida
* **Elegida:** Compactación mediante desplazamiento de elementos.
* **Justificación:** Mantiene la continuidad de los elementos válidos dentro de la estructura sin dejar espacios vacíos intermedios.

### 4. Solución al Cero Fantasma
* **Estrategia:** Filtrado condicional en el recorrido de la matriz (`valor > 0.0`) para ignorar celdas vacías por defecto.
* **Justificación:** Evita que los ceros generados por la inicialización de la matriz de `double` distorsionen los cálculos matemáticos y alteren los promedios reales de las estaciones.

### 5. Escalabilidad de la Búsqueda Secuencial
* **Resultado:** No resulta eficiente para conjuntos de datos grandes o flujos masivos de sensores IoT debido a su complejidad lineal, haciendo recomendable el uso de estructuras indexadas o búsquedas optimizadas.