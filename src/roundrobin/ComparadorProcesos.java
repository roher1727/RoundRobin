/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roundrobin;
import java.util.Comparator;
/**
 *
 * @author roher
 */
public class ComparadorProcesos implements Comparator<Proceso>{
    @Override
    public int compare(Proceso x, Proceso y) {
        // TODO: Handle null x or y values
        int startComparison = compare(x.tiempo_lle, y.tiempo_lle);
        return startComparison;
    }

    private static int compare(long a, long b) {
        return a < b ? -1 : a > b ? 1 : 0;
   }
}

