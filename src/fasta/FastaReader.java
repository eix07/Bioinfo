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
import java.util.StringTokenizer;
import jdk.jfr.events.FileWriteEvent;

/**
 *
 * @author Labing
 */
public class FastaReader extends Fasta {
    
    public FileReader n;

    public FastaReader(FileReader n) {
        this.n = n;
    }

    @Override
    public void Read() throws IOException {
        BufferedWriter bw=new BufferedWriter(new FileWriter("src/files/temp.ss"));
        BufferedReader br=new BufferedReader(this.n);
        String cadena="";
        while((cadena=br.readLine())!=null){
            if(cadena.contains(">")){
                System.out.println(cadena.replace(">", ""));
            }else{
                bw.write(cadena+"\n");
                System.out.println(cadena);
            }
        }
        bw.close();
    }

    @Override
    public void operacion() throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public FileReader getN() {
        return n;
    }

    public void setN(FileReader n) {
        this.n = n;
    }
   
}
