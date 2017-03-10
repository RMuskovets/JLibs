package com.roman.swing;

import javafx.embed.swing.JFXPanel;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

import javax.swing.*;
import java.awt.*;

/**
 * Created by LINKOR on 11.11.2016 in 15:58.
 * Date: 2016.11.11
 */
public class FXFrame extends JFrame {
    private transient JFXPanel fxRoot;
    public FXFrame(Scene s) {
        super();
        fxRoot = new JFXPanel();
        fxRoot.setScene(s);
    }
    public FXFrame(Parent g) {
        super();
        fxRoot = new JFXPanel();
        fxRoot.setScene(new Scene(g));
    }
    public FXFrame() {
        super();
        fxRoot = new JFXPanel();
    }
    public FXFrame(String title) {
        super(title);
        fxRoot = new JFXPanel();
    }
    @Override
    public void update(Graphics g) {
        super.update(g);
    }
    @Override
    public void remove(Component comp) {
        super.remove(comp);
    }
    @Override
    public void setLayout(LayoutManager manager) {
        super.setLayout(manager);
    }
    @Override
    public void setIconImage(Image image) {
        super.setIconImage(image);
    }
    @Override
    public Graphics getGraphics() {
        return super.getGraphics();
    }
    @Override
    public void repaint(long time, int x, int y, int width, int height) {
        super.repaint(time, x, y, width, height);
    }
    public FXFrame(Node... elems) {
        super();
        fxRoot = new JFXPanel();
        fxRoot.setScene(new Scene(new AnchorPane(elems)));
    }
}
