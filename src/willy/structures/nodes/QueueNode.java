/*
 * García Piña Wilberth David
 * 2BM1
 * Inteligencia artificial
 * 22/04/2022
*/
package willy.structures.nodes;

import willy.util.__;

/**
 *
 * @author Willy
 * @param <T> El tipo que se va a guardar en la pila
 *
 */
public class QueueNode<T> {

    private final T value;
    private __<QueueNode<T>> next;

    public QueueNode(final T value, final __<QueueNode<T>> next) {
        this.value = value;
        this.next = next;
    }

    public QueueNode(final T value) {
        this.value = value;
        this.next = null;
    }

    public T getValue() {
        return value;
    }

    public __<QueueNode<T>> getNext() {
        return next;
    }

    public void addNext(final T value) {
        __<QueueNode<T>> nNext = new __<>(new QueueNode<>(value));

        if (next == null) {
            next = nNext;
            return;
        }

        __<QueueNode<T>> added = next;

        while (added.__get().next != null) {
            added = added.__get().next;
        }

        added.__get().next = nNext;

    }

    @Override
    public String toString() {
        return "QueueNode{" + "value=" + value + ", next=" + next + '}';
    }

}
