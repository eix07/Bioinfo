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
import java.util.ArrayList;

/**
 *
 * @author river
 */
public class PERM {

    static ArrayList<String> st = new ArrayList<>();

    public static void PERM(String dir) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(dir));
        int a = Integer.parseInt(br.readLine());
        String s = "";
        for (int i = 0; i <a; i++) {
            s = s + (i+1);
        }
        permutation(s);
        System.out.println(st.size());
        String res = "";
        for (String st1 : st) {
            for (int i = 0; i < st1.length(); i++) {
                if(i==st1.length()-1){
                    res = res + st1.charAt(i);
                }else{
                    res = res + st1.charAt(i) + " ";
                }
                    
            }
            System.out.println(res);
            res="";
        }
    }

    public static void permutation(String str) {
        permutation("", str);
    }

    private static void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0) {
            st.add(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
            }
        }
    }

}
