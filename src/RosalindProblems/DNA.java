/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RosalindProblems;

import RosalindProblems.Reader.DNAReader;
import RosalindProblems.Reader.RawDNAReader;
import java.io.InputStream;

/**
 *
 * @author river
 */
public class DNA extends GenericProblem {


    @Override
    public DNAReader getReader(InputStream in) {
        DNAReader reader = new RawDNAReader();
        reader.Init(in);
        return reader;
    }

    @Override
    public String Solve(DNAReader origin) {
        int a = 0;
        int g = 0;
        int c = 0;
        int t = 0;
        while (origin.CanRead()) {
            char x = origin.ReadChar();
            if (x == 'A') {
                a++;
            }
            if (x == 'G') {
                g++;
            }
            if (x == 'C') {
                c++;
            }
            if (x == 'T') {
                t++;
            }
        }
        return a + " " + c + " " + g + " " + t + " ";

    }

}
