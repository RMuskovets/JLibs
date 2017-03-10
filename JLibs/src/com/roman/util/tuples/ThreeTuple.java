package com.roman.util.tuples;

/**
 * Created by LINKOR on 26.12.2016 in 9:38.
 * Date: 2016.12.26
 */
public class ThreeTuple<E, T, W> extends TwoTuple<E, T> {

    protected final W w;

    public ThreeTuple(E ee, T tt, W ww) {
        super(ee, tt);
        w = ww;
    }

    public String toString() {
        return getClass().getSimpleName() + "[ " + e + " " + t + " " + w + " ]";
    }

    public ThreeTuple copy() {
        return new ThreeTuple<>(w, e, t);
    }
}
