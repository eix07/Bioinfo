/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RosalindProblems;

/**
 *
 * @author Labing
 */


import java.io.FileNotFoundException;
import java.io.IOException;


public class Main {
    
    
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        switch (10){
            case 1: DNA.DNA("src/RosalindFiles/rosalind_dna.txt");break;
            case 2: RNA.RNA("src/RosalindFiles/rosalind_rna.txt");break;
            case 3: REVC.REVC("src/RosalindFiles/rosalind_revc (1).txt");break;
            case 4: HAM.HAM("src/RosalindFiles/hamm.txt");break;
            case 5: SUBS.SUBS("src/RosalindFiles/subs.txt");break;
            case 6: GC.GC("src/RosalindFiles/rosalind_gc.txt");break;
            case 7: PERM.PERM("src/RosalindFiles/rosalind_perm (1).txt");break;
            case 8: PROT.PROT("src/RosalindFiles/rosalind_prot.txt");break;
            case 9: SPLC.SPLC("src/RosalindFiles/rosalind_splc.txt");break;
            case 10: SSEQ.SSEQ("src/RosalindFiles/rosalind_sseq.txt");break;
        }
    }    
}
