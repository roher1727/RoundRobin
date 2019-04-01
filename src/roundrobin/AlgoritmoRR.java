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
 * @author Alejandro Hernández Rodríguez
 */
public class AlgoritmoRR {
    int tamanio = 1024, quantum; 
    // Procesos que recibe el algoritmo
    ArrayList<Proceso> colaProcesos; 
    
    // Procesos para ejecucion en cpu
    Queue<Proceso> colaEjecucion = new LinkedList();
    Queue<Proceso> colaListo = new LinkedList();
    Iterator<Proceso> iter;
    Tabla tablita = new Tabla();
    
    // Procesos listos para ejecutar en CPU
    Queue<Proceso> colaListo = new LinkedList();
    
    // Cola con la informacion de los tiempos de cada proceso
    // Procesos listos para ejecutar en CPU
    Queue<Proceso> colaTiempos = new LinkedList();
    
    // Iterador para iterar lista de procesos
    Iterator<Proceso> iter;
    
    // Impresion de lista de procesos
    Tabla tablita = new Tabla();
    
    
    public AlgoritmoRR(ArrayList<Proceso> colaProcesos, int quantum){
        this.colaProcesos = colaProcesos;
        this.quantum = quantum;
    }
    
    public void obtenerTiempos(Queue<Proceso> colaTiempos){
        float t_res = 0, t_eje = 0, t_esp = 0;
        for (Proceso p: colaTiempos){
            t_esp += p.tiempo_max - p.tiempo_ejecutado - p.tiempo_lle;
            
            t_eje += p.tiempo_ejecucion - p.tiempo_lle;
            t_res += p.tiempo_res - p.tiempo_lle;
        }
        t_res /= colaTiempos.size();
        t_eje /= colaTiempos.size();
        t_esp /= colaTiempos.size();
        
    }
    
    public void Algoritmo(){
<<<<<<< HEAD
        int tiempo=0, tiempo_nuevo = 0;
        boolean bandera = true;
        Proceso primer_proceso = colaProcesos.get(0);
=======
        int tiempo=0;
>>>>>>> 741a369dbde810c0583b7fce3a276b55cc81c3ef
        
        while(true){
            iter = colaProcesos.iterator();
            
<<<<<<< HEAD
            
            if(colaProcesos.isEmpty() && colaEjecucion.isEmpty())
                break;
            
            // Agregar procesos a la cola de procesos listos para ejecucion
            while(iter.hasNext()){
                Proceso equis = iter.next();
                
=======
            if(colaProcesos.isEmpty() && colaEjecucion.isEmpty())
                break;
            
            while(iter.hasNext()){
                Proceso equis = iter.next();
>>>>>>> 741a369dbde810c0583b7fce3a276b55cc81c3ef
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
<<<<<<< HEAD
            // Insercion de procesos en la cola de ejecucion
            if(!colaListo.isEmpty() ){
                Proceso temporalpe = colaListo.peek();
                if(temporalpe.tiempo_lle == tiempo){
                    Proceso temporalpe2 = colaListo.remove();
                    colaEjecucion.add(temporalpe2);
                    tablita.imprimir(colaEjecucion);
                }
            }
            
            // Cambio de proceso en la cola de ejecucion
            if(((tiempo_nuevo - primer_proceso.tiempo_lle) % this.quantum) == 0 && !colaEjecucion.isEmpty()){
                    if (tiempo_nuevo - primer_proceso.tiempo_lle != 0){
                        Proceso temporalp = colaEjecucion.remove();
                        if(temporalp.ejecutado){
                            temporalp.ejecutado = false;
                            temporalp.tiempo_res = tiempo;
                        }
                        colaEjecucion.add(temporalp);
                        System.out.println("\n" + tiempo + " cambio \n ");
                    }
            }
            
            // Eliminacion de proceso
            if(!colaEjecucion.isEmpty()){
                if(colaEjecucion.peek().rafaga < 1){
                    this.tamanio += colaEjecucion.peek().tamanio;
                    System.out.println("\n" + tiempo + " cambio \n ");
                    tiempo_nuevo = primer_proceso.tiempo_lle;
                    Proceso temporal = colaEjecucion.remove();
                    temporal.tiempo_ejecucion = tiempo;
                    colaTiempos.add(temporal);
                }
            }
=======
            
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
            
            
>>>>>>> 741a369dbde810c0583b7fce3a276b55cc81c3ef
            
            if(!colaEjecucion.isEmpty()){
                
                System.out.println("Proceso " + colaEjecucion.peek().nombre + " en ejecucion " + colaEjecucion.peek().rafaga + " msg en tiempo " + tiempo);
                colaEjecucion.peek().rafaga--;
            }
            
            
            // Impresion del status del proceso
            if(!colaEjecucion.isEmpty()){
                
                System.out.println("Proceso " + colaEjecucion.peek().nombre + " en ejecucion " + colaEjecucion.peek().rafaga + " msg en tiempo " + tiempo);
                colaEjecucion.peek().rafaga--;
                if(colaEjecucion.peek().rafaga > quantum){
                    colaEjecucion.peek().tiempo_ejecutado++;
                    colaEjecucion.peek().tiempo_max = tiempo;
                }
            }
            tiempo++;
<<<<<<< HEAD
            tiempo_nuevo++;
            bandera = true;
=======
            
>>>>>>> 741a369dbde810c0583b7fce3a276b55cc81c3ef
        }
    }
    
    
}
