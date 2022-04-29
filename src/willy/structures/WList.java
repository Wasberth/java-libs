/*
 * García Piña Wilberth David
 * 2BM1
 * Inteligencia artificial
 * 28/04/2022
 */
package willy.structures;

/**
 *
 * @author Willy
 * @param <T> El tipo que se va a guardar en la lista
 */
public interface WList<T> {
    
    public int size();
    
    public void setFirst(T t);
    public void setLast(T t);
    public void set(T t, int n);
    
    public T getFirst();
    public T getLast();
    public T get(int i);
    
    public T popFirst();
    public T popLast();
    public T pop(int i);
    
    public boolean isEmpty();
    
}
