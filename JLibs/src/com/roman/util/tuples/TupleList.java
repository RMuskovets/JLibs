package com.roman.util.tuples;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by LINKOR on 26.12.2016 in 9:44.
 * Date: 2016.12.26
 */
public class TupleList<T, E> extends ArrayList<TwoTuple<T, E>> {
    public TupleList(int initialCapacity) {
        super(initialCapacity);
    }

    public TupleList() {
        super();
    }

    public TupleList(Collection<TwoTuple<T, E>> coll) {
        super(coll);
    }

    public TupleList(T[] ts, E[] es) {
        ArrayList<TwoTuple<T, E>> list = new ArrayList<>();
        for (int i = 0; i < ts.length && i < es.length; i++) {
            list.add(new TwoTuple<>(ts[i], es[i]));
        }
        addAll(list);
    }

    public void add(T t, E e) {
        super.add(new TwoTuple<>(t, e));
    }
}
