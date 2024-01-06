package com.github.pospa874;

import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * A SortedList abstract class that maintains its elements in sorted order.
 * This collection is sorted according to the natural ordering of its elements,
 * determined by the {@code compareTo()} method defined in the element's class.
 * <p>
 * Users can access elements by their integer index (position in the list),
 * and perform a wide range of operations similar to those in List, LinkedList, Collections, etc.
 * <p>
 * This list allows duplicate elements but does not permit null elements.
 *
 * @param <E> the type of elements held in this collection
 */
public abstract class SortedList<E extends Comparable<E>> extends AbstractSequentialList<E> implements Cloneable, Serializable {

    /**
     * Inserts the specified element into the correct position in the list.
     *
     * @param e the element to add
     * @return true (as specified by Collection.add(E))
     */
    @Override
    public abstract boolean add(E e);

    /**
     * Removes the element at the specified position in this list.
     *
     * @param index the index of the element to be removed
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public abstract E remove(int index);

    /**
     * Removes the first occurrence of the specified element from this list, if it is present.
     *
     * @param o element to be removed from this list, if present
     * @return true if this list contained the specified element
     */
    @Override
    public abstract boolean remove(Object o);

    /**
     * Removes all the elements from this list.
     */
    @Override
    public abstract void clear();

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public abstract E get(int index);

    /**
     * Returns a list iterator over the elements in this list (in proper sequence).
     *
     * @param index index of the first element to be returned from the list iterator
     * @return a ListIterator over the elements in this list (in proper sequence)
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public abstract ListIterator<E> listIterator(int index);

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    @Override
    public abstract int size();

    /**
     * Returns a shallow copy of this SortedList instance.
     *
     * @return a clone of this SortedList instance
     */
    public abstract SortedList<E> clone();

    /**
     * Returns the first element in this list.
     *
     * @return the first element in this list
     * @throws NoSuchElementException if this list is empty
     */
    public abstract E getFirst();

    /**
     * Returns the last element in this list.
     *
     * @return the last element in this list
     * @throws NoSuchElementException if this list is empty
     */
    public abstract E getLast();
}
