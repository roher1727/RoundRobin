/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roundrobin;
import java.util.ArrayList;
import java.util.Iterator;
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
    Queue<Proceso> colaListo = new LinkedList();
    Iterator<Proceso> iter;
    Tabla tablita = new Tabla();
    
    public AlgoritmoRR(ArrayList<Proceso> colaProcesos, int quantum){
        this.colaProcesos = colaProcesos;
        this.quantum = quantum;
    }
    
    public void Algoritmo(){
        int tiempo=0;
        
        while(true){
            iter = colaProcesos.iterator();
            
            if(colaProcesos.isEmpty() && colaEjecucion.isEmpty())
                break;
            
            while(iter.hasNext()){
                Proceso equis = iter.next();
                if(tiempo == equis.tiempo_lle){
                    colaListo.add(equis);
                    iter.remove();
                    
                    if (equis.tamanio > 1024){
                        System.out.println("\nERROR: Proceso muy grande\n");
                        break;
                    }
                    
                    this.tamanio -= equis.tamanio;
                    if(tamanio >= 0){
                        System.out.println("\nSubio el proceso " + equis.nombre + " y quedan " + this.tamanio + " unidades de memoria en tiempo " + tiempo +".\n");
                    }else{
                        System.out.println("\nStack Overflow\n");
                    }
                    
                }
                
            }
            
            if(((tiempo) % quantum) == 0 && !colaListo.isEmpty()){
                Proceso temporalpe = colaListo.remove();
                colaEjecucion.add(temporalpe);
            }
            
    
            if(((tiempo) % quantum) == 0 && !colaEjecucion.isEmpty()){
                Proceso temporalp = colaEjecucion.remove();
                colaEjecucion.add(temporalp);
            }
            
            if(!colaEjecucion.isEmpty()){
                if(colaEjecucion.peek().rafaga < 1){
                    this.tamanio += colaEjecucion.peek().tamanio;
                    colaEjecucion.remove();
                }
            }
            
            
            
            if(!colaEjecucion.isEmpty()){
                
                System.out.println("Proceso " + colaEjecucion.peek().nombre + " en ejecucion " + colaEjecucion.peek().rafaga + " msg en tiempo " + tiempo);
                colaEjecucion.peek().rafaga--;
            }
            
            
            tiempo++;
            
        }
    }
    
    
}
