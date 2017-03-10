package com.roman.io;

import com.roman.exception.MethodException;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.net.URL;

/**
 * Created by LINKOR on 11.11.2016 in 15:14.
 * Date: 2016.11.11
 */
public class Loader {
    public static Document loadXMLFile(String file) throws Exception {
        return DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(file));
    }
    public static String loadFile(String file) throws IOException {
        BufferedReader bw = new BufferedReader(new FileReader(new File(file)));
        String text = "", line;
        while ((line = bw.readLine()) != null) text += (line + '\n');
        return text;
    }
    public static URL loadURL(String f) throws Exception {
        return new URI(f).normalize().toURL();
    }
    public static Class<?> loadClass(String name) throws ClassNotFoundException {
        return Class.forName(name);
    }
    public static <T> T loadClass(Class<T> c) {
        try {
            return c.newInstance();
        } catch (InstantiationException e) {
            return null;
        } catch (IllegalAccessException e) {
            return privOthLoad(c);
        }
    }
    private static <T> T privOthLoad(Class<T> c) {
        try {
            Constructor<T> ctor = c.getDeclaredConstructor((Class<?>[]) null);
            ctor.setAccessible(true);
            return ctor.newInstance();
        } catch (NoSuchMethodException e) {
            throw new MethodException("No default constructor in this class: " + c.getName());
        } catch (IllegalAccessException e) {
            return null;
        } catch (InstantiationException e) {
            return null;
        } catch (InvocationTargetException e) {
            return null;
        }
    }

}