/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RosalindProblems;

import aadn.RawADNReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author river
 */
public class DNA {
    
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
    
}
