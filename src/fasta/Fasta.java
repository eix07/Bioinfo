/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasta;

import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author river
 */
public abstract class Fasta {
    
    public FileReader n;
    public abstract void Read()throws IOException;
    public abstract void operacion()throws IOException;
    
}
