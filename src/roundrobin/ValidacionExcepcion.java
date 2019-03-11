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
public class ValidacionExcepcion extends Exception{
    public ValidacionExcepcion(){
        
        
    }
    @Override
    public String toString(){
        return "ERROR: Se repitio el ID";
    }
}
