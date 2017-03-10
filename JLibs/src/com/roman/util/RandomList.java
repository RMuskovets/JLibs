package com.roman.util;

import java.util.*;

/**
 * Created by LINKOR on 11.11.2016 in 15:50.
 * Date: 2016.11.11
 */
public class RandomList<E> {
    private ArrayList<E> storage;
    private Random r = new Random();
    public RandomList() {
        super();
    }
    public int size() {
        return storage.size();
    }
    public boolean empty() {
        return storage.isEmpty();
    }
    public E get(int index) {
        return storage.get(index);
    }
    public E set(int index, E element) {
        return storage.set(index, element);
    }
    public void add(E e) {
        storage.add(e);
    }
    public void add(int index, E element) {
        storage.add(index, element);
    }
    public E remove(int index) {
        return storage.remove(index);
    }
    public ListIterator<E> listIterator(int index) {
        return storage.listIterator(index);
    }
    public ListIterator<E> listIterator() {
        return storage.listIterator();
    }
    public Spliterator<E> spliterator() {
        return storage.spliterator();
    }
    public boolean containsAll(Collection<?> c) {
        return storage.containsAll(c);
    }
    @SafeVarargs
    public RandomList(E... elems) {
        storage = new ArrayList<E>(Arrays.asList(elems));
    }
    public E select() {
        return get(r.nextInt(size()));
    }
}
