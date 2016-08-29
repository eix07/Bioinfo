/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RosalindProblems;

import fasta.FastaReaderBytes;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 *
 * @author river
 */
public class SSEQ {

    public static void SSEQ(String dir) throws FileNotFoundException, IOException {

        File f=new File(dir);
        String[] fasta= leerFastaBytes(f);
        StringTokenizer st=new StringTokenizer(fasta[1]);
        String cadena1=st.nextToken();
        String cadena2=st.nextToken();
        
        String result="";
        int j=0;
        
        for (int i = 0; i < cadena2.length(); i++) {
            while(true){
                if(cadena1.charAt(j)==cadena2.charAt(i)){
                    result=result+(j+1)+" ";
                    j++;
                    break;
                }
                j++;
            }
        }
        System.out.println(result);
        
    }

    private static String[] leerFastaBytes(File f) throws FileNotFoundException, IOException {

        FileInputStream in = new FileInputStream(f);
        FastaReaderBytes fb = new FastaReaderBytes(in);

        int flag = 0;
        int flag2 = 0;
        int x = fb.available();
        String[] fasta = new String[2];
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
        System.out.println(fasta[0]);
        System.out.println(fasta[1]);
        return fasta;
    }

}
