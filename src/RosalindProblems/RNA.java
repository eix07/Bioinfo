/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RosalindProblems;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author river
 */
public class RNA {
    
        public static void RNA(String direccion) throws FileNotFoundException, IOException {
        BufferedReader br=new BufferedReader(new FileReader(direccion));
        String cadena;
        String a="";
        while((cadena=br.readLine())!=null){
            a=aadn.translate.toARN(cadena);
        }       
        System.out.println(a);
    }
    
    
}
