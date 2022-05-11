/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package willyplaceholder;

import java.math.BigInteger;
import java.util.Comparator;
import java.util.Random;
import java.util.function.UnaryOperator;
import willy.structures.CircularDoubleLinkedList;
import willy.structures.CircularLinkedList;
import willy.structures.WDoubleLinkedList;
import willy.structures.WList;
import willy.util.WRandom;

/**
 *
 * @author Willy
 */
public class WillyPlaceholder {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        WList<Character> lis = new CircularDoubleLinkedList<>();

        System.out.println(lis);
        lis.pushLast('a');
        System.out.println(lis);
        lis.pushLast('b');
        System.out.println(lis);
        lis.pushLast('c');
        System.out.println(lis);

        lis.push('d', 0);
        System.out.println(lis);
        lis.push('e', 1);
        System.out.println(lis);
        lis.push('f', 2);
        System.out.println(lis);

        lis.push('ñ', lis.size());
        lis.push('w', 0);
        System.out.println(lis);

        for (int i = 0; i < lis.size(); i++) {
            System.out.println("pos: " + i + " = " + lis.get(i));
        }

        System.out.println("first: " + lis.getFirst());
        System.out.println("last: " + lis.getLast());

        WList<Character> c = lis.copy(3, lis.size());

        while (!lis.isEmpty()) {
            //System.out.println(lis.popLast());
            //System.out.println(lis.pop(lis.size() / 2));
            //System.out.println(lis.pop(lis.size() - 1));
            System.out.println(lis.pop(0));

            System.out.println(lis);
        }

        System.out.println(lis);
        System.out.println(c);

        c.bubbleSort(Character::compare);

        System.out.println("Sorted: " + c);
        
        System.out.println(c.indexOf('ñ'));

        WRandom r = new WRandom(556);

        /*for (int i = 0; i < 5; i++) {
            System.out.println(r.nextBoolean());
        }*/

        /*
        r.randomize(c);
        System.out.println(c);
        r.randomize(c);
        System.out.println(c);
        r.randomize(c);
        System.out.println(c);

        c.add(c, 1, c.size() - 1);
        System.out.println(c);
         */
        BigInteger[] coeff = new BigInteger[3];
        int[] pows = new int[3];

        coeff[0] = new BigInteger("11").pow(3);
        coeff[1] = new BigInteger("11").pow(3);
        coeff[2] = new BigInteger("11").pow(3).multiply(new BigInteger("17"));
        
        pows[0] = 37;
        pows[1] = 13;
        pows[2] = 0;

        UnaryOperator<BigInteger> al = WRandom.buildAlgorithm(
                new BigInteger("2").pow(60).subtract(BigInteger.ONE),
                coeff,
                pows
        );

        WRandom wr = new WRandom(556, al);
        
        for (int i = 0; i < 10; i++) {
            System.out.println(r.nextBigInt());
            System.out.println(wr.nextBigInt());
        }

    }

}
