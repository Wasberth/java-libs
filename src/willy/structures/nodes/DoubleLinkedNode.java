/*
 * García Piña Wilberth David
 * 2BM1
 * Inteligencia artificial
 * 02/05/2022
 */
package willy.structures.nodes;

import willy.util.__;

/**
 *
 * @author Willy
 * @param <T> El tipo que se va a guardar en la pila
 *
 */
public class DoubleLinkedNode<T> {

    private final T value;
    private __<DoubleLinkedNode<T>> next;
    private __<DoubleLinkedNode<T>> prev;

    public DoubleLinkedNode(final T value) {
        this.value = value;
        this.next = new __<>(null);
        this.prev = new __<>(null);
    }

    public T getValue() {
        return value;
    }

    public __<DoubleLinkedNode<T>> getNext() {
        return next;
    }

    public void setNext(__<DoubleLinkedNode<T>> next) {
        this.next = next;
    }

    public __<DoubleLinkedNode<T>> getPrev() {
        return prev;
    }

    public void setPrev(__<DoubleLinkedNode<T>> prev) {
        this.prev = prev;
    }

    @Override
    public String toString() {
        return "DoubleLinkedNode{" + "value=" + value + ", next=" + next + '}';
    }

}