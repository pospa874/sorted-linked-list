package com.github.pospa874;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class SortedLinkedListTest {
    private SortedLinkedList<Integer> list;

    @BeforeEach
    public void setUp() {
        list = new SortedLinkedList<>();
    }

    @Test
    public void testAdd() {
        assertTrue(list.add(3));
        assertTrue(list.add(1));
        assertTrue(list.add(2));
        assertEquals("[1, 2, 3]", list.toString());
    }

    @Test
    public void testAddNullElement() {
        Exception exception = assertThrows(NullPointerException.class, () -> list.add(null));
        assertEquals("Null elements are not permitted in the list", exception.getMessage());
    }


    @Test
    public void testRemoveIndex() {
        list.add(3);
        list.add(1);
        list.add(2);
        assertEquals(1, list.remove(0));
        assertEquals("[2, 3]", list.toString());
    }

    @Test
    public void testRemoveObject() {
        list.add(3);
        list.add(1);
        list.add(2);
        list.add(2);
        assertTrue(list.remove(Integer.valueOf(2)));
        assertEquals("[1, 2, 3]", list.toString());
    }

    @Test
    public void testClear() {
        list.add(3);
        list.add(1);
        list.add(2);
        list.clear();
        assertEquals("[]", list.toString());
    }

    @Test
    public void testGet() {
        list.add(3);
        list.add(1);
        list.add(2);
        assertEquals(2, list.get(1));
    }

    @Test
    public void testSize() {
        list.add(3);
        list.add(1);
        list.add(2);
        assertEquals(3, list.size());
    }

    @Test
    public void testClone() {
        list.add(3);
        list.add(1);
        list.add(2);
        SortedLinkedList<Integer> cloned = list.clone();
        assertEquals(list.toString(), cloned.toString());
    }

    @Test
    public void testGetFirst() {
        list.add(3);
        list.add(1);
        list.add(2);
        assertEquals(1, list.getFirst());
    }

    @Test
    public void testGetLast() {
        list.add(3);
        list.add(1);
        list.add(2);
        assertEquals(3, list.getLast());
    }

    @Test
    public void testGetFirstEmpty() {
        assertThrows(NoSuchElementException.class, () -> list.getFirst());
    }

    @Test
    public void testGetLastEmpty() {
        assertThrows(NoSuchElementException.class, () -> list.getLast());
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testAddDifferentTypes() {
        SortedLinkedList list = new SortedLinkedList<>();
        list.add(1);
        assertThrows(ClassCastException.class, () -> list.add("test"));
    }

}
