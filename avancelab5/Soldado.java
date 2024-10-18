//Autor: Diego Aristides Cervantes Apaza
//Problema: 
package laboratorio05;

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