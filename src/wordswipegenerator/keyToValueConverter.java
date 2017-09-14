/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordswipegenerator;

import java.util.List;

/**
 *
 * @author HP
 */
public class keyToValueConverter {
    static char[] ValMat = {'l', 'b', 'a', 'e'  //0  1  2  3
                           ,'o', 'o', 'u', 'i'  //4  5  6  7
                           ,'s', 'k', 'p', 's'  //8  9  10 11
                           ,'o', 'i', 'e', 'u'};//12 13 14 15
    int serial = 1;
    StringBuilder sb = new StringBuilder();
    
    keyToValueConverter(List<List<Integer>> results) throws Exception {
        for(List<Integer> r : results){
           System.out.print("#" + serial + "# " + r + "\n");
            for (int i = 0; i < r.size(); i++) {
                sb.append(ValMat[r.get(i)]);
            }
            String finalString = sb.toString();
            String reverseFinalString = sb.reverse().toString();
            
            //System.out.println(" - " + finalString + " | " + reverseFinalString);
            
            new HttpURLConnectionDict().isGibbrish(finalString);
            if(!finalString.equals(reverseFinalString)){
            new HttpURLConnectionDict().isGibbrish(reverseFinalString);
            }
            
            sb.setLength(0);
            serial++;
            //break;
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    
}
