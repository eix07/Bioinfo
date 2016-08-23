/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasta;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.StringTokenizer;
import jdk.jfr.events.FileWriteEvent;

/**
 *
 * @author Labing
 */
public class FastaReader extends BufferedReader {
    
    

    public FastaReader(Reader in) {
        super(in);
    }

    public void close() throws IOException{
        super.close();
    }
    
    @Override
    public String readLine() throws IOException{
        String ret= super.readLine();
             
        return ret;
    
    }
    
    public void leerFasta() throws IOException{
        BufferedWriter bw=new BufferedWriter(new FileWriter("src/files/temp.ss"));
        
        String cadena="";
        while((cadena=readLine())!=null){
            if(cadena.contains(">")){
                System.out.println(cadena.replace(">", ""));
            }else{
                bw.write(cadena+"\n");
                System.out.println(cadena);
            }
        }
        close();
    
    }
    
    
}   
