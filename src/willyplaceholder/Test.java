/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package willyplaceholder;

import willy.structures.nodes.Sortable;

/**
 *
 * @author Willy
 */
public class Test extends Sortable<Test>{

    final Integer a;
    
    public Test(int a){
        this.a = a;
    }
    
    @Override
    public int compareTo(Test t) {
        return a.compareTo(t.a);
    }

    @Override
    public String toString() {
        return String.valueOf(a);
    }
    
}
