package com.roman.util.tuples;

import java.util.Map;

/**
 * Created by LINKOR on 26.12.2016 in 9:30.
 * Date: 2016.12.26
 */
public class TwoTuple<E, T> {
    protected final E e;
    protected final T t;

    public TwoTuple(E ee, T tt) {
        e = ee;
        t = tt;
    }

    public String toString() {
        return getClass().getSimpleName() + "[ " + e + " " + t + " ]";
    }

    public TwoTuple copy() {
        return new TwoTuple(t, e);
    }
}
