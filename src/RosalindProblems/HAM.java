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
public class HAM {
    
    public static void HAM(String dir) throws FileNotFoundException, IOException{
        BufferedReader br=new BufferedReader(new FileReader(dir));
        String cadena1= br.readLine();
        String cadena2=br.readLine();
        int result=0;
        for (int i = 0; i < cadena1.length(); i++) {
            if(cadena1.charAt(i)!=cadena2.charAt(i))
                result++;
        }
        System.out.println(result);
    }
    
}
