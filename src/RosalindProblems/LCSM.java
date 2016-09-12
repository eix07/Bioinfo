/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RosalindProblems;

import RosalindProblems.Reader.DNAReader;
import RosalindProblems.Reader.FastaDNAReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author river
 */
public class LCSM extends GenericProblem {

    @Override
    public DNAReader getReader(InputStream in) {
        DNAReader reader = new FastaDNAReader();
        reader.Init(in);
        return reader;
    }

    @Override
    public String Solve(DNAReader Origin) throws IOException {
        List<String> cadenas = Origin.ReadAllLines();
        String result="";
        for (int i = 3; i < cadenas.size(); i++) {
            String temp="";
            if(i==3){
                
            }
            i++;
        }
        return null;
    }

    public static int find(char[] A, char[] B) {
        int[][] LCS = new int[A.length + 1][B.length + 1];
        // if A is null then LCS of A, B =0
        for (int i = 0; i <= B.length; i++) {
            LCS[0][i] = 0;
        }

        // if B is null then LCS of A, B =0
        for (int i = 0; i <= A.length; i++) {
            LCS[i][0] = 0;
        }

        //fill the rest of the matrix
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= B.length; j++) {
                if (A[i - 1] == B[j - 1]) {
                    LCS[i][j] = LCS[i - 1][j - 1] + 1;
                } else {
                    LCS[i][j] = 0;
                }
            }
        }
        int result = -1;
        for (int i = 0; i <= A.length; i++) {
            for (int j = 0; j <= B.length; j++) {
                if (result < LCS[i][j]) {
                    result = LCS[i][j];
                }
            }
        }
        return result;
    }
}
