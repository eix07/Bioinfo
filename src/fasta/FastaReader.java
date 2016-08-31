/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasta;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

/**
 *
 * @author Labing
 */
public class FastaReader extends BufferedReader {

    String[] fasta = new String[2];

    public FastaReader(Reader in) {
        super(in);
    }

    public void close() throws IOException {
        super.close();
    }

    @Override
    public String readLine() throws IOException {
        String ret = super.readLine();

        return ret;

    }

    public void leerFasta() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("src/files/temp.ss"));

        String cadena = "";
        while ((cadena = readLine()) != null) {
            if (cadena.contains(">")) {
                System.out.println(cadena.replace(">", ""));
            } else {
                bw.write(cadena + "\n");
                System.out.println(cadena);
            }
        }
        close();

    }

    public String[] leerFastaBytes(File f) throws FileNotFoundException, IOException {

        FileInputStream in = new FileInputStream(f);
        FastaReaderBytes fb = new FastaReaderBytes(in);

        int flag = 0;
        int flag2 = 0;
        int x = fb.available();

        fasta[0] = "";
        fasta[1] = "";
        while (x > 0) {
            int c = fb.read();
            if (c == -7) {
                if (!fasta[1].equals("")) {
                    fasta[1] = fasta[1].trim() + " ";
                }
                flag2 = 0;
                flag = 1;
            } else if (flag == 1 && flag2 == 0) {
                fasta[0] = fasta[0] + (char) c;
                fasta[0] = fasta[0].trim();
                if ((char) c == '\n' && (char) c != ' ') {
                    fasta[0] = fasta[0].trim() + " ";
                    flag2 = 1;
                    flag = 0;
                }
            } else if (flag == 0 && flag2 == 1 && c != -7) {
                fasta[1] = fasta[1] + ((char) c);
                fasta[1] = fasta[1].trim();
            }
            x--;
        }

        System.out.println(fasta[0] + "\n" + fasta[1]);
        return fasta;
    }

}
