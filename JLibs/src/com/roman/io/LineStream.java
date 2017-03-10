package com.roman.io;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by LINKOR on 30.12.2016 in 15:49.
 * Date: 2016.12.30
 */
public class LineStream {
    private String[] lines;

    /**
     * @param input The file from which data will be scanned
     * @throws IOException
     */
    public LineStream(File input) throws IOException {
        lines = read(new InputStreamReader(new FileInputStream(input)));
    }
    public LineStream(InputStream is) throws IOException {
        lines = read(new InputStreamReader(is));
    }
    public LineStream(String file) throws IOException {
        this(new File(file));
    }
    public LineStream(Reader r) throws IOException {
        lines = read(r);
    }

    private String[] read(Reader is) throws IOException {
        BufferedReader br = new BufferedReader(is);
        String all = "", cl;
        while ((cl = br.readLine()) != null) all += cl;
        return all.split("\n");
    }
    public String getLine(int index) {
        return lines[index];
    }
    public String setLine(String line, int index) {
        String old = lines[index];
        lines[index] = line;
        return old;
    }
    public boolean delete(String line) {
        return Arrays.asList(lines).remove(line);
    }
    public String delete(int index) {
        return Arrays.asList(lines).remove(index);
    }
    public void addLine(String line) {
        ArrayList<String> ls = new ArrayList<>(Arrays.asList(lines));
        ls.add(line);
        lines = (String[]) ls.toArray();
    }
    public void addLine(String line, int index) {
        ArrayList<String> ls = new ArrayList<>(Arrays.asList(lines));
        ls.add(index, line);
        lines = (String[]) ls.toArray();
    }
}
