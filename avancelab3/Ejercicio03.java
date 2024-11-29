//Autor: Diego Aristides Cervantes Apaza
//Problema: Escribir un programa donde se creen 2 ejércitos, cada uno con un número 
//aleatorio de soldados entre 1 y 5, considerando sólo su nombre. Sus datos se 
//inicializan automáticamente con nombres tales como “Soldado0”, “Soldado1”, etc. 
//Luego de crear los 2 ejércitos se deben mostrar los datos de todos los soldados 
//de ambos ejércitos e indicar qué ejército fue el ganador.
//Restricción: aplicar arreglos DE OBJETOS y métodos para inicializar los ejércitos, 
//mostrar ejército y mostrar ejército ganador. La métrica a aplicar para indicar 
//el ganador es el mayor número de soldados de cada ejército, puede haber empates. 
//APLICAR ARREGLO DE OBJETOS.
package lab3_diegocervantes;

import java.util.Random;
public class Ejercicio03 {

    public static void main(String[] args) {
        //Creación de los ejércitos
        SoldadoGuerra[] ejercito1 = inicializarEjercito(1);
        SoldadoGuerra[] ejercito2 = inicializarEjercito(2);

        //Mostrar los datos de ambos ejércitos
        System.out.println("Ejército 1:");
        mostrarEjercito(ejercito1);
        System.out.println("\nEjército 2:");
        mostrarEjercito(ejercito2);

        //Determinar y mostrar el ejército ganador
        mostrarGanador(ejercito1, ejercito2);
    }

    //Método para inicializar un ejército con un número aleatorio de soldados
    public static SoldadoGuerra[] inicializarEjercito(int numeroEjercito) {
        Random rand = new Random();
        int cantidadSoldados = rand.nextInt(5) + 1; // Número de soldados entre 1 y 5
        SoldadoGuerra[] ejercito = new SoldadoGuerra[cantidadSoldados];

        //Crear cada soldado con nombres "Soldado0", "Soldado1", etc.
        for (int i = 0; i < ejercito.length; i++) {
            ejercito[i] = new SoldadoGuerra("Soldado" + i + "_E" + numeroEjercito);
        }
        return ejercito;
    }

    //Método para mostrar los datos de un ejército
    public static void mostrarEjercito(SoldadoGuerra[] ejercito) {
        for (int i = 0; i < ejercito.length; i++) {
            System.out.println("Nombre del soldado " + (i + 1) + ": " + ejercito[i].getNombre());
        }
        System.out.println("Total de soldados: " + ejercito.length);
    }

    //Método para determinar y mostrar el ejército ganador
    public static void mostrarGanador(SoldadoGuerra[] ejercito1, SoldadoGuerra[] ejercito2) {
        System.out.println("\nResultados:");
        System.out.println("Ejército 1 tiene " + ejercito1.length + " soldados.");
        System.out.println("Ejército 2 tiene " + ejercito2.length + " soldados.");

        //Comparar el número de soldados y determinar el ganador
        if (ejercito1.length > ejercito2.length) {
            System.out.println("¡Ejército 1 es el ganador!");
        } else if (ejercito2.length > ejercito1.length) {
            System.out.println("¡Ejército 2 es el ganador!");
        } else {
            System.out.println("¡Es un empate!");
        }
    }
}