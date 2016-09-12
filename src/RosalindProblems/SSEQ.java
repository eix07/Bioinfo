/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RosalindProblems;

import RosalindProblems.Reader.DNAReader;
import RosalindProblems.Reader.FastaDNAReader;
import fasta.FastaReaderBytes;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author river
 */
public class SSEQ extends GenericProblem {

    
    @Override
    public DNAReader getReader(InputStream in) {
        DNAReader reader = new FastaDNAReader();
        reader.Init(in);
        return reader;
    }

    @Override
    public String Solve(DNAReader Origin) throws IOException {
        List<String> cadenas = Origin.ReadAllLines();
        String cadena1 = cadenas.get(1);
        String cadena2 = cadenas.get(3);
        String result = "";
        int j = 0;
        for (int i = 0; i < cadena2.length(); i++) {
            while (true) {
                if (cadena1.charAt(j) == cadena2.charAt(i)) {
                    result = result + (j + 1) + " ";
                    j++;
                    break;
                }
                j++;
            }
        }
        return result;
    }

}
