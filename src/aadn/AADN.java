/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aadn;

/**
 *
 * @author Labing
 */
public class AADN {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String lala="ACCTGGGG";
        System.out.println("Is adn->"+translate.isADN(lala));
        System.out.println("Is valid adn->"+translate.isValidADN(lala));
        
    }
    
}
