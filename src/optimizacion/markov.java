/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package optimizacion;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Labing
 */
public class markov {
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        BufferedReader br =new BufferedReader(new FileReader("src/RosalindFiles/markov.txt"));
        String cadena="";
        float d=(float) 0.3;
        float e=(float) 0.4;        
        while((cadena=br.readLine())!=null){
            char initState=0;
            float result=1;
            char state=0;
            System.out.println(cadena);
            for (int i = 0; i < cadena.length(); i++) {
                if(i>0){
                    state=cadena.charAt(i);
                    if(state=='Y')
                        state='X';
          
                    if(initState=='X'&& state=='M'){
                        result=result*(1-e);
                        initState=state;
                    }else if(initState=='X'&&state=='X'){
                        result=result*(e);
                        initState=state;
                    }else if(initState=='M'&&state=='M'){
                        result=result*(1-2*d);
                        initState=state;
                    }else if(initState=='M'&&state=='X'){
                        result=result*(d);
                        initState=state;
                    }
                    
                }else{
                    if(cadena.charAt(i)=='Y'){
                        initState='X';
                    }else{
                        initState=cadena.charAt(i);
                    }
                }
            }
            System.out.println("result: "+result);
        }
    }   
}
