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
import java.io.IOException;
import java.io.InputStream;


/**
 *
 * @author Labing
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {

        FileReader ins=new FileReader("src/Files/test.fq");
        FileReader ins2=new FileReader("src/Files/Fasta.fa");
        
        Fasta f = new FastQReader(ins);
        Fasta f1 = new FastaReader(ins2);
        
        f.Read();
        f=new InvertADN(f);
        f.operacion();
        
        f1.Read();
        f1=new InvertADN(f1);
        f1.operacion();

    }

}
