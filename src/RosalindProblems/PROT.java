/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RosalindProblems;

import RosalindProblems.Reader.DNAReader;
import RosalindProblems.Reader.RawDNAReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

/**
 *
 * @author river
 */
public class PROT extends GenericProblem {

    @Override
    public DNAReader getReader(InputStream in) {
        DNAReader reader = new RawDNAReader();
        reader.Init(in);
        return reader;
    }

    @Override
    public String Solve(DNAReader Origin) throws IOException {
        HashMap<String,String> map=Origin.HashmapRNAcodon();
        String cadena=Origin.ReadLine();
        String result="";
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
        return result;
    }
}
