package com.roman.io;

import java.io.IOException;

/**
 * Created by LINKOR on 01.03.2017 in 15:06.
 * Date: 2017.03.01
 */
public class CharArrayOutputStream extends StringOutputStream {
    public char[] toCharArray() {
        return toString().toCharArray();
    }
    public void write(char c) throws IOException {
        write((int) c);
    }
    public void write(String s) throws IOException {
        for (char c: s.toCharArray()) write(c);
    }
}
