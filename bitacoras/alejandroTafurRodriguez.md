# Bitácora Individual - Semana 02

**Estudiante:** Alejandro Tafur  
**Rol asignado:** Encargado de Fase 0 / TAD, Contrato de Operaciones y Documentación Técnica  
**Semana:** 02 - ¿Dónde viven los datos?

---

## Respuestas a las Preguntas de la Semana

### 1. Definición de TAD
Un TAD es un modelo conceptual que define un conjunto de datos y las operaciones permitidas sobre ellos, estableciendo una garantía de uso. Le dice al usuario qué acciones puede realizar y cómo responderá el sistema ante datos incorrectos, ocultando completamente los detalles técnicos internos de cómo se guardan o procesan.

---

### 2. Comparativa de Estrategias de Redimensionamiento
- **Crecimiento de uno en uno (10 → 11 → 12...):** Generó más de 20.000 operaciones de copia para registrar las 201 filas válidas, requiriendo 191 redimensionamientos.
- **Estrategia por Duplicación (10 → 20 → 40...):** Realizó únicamente 5 redimensionamientos y menos de 350 copias totales de referencias.
- **Conclusión:** La duplicación reduce drásticamente la complejidad computacional. Aunque desperdicia un margen temporal de memoria no utilizada, el ahorro en operaciones de E/S y copia en memoria es abrumadoramente superior.

---

### 3. Estrategia de Eliminación Elegida
- **Elegida:** **Compactación** (desplazamiento a la izquierda).
- **Justificación:** Garantiza la invariante de contigüidad en el arreglo. Al eliminar un elemento, mover los índices posteriores hacia la izquierda y hacer `lecturas[cantidad - 1] = null` elimina los huecos. Esto permite que los métodos de búsqueda, recorrido y cálculo de tamaño trabajen sobre un rango contiguo (`0` a `cantidad - 1`) sin requerir validaciones extra de posiciones vacías.

---

### 4. Solución al Cero Fantasma
- **Estrategia:** Uso de envoltorios de objetos (`Double[][]`) o matriz de presencia/ausencia.
- **Justificación:** Se descartó el valor primitivo `double[][]` porque asigna por defecto `0.0`, lo cual distorsiona los promedios al tratar la falta de reporte como si fuera una medición real limpia. Se descartaron valores centinela (como `-1`) porque limitan el rango numérico válido. Utilizar `Double` con valor `null` permite separar de forma estricta la ausencia de dato (`null`) de una medición real igual a cero (`0.0`).

---

### 5. Escalabilidad de la Búsqueda Secuencial (8.000 estaciones)
- **Resultado:** No sería una solución adecuada.
- **Métrica:** En el peor de los casos (elemento al final o inexistente), `buscarPorEstacion()` ejecuta **8.000 comparaciones** de cadenas por cada consulta ($O(N)$). Si se efectúan 1.000 consultas por segundo, el sistema requeriría hasta **8.000.000 de operaciones de comparación**, generando un cuello de botella severo. Se requerirá migrar a estructuras de acceso directo ($O(1)$) o búsquedas binarias ($O(\log N)$).