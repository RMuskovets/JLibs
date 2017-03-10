package com.roman.lang;

import java.io.IOException;
import java.lang.reflect.*;
import java.util.*;

/**
 * Created by LINKOR on 30.12.2016 in 15:52.
 * Date: 2016.12.30
 */
public final class System {
    private System() {}
    public static void println(Object obj) {
        java.lang.System.out.println(obj);
    }
    public static void print(Object obj) {
        java.lang.System.out.print(obj);
    }
    public static void print(Object... arr) {
        java.lang.System.out.println(Arrays.toString(arr));
    }
    public static <T> T create(Class<T> cls) {
        try {
            return cls.newInstance();
        } catch (InstantiationException e) {
            return null;
        } catch (IllegalAccessException e) {
            try {
                Constructor<T> c = cls.getConstructor();
                c.setAccessible(true);
                return c.newInstance();
            } catch (NoSuchMethodException e1) {
                return null;
            } catch (IllegalAccessException | InstantiationException | InvocationTargetException e1) {
                return null;
            }
        }
    }
    public static Class<?> getClass(Object obj) {
        return obj.getClass();
    }
    public static char read() throws IOException {
        return (char) java.lang.System.in.read();
    }
    public static Iterator<Map.Entry<String, String>> getenvIterator() {
        return java.lang.System.getenv().entrySet().iterator();
    }
    public static Map.Entry[] getenv() {
        return (Map.Entry[]) java.lang.System.getenv().entrySet().toArray();
    }
    public static Object invokeMethod(String name, Class<?> cls, Object... args) {
        try {
            return cls.getMethod(name, getTypes(args)).invoke(create(cls));
        } catch (Exception e) {throw new RuntimeException(e); }
    }

    private static Class[] getTypes(Object[] args) {
        Class<?>[] cls = new Class<?>[args.length];
        for (int i = 0; i < args.length; i ++) cls[i] = args[i].getClass();
        return cls;
    }
}