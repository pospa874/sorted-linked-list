package com.github.pospa874;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class SortedLinkedListTest {
    private SortedLinkedList<Integer> intList;
    private SortedLinkedList<String> stringList;

    @BeforeEach
    public void setUp() {
        intList = new SortedLinkedList<>();
        stringList = new SortedLinkedList<>();
    }

    @Test
    public void testAdd() {
        assertTrue(intList.add(3));
        assertTrue(intList.add(1));
        assertTrue(intList.add(2));
        assertEquals("[1, 2, 3]", intList.toString());

        Iterator<Integer> iterator = intList.iterator();
        assertEquals(1, iterator.next());
        assertEquals(2, iterator.next());
        assertEquals(3, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testAddAll() {
        assertTrue(intList.addAll(List.of(3, 1, 2)));
        assertEquals("[1, 2, 3]", intList.toString());

        Iterator<Integer> iterator = intList.iterator();
        assertEquals(1, iterator.next());
        assertEquals(2, iterator.next());
        assertEquals(3, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testAddNullElement() {
        Exception exception = assertThrows(NullPointerException.class, () -> intList.add(null));
        assertEquals("Null elements are not permitted in the list", exception.getMessage());
    }


    @Test
    public void testRemoveIndex() {
        intList.add(3);
        intList.add(1);
        intList.add(2);
        assertEquals(1, intList.remove(0));
        assertEquals("[2, 3]", intList.toString());
        assertThrows(IndexOutOfBoundsException.class, () -> intList.remove(5));
    }

    @Test
    public void testRemoveObject() {
        intList.add(3);
        intList.add(1);
        intList.add(2);
        intList.add(2);
        assertTrue(intList.remove(Integer.valueOf(2)));
        assertFalse(intList.remove((Integer) 5));
        assertEquals("[1, 2, 3]", intList.toString());
    }

    @Test
    public void testClear() {
        intList.add(3);
        intList.add(1);
        intList.add(2);
        intList.clear();
        assertEquals("[]", intList.toString());
        assertEquals(0, intList.size());
    }

    @Test
    public void testGet() {
        intList.add(3);
        intList.add(1);
        intList.add(2);
        assertEquals(2, intList.get(1));
    }

    @Test
    public void testSize() {
        intList.add(3);
        intList.add(1);
        intList.add(2);
        assertEquals(3, intList.size());
    }

    @Test
    public void testClone() {
        intList.add(3);
        intList.add(1);
        intList.add(2);
        SortedLinkedList<Integer> cloned = intList.clone();
        assertEquals(intList.toString(), cloned.toString());
        assertEquals(intList.size(), cloned.size());

        Iterator<Integer> iterator = intList.iterator();
        Iterator<Integer> clonedIterator = cloned.iterator();
        while (iterator.hasNext() && clonedIterator.hasNext()) {
            assertEquals(iterator.next(), clonedIterator.next());
        }
    }

    @Test
    public void testAddAllWithNullCollection() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            intList.addAll(null);
        });

        String expectedMessage = "Null collection is not permitted";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testAddAllWithNullElement() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            intList.addAll(Arrays.asList(1, null, 2));
        });

        String expectedMessage = "Null elements are not permitted in the list";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testAddAllAtIndex() {
        Exception exception = assertThrows(UnsupportedOperationException.class, () -> {
            intList.addAll(0, Arrays.asList(3, 1, 2));
        });

        String expectedMessage = "Cannot add a collection at a specific index";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testGetFirst() {
        intList.add(3);
        intList.add(1);
        intList.add(2);
        assertEquals(1, intList.getFirst());
    }

    @Test
    public void testGetLast() {
        intList.add(3);
        intList.add(1);
        intList.add(2);
        assertEquals(3, intList.getLast());
    }

    @Test
    public void testGetFirstEmpty() {
        assertThrows(NoSuchElementException.class, () -> intList.getFirst());
    }

    @Test
    public void testGetLastEmpty() {
        assertThrows(NoSuchElementException.class, () -> intList.getLast());
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testAddDifferentTypes() {
        SortedLinkedList list = new SortedLinkedList<>();
        list.add(1);
        assertThrows(ClassCastException.class, () -> list.add("test"));
    }

    @Test
    public void testAddStrings() {
        assertTrue(stringList.add("banana"));
        assertTrue(stringList.add("apple"));
        assertTrue(stringList.add("cherry"));
        assertEquals("[apple, banana, cherry]", stringList.toString());
    }

    @Test
    public void testAddEmptyString() {
        assertTrue(stringList.add(""));
        assertTrue(stringList.add("apple"));
        assertEquals("[, apple]", stringList.toString());
    }

    @Test
    public void testAddStringsWithSpecialCharacters() {
        assertTrue(stringList.add("banana!"));
        assertTrue(stringList.add("apple#"));
        assertTrue(stringList.add("cherry$"));
        assertEquals("[apple#, banana!, cherry$]", stringList.toString());
    }

    @Test
    public void testAddStringsWithSpaces() {
        assertTrue(stringList.add(" banana"));
        assertTrue(stringList.add("apple "));
        assertTrue(stringList.add(" cherry "));
        assertEquals("[ banana,  cherry , apple ]", stringList.toString());
    }

}