package com.roman.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CircleButton extends JButton implements MouseListener {

    private Color onEnter = Color.CYAN;
    private Color border = Color.BLUE;
    private Color onClick = new Color(onEnter.getRed(), onEnter.getGreen(), onEnter.getBlue() + 15);
    private Color defaultState = Color.CYAN;
    private Color now = defaultState;

    public CircleButton() {
        addMouseListener(this);
    }

    public CircleButton(Icon icon) {
        super(icon);
        addMouseListener(this);
    }

    public CircleButton(String text) {
        super(text);
        addMouseListener(this);
    }

    public CircleButton(Action a) {
        super(a);
        addMouseListener(this);
    }

    public CircleButton(String text, Icon icon) {
        super(text, icon);
        addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        now = onClick;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        now = onClick;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        now = defaultState;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        now = onEnter;
    }

    @Override
    public void mouseExited(MouseEvent e) {
        now = defaultState;
    }


    public void paintComponent(Graphics g) {
        g.setColor(border);
        g.drawOval(0, 0, getWidth(), getHeight());
        g.setColor(now);
        g.fillOval(1, 1, getWidth() - 2, getHeight() - 2);
    }
}
