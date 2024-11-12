//Autor: Diego Aristides Cervantes Apaza
//Problema:Tendrá 2 Ejércitos (utilizar la estructura de datos más adecuada). Inicializar el tablero con n
//soldados aleatorios entre 1 y 10 para cada Ejército. Cada soldado tendrá un nombre
//autogenerado: Soldado0X1, Soldado1X1, etc., un valor de puntos de vida autogenerado
//aleatoriamente [1..5], la fila y columna también autogenerados aleatoriamente (no puede
//haber 2 soldados en el mismo cuadrado). Se debe mostrar el tablero con todos los soldados
//creados y sus puntos de vida (usar caracteres como | _ y otros y distinguir los de un ejército
//de los del otro ejército). Además de los datos del Soldado con mayor vida de cada ejército, el
//promedio de puntos de vida de todos los soldados creados por ejército, los datos de todos los
//soldados por ejército en el orden que fueron creados y un ranking de poder de todos los
//soldados creados por ejército (del que tiene más nivel de vida al que tiene menos) usando 2
//diferentes algoritmos de ordenamiento. Finalmente, que muestre qué ejército ganará la
//batalla (indicar la métrica usada para decidir al ganador de la batalla). Hacer el programa
//iterativo.

package lab7;


public class Soldado {
    private String nombre;
    private int fila;
    private int columna;
    private int nivelDeVida;

    // Métodos mutadores
    public void setNombre(String n) { 
        nombre = n; 
    }
    public void setFila(int f) { 
        fila = f; 
    }
    public void setColumna(int c) { 
        columna = c; 
    }
    public void setNivelDeVida(int f) { 
        nivelDeVida = f; 
    }

    // Métodos accesores
    public String getNombre() { 
        return nombre; 
    }
    public int getFila() { 
        return fila; 
    }
    public int getColumna() {
        return columna; 
    }
    public int getNivelDeVida() {
        return nivelDeVida; 
    }
}