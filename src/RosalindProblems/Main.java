/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RosalindProblems;

/**
 *
 * @author Miguel
 */
import RosalindProblems.Writer.Writer;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        GenericProblem problem = null;
        InputStream stream = null;
        switch (12) {
            case 1:
                problem = new DNA();
                stream=new FileInputStream("src/RosalindFiles/rosalind_dna.txt");
                break;
            case 2:
                problem =new RNA();
                stream=new FileInputStream("src/RosalindFiles/rosalind_rna.txt");
                break;
            case 3:
                problem=new REVC();
                stream=new FileInputStream("src/RosalindFiles/rosalind_revc (1).txt");
                break;
            case 4:
                problem=new HAM();
                stream=new FileInputStream("src/RosalindFiles/hamm.txt");
                break;
            case 5:
                problem =new SUBS();
                stream=new FileInputStream("src/RosalindFiles/subs.txt");
                break;
            case 6:
                problem=new GC();
                stream=new FileInputStream("src/RosalindFiles/rosalind_gc.txt");
                break;
            case 7:
                PERM.PERM("src/RosalindFiles/rosalind_perm (1).txt");
                break;
            case 8:
                problem=new PROT();
                stream=new FileInputStream("src/RosalindFiles/rosalind_prot.txt");
                break;
            case 9:
                problem=new SPLC();
                stream=new FileInputStream("src/RosalindFiles/rosalind_splc.txt");
                break;
            case 10:
                problem=new SSEQ();
                stream=new FileInputStream("src/RosalindFiles/rosalind_sseq.txt");
                break;
            case 11:
                problem=new LCSM();
                stream = new FileInputStream("src/RosalindFiles/rosalind_lcsm.txt");
                break;
            //matrices para alinear cadeanas!!!!!!!! ------>
            case 12:
                problem=new Exercise();
                stream=new FileInputStream("src/RosalindFiles/alinear.txt");
                break;
        }
        String result = problem.Solve(problem.getReader(stream));
        Writer.consoleWriter(result);
    }
}
