package com.roman.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by LINKOR on 01.03.2017 in 15:13.
 * Date: 2017.03.01
 */
public class ReadOutputStream extends OutputStream implements ReadWrite {

    private final InputStream is;
    private final OutputStream os;

    public ReadOutputStream(InputStream si, OutputStream out) {
        is = si;
        os = out;
    }

    @Override
    public void write(int b) throws IOException {
        os.write(b);
    }
    public void writefr() throws IOException {
        int b;
        while ((b = is.read()) != -1) {
            os.write(b);
        }
    }
    public void close() throws IOException {
        os.close();
        is.close();
    }

    @Override
    public void flush() throws IOException {
        os.flush();
    }
}
