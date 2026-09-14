# Decisiones de Diseno - Bitacora Tecnica

Formato: cada entrada con fecha, decision, alternativas consideradas, justificacion.

## S1 - De codigo fragil a confiable - 2026-08-26

### Decision 1: Crear clase LecturaSensor
- **Alternativas:** mantener 5 variables sueltas vs crear clase.
- **Elegida:** clase con atributos privados, constantes de rangos.
- **Justificacion:** encapsulamiento (numeral 1.2), reutilizable 12 semanas, firma de metodos pasa de 5 params a 1. Evita error de orden de parametros.

### Decision 2: Estrategia ante fila invalida
- **Alternativas:** A) descartar solo campo malo B) descartar fila completa.
- **Elegida:** B) fila completa.
- **Justificacion:** principio conservador para reporte oficial. Si un canal falla (-999), no confiamos en sincronia de los otros dos. Preferimos perdida de datos a contaminacion silenciosa. Registrado en descartes.csv para auditoria.

### Decision 3: Manejo de excepciones
- **Alternativas:** catch generico Exception vs especificos.
- **Elegida:** catch especifico NumberFormatException y ArrayIndexOutOfBoundsException + validacion fisica.
- **Justificacion:** catch vacio o generico esconde causa. Necesitamos trazabilidad: cuantos, por que motivo.

### Decision 4: Constantes vs numeros magicos
- **Elegida:** TEMP_MIN=-40, TEMP_MAX=60, HUM_MIN=0, HUM_MAX=100, PM_MIN=0, CODIGO_DESCONECTADO=-999
- **Justificacion:** si cambian umbrales de la norma ambiental, se cambia en un solo lugar.

## S2 - Especificación de TAD, Estructuras de Datos y Matriz - 2026-09-14

### Decisión 5: Reglas de Validación de Lecturas en la Ingesta
- **Diseñado por:** Alejandro Tafur
- **Alternativas:** A) Permitir datos corruptos y tratarlos individualmente en la matriz. B) Descartar la fila completa ante cualquier anomalía numérica o de rango.
- **Elegida:** B) Filtro conservador con descarte de fila completa.
- **Justificación:** Garantiza la integridad del dataset procesado. Si una variable presenta inconsistencias de formato (`ERR`, texto), valores nulos/desconectados (`-999`) o está fuera de los rangos físicos (humedad > 100% o PM2.5 negativo), se descarta toda la lectura para evitar desfasar las mediciones de la estación.

### Decisión 6: Control de Integridad para Lecturas Duplicadas
- **Diseñado por:** Alejandro Tafur
- **Alternativas:** A) Sobrescribir la lectura previa con el nuevo registro entrante. B) Ignorar la lectura duplicada detectada (misma estación y misma hora).
- **Elegida:** B) Ignorar la lectura duplicada.
- **Justificación:** Mantiene la precisión de las lecturas en memoria. Evita que registros repetidos en el archivo de origen incrementen innecesariamente el tamaño del repositorio o distorsionen los cálculos de promedios ambientales.


