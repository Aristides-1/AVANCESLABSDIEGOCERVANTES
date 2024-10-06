//Autor: Diego Aristides Cervantes Apaza
//Problema: Escribir un programa donde se creen 5 soldados considerando
//su nombre y nivel de vida. Ingresar sus datos y después mostrarlos.
//Restricción: aplicar arreglos con objetos


package lab3_diegocervantes;

public class Soldado {
    private String nombre;
    private int vida;

    // Constructor de la clase Soldado
    public Soldado(String nombre, int vida) {
        this.nombre = nombre;
        this.vida = vida;
    }

    // Método para obtener el nombre del soldado
    public String getNombre() {
        return nombre;
    }

    // Método para obtener la vida del soldado
    public int getVida() {
        return vida;
    }
}