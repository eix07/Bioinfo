/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RosalindProblems;

import RosalindProblems.Reader.DNAReader;
import RosalindProblems.Reader.RawDNAReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 *
 * @author river
 */
public class SUBS extends GenericProblem{
    
    
    @Override
    public DNAReader getReader(InputStream in) {
        DNAReader reader=new RawDNAReader();
        reader.Init(in);
        return reader;
    }

    @Override
    public String Solve(DNAReader Origin) throws IOException {
        List<String>cadenas=Origin.ReadAllLines();
        String cadena1=cadenas.get(0);
        String cadena2=cadenas.get(1);
        System.out.println(cadena1);
        System.out.println(cadena2);
        int x=0;
        int y=cadena2.length();
        String result="";
        while(y<=cadena1.length()){
            if(cadena1.substring(x, y).equalsIgnoreCase(cadena2)){
                result=result+x+" ";
            }
            x++;
            y++;
        }
        return result;
    }
    
}
