/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasta;

/**
 *
 * @author Labing
 */
public class InvertADN {

    private static char inv(char c) {
        char aux=c;
        if(c=='T'||c=='U')
            aux='A';
        if(c=='A')
            aux='C';
        if(c=='C')
            aux='G';
        if(c=='G')
            aux='C';
        return aux;
    }
    
    public static char[] inverse(char[] ADN){
        int j=0;
        char[] r=new char[ADN.length];
        for (int i = ADN.length-1; i >=0; i--) {
            r[j]=inv(ADN[i]);
            j++;
        }
        return r;
    }
}
