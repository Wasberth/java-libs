/*
 * García Piña Wilberth David
 * 2BM1
 * Inteligencia artificial
 * 22/04/2022
*/
package willy.structures;

import willy.structures.nodes.QueueNode;
import willy.util.__;

/**
 *
 * @author Willy
 * @param <T> El tipo que se va a guardar en la pila
 */
public class Queue<T> {

    private __<QueueNode<T>> next;
    private int counter;

    public Queue() {
        this.next = null;
        this.counter = 0;
    }

    public void add(final T t) {
        if (next == null) {
            next = new __<>(new QueueNode<>(t));
            counter++;
            return;
        }

        next.__get().addNext(t);
        counter++;
    }

    public T remove() {
        if (counter == 0) {
            return null;
        }

        final __<QueueNode<T>> node = next;
        this.next = this.next.__get().getNext();
        this.counter--;
        return node.__get().getValue();
    }

    public T peek() {
        if (this.counter == 0) {
            return null;
        }

        return next.__get().getValue();
    }
    
    public int getSize() {
        return counter;
    }

    public boolean isEmpty() {
        return counter == 0;
    }
    
    public void emptyfy() {
        T a;
        while (next != null) {
            a = this.remove();
            System.out.println("Desencolando: " + a);
        }
    }

    @Override
    public String toString() {
        String s = "";
        __<QueueNode<T>> node = next;

        while (node != null && node.__get() != null) {
            s = s + node.__get().getValue() + " ";
            node = node.__get().getNext();
        }

        return "[ " + s + "]";
    }
    
}
