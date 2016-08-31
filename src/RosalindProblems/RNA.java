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
public class RNA extends GenericProblem {


    @Override
    public DNAReader getReader(InputStream in) {
        DNAReader reader = new RawDNAReader();
        reader.Init(in);
        return reader;
    }

    @Override
    public String Solve(DNAReader Origin) {
        String cadena=Origin.ReadLine();
        String a = "";
            a = aadn.translate.toARN(cadena);
        return a;
    }

}
