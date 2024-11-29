//Autor: Diego Aristides Cervantes Apaza
//Problema: 1. Cree un Proyecto llamado Laboratorio8
//2. Usted deberá crear las dos clases Soldado.java y VideoJuego5.java. Puede reutilizar lo
//desarrollado en Laboratorios anteriores.
//3. Del Soldado nos importa el nombre, puntos de vida, fila y columna (posición en el tablero).
//4. El juego se desarrollará en el mismo tablero de los laboratorios anteriores. Para crear el
//tablero utilice la estructura de datos más adecuada.
//5. Tendrá 2 Ejércitos (usar HashMaps). Inicializar el tablero con n soldados aleatorios entre 1 y
//10 para cada Ejército. Cada soldado tendrá un nombre autogenerado: Soldado0X1,
//Soldado1X1, etc., un valor de puntos de vida autogenerado aleatoriamente [1..5], la fila y
//columna también autogenerados aleatoriamente (no puede haber 2 soldados en el mismo
//cuadrado). Se debe mostrar el tablero con todos los soldados creados (distinguir los de un
//ejército de los del otro ejército). Además de los datos del Soldado con mayor vida de cada
//ejército, el promedio de puntos de vida de todos los soldados creados por ejército, los datos
//de todos los soldados por ejército en el orden que fueron creados y un ranking de poder de
//todos los soldados creados por ejército (del que tiene más nivel de vida al que tiene menos)
//usando 2 diferentes algoritmos de ordenamiento (indicar conclusiones respecto a este
//ordenamiento de HashMaps). Finalmente, que muestre qué ejército ganará la batalla (indicar
//la métrica usada para decidir al ganador de la batalla). Hacerlo como programa iterativo.
package laboratorio8;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Videojuego5 {

    public static void main(String[] args) {
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);

        boolean repetitivo = true; // Controlar el bucle

        while (repetitivo) {
            // Crear dos ejércitos (HashMaps)
            Map<Integer, Soldado> ejercito1 = new HashMap<>();
            Map<Integer, Soldado> ejercito2 = new HashMap<>();

            // Generación de filas y columnas aleatorias para el tablero
            int filas = rand.nextInt(8) + 3; // Tamaño aleatorio entre 3 y 10
            int columnas = rand.nextInt(8) + 3;

            // Crear soldados para el primer ejército (1 a 10 soldados)
            crearEjercito(rand, ejercito1, 1, filas, columnas);
            // Crear soldados para el segundo ejército (1 a 10 soldados)
            crearEjercito(rand, ejercito2, 2, filas, columnas);

            // Mostrar el tablero con los soldados de ambos ejércitos
            System.out.println("\nTablero:");
            mostrarTablero(ejercito1, ejercito2, filas, columnas);

            // Mostrar el soldado con mayor vida de cada ejército
            System.out.println("\nSoldado con mayor vida del Ejército 1: " + soldadoConMasVida(ejercito1).getNombre());
            System.out.println("Soldado con mayor vida del Ejército 2: " + soldadoConMasVida(ejercito2).getNombre());

            // Promedio de puntos de vida por ejército
            System.out.println("\nPromedio de puntos de vida Ejército 1: " + promedioPuntosDeVida(ejercito1));
            System.out.println("Promedio de puntos de vida Ejército 2: " + promedioPuntosDeVida(ejercito2));

            // Mostrar ranking de soldados por nivel de vida (por ejército)
            mostrarRanking(ejercito1, "Ejército 1", rand);
            mostrarRanking(ejercito2, "Ejército 2", rand);

            // Decidir qué ejército gana basado en el total de puntos de vida
            int totalEjercito1 = totalPuntosDeVida(ejercito1);
            int totalEjercito2 = totalPuntosDeVida(ejercito2);

            System.out.println("\nTotal de puntos de vida Ejército 1: " + totalEjercito1);
            System.out.println("Total de puntos de vida Ejército 2: " + totalEjercito2);

            // Determinar al ganador
            if (totalEjercito1 > totalEjercito2) {
                System.out.println("\n¡El Ejército 1 gana!");
            } else if (totalEjercito1 < totalEjercito2) {
                System.out.println("\n¡El Ejército 2 gana!");
            } else {
                System.out.println("\n¡Es un empate!");
            }

            // Preguntar si desea seguir creando ejércitos
            System.out.print("\n¿Quieres crear nuevos ejércitos? (sí/no): ");
            String respuesta = scan.nextLine();
            if (!respuesta.equalsIgnoreCase("sí")) {
                repetitivo = false;
                System.out.println("Gracias por jugar.");
            }
        }

        scan.close();
    }

    // Método para crear un ejército de soldados aleatorios
    public static void crearEjercito(Random rand, Map<Integer, Soldado> ejercito, int numeroEjercito, 
                                      int filas, int columnas) {
        int numeroSoldados = rand.nextInt(10) + 1; // Número de soldados entre 1 y 10
        for (int i = 0; i < numeroSoldados; i++) {
            int fila, columna;
            // Asegurarse que no haya dos soldados en la misma posición
            do {
                fila = rand.nextInt(filas);
                columna = rand.nextInt(columnas);
            } while (yaExisteSoldadoEnPosicion(ejercito, fila, columna)); // Verificar si ya hay un soldado en esa celda

            // Crear un nombre único para el soldado
            String nombre = "Soldado" + i + "X" + numeroEjercito;
            int puntosDeVida = rand.nextInt(5) + 1;

            Soldado soldado = new Soldado();
            soldado.setNombre(nombre);
            soldado.setFila(fila);
            soldado.setColumna(columna);
            soldado.setNivelDeVida(puntosDeVida);

            // Guardar el soldado en el ejército
            ejercito.put(i, soldado);
        }
    }

    // Verificar si ya existe un soldado en la posición (fila, columna)
    public static boolean yaExisteSoldadoEnPosicion(Map<Integer, Soldado> ejercito, int fila, int columna) {
        for (Soldado soldado : ejercito.values()) {
            if (soldado.getFila() == fila && soldado.getColumna() == columna) {
                return true;
            }
        }
        return false;
    }

    // Mostrar el tablero con los soldados de ambos ejércitos
    public static void mostrarTablero(Map<Integer, Soldado> ejercito1, Map<Integer, Soldado> ejercito2,
                                      int filas, int columnas) {
        // Usar un tablero representado por filas y columnas
        String[][] tablero = new String[filas][columnas];
        // Inicializamos el tablero con "_" indicando una celda vacía
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                tablero[i][j] = "_";
            }
        }

        // Colocamos los soldados de los dos ejércitos en el tablero
        for (Soldado soldado : ejercito1.values()) {
            tablero[soldado.getFila()][soldado.getColumna()] = "S1"; // "S1" para Ejército 1
        }
        for (Soldado soldado : ejercito2.values()) {
            tablero[soldado.getFila()][soldado.getColumna()] = "S2"; // "S2" para Ejército 2
        }

        // Mostrar el tablero
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print("| " + tablero[i][j] + " ");
            }
            System.out.println("|");
        }
    }

    // Obtener el soldado con más puntos de vida
    public static Soldado soldadoConMasVida(Map<Integer, Soldado> ejercito) {
        Soldado soldadoMax = null;
        for (Soldado soldado : ejercito.values()) {
            if (soldadoMax == null || soldado.getNivelDeVida() > soldadoMax.getNivelDeVida()) {
                soldadoMax = soldado;
            }
        }
        return soldadoMax;
    }

    // Calcular el promedio de puntos de vida de un ejército
    public static double promedioPuntosDeVida(Map<Integer, Soldado> ejercito) {
        int suma = 0;
        int contador = 0;
        for (Soldado soldado : ejercito.values()) {
            suma += soldado.getNivelDeVida();
            contador++;
        }
        return (double) suma / contador;
    }

    // Mostrar el ranking de soldados por nivel de vida (por ejército)
    public static void mostrarRanking(Map<Integer, Soldado> ejercito, String nombreEjercito, Random rand) {
        List<Soldado> soldados = new ArrayList<>(ejercito.values());
        
        // Ordenamiento con Bubble Sort
        ordenarSoldadosPorNivelDeVidaBurbuja(soldados);

        System.out.println("\nRanking de poder de " + nombreEjercito + " con Bubble Sort:");
        for (Soldado soldado : soldados) {
            System.out.println(soldado.getNombre() + " | Puntos de vida: " + soldado.getNivelDeVida());
        }

        // Ordenamiento con Selección
        ordenarSoldadosPorNivelDeVidaSeleccion(soldados);

        System.out.println("\nRanking de poder de " + nombreEjercito + " con Selección:");
        for (Soldado soldado : soldados) {
            System.out.println(soldado.getNombre() + " | Puntos de vida: " + soldado.getNivelDeVida());
        }
    }

    // Total de puntos de vida de todos los soldados en el ejército
    public static int totalPuntosDeVida(Map<Integer, Soldado> ejercito) {
        int total = 0;
        for (Soldado soldado : ejercito.values()) {
            total += soldado.getNivelDeVida();
        }
        return total;
    }

    // Métodos de ordenamiento (Bubble Sort y Selección)
    public static void ordenarSoldadosPorNivelDeVidaBurbuja(List<Soldado> soldados) {
        boolean ordenado;
        do {
            ordenado = true;
            for (int i = 0; i < soldados.size() - 1; i++) {
                if (soldados.get(i).getNivelDeVida() < soldados.get(i + 1).getNivelDeVida()) {
                    // Intercambiar
                    Soldado temp = soldados.get(i);
                    soldados.set(i, soldados.get(i + 1));
                    soldados.set(i + 1, temp);
                    ordenado = false;
                }
            }
        } while (!ordenado);
    }

    public static void ordenarSoldadosPorNivelDeVidaSeleccion(List<Soldado> soldados) {
        for (int i = 0; i < soldados.size() - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < soldados.size(); j++) {
                if (soldados.get(j).getNivelDeVida() > soldados.get(maxIdx).getNivelDeVida()) {
                    maxIdx = j;
                }
            }
            // Intercambiar
            Soldado temp = soldados.get(maxIdx);
            soldados.set(maxIdx, soldados.get(i));
            soldados.set(i, temp);
        }
    }
}
