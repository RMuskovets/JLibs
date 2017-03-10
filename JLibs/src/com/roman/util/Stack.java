package com.roman.util;

/**
 * Created by LINKOR on 07.03.2017 in 7:27.
 * Date: 2017.03.07
 */
public interface Stack<T> {
    T pop();
    void push();
    T[] removeAll();
    T peek();
    boolean empty();
    int search(Object t);
}
