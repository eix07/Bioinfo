/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agosto29;

import RosalindProblems.GenericProblem;
import RosalindProblems.Writer.Writer;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 *
 * @author JuanFelipe
 */
public class Bioinformatica {
    
    public static void main(String[] args) throws FileNotFoundException {
        GenericProblem problemita = null;
        int i = 0;
        InputStream stream = null;
        switch(i){
            case 0: problemita = new DNA();
            stream = new FileInputStream("src/agosto29/DNA.txt");break;
        }
        String result = problemita.Solve(problemita.getReader(stream));
        Writer.consoleWriter(result);
        
    }
    
}
