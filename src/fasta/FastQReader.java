/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasta;

import java.io.IOException;
import java.io.InputStream;
import java.util.StringTokenizer;

/**
 *
 * @author Labing
 */
public class FastQReader extends Fasta {

    @Override
    public String[] Read(InputStream in) throws IOException {
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
            c = (char) in.read();
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
            this.x = concats;
            return this.x;
        }
    }

    @Override
    public String Operation() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String Print() {
        StringTokenizer st;
        StringTokenizer st1;
        StringTokenizer st2;
        StringTokenizer st3;
        String aux = this.x[0];
        String aux1 = this.x[1];
        String aux2 = this.x[2];
        st = new StringTokenizer(aux);
        st1 = new StringTokenizer(aux1);
        st3 = new StringTokenizer(aux2);
        while (st.hasMoreTokens()) {
            result = result + st.nextToken() + "\n" + st1.nextToken() + "\n" + st3.nextToken() + "\n";
        }
        return result;
    }

}
