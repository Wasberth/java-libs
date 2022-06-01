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

    protected __<BinaryTree<T>> getL() {
        return left;
    }

    protected __<BinaryTree<T>> getR() {
        return right;
    }

    public boolean hasLeft() {
        return left != null && !left.__isNull();
    }

    public boolean hasRight() {
        return right != null && !right.__isNull();
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

    public int leafCount() {
        return leafCount(this);
    }

    public static int leafCount(BinaryTree tree) {
        if (tree == null) {
            return 0;
        }

        if (tree.getL().__isNull() && tree.getR().__isNull()) {
            return 1;
        }

        return leafCount(tree.getLeft()) + leafCount(tree.getRight());
    }

    public BinaryTree<T> search(T value) {
        return search(value, this);
    }

    public static <E> BinaryTree<E> search(E value, BinaryTree<E> tree) {
        if (tree == null) {
            return null;
        }

        if (tree.getValue() == value) {
            return tree;
        }

        BinaryTree<E> found = search(value, tree.getLeft());

        if (found != null) {
            return found;
        }

        return search(value, tree.getRight());
    }

    public static <E> void preOrder(BinaryTree<E> tree, Queue<E> q) {
        if (tree == null) {
            return;
        }

        q.add(tree.value);
        preOrder(tree.getLeft(), q);
        preOrder(tree.getRight(), q);
    }

    public String preOrder() {
        Queue<T> q = new Queue<>();
        preOrder(this, q);
        return q.toString();
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

    public static <E> void postOrder(BinaryTree<E> tree, Queue<E> q) {
        if (tree == null) {
            return;
        }

        postOrder(tree.getLeft(), q);
        postOrder(tree.getRight(), q);
        q.add(tree.value);
    }

    public String postOrder() {
        Queue<T> q = new Queue<>();
        inOrder(this, q);
        return q.toString();
    }

    @Override
    public String toString() {
        return "BinaryTree{" + "value=" + value + ", left=" + left + ", right=" + right + '}';
    }

}
