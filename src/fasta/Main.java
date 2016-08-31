/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasta;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;


/**
 *
 * @author Labing
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        Reader r = new FileReader("src/Files/Fasta.fa");
        FastaReader lector = new FastaReader(r);
        //lector.leerFasta();
        
        InputStream in=new FileInputStream(new File("src/Files/test.fq"));
        FastQReader fq=new FastQReader(in);
        fq.Reads();
        
        File f=new File("src/Files/Fasta.fa");
        //lector.leerFastaBytes(f);

    }

}
