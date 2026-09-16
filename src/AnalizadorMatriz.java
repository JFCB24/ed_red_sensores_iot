/* ============================================================
   PLATAFORMA DE MONITOREO AMBIENTAL URBANO
   AnalizadorMatriz - VERSION 0.1 INCOMPLETA

   Una matriz de 9 estaciones x 24 horas para responder
   preguntas como: a que hora del dia se contamina mas la ciudad,
   y cual estacion sostiene los peores niveles.

   filas    = estaciones (0..8  ->  EST-001..EST-009)
   columnas = horas      (0..23)
   ============================================================ */

public class AnalizadorMatriz {

    private static final int NUM_ESTACIONES = 9;
    private static final int NUM_HORAS = 24;

    private double[][] pm25PorEstacionHora;

    public AnalizadorMatriz() {
        this.pm25PorEstacionHora = new double[NUM_ESTACIONES][NUM_HORAS];
    }

    /**
     * Convierte "EST-004" en el indice de fila 3.
     */
    private int indiceDeEstacion(String idSensor) {
        String numero = idSensor.substring(4);
        return Integer.parseInt(numero) - 1;
    }

    /**
     * Ubica una lectura en su celda correspondiente.
     */
    public void registrar(LecturaSensor lectura) {
        int fila = indiceDeEstacion(lectura.getIdSensor());
        int columna = lectura.getHora();
        pm25PorEstacionHora[fila][columna] = lectura.getPm25();
    }

    /**
     * Promedio de PM2.5 de una hora del dia, sobre todas las estaciones.
     *
     * TODO 1: este metodo tiene un problema serio. Ejecutalo primero,
     * mira los resultados de las horas 09, 10, 11 y 12, y averigua por que.
     * Pista: revisa cuantas filas trae EST-003 en el archivo.
     */
    public double promedioDeHora(int hora) {
        double suma = 0;
        for (int fila = 0; fila < NUM_ESTACIONES; fila++) {
            suma = suma + pm25PorEstacionHora[fila][hora];
        }
        return suma / NUM_ESTACIONES;
    }

    /**
     * Promedio de PM2.5 de una estacion a lo largo del dia.
     * Implementado ignorando los ceros fantasma (datos faltantes).
     */
    public double promedioDeEstacion(int fila) {
        double suma = 0;
        int contadorValidos = 0;

        for (int columna = 0; columna < NUM_HORAS; columna++) {
            double valor = pm25PorEstacionHora[fila][columna];

            // Si el valor es mayor a 0, asumimos que es una lectura real y válida.
            if (valor > 0.0) {
                suma += valor;
                contadorValidos++;
            }
        }

        // Evitamos división por cero si la estación no tiene ninguna lectura registrada
        if (contadorValidos == 0) {
            return 0.0;
        }

        return suma / contadorValidos;
    }

    /**
     * Hora del dia con mayor contaminacion promedio en la ciudad.
     * TODO 3: implementar.
     */
    public int horaMasContaminada() {
        int horaMayor = 0;
        double mayorPromedio = promedioDeHora(0);

        for (int hora = 1; hora < NUM_HORAS; hora++) {
            double promedioActual = promedioDeHora(hora);

            if (promedioActual > mayorPromedio) {
                mayorPromedio = promedioActual;
                horaMayor = hora;
            }
        }

        return horaMayor;
    }
    /**
     * Imprime la matriz completa. Util para ver los huecos con tus ojos.
     */
    public void imprimirMatriz() {
        System.out.print("EST\\HORA");
        for (int h = 0; h < NUM_HORAS; h++) {
            System.out.printf("%7s", String.format("%02d", h));
        }
        System.out.println();
        for (int f = 0; f < NUM_ESTACIONES; f++) {
            System.out.printf("EST-%03d ", f + 1);
            for (int h = 0; h < NUM_HORAS; h++) {
                System.out.printf("%7.1f", pm25PorEstacionHora[f][h]);
            }
            System.out.println();
        }
    }
}
