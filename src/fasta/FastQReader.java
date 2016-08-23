/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasta;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.StringTokenizer;
import javax.imageio.IIOException;

/**
 *
 * @author Labing
 */
public class FastQReader extends FilterInputStream{

    public FastQReader(InputStream in){
        super(in);
    }

    public int read() throws IOException {
        char c = (char) super.read();
        return ((int)c);
    }
    
    public String[] Reads() throws IOException {
        int a = 0;
        char c;
        int flag = 0;
        int flag2 = 0;
        String[] concats = new String[3];
        concats[0] = "";
        concats[1] = "";
        concats[2] = "";
        int cont = in.available();
        while (cont >= 1) {
            c = (char) read();
            if (a == 0 && c == '@') {
                a = 1;
            } else if (flag == 0 && c != '+') {
                concats[0] = concats[0] + c;
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
                concats[2] = concats[2] + c;
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


    /*public void Read(FileReader in) throws IOException {
        BufferedReader br = new BufferedReader(in);
        BufferedWriter bw = new BufferedWriter(new FileWriter("src/files/temp.ss"));
        String cadena = "";
        int a = 0;
        int b = 0;
        int flag2 = 0;
        int flag = 0;
        while ((cadena = br.readLine()) != null) {
            if (cadena.contains("@") && flag == 0) {
                flag = 1;
                System.out.println(cadena.replace("@", ""));
            } else if (flag == 1 && !cadena.contains("+") && flag2 == 0) {
                a = a + cadena.length();
                System.out.println(cadena);
                bw.write(cadena + "\n");
            } else if (cadena.startsWith("+") && flag2 == 0 && flag == 1) {
                flag2 = 1;
            } else if (flag2 == 1) {
                b = b + cadena.length();
                if (a == b) {
                    System.out.println(CalidadInt(cadena));
                    flag = 0;
                    flag2 = 0;
                    a = 0;
                    b = 0;
                } else {
                    throw new IIOException("Cadenas de calidad y ADN diferentes");
                }
            }
        }
        bw.close();
    }

    public String CalidadInt(String a) {
        String b = "";
        for (int i = 0; i < a.length(); i++) {
            b = b+(int)a.charAt(i)+",";
        }
        return b;
    }*/

}
