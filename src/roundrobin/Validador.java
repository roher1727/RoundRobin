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
public class Validador{
    
    public void validar(Proceso process, ArrayList<Proceso> lista) throws ValidacionExcepcion{
        
        for(Proceso temporal : lista){
            if (temporal.id == process.id){
                throw new ValidacionExcepcion();
            }
        }
    }
}
