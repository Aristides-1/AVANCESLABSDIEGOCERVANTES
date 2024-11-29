//Autor: Diego Aristides Cervantes Apaza
//Problema: 1. Cree un Proyecto llamado Laboratorio5
//2. Usted deberá crear las dos clases Soldado.java y VideoJuego2.java. Puede reutilizar lo
//desarrollado en Laboratorio 3 y 4.
//3. Del Soldado nos importa el nombre, nivel de vida, fila y columna (posición en el tablero).
//4. El juego se desarrollará en el mismo tablero de los laboratorios anteriores. Pero ahora el
//tablero debe ser un arreglo bidimensional de objetos.
//5. Inicializar el tablero con n soldados aleatorios entre 1 y 10. Cada soldado tendrá un nombre
//autogenerado: Soldado0, Soldado1, etc., un valor de nivel de vida autogenerado
//aleatoriamente [1..5], la fila y columna también autogenerados aleatoriamente (verificar que
//no puede haber 2 soldados en el mismo cuadrado). Se debe mostrar el tablero con todos los
//soldados creados (usar caracteres como | _ y otros). Además, mostrar los datos del Soldado
//con mayor nivel de vida, el promedio de nivel de vida de todos los soldados creados, el nivel
//de vida de todo el ejército, los datos de todos los soldados en el orden que fueron creados y
//un ranking de poder de todos los soldados creados, del que tiene más nivel de vida al que
//tiene menos (usar al menos 2 algoritmos de ordenamiento).
package laboratorio05;

import java.util.Random;

public class Videojuego2 {
    public static void main(String[] args) {
        Random rand = new Random();

        //Generación de filas y columnas aleatorias
        int filas = rand.nextInt(8) + 3; 
        int columnas = rand.nextInt(8) + 3;  

        
        //Creación de arreglo bidimensional
        Soldado[][] tablero = new Soldado[filas][columnas];
        
        //Generación de cantidad de soldados totales
        int numeroSoldados = rand.nextInt(10) + 1; 
        
        //Inicializar soldados aleatorios asegurando que no haya duplicados
        for (int i = 0; i < numeroSoldados; i++) {
            int fila, columna;
            do {
                fila = rand.nextInt(filas); //Filas aleatorias dentro del rango
                columna = rand.nextInt(columnas); //Columnas aleatorias dentro del rango
            } while (tablero[fila][columna] != null); //Aseguramos que no haya dos soldados en el mismo lugar

            //Creación de nombres de soldados autogenerados
            String nombre = "Soldado" + i;
            int nivelDeVida = rand.nextInt(5) + 1; //Nivel de vida aleatorio
            Soldado soldado = new Soldado();
            soldado.setNombre(nombre);
            soldado.setFila(fila);
            soldado.setColumna(columna);
            soldado.setNivelDeVida(nivelDeVida);
            tablero[fila][columna] = soldado; //Meter un soldado generado al tablero
        }

        //Impresión de tablero
        System.out.println("Tablero:");
        mostrarTablero(tablero);

        //Impresión de soldado con más vida
        Soldado soldadoMayorVida = soldadoConMasNivelDeVida(tablero);
        System.out.println("\nSoldado con mayor nivel de vida:");
        System.out.println(soldadoMayorVida.getNombre() + " - Nivel de vida: " + soldadoMayorVida.getNivelDeVida());

        //Impresión del nivel promedio de vida de los soldados
        double promedioNivelDeVida = promedioNivelDeVida(tablero);
        System.out.println("Promedio de nivel de vida: " + promedioNivelDeVida);

        //Impresión vida total
        int nivelDeVidaTotal = nivelDeVidaTotal(tablero);
        System.out.println("Nivel de vida total del ejército: " + nivelDeVidaTotal);

        //Impresión de los soldados en el orden que fueron creados
        System.out.println("\nSoldados en el orden que fueron creados:");
        mostrarSoldadosEnOrden(tablero);

        //Mostrar ranking de soldados por nivel de vida (usando burbuja)
        Soldado[] soldadosRanking = obtenerListaDeSoldados(tablero);
        ordenarSoldadosPorNivelDeVidaBurbuja(soldadosRanking);
        System.out.println("\nRanking de soldados por nivel de vida (Burbuja):");
        mostrarSoldados(soldadosRanking);

        //Mostrar ranking de soldados por nivel de vida (usando selección)
        ordenarSoldadosPorNivelDeVidaSeleccion(soldadosRanking);
        System.out.println("\nRanking de soldados por nivel de vida (Selección):");
        mostrarSoldados(soldadosRanking);
    }

    //Método para mostrar el tablero con los soldados
    public static void mostrarTablero(Soldado[][] tablero) {
        // Imprimir la primera fila de letras (A, B, C, ...)
       System.out.print("   ");  // Espacio para la columna de números
       for (int j = 0; j < tablero[0].length; j++) {
           System.out.print("  " + (char) ('A' + j) + " ");
       }
       System.out.println();

       //Impresión del tablero con los números en la primera columna
       for (int i = 0; i < tablero.length; i++) {
           System.out.print((i + 1) + " "); // Número de fila
           if (i + 1 < 10) {
               System.out.print(" "); // Alineación para números de una cifra
           }

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

    //Método que devuelve el soldado con mayor nivel de vida
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

    //Método que calcula el promedio de nivel de vida del ejército
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

    //Método que calcula el nivel de vida total del ejército
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

    //Método para mostrar los soldados en el orden en que fueron creados
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

    //Método para convertir el tablero en una lista unidimensional de soldados
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

    //Método que cuenta el número de soldados en el tablero
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

    //Método de ordenamiento por burbuja
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

    //Método de ordenamiento por selección
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

    //Método para mostrar una lista de soldados
    public static void mostrarSoldados(Soldado[] soldados) {
        for (Soldado soldado : soldados) {
            System.out.println(soldado.getNombre() + " | Nivel de vida: " + soldado.getNivelDeVida());
        }
    }
}