package com.roman.util;

import java.util.*;

/**
 * Created by LINKOR on 02.12.2016 in 21:14.
 * Date: 2016.12.02
 */
public class ArrayList<E> extends java.util.ArrayList<E> implements MoreList<E> {
    private Random rand = new Random();

    public ArrayList(int initialCapacity) {
        super(initialCapacity);
    }

    public ArrayList() {
        super();
    }

    public ArrayList(Collection<? extends E> c) {
        super(c);
    }

    public E select() {
        return get(rand.nextInt(size()));
    }

    public void addRandom(E e) {
        add(rand.nextInt(size() + 1), e);
    }

    public void addAll(E... es) {
        super.addAll(Arrays.asList(es));
    }
}
