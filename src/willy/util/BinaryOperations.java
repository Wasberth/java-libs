/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package willy.util;

/**
 *
 * @author Willy
 */
public class BinaryOperations {

    public static String toBin(final int i) {
        return Integer.toBinaryString(i);
    }

    public static int toDec(final String bin) {
        return Integer.valueOf(bin, 2);
    }

    public static int getNextPow(final int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("El entero debe ser mayor a 0");
        }
        int j = toBin(i).length();
        return j;
    }

    public static int getPreviousPow(final int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("El entero debe ser mayor a 0");
        }
        int j = toBin(i).length();
        return j - 1;
    }

}
