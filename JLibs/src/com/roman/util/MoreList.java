package com.roman.util;

import java.util.List;

/**
 * Created by LINKOR on 26.12.2016 in 9:49.
 * Date: 2016.12.26
 */
public interface MoreList<E> extends List<E> {
    void addAll(E... es);
    E select();
    void addRandom(E e);
}
