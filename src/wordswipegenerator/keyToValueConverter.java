/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordswipegenerator;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

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
            
            new HttpURLConnectionDict().checkDict(finalString);
//            if(!finalString.equals(reverseFinalString)){
//            new HttpURLConnectionDict().checkDict(reverseFinalString);
//            }
            
            sb.setLength(0);
            serial++;
            //break;
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    List<List<Integer>> removeDuplicate(List<List<Integer>> tempres) throws Exception{
                    //tempList.addAll(result);
                    System.out.println("Size of list before adding to set" + tempres.size());
                    Set<List<Integer>> tempset = new LinkedHashSet<List<Integer>>(tempres);//Set remove's duplicate
                    System.out.println("Size of set" + tempset.size());
                    List<List<Integer>> templist = new ArrayList<List<Integer>>();
                    templist.addAll(tempset);
                    System.out.println("Size of list after adding to set" + templist.size());
                    return templist;            
                }
}
