/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package willyplaceholder;

import willy.structures.WLinkedList;
import willy.structures.WList;

/**
 *
 * @author Willy
 */
public class WillyPlaceholder {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        WList<Test> lis = new WLinkedList<>();

        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                lis.setFirst(new Test(i));
            }
            lis.set(new Test(i), i);
        }
        
        System.out.println(lis);
        System.out.println(lis.size());
        System.out.println(lis.getFirst());
        System.out.println(lis.getLast());
        System.out.println(lis.get(0));
        
        for (int i = 0; i < 30; i++) {
            System.out.println(lis.pop(lis.size() / 2));
            System.out.println(lis);
        }
        
    }

}
