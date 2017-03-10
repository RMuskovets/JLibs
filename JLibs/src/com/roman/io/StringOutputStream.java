package com.roman.io;

import java.io.*;

/**
 * Created by LINKOR on 01.03.2017 in 14:54.
 * Date: 2017.03.01
 */
public class StringOutputStream extends OutputStream {

    private StringBuilder sb = new StringBuilder();

    @Override
    public void write(int b) throws IOException {
        sb.append((char) b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        if (b == null) {
            throw new NullPointerException();
        } else if ((off < 0) || (off > b.length) || (len < 0) ||
                ((off + len) > b.length) || ((off + len) < 0)) {
            throw new IndexOutOfBoundsException();
        } else if (len == 0) {
            return;
        }
        for (int i = 0 ; i < len ; i++) {
            write(b[off + i]);
        }
    }

    @Override
    public void write(byte[] b) throws IOException {
        write(b, 0, b.length);
    }

    @Override
    public String toString() {
        return sb.toString();
    }
}
