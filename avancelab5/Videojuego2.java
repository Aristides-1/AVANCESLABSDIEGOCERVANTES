//Autor: Diego Aristides Cervantes Apaza
//Problema: 
package laboratorio05;

import java.util.Random;
import java.util.Scanner;

public class Videojuego2 {
    public static void main(String[] args) {
        Soldado[] misSoldados = new Soldado[10];
        Scanner sc = new Scanner(System.in);
        String nomb, col;
        int fil, nivelDeVida;
        
        // Captura de datos para cada soldado
        for (int i = 0; i < misSoldados.length; i++) {
            System.out.println("Soldado " + (i + 1));
            System.out.print("Nombre: ");
            nomb = sc.next();
            System.out.print("Fila: ");
            fil = sc.nextInt();
            System.out.print("Columna: ");
            col = sc.next();
            System.out.print("Nivel de vida: ");
            nivelDeVida = sc.nextInt();

            // Se crea un objeto Soldado y se asigna su referencia a misSoldados
            misSoldados[i] = new Soldado();
            misSoldados[i].setNombre(nomb);
            misSoldados[i].setFila(fil);
            misSoldados[i].setColumna(col);
            misSoldados[i].setNivelDeVida(nivelDeVida);
        }

        // Mostrar soldados
        System.out.println("\nSoldados creados:");
        mostrarSoldados(misSoldados);
        
        // Mostrar soldados por nombre
        mostrarPorNombre(misSoldados);
        
        // Mostrar soldados por nivel de vida
        mostrarPorNivelDeVida(misSoldados);

        // Mostrar el soldado con mayor nivel de vida
        Soldado soldadoMayorVida = soldadoConMasNivelDeVida(misSoldados);
        System.out.println("\nSoldado con mayor nivel de vida:");
        System.out.println(soldadoMayorVida.getNombre() + " - Nivel de vida: " + soldadoMayorVida.getNivelDeVida());

        // Desordenar soldados aleatoriamente
        Soldado[] soldadosDesordenados = desordenarSoldados(misSoldados);
        System.out.println("\nSoldados desordenados:");
        mostrarSoldados(soldadosDesordenados);
    }

    // Método para mostrar todos los soldados
    public static void mostrarSoldados(Soldado[] flota) {
        for (Soldado soldado : flota) {
            System.out.println(soldado.getNombre() + " | Fila: " + soldado.getFila() + " | Columna: " + soldado.getColumna() + 
                               " | Nivel de vida: " + soldado.getNivelDeVida());
        }
    }

    // Método para mostrar todos los soldados con un nombre dado
    public static void mostrarPorNombre(Soldado[] flota) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nIngrese nombre para buscar: ");
        String nombreBuscado = sc.next();

        for (Soldado soldado : flota) {
            if (soldado.getNombre().equalsIgnoreCase(nombreBuscado)) {
                System.out.println(soldado.getNombre() + " | Fila: " + soldado.getFila() + " | Columna: " + soldado.getColumna() + 
                                   " | Nivel de vida: " + soldado.getNivelDeVida());
            }
        }
    }

    // Método para mostrar todos los soldados con nivel de vida menor o igual a un valor dado
    public static void mostrarPorNivelDeVida(Soldado[] flota) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nIngrese nivel de vida máximo: ");
        int nivelDeVidaMax = sc.nextInt();

        for (Soldado soldado : flota) {
            if (soldado.getNivelDeVida() <= nivelDeVidaMax) {
                System.out.println(soldado.getNombre() + " | Fila: " + soldado.getFila() + " | Columna: " + soldado.getColumna() + 
                                   " | Nivel de vida: " + soldado.getNivelDeVida());
            }
        }
    }

    // Método que devuelve el soldado con mayor nivel de vida
    public static Soldado soldadoConMasNivelDeVida(Soldado[] flota) {
        Soldado soldadoMayor = flota[0];
        for (Soldado soldado : flota) {
            if (soldado.getNivelDeVida() > soldadoMayor.getNivelDeVida()) {
                soldadoMayor = soldado;
            }
        }
        return soldadoMayor;
    }

    // Método que desordena los soldados aleatoriamente
    public static Soldado[] desordenarSoldados(Soldado[] flota) {
        Random rand = new Random();
        Soldado[] flotaDesordenada = flota.clone(); // Clonar para no modificar el arreglo original

        for (int i = 0; i < flotaDesordenada.length; i++) {
            int randomIndex = rand.nextInt(flotaDesordenada.length);
            // Intercambiar posiciones
            Soldado temp = flotaDesordenada[i];
            flotaDesordenada[i] = flotaDesordenada[randomIndex];
            flotaDesordenada[randomIndex] = temp;
        }
        return flotaDesordenada;
    }
}