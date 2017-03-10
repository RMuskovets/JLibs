package com.roman.io;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * Created by LINKOR on 01.03.2017 in 15:08.
 * Date: 2017.03.01
 */
public class ReadWriter extends Writer implements ReadWrite {

    private final Reader r;
    private final Writer out;
    private boolean closed;

    public ReadWriter(Reader e, Writer w) {
        r = e;
        out = w;
    }

    @Override
    public void write(char[] b, int off, int len) throws IOException {
        if (!closed) {
            if (b == null) {
                throw new NullPointerException();
            } else if ((off < 0) || (off > b.length) || (len < 0) ||
                    ((off + len) > b.length) || ((off + len) < 0)) {
                throw new IndexOutOfBoundsException();
            } else if (len == 0) {
                return;
            }
            for (int i = 0; i < len; i++) {
                write(b[off + i]);
            }
        } else throw new IOException("Writer is closed.");
    }

    @Override
    public void flush() throws IOException {
        out.flush();
    }

    @Override
    public void close() throws IOException {
        closed = true;
        out.close();
        r.close();
    }

    public void writefr() throws IOException {
        int c;
        while ((c = r.read()) != -1) {
            write(c);
        }
    }

    @Override
    public void write(int c) throws IOException {
        out.write(c);
    }

    public void append() throws IOException {
        out.write(r.read());
    }
}
