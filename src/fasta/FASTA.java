/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasta;

import java.io.FileNotFoundException;
import java.io.IOException;

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
        FastaReader fr=new FastaReader("src/fasta/Fasta.fa");
        System.out.println(fr.Read());
    }
    
}
