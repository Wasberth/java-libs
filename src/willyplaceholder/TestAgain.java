/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package willyplaceholder;

import java.net.ServerSocket;
import java.util.concurrent.TimeUnit;
import willy.structures.BiQueue;
import willy.structures.Queue;
import willy.structures.QueueArray;
import willy.structures.SortableWArray;
import willy.structures.Stack;
import willy.structures.StackArray;
import willy.structures.WArray;
import willy.structures.nodes.Sortable;

/**
 *
 * @author Willy
 */
public class TestAgain {

    public static void main(String args[]) throws InterruptedException {
        BiQueue<Test> s = new BiQueue<>();
        System.out.println("EMPTY QUEUE: " + s);
        
        for (int i = 0; i < 500; i++) {
            if (i % 2 == 0) {
                s.addStart(new Test(i));
            }
            
            if (i % 2 == 1) {
                s.addEnd(new Test(i));
            }
            
            if (i % 5 == 0) {
                System.out.println("Removed " + s.removeStart() + " y " + s.removeEnd());
            }
        }
        
        System.out.println("QUEUE: " + s);
        
        s.emptyfyStart();
        
        System.out.println("TEST " + s);
    }

}
