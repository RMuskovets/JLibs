package com.roman.util;

import java.lang.reflect.Array;
import java.util.*;
import static java.util.AbstractMap.*;

/**
 * Created by LINKOR on 30.10.2016 in 9:08.
 * Date: 2016.10.30
 */
public class ArrayMap<KV> implements Iterable<Entry<KV, KV>> {
    private java.util.ArrayList<Entry<KV, KV>> storage;
    public ArrayMap(KV[] keys, KV[] values, int size) {
        storage = new java.util.ArrayList<>(size);
        for (int i = 0; i < size; i ++) {
            storage.add(new SimpleEntry<>(keys[i], values[i]));
        }
    }
    @SafeVarargs
    public ArrayMap(KV... kvals) {
        storage = new java.util.ArrayList<>();
        for (KV kv : kvals) {
            storage.add(new SimpleEntry<>(kv, kv));
        }
    }
    public ArrayMap(List<? extends KV> keys, List<? extends KV> values, int size) {
        storage = new java.util.ArrayList<>(size);
        for (int i = 0; i < size; i ++) {
            storage.add(new SimpleEntry<>(keys.get(i), values.get(i)));
        }
    }
    public ArrayMap(List<? extends KV> kvals) {
        this(kvals, kvals, kvals.size());
    }

    public int size() {
        return storage.size();
    }
    public Entry<KV, KV> getEntry(int index) {
        return storage.get(index);
    }
    public Entry<KV, KV> set(int index, Entry<KV, KV> element) {
        return storage.set(index, element);
    }
    public boolean add(Entry<KV, KV> entry) {
        return storage.add(entry);
    }
    public KV[] get(int index) {
        KV kv = getEntry(index).getKey();
        KV[] res = (KV[]) Array.newInstance(kv.getClass(), 2);
        res[0] = kv;
        res[1] = getEntry(index).getValue();
        return res;
    }
    public void add(int index, Entry<KV, KV> element) {
        storage.add(index, element);
    }
    public Entry<KV, KV> remove(int index) {
        return storage.remove(index);
    }
    public boolean addAll(Collection<? extends Entry<KV, KV>> c) {
        return storage.addAll(c);
    }
    public boolean addAll(int index, Collection<? extends Entry<KV, KV>> c) {
        return storage.addAll(index, c);
    }
    public boolean removeAll(Collection<Entry<KV, KV>> c) {
        return storage.removeAll(c);
    }
    public ListIterator<Entry<KV, KV>> listIterator(int index) {
        return storage.listIterator(index);
    }
    public ListIterator<Entry<KV, KV>> listIterator() {
        return storage.listIterator();
    }
    public Iterator<Entry<KV, KV>> iterator() {
        return storage.iterator();
    }
    public boolean put(KV key, KV value) {
        return storage.add(new SimpleEntry<>(key, value));
    }

    public boolean isEmpty() {
        return storage.isEmpty();
    }
    public boolean contains(Entry<KV, KV> o) {
        return storage.contains(o);
    }

    public int indexOf(Object o) {
        return storage.indexOf(o);
    }

    public int lastIndexOf(Object o) {
        return storage.lastIndexOf(o);
    }
}
