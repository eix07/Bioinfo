/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasta;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.StringTokenizer;

/**
 *
 * @author Labing
 */
public class FastaReader extends Fasta {

    @Override
    public String[] Read(InputStream in) throws IOException {
        //FileOutputStream fos=new FileOutputStream("G:/Bioinformatica/temp.xs");
        //DataOutputStream Sa=new DataOutputStream(fos);
        String[] a = new String[2];
        //int buf_len=4096;
        //byte[] buf=new byte[buf_len];
        a[0] = "";
        a[1] = "";
        int flag2 = 0;
        int flag = 0;
        int number = in.available();
        while (number >= 1) {
            //Sa.flush();
            char aux = (char) in.read();
            if (aux == '>') {
                flag = 0;
            } else if (flag == 0) {
                a[0] = a[0] + aux;
                if (aux == '\n') {
                    flag = 1;
                }
            } else if (flag == 1) {
                //Sa.write(buf,0,buf_len);
                a[1] = a[1] + aux;
            }
            number--;
        }
        this.x = a;
        return this.x;
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
        String aux = this.x[0];
        String aux1 = this.x[1];
        st = new StringTokenizer(aux);
        st1 = new StringTokenizer(aux1);
        while (st.hasMoreTokens()) {
            result = result + st.nextToken() + "\n" + st1.nextToken() + "\n";
        }
        return result;
    }

}
