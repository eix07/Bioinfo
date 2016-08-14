/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasta;

import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author Labing
 */
public class InvertADN extends Decoradores{
    
    public InvertADN(Fasta f){
        this.fasta=f;
    }

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

    @Override
    public String[] Read(InputStream in) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String Operation() {
        return inverse(this.fasta.x[1]);
    }

    @Override
    public String Print() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
