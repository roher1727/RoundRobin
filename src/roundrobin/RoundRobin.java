/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roundrobin;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;


/**
 *
 * @author roher
 */
public class RoundRobin {

    /**
     * @param args the command line arguments
     */
    // public void 
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        ArrayList<Proceso> listaProcesos = new ArrayList<>(); 
        Tabla tabla = new Tabla();
        
        ComparadorProcesos comparador = new ComparadorProcesos();
        
        boolean nuevo_proceso = true;
        int id, rafaga, prioridad, tiempo_lle, tamanio_p, tamanio, quantum;
        Scanner sc = new Scanner(System.in);
        Validador validador = new Validador();
        
        String nombre, opcion;
        System.out.println("\n======================================");
        System.out.println("\n||     PLANIFICADOR ROUND ROBIN   ||");
        System.out.println("\n======================================");
        
        System.out.println("\n Inserta Quantum del procesador: ");
        quantum = sc.nextInt();
        
        while(nuevo_proceso){
            
            System.out.println("\n\n===== REGISTRA EL NUEVO PROCESO =====\n\n");
            sc.nextLine();
            System.out.println("Nombre: ");
            nombre = sc.nextLine();
            System.out.println("\nIdentificador del Proceso: ");
            id = sc.nextInt();
            System.out.println("\nPrioridad: ");
            prioridad = sc.nextInt();
            System.out.println("\nTiempo de llegada: ");
            tiempo_lle = sc.nextInt();
            System.out.println("\nRáfaga: ");
            rafaga = sc.nextInt();
            System.out.println("\nTamaño: ");
            tamanio_p = sc.nextInt();
            
            
            Proceso temporal = new Proceso(id, rafaga, prioridad, tiempo_lle, nombre, tamanio_p, 0);
            
            
            try {
                validador.validar(temporal, listaProcesos);
                listaProcesos.add(temporal);
                
            }catch(ValidacionExcepcion ve){
                System.out.println(ve);
            }finally{
            
                sc.nextLine();
                System.out.println("¿Deseas crear un nuevo proceso?(Si o no)");
                opcion = sc.nextLine();

                if(opcion.equals("No") || opcion.equals("no")){
                   nuevo_proceso = false;
                }
            }
        }
        Collections.sort(listaProcesos, comparador);
        tabla.imprimir(listaProcesos);
        
        AlgoritmoRR algo = new AlgoritmoRR(listaProcesos, quantum);
        
        algo.Algoritmo();
    
    }
    
}
