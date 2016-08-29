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
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author river
 */
public class SPLC {

    public static void SPLC(String dir) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(dir));
        String cadena = "";
        String exonsIntrons = "";
        String exons = "";
        int cont = 0;
        ArrayList<String> introns = new ArrayList<>();
        while ((cadena = br.readLine()) != null) {
            if (cadena.contains(">")) {
                continue;
            } else {
                if (cont == 0) {
                    exonsIntrons = cadena;
                    cont++;
                } else {
                    introns.add(cadena);
                    cont++;
                }
            }
        }
        for (int i = 0; i < introns.size(); i++) {
            exonsIntrons = exonsIntrons.replaceAll(introns.get(i), "");
        }
        exons = exonsIntrons;
        String RNAexons=aadn.translate.toARN(exons);
        HashMap<String, String> map = new HashMap<>();
        map=PROT.map();
        String result = "";
        for (int i = 0; i < RNAexons.length(); i++) {
            if ((i + 2) == RNAexons.length()) {
                break;
            } else {
                String temp = RNAexons.substring(i, (i + 3));
                if(map.get(temp).equalsIgnoreCase("Stop")){
                    break;
                }else{
                    result = result + map.get(temp);
                }
                i = i + 2;
            }
        }
        System.out.println(result);
    }

}
