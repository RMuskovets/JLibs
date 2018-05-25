package com.roman.util;

import com.roman.io.StringOutputStream;

import java.io.*;

/**
 * Created by LINKOR on 15.02.2017 in 15:08.
 * Date: 2017.02.15
 */
public class PDFReader {
    public static String read(File f) throws IOException {

        OutputStream oos = new StringOutputStream();

        byte[] buf = new byte[8192];

        InputStream is = new FileInputStream(f);

        int c;

        while ((c = is.read(buf, 0, buf.length)) > 0) {
            oos.write(buf, 0, c);
            oos.flush();
        }

        oos.close();
        is.close();
        return oos.toString();
    }
}
