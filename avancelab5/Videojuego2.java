//Autor: Diego Aristides Cervantes Apaza
//Problema: 
package laboratorio05;

import java.util.Random;

public class Videojuego2 {
    public static void main(String[] args) {
        Random rand = new Random();

        // Generar filas y columnas aleatoriamente (por ejemplo, entre 3 y 10)
        int filas = rand.nextInt(8) + 3;  // Filas entre 3 y 10
        int columnas = rand.nextInt(8) + 3;  // Columnas entre 3 y 10

        Soldado[][] tablero = new Soldado[filas][columnas];
        int numeroSoldados = rand.nextInt(10) + 1; // Genera entre 1 y 10 soldados
        
        // Inicializar soldados aleatorios asegurando que no haya duplicados
        for (int i = 0; i < numeroSoldados; i++) {
            int fila, columna;
            do {
                fila = rand.nextInt(filas); // Filas aleatorias dentro del rango
                columna = rand.nextInt(columnas); // Columnas aleatorias dentro del rango
            } while (tablero[fila][columna] != null); // Asegurar que no haya dos soldados en el mismo lugar

            String nombre = "Soldado" + i;
            int nivelDeVida = rand.nextInt(5) + 1; // Nivel de vida entre 1 y 5
            Soldado soldado = new Soldado();
            soldado.setNombre(nombre);
            soldado.setFila(fila);
            soldado.setColumna(columna);
            soldado.setNivelDeVida(nivelDeVida);
            tablero[fila][columna] = soldado; // Asignar el soldado en el tablero
        }

        // Mostrar el tablero
        System.out.println("Tablero:");
        mostrarTablero(tablero);

        // Mostrar datos del soldado con mayor nivel de vida
        Soldado soldadoMayorVida = soldadoConMasNivelDeVida(tablero);
        System.out.println("\nSoldado con mayor nivel de vida:");
        System.out.println(soldadoMayorVida.getNombre() + " - Nivel de vida: " + soldadoMayorVida.getNivelDeVida());

        // Mostrar promedio del nivel de vida del ejército
        double promedioNivelDeVida = promedioNivelDeVida(tablero);
        System.out.println("Promedio de nivel de vida: " + promedioNivelDeVida);

        // Mostrar el nivel de vida total del ejército
        int nivelDeVidaTotal = nivelDeVidaTotal(tablero);
        System.out.println("Nivel de vida total del ejército: " + nivelDeVidaTotal);

        // Mostrar los soldados en el orden en que fueron creados
        System.out.println("\nSoldados en el orden que fueron creados:");
        mostrarSoldadosEnOrden(tablero);

        // Mostrar ranking de soldados por nivel de vida (usando burbuja)
        Soldado[] soldadosRanking = obtenerListaDeSoldados(tablero);
        ordenarSoldadosPorNivelDeVidaBurbuja(soldadosRanking);
        System.out.println("\nRanking de soldados por nivel de vida (Burbuja):");
        mostrarSoldados(soldadosRanking);

        // Mostrar ranking de soldados por nivel de vida (usando selección)
        ordenarSoldadosPorNivelDeVidaSeleccion(soldadosRanking);
        System.out.println("\nRanking de soldados por nivel de vida (Selección):");
        mostrarSoldados(soldadosRanking);
    }

    // Método para mostrar el tablero con los soldados
    public static void mostrarTablero(Soldado[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] == null) {
                    System.out.print("| _ ");
                } else {
                    System.out.print("| S ");
                }
            }
            System.out.println("|");
        }
    }

    // Método que devuelve el soldado con mayor nivel de vida
    public static Soldado soldadoConMasNivelDeVida(Soldado[][] tablero) {
        Soldado soldadoMayor = null;
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                Soldado actual = tablero[i][j];
                if (actual != null && (soldadoMayor == null || actual.getNivelDeVida() > soldadoMayor.getNivelDeVida())) {
                    soldadoMayor = actual;
                }
            }
        }
        return soldadoMayor;
    }

    // Método que calcula el promedio de nivel de vida del ejército
    public static double promedioNivelDeVida(Soldado[][] tablero) {
        int suma = 0;
        int contador = 0;
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] != null) {
                    suma += tablero[i][j].getNivelDeVida();
                    contador++;
                }
            }
        }
        return (double) suma / contador;
    }

    // Método que calcula el nivel de vida total del ejército
    public static int nivelDeVidaTotal(Soldado[][] tablero) {
        int suma = 0;
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] != null) {
                    suma += tablero[i][j].getNivelDeVida();
                }
            }
        }
        return suma;
    }

    // Método para mostrar los soldados en el orden en que fueron creados
    public static void mostrarSoldadosEnOrden(Soldado[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] != null) {
                    Soldado soldado = tablero[i][j];
                    System.out.println(soldado.getNombre() + " | Fila: " + soldado.getFila() + " | Columna: " + soldado.getColumna() + 
                                       " | Nivel de vida: " + soldado.getNivelDeVida());
                }
            }
        }
    }

    // Método para convertir el tablero en una lista unidimensional de soldados
    public static Soldado[] obtenerListaDeSoldados(Soldado[][] tablero) {
        Soldado[] soldados = new Soldado[contarSoldados(tablero)];
        int index = 0;
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] != null) {
                    soldados[index++] = tablero[i][j];
                }
            }
        }
        return soldados;
    }

    // Método que cuenta el número de soldados en el tablero
    public static int contarSoldados(Soldado[][] tablero) {
        int contador = 0;
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] != null) {
                    contador++;
                }
            }
        }
        return contador;
    }

    // Método de ordenamiento por burbuja
    public static void ordenarSoldadosPorNivelDeVidaBurbuja(Soldado[] soldados) {
        boolean ordenado;
        do {
            ordenado = true;
            for (int i = 0; i < soldados.length - 1; i++) {
                if (soldados[i].getNivelDeVida() < soldados[i + 1].getNivelDeVida()) {
                    Soldado temp = soldados[i];
                    soldados[i] = soldados[i + 1];
                    soldados[i + 1] = temp;
                    ordenado = false;
                }
            }
        } while (!ordenado);
    }

    // Método de ordenamiento por selección
    public static void ordenarSoldadosPorNivelDeVidaSeleccion(Soldado[] soldados) {
        for (int i = 0; i < soldados.length - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < soldados.length; j++) {
                if (soldados[j].getNivelDeVida() > soldados[maxIdx].getNivelDeVida()) {
                    maxIdx = j;
                }
            }
            Soldado temp = soldados[maxIdx];
            soldados[maxIdx] = soldados[i];
            soldados[i] = temp;
        }
    }

    // Método para mostrar una lista de soldados
    public static void mostrarSoldados(Soldado[] soldados) {
        for (Soldado soldado : soldados) {
            System.out.println(soldado.getNombre() + " | Nivel de vida: " + soldado.getNivelDeVida());
        }
    }
}