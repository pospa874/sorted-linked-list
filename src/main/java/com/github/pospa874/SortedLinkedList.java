package com.github.pospa874;

import java.io.Serial;
import java.util.*;

/**
 * A SortedLinkedList class that maintains its elements in sorted order.
 *
 * @param <E> the type of elements held in this collection
 */
public class SortedLinkedList<E extends Comparable<E>> extends SortedList<E> {

    @Serial
    private static final long serialVersionUID = 1L;
    private LinkedList<E> list;

    /**
     * Constructs an empty list.
     */
    public SortedLinkedList() {
        list = new LinkedList<>();
    }

    /**
     * Inserts the specified element into the correct position in the list.
     *
     * @param e the element to add
     * @return true (as specified by Collection.add(E))
     */
    @Override
    public boolean add(E e) {
        if (!list.isEmpty() && !list.getFirst().getClass().equals(e.getClass())) {
            throw new IllegalArgumentException("Cannot mix different types of elements in the list");
        }

        int index = 0;
        for (E item : list) {
            if (item.compareTo(e) > 0) {
                break;
            }
            index++;
        }
        list.add(index, e);
        return true;
    }

    /**
     * Removes the element at the specified position in this list.
     *
     * @param index the index of the element to be removed
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public E remove(int index) {
        return list.remove(index);
    }

    /**
     * Removes the first occurrence of the specified element from this list, if it is present.
     *
     * @param o element to be removed from this list, if present
     * @return true if this list contained the specified element
     */
    @Override
    public boolean remove(Object o) {
        return list.remove(o);
    }

    /**
     * Removes all the elements from this list.
     */
    @Override
    public void clear() {
        list.clear();
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public E get(int index) {
        return list.get(index);
    }

    /**
     * Returns a list iterator over the elements in this list (in proper sequence).
     *
     * @param index index of the first element to be returned from the list iterator
     * @return a ListIterator over the elements in this list (in proper sequence)
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public ListIterator<E> listIterator(int index) {
        return list.listIterator(index);
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    @Override
    public int size() {
        return list.size();
    }

    /**
     * Returns a shallow copy of this SortedList instance.
     *
     * @return a clone of this SortedList instance
     */
    @Override
    public SortedLinkedList<E> clone() {
        SortedLinkedList<E> cloned = new SortedLinkedList<>();
        cloned.list = new LinkedList<>(this.list);
        return cloned;
    }

    /**
     * Returns the first element in this list.
     *
     * @return the first element in this list
     * @throws NoSuchElementException if this list is empty
     */
    @Override
    public E getFirst() {
        return list.getFirst();
    }

    /**
     * Returns the last element in this list.
     *
     * @return the last element in this list
     * @throws NoSuchElementException if this list is empty
     */
    @Override
    public E getLast() {
        return list.getLast();
    }
}
