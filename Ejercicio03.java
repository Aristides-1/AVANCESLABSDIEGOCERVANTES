//Autor: Diego Aristides Cervantes Apaza
//Problema: Escribir un programa donde se creen 5 soldados considerando su 
//nombre. Ingresar datos y después mostrarlos
//Use arreglos estándar

package EjerciciosLab;

import java.util.Scanner;
public class Ejercicio03 {
    public static void main (String [] args){
    	
        Scanner scan = new Scanner(System.in);
        
        //Declaración de variables
        int n=5, i;
        
        //Creación de arreglo
        String[] soldados = new String[n];
        
        //Mensaje de ingreso de datos
        System.out.println("Ingrese usted los nombres de los soldados:");
        
        //Bucle para almacenar los nombres de los soldados
        for (i=0; i<soldados.length ; i++){
            soldados[i]=scan.nextLine();   
        }
        
        //Bucle para mostrar todos los elementos del arreglo 
        for (i=0; i<soldados.length; i++){
            System.out.println("El nombre del soldado " +(i+1)+" es :"+
                    soldados [i]);
         }
     
     
    }  
}
