/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RosalindProblems;

import RosalindProblems.Reader.DNAReader;
import RosalindProblems.Reader.FastaDNAReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 *
 * @author river
 */
public class GC extends GenericProblem {

    @Override
    public DNAReader getReader(InputStream in) {
        DNAReader reader = new FastaDNAReader();
        reader.Init(in);
        return reader;
    }

    @Override
    public String Solve(DNAReader Origin) throws IOException {
        List<String> a = Origin.ReadAllLines();
        float result = 0;
        String idr = "";
        for (int i = 1; i < a.size(); i++) {
            String cadena = a.get(i);
            float cont = 0;
            float prom = 0;
            for (int j = 0; j < cadena.length(); j++) {
                if (cadena.charAt(j) == 'G' || cadena.charAt(j) == 'C') {
                    cont++;
                }
            }
            prom = (cont / cadena.length()) * 100;
            if (prom > result) {
                result=prom;
                idr=a.get(i-1);
            }
            i++;
        }
        return idr+"\n"+result;
    }

}
