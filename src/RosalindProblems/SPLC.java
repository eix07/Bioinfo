/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RosalindProblems;

import RosalindProblems.Reader.DNAReader;
import RosalindProblems.Reader.FastaDNAReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author river
 */
public class SPLC extends GenericProblem{

    @Override
    public DNAReader getReader(InputStream in) {
        DNAReader reader=new FastaDNAReader();
        reader.Init(in);
        return reader;
    }

    @Override
    public String Solve(DNAReader Origin) throws IOException {
        List<String>cadenas=Origin.ReadAllLines();
        String exonsIntrons=cadenas.get(1);
        for (int i = 3; i < cadenas.size(); i++) {
            exonsIntrons=exonsIntrons.replaceAll(cadenas.get(i),"");
            i++;
        }
        String RNAexons=aadn.translate.toARN(exonsIntrons);
        HashMap<String,String>map=Origin.HashmapRNAcodon();
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
        return result;
    }
}
