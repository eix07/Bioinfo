/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RosalindProblems;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 *
 * @author river
 */
public class PROT {

    public static void PROT(String dir) throws FileNotFoundException, IOException {
        HashMap<String, String> map = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader("src/RosalindFiles/rnaCodon.txt"));
        String cadena = "";
        while ((cadena = br.readLine()) != null) {
            String[] sx = cadena.split(" ");
            map.put(sx[0], sx[1]);
        }
        String result = "";
        BufferedReader br1 = new BufferedReader(new FileReader(dir));
        cadena = "";
        cadena = br1.readLine();
        //System.out.println(cadena);
        for (int i = 0; i < cadena.length(); i++) {
            if ((i + 2) == cadena.length()) {
                break;
            } else {
                String temp = cadena.substring(i, (i + 3));
                if (map.get(temp).equalsIgnoreCase("Stop")) {
                    break;
                } else {
                    result = result + map.get(temp);
                }

                i = i + 2;
            }

        }
        System.out.println(result);
    }

}
