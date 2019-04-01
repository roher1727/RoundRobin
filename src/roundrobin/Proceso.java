/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roundrobin;

/**
 *
 * @author roher
 */
public class Proceso {
    public int id, rafaga, prioridad, tiempo_lle, tamanio, tiempo_ejecutado, tiempo_max = 0, tiempo_res = 0, tiempo_ejecucion;
    public boolean ejecutado = true;
    public String nombre;
    
    public Proceso(int id, int rafaga, int prioridad, int tiempo_lle, String nombre, int tamanio, int tiempo_eje){
        this.id = id;
        this.rafaga = rafaga;
        this.prioridad = prioridad;
        this.tiempo_lle = tiempo_lle;
        this.nombre = nombre; 
        this.tamanio = tamanio;
        this.tiempo_ejecutado = tiempo_eje;
    }
    
    public void setRafaga(int rafaga_nueva){
        this.rafaga = rafaga_nueva;
    }
    
    public int getRafaga(){
        return this.rafaga;
    }
    
    public int getTiempo_lle(){
        return this.tiempo_lle;
    }
    
    
    public String toString(){
        return "|   " + this.id + " |  "+ this.nombre + "  |  " + this.tiempo_lle + "  |  " + this.prioridad + "  |  " + this.rafaga + "  |";
    }
    
    
    
}
