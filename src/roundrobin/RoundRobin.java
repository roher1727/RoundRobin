/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roundrobin;
import java.util.Queue; 
import java.util.LinkedList;
import java.util.Scanner;
import java.util.ArrayList;


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
        
        Queue<Proceso> colaPL = new LinkedList <>();
        Queue<Proceso> colaEjecucion = new LinkedList <>();
        ArrayList<Proceso> listaProcesos = new ArrayList<>(); 
        Tabla tabla = new Tabla();
        boolean nuevo_proceso = true;
        int id, rafaga, prioridad, tiempo_lle;
        Scanner sc = new Scanner(System.in);
        Validador validador = new Validador();
        
        String nombre, opcion;
        
        while(nuevo_proceso){
            
            System.out.println("\n\n===== REGISTRA EL NUEVO PROCESO =====\n\n");
            System.out.println("Nombre: ");
            nombre = sc.nextLine();
            System.out.println("\nIdentificador del Proceso: ");
            id = sc.nextInt();
            System.out.println("\nPrioridad: ");
            prioridad = sc.nextInt();
            System.out.println("\nTiempo de llegada: ");
            tiempo_lle = sc.nextInt();
            System.out.println("\nRáfaga");
            rafaga = sc.nextInt();
                
            Proceso temporal = new Proceso(id, rafaga, prioridad, tiempo_lle, nombre);
            
            
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
        
        tabla.imprimir(listaProcesos);
    
    }
    
}
