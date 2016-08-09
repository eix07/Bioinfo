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

    public String FastQRead() throws IOException {
        int a = 0;
        char c;
        int flag = 0;
        int flag2 = 0;
        String concats = "";
        int cont = super.available();
        while (cont > 1) {
            c = (char) super.read();
            if (a == 0 && c == '@') {
                a = 1;
            } else if (flag == 0 && c != '+') {
                concats = concats + c;
                if (c == '\n') {
                    flag = 1;
                }
            } else if (c != '+' && flag == 1 && flag2 == 0) {
                concats = concats + c;
                if (c == '\n') {
                    flag = 0;
                }
            } else if (c == '+' && flag == 0) {
                flag2 = 1;
            } else if (flag2 == 1 && a == 1) {
                int n = c;
                concats = concats + n+", ";
                if (c == '\n') {
                    flag = 0;
                    a=0;
                    flag2=0;
                    flag=0;                    
                }
            }
            cont--;
        }
        return concats;
    }
}
