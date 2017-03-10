package com.roman.util;

/**
 * Created by LINKOR on 13.02.2017 in 16:56.
 * Date: 2017.02.13
 */
public interface Builder<T> {
    T build(Object... args);
    T build();
}
