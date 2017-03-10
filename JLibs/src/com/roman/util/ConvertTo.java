package com.roman.util;

/**
 * Created by LINKOR on 25.11.2016 in 16:33.
 * Date: 2016.11.25
 */
public final class ConvertTo {

    private ConvertTo() {}

    public static byte[] prim(Byte[] in) {
        byte[] out = new byte[in.length];
        for (int i = 0; i < in.length; i++) {
            out[i] = in[i];
        }
        return out;
    }
    public static String string(byte[] in) {
        return new String(in);
    }
    public static char[] string(String s) {
        return s.toCharArray();
    }
    public static byte[] prim(char[] s) {
        byte[] out = new byte[s.length];
        for (int i = 0; i < s.length; i++) {
            out[i] = Byte.parseByte(String.valueOf(s[i]));
        }
        return out;
    }
    public static byte[] prim(long l) {
        byte[] bs = new byte[Long.BYTES];
        for (int i = 0; i < bs.length; i++) {
            long o = l % Byte.MAX_VALUE;
            bs[i] = (byte) o;
            l -= o;
        }
        return bs;
    }
    public static Byte[] obj(byte[] in) {
        Byte[] out = new Byte[in.length];
        for (int i = 0; i < in.length; i++) {
            out[i] = in[i];
        }
        return out;
    }
}
