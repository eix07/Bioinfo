/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RosalindProblems;

/**
 *
 * @author Labing
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import aadn.translate;
import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
    
    
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        switch (3){
            case 1: DNA("src/RosalindProblems/rosalind_dna.txt");break;
            case 2: RNA("src/RosalindProblems/rosalind_rna.txt");break;
            case 3: REVC("src/RosalindProblems/rosalind_revc (1).txt");break;
        }

    }
    
    public static void DNA(String direccion) throws FileNotFoundException, IOException{
                
        FileInputStream in=new FileInputStream(new File(direccion));
        RawADNReader raw=new RawADNReader(in);
        int a=0;
        int g=0;
        int c=0;
        int t=0;
        int cont=raw.available();
        while(cont>=1){
            char x= (char)raw.read();
            if(x=='A'){
                a++;
            }if(x=='G'){
                g++;
            }if(x=='C'){
                c++;
            }if(x=='T'){
                t++;
            }
            cont--;
        }
        String result=a+" "+c+" "+g+" "+t+" ";
        System.out.println(result);
    }
    
    public static void RNA(String direccion) throws FileNotFoundException, IOException {
        BufferedReader br=new BufferedReader(new FileReader(direccion));
        String cadena;
        String a="";
        while((cadena=br.readLine())!=null){
            a=aadn.translate.toARN(cadena);
        }       
        System.out.println(a);
    }
    
    public static void REVC(String direccion) throws FileNotFoundException, IOException{
        BufferedReader br=new BufferedReader(new FileReader(direccion));
        String cadena;
        String a="";
        while((cadena=br.readLine())!=null){
            a=inverse(cadena);
        }
        System.out.println(a);
    }
    
    private static char inv(char c) {
        char aux=c;
        if(c=='T'||c=='U'||c=='t'||c=='u')
            aux='A';
        if(c=='A'||c=='a')
            aux='T';
        if(c=='C'||c=='c')
            aux='G';
        if(c=='G'||c=='g')
            aux='C';
        return aux;
    }
    
    public static String inverse(String ADNN){
        int j=0;
        char[]ADN=ADNN.toCharArray();
        char[] r=new char[ADN.length];
        for (int i = ADN.length-1; i >=0; i--) {
            r[j]=inv(ADN[i]);
            j++;
        }
        return String.copyValueOf(r);
    }

    
}
