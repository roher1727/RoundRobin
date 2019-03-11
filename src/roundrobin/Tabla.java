/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roundrobin;

import java.util.ArrayList;

/**
 *
 * @author roher
 */
public class Tabla {
    
        public Tabla(){
            
        }
        
        public void imprimir(ArrayList<Proceso> lista){
            System.out.println("| PID |  Proceso  |  TLlegada  |  Prioridad  |  TRafaga(ms)  |");

            for(Proceso ps : lista){
                System.out.println(ps);
            }
        }
    
}
