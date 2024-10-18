//Autor: Diego Aristides Cervantes Apaza
//Problema: Utilizando el laboratorio 3 realizar el juego de ordenamientos
package laboratorio04;

public class Nave {
    private String nombre;
    private int fila;
    private String columna;
    private boolean estado;
    private int puntos;

    // Métodos mutadores
    public void setNombre(String n) { 
        nombre = n; 
    }
    public void setFila(int f) { 
        fila = f; 
    }
    public void setColumna(String c) { 
        columna = c; 
    }
    public void setEstado(boolean e) { 
        estado = e; 
    }
    public void setPuntos(int p) {
        puntos = p; 
    }

    // Métodos accesores
    public String getNombre() { 
        return nombre; 
    }
    public int getFila() { 
        return fila; 
    }
    public String getColumna() {
        return columna; 
    }
    public boolean getEstado() {
        return estado; 
    }
    public int getPuntos() {
        return puntos; 
    }
}