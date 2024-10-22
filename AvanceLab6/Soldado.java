//Autor: Diego Aristides Cervantes Apaza
//Problema: Cree un Proyecto llamado Laboratorio6
//2. Usted deberá crear las dos clases Soldado.java y VideoJuego3.java. Puede reutilizar lo
//desarrollado en Laboratorios anteriores.
//3. Del Soldado nos importa el nombre, puntos de vida, fila y columna (posición en el tablero).
//4. El juego se desarrollará en el mismo tablero de los laboratorios anteriores. Pero ahora el
//tablero debe ser un ArrayList bidimensional.
//5. Tendrá 2 Ejércitos. Inicializar el tablero con n soldados aleatorios entre 1 y 10 para cada
//Ejército. Cada soldado tendrá un nombre autogenerado: Soldado0X1, Soldado1X1, etc., un
//valor de puntos de vida autogenerado aleatoriamente [1..5], la fila y columna también
//autogenerados aleatoriamente (no puede haber 2 soldados en el mismo cuadrado). Se debe
//mostrar el tablero con todos los soldados creados (distinguir los de un ejército de los del otro
//ejército). Además de los datos del Soldado con mayor vida de cada ejército, el promedio de
//puntos de vida de todos los soldados creados por ejército, los datos de todos los soldados por
//ejército en el orden que fueron creados y un ranking de poder de todos los soldados creados
//por ejército (del que tiene más nivel de vida al que tiene menos) usando 2 diferentes
//algoritmos de ordenamiento. Finalmente, que muestre qué ejército ganará la batalla (indicar
//la métrica usada para decidir al ganador de la batalla).
package laboratorio6;

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