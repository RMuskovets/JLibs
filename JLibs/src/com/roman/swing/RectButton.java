package com.roman.swing;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

@EqualsAndHashCode(callSuper = true)
@Data
public class RectButton extends JButton implements MouseListener {

    private Color onEnter = Color.CYAN;
    private Color border = Color.BLUE;
    private Color onClick = new Color(onEnter.getRed(), onEnter.getGreen(), onEnter.getBlue() + 15);
    private Color defaultState = Color.CYAN;
    private Color now = defaultState;

    public RectButton() {
        addMouseListener(this);
    }

    public RectButton(Icon icon) {
        super(icon);
        addMouseListener(this);
    }

    public RectButton(String text) {
        super(text);
        addMouseListener(this);
    }

    public RectButton(Action a) {
        super(a);
        addMouseListener(this);
    }

    public RectButton(String text, Icon icon) {
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
        g.drawRect(0, 0, getWidth(), getHeight());
        g.setColor(now);
        g.fillRect(1, 1, getWidth() - 2, getHeight() - 2);
    }
}
