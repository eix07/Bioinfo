/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasta;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author Labing
 */
public class FastQReader extends FilterInputStream {

    public FastQReader(InputStream in) {
        super(in);
    }

    public String[] FastQRead() throws IOException {
        int a = 0;
        char c;
        int flag = 0;
        int flag2 = 0;
        String[] concats = new String[3];
        concats[0]="";
        concats[1]="";
        concats[2]="";
        int cont = super.available();
        while (cont >= 1) {
            c = (char) super.read();
            if (a == 0 && c == '@') {
                a = 1;
            } else if (flag == 0 && c != '+') {
                concats[0] =concats[0] + c;
                if (c == '\n') {
                    flag = 1;
                }
            } else if (c != '+' && flag == 1 && flag2 == 0) {
                concats[1] = concats[1] + c;
                if (c == '\n') {
                    flag = 0;
                }
            } else if (c == '+' && flag == 0) {
                flag2 = 1;
            } else if (flag2 == 1 && a == 1) {
                concats[2] =concats[2]+ c;
                if (c == '\n') {
                    flag = 0;
                    a = 0;
                    flag2 = 0;
                    flag = 0;
                }
            }
            cont--;
        }
        if (concats[1].length() != concats[2].length()) {
            throw new IOException("Cadenas invalidas, diferente longitud \n");
        } else {
            return concats;
        }
    }
    
    
}
