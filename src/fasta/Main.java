/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasta;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

        InputStream in = new FileInputStream(new File("src/Files/test.fq"));
        InputStream in2 = new FileInputStream(new File("src/Files/Fasta.fa"));
        InputStream in3= new FileInputStream(new File("G:/Bioinformatica/worm.fasta"));

        Fasta f = new FastQReader();
        
        Fasta f1 = new FastaReader();
        f1.Read(in3);
        //System.out.println(f1.Print());
        //f1 = new InvertADN(f1);
        //System.out.println(f1.Operation());
    }

}
