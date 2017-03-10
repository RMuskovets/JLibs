package com.roman.util;

import java.io.*;

/**
 * Created by LINKOR on 27.12.2016 in 8:48.
 * Date: 2016.12.27
 */
public class Processes {
    public static void exec(String cmd, OutputStream err, OutputStream out, InputStream in) throws IOException {
        exec(cmd, new OutputStreamWriter(err), new OutputStreamWriter(out), new InputStreamReader(in));
    }
    public static void exec(String cmd, Writer err, Writer out, Reader in) throws IOException {
        Process p = Runtime.getRuntime().exec(cmd);
        new Thread(() -> {
            String line;
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            try {
                while ((line = br.readLine()) != null) {
                    err.write(line + "\n");
                }
            } catch (IOException e) {
                StringWriter trace = new StringWriter();
                e.printStackTrace(new PrintWriter(trace));
                try {
                    err.write(trace.toString() + "\n");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            String line;
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            try {
                while ((line = br.readLine()) != null) {
                    out.write(line + "\n");
                }
            } catch (IOException e) {
                StringWriter trace = new StringWriter();
                e.printStackTrace(new PrintWriter(trace));
                try {
                    err.write(trace.toString() + "\n");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            String line;
            BufferedReader br = new BufferedReader(in);
            try {
                while ((line = br.readLine()) != null) {
                    p.getOutputStream().write((line + "\n").getBytes());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
    public static void exec(String cmd) throws IOException {
        exec(cmd, System.err, System.out, System.in);
    }
}
