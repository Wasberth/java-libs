/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package willyplaceholder;

import java.net.ServerSocket;
import java.util.concurrent.TimeUnit;
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
        Queue<Test> s = new Queue<>();
        
        for (int i = 0; i < 50000; i++) {
            s.add(new Test(i + 1));
        }
        
        s.emptyfy();
    }

}
