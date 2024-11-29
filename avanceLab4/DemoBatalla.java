//Autor: Diego Aristides Cervantes Apaza
//Problema: Utilizando el laboratorio 03 utilizar métodos de ordenamiento
package laboratorio04;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class DemoBatalla {
    public static void main(String[] args) {
        Nave[] misNaves = new Nave[10];
        Scanner sc = new Scanner(System.in);
        String nomb, col;
        int fil, punt;
        boolean est;
        
        // Captura de datos para cada nave
        for (int i = 0; i < misNaves.length; i++) {
            System.out.println("Nave " + (i + 1));
            System.out.print("Nombre: ");
            nomb = sc.next();
            System.out.print("Fila (1-10): ");
            fil = sc.nextInt();
            System.out.print("Columna (A-J): ");
            col = sc.next().toUpperCase();
            System.out.print("Estado (true/false): ");
            est = sc.nextBoolean();
            System.out.print("Puntos: ");
            punt = sc.nextInt();

            // Se crea un objeto Nave y se asigna su referencia a misNaves
            misNaves[i] = new Nave();
            misNaves[i].setNombre(nomb);
            misNaves[i].setFila(fil);
            misNaves[i].setColumna(col);
            misNaves[i].setEstado(est);
            misNaves[i].setPuntos(punt);
        }

        // Mostrar naves
        System.out.println("\nNaves creadas:");
        mostrarNaves(misNaves);
        
        // Búsqueda lineal
        System.out.println("\nIngrese el nombre a buscar con búsqueda lineal:");
        String nombreBuscado = sc.next();
        int index = busquedaLinealNombre(misNaves, nombreBuscado);
        if (index != -1) {
            System.out.println("Nave encontrada: " + misNaves[index].getNombre() + " con " + misNaves[index].getPuntos() + " puntos.");
        } else {
            System.out.println("Nave no encontrada.");
        }

        // Ordenar por puntos usando burbuja
        System.out.println("\nNaves ordenadas por puntos (Burbuja):");
        ordenarPorPuntosBurbuja(misNaves);
        mostrarNaves(misNaves);
        
        // Ordenar por nombre de A a Z usando selección
        System.out.println("\nNaves ordenadas por nombre (Selección):");
        ordenarPorNombreSeleccion(misNaves);
        mostrarNaves(misNaves);
        
        // Búsqueda binaria
        System.out.println("\nIngrese el nombre a buscar con búsqueda binaria:");
        nombreBuscado = sc.next();
        ordenarPorNombreBurbuja(misNaves);  // Ordenar antes de usar búsqueda binaria
        int binIndex = busquedaBinariaNombre(misNaves, nombreBuscado);
        if (binIndex != -1) {
            System.out.println("Nave encontrada: " + misNaves[binIndex].getNombre() + " con " + misNaves[binIndex].getPuntos() + " puntos.");
        } else {
            System.out.println("Nave no encontrada.");
        }
    }

    // Método para mostrar todas las naves
    public static void mostrarNaves(Nave[] flota) {
        for (Nave nave : flota) {
            System.out.println(nave.getNombre() + " | Fila: " + nave.getFila() + " | Columna: " + nave.getColumna() + 
                               " | Estado: " + nave.getEstado() + " | Puntos: " + nave.getPuntos());
        }
    }

    // Método para buscar la primera nave con un nombre que se pidió por teclado
    public static int busquedaLinealNombre(Nave[] flota, String s) {
        for (int i = 0; i < flota.length; i++) {
            if (flota[i].getNombre().equalsIgnoreCase(s)) {
                return i;
            }
        }
        return -1;  // No encontrado
    }

    // Método que ordena por número de puntos de menor a mayor (Burbuja)
    public static void ordenarPorPuntosBurbuja(Nave[] flota) {
        int n = flota.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (flota[j].getPuntos() > flota[j + 1].getPuntos()) {
                    // Intercambiar
                    Nave temp = flota[j];
                    flota[j] = flota[j + 1];
                    flota[j + 1] = temp;
                }
            }
        }
    }

    // Método que ordena por nombre de A a Z (Selección)
    public static void ordenarPorNombreSeleccion(Nave[] flota) {
        int n = flota.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (flota[j].getNombre().compareToIgnoreCase(flota[minIndex].getNombre()) < 0) {
                    minIndex = j;
                }
            }
            // Intercambiar
            Nave temp = flota[minIndex];
            flota[minIndex] = flota[i];
            flota[i] = temp;
        }
    }

    // Método que ordena por nombre de A a Z (Burbuja)
    public static void ordenarPorNombreBurbuja(Nave[] flota) {
        int n = flota.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (flota[j].getNombre().compareToIgnoreCase(flota[j + 1].getNombre()) > 0) {
                    // Intercambiar
                    Nave temp = flota[j];
                    flota[j] = flota[j + 1];
                    flota[j + 1] = temp;
                }
            }
        }
    }
    // Método para buscar la primera nave con un nombre que se pidió por teclado (Búsqueda Binaria)
    public static int busquedaBinariaNombre(Nave[] flota, String s) {
        int inicio = 0;
        int fin = flota.length - 1;
        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            int comparacion = flota[medio].getNombre().compareToIgnoreCase(s);
            if (comparacion == 0) {
                return medio;
            } else if (comparacion < 0) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }
        return -1;  // No encontrado
    }

    // Método que ordena por puntos de mayor a menor (Inserción)
    public static void ordenarPorPuntosInsercion(Nave[] flota) {
        for (int i = 1; i < flota.length; i++) {
            Nave actual = flota[i];
            int j = i - 1;
            while (j >= 0 && flota[j].getPuntos() < actual.getPuntos()) {
                flota[j + 1] = flota[j];
                j--;
            }
            flota[j + 1] = actual;
        }
    }

    // Método que ordena por nombre de Z a A (Inserción)
    public static void ordenarPorNombreInsercion(Nave[] flota) {
        for (int i = 1; i < flota.length; i++) {
            Nave actual = flota[i];
            int j = i - 1;
            while (j >= 0 && flota[j].getNombre().compareToIgnoreCase(actual.getNombre()) < 0) {
                flota[j + 1] = flota[j];
                j--;
            }
            flota[j + 1] = actual;
        }
    }
}