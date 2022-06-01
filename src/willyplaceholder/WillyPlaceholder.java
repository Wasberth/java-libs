/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package willyplaceholder;

import willy.structures.BST;
import willy.structures.BinaryTree;
import willy.structures.WLinkedList;
import willy.structures.WList;
import willy.util.WRandom;

/**
 *
 * @author Willy
 */
public class WillyPlaceholder {
    
    public static void main(String[] args) {
        //BinaryTree<Integer> t = null, r = null;
        //BST<Integer> b = new BST<>(args);
        BST<Integer> bst = new BST<>(Integer::compare);
        WList<Integer> l = new WLinkedList<>();
        WRandom r = new WRandom();
        
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                /*
                t = new BinaryTree(i, r, t);
                r = new BinaryTree<>(i * i);
                 */
                l.pushLast(i * i);
                //bst.add(i * i);
                continue;
            }
            l.pushLast(i);
            //bst.add(i);
            /*
            t = new BinaryTree(i, t, r);
            r = new BinaryTree<>(i ^ 2);
             */
        }
        
        r.randomize(l);
        
        for (int i = 0; i < l.size(); i++) {
            bst.add(l.get(i));
        }
        
        System.out.println(bst);
        System.out.println(bst.inOrder());
        System.out.println(bst.preOrder());
        
        System.out.println(bst.height());
        System.out.println(bst.leafCount());
        System.out.println(bst.size());
        System.out.println(bst.search(17));
        
        r.randomize(l);
        
        for (int i = 0; i < l.size(); i++) {
            System.out.println("REMOVING: " + l.get(i));
            
            bst.remove(l.get(i));    
            
            //System.out.println(bst);
            System.out.println(bst.inOrder());
            System.out.println(bst.preOrder());
        }
        
    }
    
}
