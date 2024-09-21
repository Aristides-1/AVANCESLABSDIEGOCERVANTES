//Autor: Diego Aristides Cervantes Apaza
//Problema:Escribir un programa donde se creen 5 soldados
//considerando solo su nombre. Ingresar sus datos y después mostrarlos.


package EjerciciosLab;
import java.util.Scanner;
public class Ejercicio01 {

    public static void main (String [] args){
        Scanner scan = new Scanner(System.in);
        String soldado1, soldado2, soldado3, soldado4, soldado5;
        
        System.out.println("Ingrese el nombre del soldado 1:");
        soldado1=scan.nextLine();
        System.out.println("Ingrese el nombre del soldado 2:");
        soldado2=scan.nextLine();
        System.out.println("Ingrese el nombre del soldado 3:");
        soldado3=scan.nextLine();
        System.out.println("Ingrese el nombre del soldado 4:");
        soldado4=scan.nextLine();
        System.out.println("Ingrese el nombre del soldado 5:");
        soldado5=scan.nextLine();
        
        
        System.out.println("Los nombres de los soldados son:" +"\n" +
                soldado1+ "\n"+ soldado2 + "\n"+ soldado3+"\n"+soldado4+
                "\n"+soldado5);
  
    }
}
