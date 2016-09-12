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

/**
 *
 * @author river
 */
public class REVC extends GenericProblem{
    
  
    private static char inv(char c) {
        char aux=c;
        if(c=='T'||c=='U'||c=='t'||c=='u')
            aux='A';
        if(c=='A'||c=='a')
            aux='T';
        if(c=='C'||c=='c')
            aux='G';
        if(c=='G'||c=='g')
            aux='C';
        return aux;
    }
    
    public static String inverse(String ADNN){
        int j=0;
        char[]ADN=ADNN.toCharArray();
        char[] r=new char[ADN.length];
        for (int i = ADN.length-1; i >=0; i--) {
            r[j]=inv(ADN[i]);
            j++;
        }
        return String.copyValueOf(r);
    }

    @Override
    public DNAReader getReader(InputStream in) {
        DNAReader reader=new RawDNAReader();
        reader.Init(in);
        return reader;
    }

    @Override
    public String Solve(DNAReader Origin) throws IOException {
        String a=Origin.ReadLine();
        return inverse(a);
    }
    
}
