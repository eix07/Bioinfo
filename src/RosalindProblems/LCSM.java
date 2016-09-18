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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
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
        List<String> ADN = new ArrayList<>();
        for (int i = 1; i < cadenas.size(); i++) {
            ADN.add(cadenas.get(i));
            i++;
        }
        String result = identifyCommonSub(ADN);

        return result;
    }

    public String identifyCommonSub(List<String> strArr) {

        String commonStr = "";
        String smallStr = "";

        //identify smallest String
        for (String s : strArr) {
            if (smallStr.length() < s.length()) {
                smallStr = s;
            }
        }
        String tempCom = "";
        char[] smallStrChars = smallStr.toCharArray();
        for (char c : smallStrChars) {
            tempCom += c;
            for (String s : strArr) {
                if (!s.contains(tempCom)) {
                    tempCom += c;
                    for (String k : strArr) {
                        if (!k.contains(tempCom)) {
                            tempCom = "";
                            break;
                        }
                    }
                    break;
                }
            }
            if (tempCom != "" && tempCom.length() > commonStr.length()) {
                commonStr = tempCom;
            }
        }

        return commonStr;
    }
}
