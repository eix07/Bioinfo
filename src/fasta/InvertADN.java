/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasta;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author Labing
 */
public class InvertADN{
    

    private static char inv(char c) {
        char aux=c;
        if(c=='T'||c=='U'||c=='t'||c=='u')
            aux='A';
        if(c=='A'||c=='a')
            aux='C';
        if(c=='C'||c=='c')
            aux='G';
        if(c=='G'||c=='g')
            aux='C';
        return aux;
    }
    
    public String inverse(String ADNN){
        int j=0;
        char[]ADN=ADNN.toCharArray();
        char[] r=new char[ADN.length];
        for (int i = ADN.length-1; i >=0; i--) {
            r[j]=inv(ADN[i]);
            j++;
        }
        return String.copyValueOf(r);
    }

    public void operacion() throws IOException {
        FileReader in=new FileReader("src/Files/temp.ss");
        BufferedReader br=new BufferedReader(in);
        String cadena="";
        while((cadena=br.readLine())!=null){
            System.out.println(this.inverse(cadena));
        }
    }

    
}
