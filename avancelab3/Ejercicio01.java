//Autor: Diego Aristides Cervantes Apaza
//Problema: Completar el juego de naves
package lab3_diegocervantes;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Ejercicio01 {
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
            System.out.print("Fila: ");
            fil = sc.nextInt();
            System.out.print("Columna: ");
            col = sc.next();
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
        
        // Mostrar naves por nombre
        mostrarPorNombre(misNaves);
        
        // Mostrar naves por puntos
        mostrarPorPuntos(misNaves);

        // Mostrar la nave con más puntos
        Nave naveMayorPuntos = naveConMasPuntos(misNaves);
        System.out.println("\nNave con más puntos:");
        System.out.println(naveMayorPuntos.getNombre() + " - Puntos: " + naveMayorPuntos.getPuntos());

        // Desordenar naves aleatoriamente
        Nave[] navesDesordenadas = desordenarNaves(misNaves);
        System.out.println("\nNaves desordenadas:");
        mostrarNaves(navesDesordenadas);
    }

    // Método para mostrar todas las naves
    public static void mostrarNaves(Nave[] flota) {
        for (Nave nave : flota) {
            System.out.println(nave.getNombre() + " | Fila: " + nave.getFila() + " | Columna: " + nave.getColumna() + 
                               " | Estado: " + nave.getEstado() + " | Puntos: " + nave.getPuntos());
        }
    }

    // Método para mostrar todas las naves con un nombre dado
    public static void mostrarPorNombre(Nave[] flota) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nIngrese nombre para buscar: ");
        String nombreBuscado = sc.next();

        for (Nave nave : flota) {
            if (nave.getNombre().equalsIgnoreCase(nombreBuscado)) {
                System.out.println(nave.getNombre() + " | Fila: " + nave.getFila() + " | Columna: " + nave.getColumna() + 
                                   " | Estado: " + nave.getEstado() + " | Puntos: " + nave.getPuntos());
            }
        }
    }

    // Método para mostrar todas las naves con puntos menores o iguales a un valor dado
    public static void mostrarPorPuntos(Nave[] flota) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nIngrese puntos máximos: ");
        int puntosMax = sc.nextInt();

        for (Nave nave : flota) {
            if (nave.getPuntos() <= puntosMax) {
                System.out.println(nave.getNombre() + " | Fila: " + nave.getFila() + " | Columna: " + nave.getColumna() + 
                                   " | Estado: " + nave.getEstado() + " | Puntos: " + nave.getPuntos());
            }
        }
    }

    // Método que devuelve la nave con mayor número de puntos
    public static Nave naveConMasPuntos(Nave[] flota) {
        Nave naveMayor = flota[0];
        for (Nave nave : flota) {
            if (nave.getPuntos() > naveMayor.getPuntos()) {
                naveMayor = nave;
            }
        }
        return naveMayor;
    }

    // Método que desordena las naves aleatoriamente
    public static Nave[] desordenarNaves(Nave[] flota) {
        Random rand = new Random();
        Nave[] flotaDesordenada = flota.clone(); // Clonar para no modificar el arreglo original

        for (int i = 0; i < flotaDesordenada.length; i++) {
            int randomIndex = rand.nextInt(flotaDesordenada.length);
            // Intercambiar posiciones
            Nave temp = flotaDesordenada[i];
            flotaDesordenada[i] = flotaDesordenada[randomIndex];
            flotaDesordenada[randomIndex] = temp;
        }
        return flotaDesordenada;
    }
}