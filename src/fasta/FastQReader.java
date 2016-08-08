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

    public int FastQRead() throws IOException {
        char c = (char) super.read();
        while (super.read() != -1) {
            if (c == '@') {

            }
        }

        return ((int) c);
    }
}
