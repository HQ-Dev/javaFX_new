package com.archy.swing25awtIntro;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author Archy
 * @date 11.25
 **/
// Resizing output to fit the current size of a window

/*
  <applet code="ResizeMe" width=200 height=200>
  </applet>
*/
public class ResizeMe extends Applet {
    final int inc =25;
    int max = 500;
    int min = 200;
    Dimension d;

    public ResizeMe() {
        addMouseListener(new MouseAdapter() {
            // ����ͷ�
            @Override
            public void mouseReleased(MouseEvent e) {
                int w = (d.width + inc) > max ? min : d.width + inc;
                int h = (d.height + inc) > max ? min : d.height + inc;
                setSize(new Dimension(w, h));
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        d = getSize(); // ������������ Dimension ����

        g.drawLine(0,0,d.width-1, d.height-1);
        g.drawLine(0,d.height-1, d.width-1,0);
        g.drawRect(0,0,d.width-1,d.height-1);

    }
}
