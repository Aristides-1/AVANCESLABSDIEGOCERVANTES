//Autor: Diego Aristides Cervantes Apaza
//Problema: Escribir un programa donde se creen 5 soldados considerando su 
//nombre
//y nivel de vida (aleatorio entre 1 y 5). Ingresar sus datos y después 
//mostrarlos.

package EjerciciosLab;

import java.util.Scanner;
import java.util.Random;
public class Ejercicio02 {

    public static void main (String [] args){
        Scanner scan = new Scanner(System.in);
        Random num = new Random();
        //Declaración de variables
        String soldado1, soldado2, soldado3, soldado4, soldado5;
        int vidaSoldado1, vidaSoldado2, vidaSoldado3, vidaSoldado4, 
                vidaSoldado5;
        
        //Ingreso de nombres de los soldados
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
        
        //Aleatorios para la vida de los soldados
        vidaSoldado1= num.nextInt(5)+1;
        vidaSoldado2= num.nextInt(5)+1;
        vidaSoldado3= (num.nextInt(5)+1);
        vidaSoldado4= (num.nextInt(5)+1);
        vidaSoldado5= (num.nextInt(5)+1);
        
        //Muestra de los datos ingresados 
        System.out.println ("Los datos de los soldados son: "+"\n"+
                "Número de soldado" +"\t"+"NOMBRE"+"\t\t\t\t"+"VIDA"+"\n"+
                "Soldado 1:" +"\t\t"+soldado1+"\t\t\t\t"+vidaSoldado1+ "\n"+
                "Soldado 2:"+"\t\t"+soldado2+"\t\t\t\t"+vidaSoldado2+ "\n"+
                "Soldado 3:" +"\t\t"+soldado3+"\t\t\t\t"+vidaSoldado3+ "\n"+
                "Soldado 4:" +"\t\t"+soldado4+"\t\t\t\t"+vidaSoldado4+ "\n"+
                "Soldado 5:" +"\t\t"+soldado5+"\t\t\t\t"+vidaSoldado5);
     }
}
     