package com.roman.swing;

import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javax.swing.*;
import java.applet.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

/**
 * Created by LINKOR on 11.11.2016 in 15:01.
 * Date: 2016.11.11
 */
public final class SConsole {

    private SConsole() {}

    public static void run(final JFrame jfr, final int width, final int height) {
        SwingUtilities.invokeLater(() -> {
            jfr.setSize(width, height);
            run(jfr);
        });
    }

    public static void run(final JFrame jfr) {
        SwingUtilities.invokeLater(() -> {
            jfr.setVisible(true);
        });
    }

    public static void run(final Applet app, final AppletStub ast, final boolean init) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                app.setStub(ast);
                if (init) app.init();

                app.start();
            }
        });
    }

    public static void show(final Component c) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame f = new JFrame(getClass().getSimpleName());
                f.setLayout(new FlowLayout());
                f.add(c);
                f.pack();
            }
        });
    }

    public static JFrame create(final int width, final int height, final String title) {
        JFrame jf = new JFrame(title);
        jf.setSize(width, height);
        return jf;
    }

    public static JFrame create(int width, int height) {
        return create(width, height, "");
    }

    public static void run(int width, int height) {
        run(create(width, height), width, height);
    }

    public static JFXPanel create(Scene s) {
        JFXPanel res = new JFXPanel();
        res.setScene(s);
        return res;
    }

    public static JFrame createFX(Parent root) {
        JFrame jfr = new JFrame();
        jfr.add(create(new Scene(root)));
        return jfr;
    }

    public static void showFX(URL root) throws IOException {
        run(createFX(FXMLLoader.load(root)));
    }
}
