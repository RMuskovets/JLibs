package com.roman.swing;

import javax.swing.*;

/**
 * Created by LINKOR on 13.02.2017 in 17:14.
 * Date: 2017.02.13
 */
public class Window extends JInternalFrame {
    public Window() {
        this("");
    }

    public Window(String title) {
        this(title, true);
    }

    public Window(String title, boolean resizable) {
        this(title, true, true);
    }

    public Window(String title, boolean resizable, boolean closable) {
        this(title, resizable, closable, true);
    }

    public Window(String title, boolean resizable, boolean closable, boolean maximizable) {
        this(title, resizable, closable, maximizable, true);
    }

    public Window(String title, boolean resizable, boolean closable, boolean maximizable, boolean iconifiable) {
        super(title, resizable, closable, maximizable, iconifiable);
    }
}
