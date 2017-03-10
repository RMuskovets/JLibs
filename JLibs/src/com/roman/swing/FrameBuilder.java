package com.roman.swing;

import com.roman.util.Builder;

import javax.swing.*;
import java.awt.*;

/**
 * Created by LINKOR on 13.01.2017 in 20:50.
 * Date: 2017.01.13
 */
public class FrameBuilder implements Builder<JFrame> {

    /**
     * @param args
     * @return a JFrame that builded with args
     * Args: [{title}, {closeOperation}, {visible}, {width}, {height}, {layout}, {x}, {y}]
     */

    @Override
    public JFrame build(Object... args) {
        int len = args.length;
        JFrame res= build();
        switch (len) {
            case 1: oneArg(res, args[0]); break;
            case 2: twoArg(res, args); break;
            case 3: thrArg(res, args); break;
            case 5: fourArg(res, args);break;
            case 6: sixArg(res, args); break;
            case 8: eiArg(res,  args); break;
            default: throw new IllegalArgumentException();
        }
        return res;
    }

    private void eiArg(JFrame res, Object[] args) {
        sixArg(res, args);
        int x = (Integer) args[6], y = (Integer) args[7];
        res.setLocation(x, y);
    }

    private void sixArg(JFrame res, Object[] args) {
        fourArg(res, args);
        res.setLayout((LayoutManager) args[5]);
    }

    private void fourArg(JFrame res, Object[] args) {
        thrArg(res, args);
        res.setSize((Integer) args[3], (Integer) args[4]);
    }

    private void thrArg(JFrame res, Object[] args) {
        twoArg(res, args);
        res.setVisible((Boolean) args[2]);
    }

    private void twoArg(JFrame res, Object[] args) {
        oneArg(res, args[0]);
        res.setDefaultCloseOperation((Integer) args[1]);
    }

    private void oneArg(Frame res, Object arg) {
        res.setTitle((String) arg);
    }

    @Override
    public JFrame build() {
        return new JFrame();
    }
}
