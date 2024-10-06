//Autor: Diego Aristides Cervantes Apaza
//Problema: Escribir un programa donde se creen 5 soldados considerando
//su nombre y nivel de vida. Ingresar sus datos y después mostrarlos.
//Restricción: aplicar arreglos con objetos

package lab3_diegocervantes;

import java.util.Scanner;
import java.util.Random;

public class Ejercicio02 {

    public static void main(String[] args) {

        // Declaración de objetos para las clases de ingreso de datos y obtención de aleatorios
        Scanner scan = new Scanner(System.in);
        Random num = new Random();

        // Creación de arreglo de objetos Soldado
        Soldado[] soldados = new Soldado[5];

        // Ingreso de datos de nombres
        System.out.println("Ingrese el nombre de los soldados:");

        // Bucle para almacenar nombres ingresados y asignar vida aleatoria
        for (int i = 0; i < soldados.length; i++) {
            System.out.print("Nombre del soldado " + (i + 1) + ": ");
            String nombre = scan.nextLine();
            int vida = num.nextInt(5) + 1; // Genera vida aleatoria entre 1 y 5
            soldados[i] = new Soldado(nombre, vida); // Crea un objeto Soldado y lo almacena en el arreglo
        }

        // Bucle para imprimir los datos de los soldados previamente ingresados y generados respectivamente
        System.out.println("\nDatos de los soldados:");
        for (int i = 0; i < soldados.length; i++) {
            System.out.println("El nombre del soldado " + (i + 1) + " es " +
                    soldados[i].getNombre() + " y su vida es " + soldados[i].getVida() + ".");
        }
    }
}