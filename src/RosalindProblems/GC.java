/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RosalindProblems;

import fasta.FastaReader;
import fasta.Fasta;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 *
 * @author river
 */
public class GC {

    public static void GC(String dir) throws FileNotFoundException, IOException {
        BufferedReader br=new BufferedReader(new FileReader(dir));
        String cadena="";
        String[]ds=new String[2];
        ds[0]="";
        ds[1]="";
        while((cadena=br.readLine())!=null){
            if(cadena.contains(">")){
                ds[0]=ds[0]+cadena.replace(">","")+" ";
                ds[1]=ds[1]+" ";
            }else{
                ds[1]=ds[1]+cadena;
            }
        }
        StringTokenizer tk0=new StringTokenizer(ds[0]);
        StringTokenizer tk1=new StringTokenizer(ds[1]);
        float result=0;
        String idr="";
        while(tk0.hasMoreTokens()){
            String id=tk0.nextToken();
            String cad=tk1.nextToken();
            float cont=0;
            float prom=0;
            for (int i = 0; i < cad.length(); i++) {
                if(cad.charAt(i)=='G'||cad.charAt(i)=='C'){
                    cont++;
                }
            }
            prom=(cont/cad.length())*100;
            if(prom>result){
                result=prom;
                idr=id;
            }
        }
        System.out.println(idr);
        System.out.println(result);
        
    }

}
