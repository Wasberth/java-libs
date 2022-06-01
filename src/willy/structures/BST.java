/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package willy.structures;

import java.util.Comparator;
import willy.util.__;

/**
 *
 * @author Willy
 * @param <T> El tipo que se va a guardar en el arbol
 */
public class BST<T> extends BinaryTree<T> {

    private final Comparator<T> c;
    private static BST parentOfLastSearched = null;

    public BST(Comparator<T> c) {
        super(null);

        this.c = c;
    }

    public BST(T value, Comparator<T> c) {
        super(value);

        this.c = c;
    }

    public void add(T value) {
        add(value, this);
    }

    public void remove(T value) {
        remove(value, this);
    }

    public static <E> void add(E value, BST<E> tree) {
        if (tree.getValue() == null) {
            tree.setValue(value);
            return;
        }

        if (tree.c.compare(value, tree.getValue()) < 0) {
            if (tree.getL().__isNull()) {
                tree.setLeft(new __(new BST(value, tree.c)));
                return;
            }

            add(value, (BST<E>) tree.getLeft());
            return;
        }

        if (tree.getR().__isNull()) {
            tree.setRight(new __(new BST(value, tree.c)));
            return;
        }

        add(value, (BST<E>) tree.getRight());
    }

    @Override
    public BST<T> search(T value) {
        return search(value, this);
    }

    private static <E> BST<E> search(E value, BST<E> tree) {
        parentOfLastSearched = null;
        return searchPar(value, tree);
    }

    private static <E> BST<E> searchPar(E value, BST<E> tree) {
        if (tree == null || tree.getValue() == null) {
            return null;
        }

        if (tree.c.compare(value, tree.getValue()) == 0) {
            return tree;
        }

        BST<E> toSearch
                = (BST<E>) (tree.c.compare(value, tree.getValue()) < 0
                ? tree.getLeft() : tree.getRight());

        parentOfLastSearched = tree;
        return searchPar(value, toSearch);
    }

    public static <E> void remove(E value, BST<E> tree) {
        if (tree == null || tree.getValue() == null) {
            return;
        }

        if (!tree.hasLeft() && !tree.hasRight() && tree.c.compare(tree.getValue(), value) == 0) {
            tree.setValue(null);
            return;
        }

        BST<E> toDelete = tree.search(value);

        if (toDelete == null) {
            return;
        }

        int d = 0;

        if (!toDelete.hasLeft() && !toDelete.hasRight()) {
            d = tree.c.compare(toDelete.getValue(), (E) parentOfLastSearched.getValue());

            if (d < 0) {
                parentOfLastSearched.setLeft(new __(null));
                return;
            }

            parentOfLastSearched.setRight(new __(null));
            return;
        }

        if (!toDelete.hasRight()) {
            if (parentOfLastSearched == null) {
                tree.setValue(tree.getLeft().getValue());
                tree.setRight(tree.getLeft().getR());
                tree.setLeft(tree.getLeft().getL());
                return;
            }

            d = tree.c.compare(toDelete.getValue(), (E) parentOfLastSearched.getValue());

            if (d < 0) {
                parentOfLastSearched.setLeft(toDelete.getL());
                toDelete.setLeft(new __(null));
                return;
            }

            parentOfLastSearched.setRight(toDelete.getL());
            toDelete.setLeft(new __(null));
            return;
        }

        if (!toDelete.hasLeft()) {
            if (parentOfLastSearched == null) {
                tree.setValue(tree.getRight().getValue());
                tree.setLeft(tree.getRight().getL());
                tree.setRight(tree.getRight().getR());
                return;
            }

            d = tree.c.compare(toDelete.getValue(), (E) parentOfLastSearched.getValue());

            if (d < 0) {
                parentOfLastSearched.setLeft(toDelete.getR());
                toDelete.setLeft(new __(null));
                return;
            }

            parentOfLastSearched.setRight(toDelete.getR());
            toDelete.setLeft(new __(null));
            return;
        }

        BST<E> prt = toDelete;
        BST<E> low = (BST<E>) toDelete.getRight();

        while (low.hasLeft()) {
            prt = low;
            low = (BST<E>) low.getLeft();
            d++;
        }

        if (d == 0) {
            E lowest = low.getValue();
            prt.setRight(low.getR());
            low.setRight(new __(null));

            toDelete.setValue(lowest);

            return;
        }

        E lowest = low.getValue();
        prt.setLeft(low.getR());
        low.setRight(new __(null));

        toDelete.setValue(lowest);
    }

}
