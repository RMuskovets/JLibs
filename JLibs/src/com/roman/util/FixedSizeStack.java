package com.roman.util;

/**
 * Created by LINKOR on 02.12.2016 in 21:13.
 * Date: 2016.12.02
 */
public class FixedSizeStack<E> {
    private Object[] elements;
    private int index = 0;
    public FixedSizeStack(int size) {
        elements = new Object[size];
    }
    public void push(E e) {
        elements[index++] = e;
    }
    @SuppressWarnings("unchecked")
    public E pop() {
        return (E) elements[index];
    }
}
