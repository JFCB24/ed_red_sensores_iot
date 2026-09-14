# Definición formal del TAD y Contrato del Sistema

## 1. Definición del TAD (Tipo Abstracto de Dato)
El **TAD RepositorioLecturas** es una estructura de almacenamiento lógico para la gestión de mediciones ambientales provenientes de la red IoT. Abstrae el mecanismo de almacenamiento subyacente (arreglos estáticos) exponiendo únicamente una interfaz de operaciones seguras para garantizar el encapsulamiento y la integridad del dominio.

---

## 2. Especificación del Contrato de Métodos (`RepositorioLecturas`)

### `boolean agregar(LecturaSensor lectura)`
- **Descripción:** Incorpora una nueva lectura al repositorio. Si el arreglo alcanza su capacidad física, invoca internamente el redimensionamiento dinámico.
- **Precondición:** `lectura != null`.
- **Poscondición:** Incrementa `cantidad` en 1 y almacena el objeto en la posición `cantidad - 1`.
- **Manejo de Caso Inválido:** Si `lectura == null`, no modifica el repositorio y retorna `false`.

### `LecturaSensor obtener(int posicion)`
- **Descripción:** Recupera la lectura ubicada en el índice especificado.
- **Precondición:** Ninguna.
- **Poscondición:** Retorna la referencia del objeto sin alterar la estructura.
- **Manejo de Caso Inválido:** Si `posicion < 0` o `posicion >= cantidad`, retorna `null`.

### `LecturaSensor buscarPorEstacion(String idEstacion)`
- **Descripción:** Realiza una búsqueda secuencial para hallar la primera lectura asociada al ID de la estación.
- **Precondición:** `idEstacion != null` y no vacía.
- **Poscondición:** Retorna el primer objeto `LecturaSensor` cuyo ID coincida exactamente.
- **Manejo de Caso Inválido:** Si el ID no existe o es `null`, retorna `null`.

### `boolean actualizar(int posicion, LecturaSensor nueva)`
- **Descripción:** Reemplaza el registro de la posición indicada por una nueva instancia.
- **Precondición:** `nueva != null`.
- **Poscondición:** La posición especificada almacena la referencia `nueva`.
- **Manejo de Caso Inválido:** Si `posicion < 0` o `posicion >= cantidad` o `nueva == null`, retorna `false`.

### `boolean eliminar(int posicion)`
- **Descripción:** Desplaza los elementos posteriores una posición hacia la izquierda (Compactación) y anula la referencia sobrante.
- **Precondición:** `posicion >= 0` y `posicion < cantidad`.
- **Poscondición:** `cantidad` disminuye en 1, el último índice usado queda en `null` y se mantiene la continuidad sin huecos.
- **Manejo de Caso Inválido:** Si la posición está fuera de rango, retorna `false`.

### `int tamano()`
- **Descripción:** Retorna el número actual de registros almacenados.
- **Poscondición:** Retorna `cantidad` (diferente de `lecturas.length`).

---

## 3. Visibilidad y Encapsulamiento
- **Operaciones Públicas:** `agregar`, `obtener`, `buscarPorEstacion`, `actualizar`, `eliminar`, `tamano`.
- **Operaciones Privadas (Internas):** `redimensionar()` (gestión interna del crecimiento del arreglo).
- **Atributos Protegidos (`private`):** `lecturas` (`LecturaSensor[]`), `cantidad` (`int`), `copiasRealizadas` (`int`), `redimensionamientos` (`int`).