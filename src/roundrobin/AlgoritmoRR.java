/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roundrobin;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

/**
 *
 * @author roher
 */
public class AlgoritmoRR {
    int tamanio = 1024, quantum;  
    ArrayList<Proceso> colaProcesos;
    Queue<Proceso> colaEjecucion = new LinkedList();
    
    public AlgoritmoRR(ArrayList<Proceso> colaProcesos, int quantum){
        this.colaProcesos = colaProcesos;
        this.quantum = quantum;
    }
    
    public void Algoritmo(){
        int tiempo=0;
        while(true){
            if(colaProcesos.isEmpty() && colaEjecucion.isEmpty())
                break;
            
            System.out.println("" + colaProcesos.isEmpty() + colaEjecucion.isEmpty());
            
                
            for(Proceso equis : colaProcesos){
                if(tiempo == equis.tiempo_lle){
                    colaEjecucion.add(equis);
                    colaProcesos.remove(equis);
                
                    
                    tamanio -= equis.tamanio;
                    if(tamanio >= 0){
                        System.out.println("\nSubio el proceso " + equis.nombre + " y quedan " + this.tamanio + " unidades de memoria.\n");
                    }else{
                        System.out.println("\nStack Overflow\n");
                    }
                }
            }
            
            if(colaEjecucion.isEmpty()){
                continue;
            }
            
            if((tiempo % quantum) == 0){
                Proceso temporalp = colaEjecucion.remove();
                colaEjecucion.add(temporalp);
            }
            
            if(colaEjecucion.peek().rafaga <= 0)
                colaEjecucion.remove();
            
            colaEjecucion.peek().rafaga--;
            System.out.println("Proceso " + colaEjecucion.peek().nombre + " en ejecucion " + colaEjecucion.peek().rafaga + " msg");
            
            
            
            tiempo++;
        }
    }
    
    
}
