/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasta;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author river
 */
public class FastaReaderBytes extends FilterInputStream{
    
    public FastaReaderBytes(InputStream in){
        super(in);
    }
    
    
    public int read() throws IOException{
        char c=(char)super.read();
        if(c=='>'){
            return -7;
        }
        return ((int)c);
    }
}
