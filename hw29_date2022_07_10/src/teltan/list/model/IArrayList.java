package teltan.list.model;

import java.util.Arrays;
import java.util.Iterator;

import teltan.list.interfaces.IList;

public class IArrayList<E> implements IList<E> {

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    private Object[] elements;
    private int size;

    // O(1)
    public IArrayList() {
        elements = new Object[10];
    }

    // O(1)
    public IArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal capacity " + initialCapacity);
        }
        elements = new Object[initialCapacity];
    }

    // O(n)
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int curPos;

            @Override
            public boolean hasNext() {
                return curPos < size;
            }

            @SuppressWarnings("unchecked")
            @Override
            public E next() {
                return (E) elements[curPos++];
            }

        };
    }

    // O(1)
    @Override
    public boolean add(E element) {
        ensureCapacity();
        elements[size++] = element;
        return true;
    }

    // O(n)
    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
    }

    // O(1)
    @Override
    public int size() {
        return size;
    }

    // O(n)
    @Override
    public boolean add(int index, E element) {
        ensureCapacity();
        if (index == size) {
            add(element);
            return true;
        }
        checkIndex(index);
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
        return true;
    }

    // O(1)
    @SuppressWarnings("unchecked")
    @Override
    public E get(int index) {
        checkIndex(index);
        return (E) elements[index];
    }

    // O(n)
    @Override
    public int indexOf(Object o) {
        if (o != null) {
            for (int i = 0; i < size; i++) {
                if (o.equals(elements[i])) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    return i;
                }
            }
        }
        return -1;
    }

    // O(n)
    @Override
    public int lastIndexOf(Object o) {
        if (o != null) {
            for (int i = size - 1; i >= 0; i--) {
                if (o.equals(elements[i])) {
                    return i;
                }
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (elements[i] == null) {
                    return i;
                }
            }
        }
        return -1;
    }

    // O(n)
    @Override
    public E remove(int index) {
        checkIndex(index);
        @SuppressWarnings("unchecked")
        E victum = (E) elements[index];
        System.arraycopy(elements, index + 1, elements, index, --size - index);
        elements[size] = null;
        return victum;
    }

    // O(1)
    @Override
    public E set(int index, E element) {
        checkIndex(index);
        @SuppressWarnings("unchecked")
        E temp = (E) elements[index];
        elements[index] = element;
        return temp;
    }

    // O(1)
    private void ensureCapacity() {
        if (size == MAX_ARRAY_SIZE) {
            throw new OutOfMemoryError();
        }
        if (size == elements.length) {
            int newCapacity = elements.length + elements.length / 2 + 1;
            if (newCapacity < 0 || newCapacity > MAX_ARRAY_SIZE) {
                newCapacity = MAX_ARRAY_SIZE;
            }
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    // O(1)
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }

    }
}
