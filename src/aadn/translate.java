/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aadn;


import java.util.IllegalFormatException;

/**
 *
 * @author Labing
 */
public class translate {

    public static final String ADN = "ATCG";
    public static final String ARN = "AUCG";

    public static boolean isADN(String ADNCandidate) {
        if (ADNCandidate.toUpperCase().contains("U")) {
            return false;
        }
        return true;
    }

    public static boolean isARN(String ARNCandidate) {
        if (ARNCandidate.toUpperCase().contains("T")) {
            return false;
        }
        return true;
    }

    public static boolean isValidADN(String ADNcandidate) {
        String ADNcandidate1 = ADNcandidate.toUpperCase();
        for (int i = 0; i < ADNcandidate1.length(); i++) {
            if (!ADN.contains(ADNcandidate1.charAt(i) + "")) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidARN(String ARNcandidate) {
        String ARNcandidate1 = ARNcandidate.toUpperCase();
        for (int i = 0; i < ARNcandidate1.length(); i++) {
            if (!ARN.contains(ARNcandidate1.charAt(i) + "")) {
                return false;
            }
        }
        return true;
    }

    public static String toARN(String ADN1) throws IllegalFormatException, NullPointerException {
        String toARN = "";
        try {
            if (isValidADN(ADN1)) {
                for (int i = 0; i < ADN1.length(); i++) {
                    if (ADN1.charAt(i) == 't' || ADN1.charAt(i) == 'T') {
                        toARN = toARN + "U";
                    } else {
                        toARN = toARN + ADN1.charAt(i);
                    }
                }
            }
            return toARN;

        } catch (Exception e) {
            return e + "";
        }
    }

    public static String toADN(String ARN1) throws IllegalFormatException, NullPointerException {
        String toADN = "";
        try {
            if (isValidADN(ARN1)) {
                for (int i = 0; i < ARN1.length(); i++) {
                    if (ARN1.charAt(i) == 't' || ARN1.charAt(i) == 'T') {
                        toADN = toADN + "T";
                    } else {
                        toADN = toADN + ARN1.charAt(i);
                    }
                }
            }
            return toADN;

        } catch (Exception e) {
            return e + "";
        }
    }
}
