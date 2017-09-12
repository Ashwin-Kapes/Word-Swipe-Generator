/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordswipegenerator;

import java.util.List;

/**
 * @author HP
 */
public class keyToValueConverter {
  static char[] ValMat = {'M', 'A', 'S', 'I'  //0  1  2  3
      , 'U', 'T', 'M', 'U'  //4  5  6  7
      , 'N', 'I', 'T', 'E'  //8  9  10 11
      , 'A', 'O', 'D', 'N'};//12 13 14 15
  int serial = 1;
  StringBuilder sb = new StringBuilder();

  keyToValueConverter(List<List<Integer>> results) throws Exception {
    for (List<Integer> r : results) {
      System.out.print("#" + serial + "# " + r + "\n");
      for (int i = 0; i < r.size(); i++) {
        sb.append(ValMat[r.get(i)]);
      }
      String finalString = sb.toString();
      String reverseFinalString = sb.reverse().toString();

      //System.out.println(" - " + finalString + " | " + reverseFinalString);

      HttpURLConnectionDict.isGibbrish(finalString);
      HttpURLConnectionDict.isGibbrish(reverseFinalString);

      sb.setLength(0);
      serial++;
      //break;
    }
    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
}
