package com.roman.io;

import com.roman.util.ConvertTo;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by LINKOR on 25.11.2016 in 16:26.
 * Date: 2016.11.25
 */
public class Files {
    protected Files() {}

    public static Byte[] readBytes(File root) throws Exception {
        ArrayList<Byte> bytes = new ArrayList<>();
        FileInputStream fis = new FileInputStream(root);
        int c;
        while ((c = fis.read()) != -1) bytes.add((byte) c);
        return bytes.toArray(new Byte[bytes.size()]);
    }
    public static String read(File root) throws Exception {
        return new String(ConvertTo.prim(readBytes(root)));
    }
    public static void write(File root, byte[] text) throws Exception {
        FileOutputStream fos = new FileOutputStream(root);
        fos.write(text);
        fos.close();
    }
    public static void write(File root, String text) throws Exception {
        write(root, text.getBytes());
    }
    public static long length(File f) {
        return f.length();
    }
    public static boolean valid(File f) {
        return f.length() > 0 && f.getName().length() != 0 && f.exists() && f.canRead();
    }
    public static String getPath(String file) {
        return new File(file).getAbsolutePath();
    }
    public static String format(File f) {
        return f.getName().split(".")[f.getName().split(".").length - 1];
    }

}
