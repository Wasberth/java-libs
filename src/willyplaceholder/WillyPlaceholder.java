/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package willyplaceholder;

import willy.structures.BinaryTree;

/**
 *
 * @author Willy
 */
public class WillyPlaceholder {

    public static void main(String[] args) {
        BinaryTree<Integer> t = null, r = null;

        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                t = new BinaryTree(i, r, t);
                r = new BinaryTree<>(i * i);
                continue;
            }
            
            t = new BinaryTree(i, t, r);
            r = new BinaryTree<>(i ^ 2);
        }
        
        System.out.println(t);
        System.out.println(t.inOrder());
        System.out.println(t.preOrder());
        
    }

}
