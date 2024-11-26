//Autor: Diego Aristides Cervantes Apaza
//Problema: 1. Cree un Proyecto llamado Laboratorio8
//2. Usted deberá crear las dos clases Soldado.java y VideoJuego5.java. Puede reutilizar lo
//desarrollado en Laboratorios anteriores.
//3. Del Soldado nos importa el nombre, puntos de vida, fila y columna (posición en el tablero).
//4. El juego se desarrollará en el mismo tablero de los laboratorios anteriores. Para crear el
//tablero utilice la estructura de datos más adecuada.
//5. Tendrá 2 Ejércitos (usar HashMaps). Inicializar el tablero con n soldados aleatorios entre 1 y
//10 para cada Ejército. Cada soldado tendrá un nombre autogenerado: Soldado0X1,
//Soldado1X1, etc., un valor de puntos de vida autogenerado aleatoriamente [1..5], la fila y
//columna también autogenerados aleatoriamente (no puede haber 2 soldados en el mismo
//cuadrado). Se debe mostrar el tablero con todos los soldados creados (distinguir los de un
//ejército de los del otro ejército). Además de los datos del Soldado con mayor vida de cada
//ejército, el promedio de puntos de vida de todos los soldados creados por ejército, los datos
//de todos los soldados por ejército en el orden que fueron creados y un ranking de poder de
//todos los soldados creados por ejército (del que tiene más nivel de vida al que tiene menos)
//usando 2 diferentes algoritmos de ordenamiento (indicar conclusiones respecto a este
//ordenamiento de HashMaps). Finalmente, que muestre qué ejército ganará la batalla (indicar
//la métrica usada para decidir al ganador de la batalla). Hacerlo como programa iterativo.
package laboratorio8;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Videojuego5 {

    public static void main(String[] args) {
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);

        boolean repetitivo = true; // Controlar el bucle

        while (repetitivo) {
            // Crear dos ejércitos dentro del bucle
            Map<Integer, Integer> ejército1 = new HashMap<>();
            Map<Integer, Integer> ejército2 = new HashMap<>();
            
            //Generación de filas y columnas aleatorias
            int filas = rand.nextInt(8) + 3; 
            int columnas = rand.nextInt(8) + 3;  

     
            // Preguntar si desea seguir creando ejércitos
            System.out.print("\n¿Quieres crear nuevos ejércitos? (sí/no): ");
            String respuesta = scan.nextLine();
            if (!respuesta.equalsIgnoreCase("sí")) {
                repetitivo = false;
                System.out.println("Gracias por jugar.");
            }
        }

        // Cerrar el scanner
        scan.close();
    }
}