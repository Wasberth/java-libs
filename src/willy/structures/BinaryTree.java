/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package willy.structures;

import willy.util.__;

/**
 *
 * @author Willy
 * @param <T> El tipo que se va a guardar en el arbol
 */
public class BinaryTree<T> {

    private T value;
    private __<BinaryTree<T>> left, right;

    public BinaryTree(T value) {
        this.value = value;
        this.left = new __(null);
        this.right = new __(null);
    }

    public BinaryTree(T value, BinaryTree<? super T> left, BinaryTree<? super T> right) {
        this.value = value;
        this.left = new __(left);
        this.right = new __(right);
    }

    public T getValue() {
        return value;
    }

    public BinaryTree<T> getLeft() {
        return left.__get();
    }

    public BinaryTree<T> getRight() {
        return right.__get();
    }

    public void setValue(T value) {
        this.value = value;
    }

    protected void setLeft(__<BinaryTree<T>> left) {
        this.left = left;
    }

    protected void setRight(__<BinaryTree<T>> right) {
        this.right = right;
    }

    public static int height(BinaryTree tree) {
        if (tree == null) {
            return 0;
        }
        int left = height(tree.getLeft());
        int right = height(tree.getRight());
        return Math.max(left, right) + 1;
    }

    public int height() {
        return height(this);
    }

    /**
     * @return El número de nodos del árbol
     */
    public int size() {
        return size(this);
    }

    public static int size(BinaryTree tree) {
        if (tree == null) {
            return 0;
        }
        return 1 + size(tree.getLeft()) + size(tree.getRight());
    }

    public static String preOrder(BinaryTree tree) {
        if (tree == null) {
            return "";
        }

        return tree.value.toString() + " " + preOrder(tree.getLeft()) + " " + preOrder(tree.getRight());
    }

    public String preOrder() {
        return preOrder(this);
    }

    public static <E> void inOrder(BinaryTree<E> tree, Queue<E> q) {
        if (tree == null) {
            return;
        }
        
        inOrder(tree.getLeft(), q);
        q.add(tree.value);
        inOrder(tree.getRight(), q);
    }

    public String inOrder() {
        Queue<T> q = new Queue<>();
        inOrder(this, q);
        return q.toString();
    }

    private static String toString(BinaryTree tree, int w) {
        if (tree == null) {
            return "";
        }

        String s = "";
        for (int i = 0; i < w; i++) {
            s = s + "|";
            
            if (i != w - 1) {
                s = s + "  "; 
            }
        }
        
        if (!s.equals("")) {
            s = s + "---";
        }

        String l = toString(tree.getLeft(), w + 1);
        if (!l.equals("")) {
            l = "\n" + l;
        }

        String r = toString(tree.getRight(), w + 1);
        if (!r.equals("")) {
            r = "\n" + r;
        }

        return s + tree.value + l + r;
    }

    @Override
    public String toString() {
        return toString(this, 0);
    }

}
