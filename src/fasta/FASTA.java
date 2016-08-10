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
public class FASTA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        //FastaReader fr=new FastaReader("src/fasta/Fasta.fa");
        //System.out.println(fr.Read());
        
        InputStream in=new FileInputStream(new File("src/fasta/test.fq"));
        FastQReader fq=new FastQReader(in);
        
        //System.out.println(fq.FastQRead());
        System.out.println(fq.FQinverse());
                
    }
    
}
