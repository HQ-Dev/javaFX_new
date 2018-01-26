package com.archy.swing25awtIntro;

import java.applet.Applet;
import java.awt.*;

/**
 * @author Archy
 * @date 2018.1.26
 **/
/*
    <applet code="ColorDemo" width=300 height=200>
    </applet>
 */
public class ColorDemo extends Applet {

    // draw lines
    @Override
    public void paint(Graphics g) {
        Color color1 = new Color(255,100,100);
        Color color2 = new Color(100,255,255);
        Color color3 = new Color(100,100,255);

        g.setColor(color1);
        g.drawLine(0,0,100,100);
        g.drawLine(0,100,100,0);

        g.setColor(color2);
        g.drawLine(40,25,250,180);
        g.drawLine(75,90,400,400);

        g.setColor(color3);
        g.drawLine(20,150,400,40);
        g.drawLine(5,290,80,19);

        g.setColor(Color.red);
        g.drawOval(10,10,50,50);
        g.drawOval(70,90,140,100);

        g.setColor(Color.cyan);
        g.fillRect(100,10,60,50);
        g.drawRoundRect(190,10,60,50,15,15);
    }
}
