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
public class SUBS {
    
    public static void SUBS(String dir) throws FileNotFoundException, IOException{
        BufferedReader br =new BufferedReader(new FileReader(dir));
        String cadena1=br.readLine();
        String cadena2=br.readLine();
        int x=0;
        int y=cadena2.length();
        String result="";
        while(y<=cadena1.length()){
            if(cadena1.substring(x, y).equalsIgnoreCase(cadena2)){
                result=result+x+" ";
            }
            x++;
            y++;
        }
        System.out.println(result);
    }
    
}
