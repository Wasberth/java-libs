/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package willy.util;

/**
 *
 * Esta clase sirve como un "apuntador" por wrappers
 * 
 * @author Willy
 * @param <T> El tipo al que la clase "apunta"
 */
public class __<T> {

    private T ref;

    public __(T ref) {
        this.ref = ref;
    }
    
    public T __get(){
        return ref;
    }
    
    public void __set(T ref){
        this.ref = ref;
    }

    @Override
    public String toString() {
        return "__{" + "ref=" + ref + '}';
    }
    
    
    
}
