/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aadn;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author Labing
 */
public class AADN {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        InputStream in=new FileInputStream(new File("G:\\TExt.txt"));
        RawADNReader r=new RawADNReader(in);
        while(r.read()!=-1){
            System.out.println(r.read());
        }
    }    
}
