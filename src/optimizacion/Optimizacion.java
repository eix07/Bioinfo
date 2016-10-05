/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package optimizacion;

import java.util.ArrayList;
import java.util.Arrays;


/**
 *
 * @author Labing
 */
public class Optimizacion {
    
    public static int k=4;
    public static int[] dicc= new int[(int)(Math.pow(4, k))];
    public static int max=-1;
    
    public static void main(String[] args) {
        String  cadena= "AGCTTAGCCTTCGA";
        int ventana=k;
        for (int i = 0; i < cadena.length(); i++) {
            if (ventana>cadena.length()) {
                break;
            }else{
                String sub=cadena.substring(i, ventana);   
                int santi = strToInt(sub);
                //System.out.println(santi + " "+sub);
                dicc[santi]++;
                
                if (dicc[santi]>max) {
                    max=dicc[santi];
                }
                
            }
            
            ventana++;
        }
        ArrayList<Integer> y=indexOf(max);
        String res="Max= ";
        for (Integer integer : y) {
            res=res+intToStr(integer, k)+" ";
        }
        System.out.println(res);
        
        
        
    }
    
    public static int strToInt(String s){
        int result=0;
        int l= s.length()-1;
        int base=4;
        int pot=1;
        for(int i=l; i>=0; i--){
            result+=pot*charToInt(s.charAt(i));
            pot*=base;
        }
        return result;
    }
    
    
    public static int charToInt(char c){
        if (c=='A') {
            return 0;
        }else if (c=='G'){
            return 1;
        }else if (c=='C'){
            return 2;
        }else if (c=='T'){
            return 3;
        }
        return -1;
    }
    
    public static char intToChar(int a){
        if (a==0) {
            return 'A';
        }else if(a==1){
            return 'G';
        }else if(a==2){
            return 'C';
        }else if(a==3){
            return 'T';
        }
        return 'Z';
    }
    
    public static String intToStr(int a, int k){
        String result="";
        for (int i = 0; i < k; i++) {
            result= intToChar(a%4)+result;
            a=(int)a/4;
        }
        return result;
    }
    
    public static ArrayList indexOf(int value){
        ArrayList<Integer>x=new ArrayList<>();
        for(int i = 0; i< dicc.length;i++){
            if(dicc[i] == value){
                x.add(i);
            }
        }
       return x;
    }
    
}
