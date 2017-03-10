package com.roman.util;

import java.util.Objects;

/**
 * Created by LINKOR on 13.02.2017 in 17:07.
 * Date: 2017.02.13
 */
public class StackTraceReader {
    public static String[] read(Thread current) {
        String all = "";
        String line;
        for (StackTraceElement ste: current.getStackTrace()) {
            if (!Objects.equals(ste.getMethodName(), "read")) {
                line = ste.getMethodName() + ", line" + ste.getLineNumber() + "\n";
            } else line = "";
            all += line;
        }
        return all.split("\n");
    }

    public static String[] read() {
        return read(Thread.currentThread());
    }
}
