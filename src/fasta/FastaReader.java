/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasta;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Labing
 */
public class FastaReader extends FileReader {

    public FastaReader(String fileName) throws FileNotFoundException {
        super(fileName);
    }

    public String Read() throws IOException {
        String cadena;
        String a="";
        BufferedReader b = new BufferedReader(this);
        while ((cadena = b.readLine()) != null) {
            if (cadena.contains(">")) {     
                a=a+(cadena.replace(">","")+"\n");
            } else {
               a=a+cadena+"\n";
            }
        }
        b.close();
        return a;
    }
}
