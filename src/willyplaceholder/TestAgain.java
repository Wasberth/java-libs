/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package willyplaceholder;

import java.net.ServerSocket;
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

    public static void main(String args[]) {
        StackArray<Test> s = new StackArray<>(Test.class, 15);
        System.out.println(s.getStacked() + ": " + s);
        s.push(new Test(0));
        System.out.println(s.getStacked() + ": " + s);
        s.push(new Test(50));
        s.push(new Test(3));
        System.out.println(s.getStacked() + ": " + s);
        Test a;
        
        a = s.pop();
        System.out.println(a);
        System.out.println(s.getStacked() + ": " + s);
        s.emptyfy();
        System.out.println(s.getStacked() + ": " + s);
        a = s.pop();
        System.out.println(a);
        System.out.println(s.getStacked() + ": " + s);
    }
    
    public static void sort(WArray<Test> arr){
        arr.realloc(7);
    }

}
