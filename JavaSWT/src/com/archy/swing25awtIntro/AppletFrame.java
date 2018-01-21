package com.archy.swing25awtIntro;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by lenovo-pc on 2018/1/21.
 */
/*
    <applet code="AppletFrame" width=300 height=50>
    </applet>
 */
// create a subclass of Frame.
class SampleFrame extends Frame {

    SampleFrame(String title) {
        super(title);
        // create a subclass of Frame
        MyWindowAdapter adapter = new MyWindowAdapter(this);
        // register it to receive those events
        addWindowListener(adapter);
    }
    @Override
    public void paint(Graphics g) {
        g.drawString("This is in frame window", 10, 40);
    }

}

class MyWindowAdapter extends WindowAdapter {
    SampleFrame sampleFrame;

    public MyWindowAdapter(SampleFrame sampleFrame) {
        this.sampleFrame = sampleFrame;
    }
    @Override
    public void windowClosing(WindowEvent we) {
        sampleFrame.setVisible(false);
    }
}

// Create frame window.
public class AppletFrame extends Applet {
    Frame f;
    @Override
    public void init() {
        f = new SampleFrame("A Frame Window");

        f.setSize(250,250);
        f.setVisible(true);
    }

    @Override
    public void start() {
        f.setVisible(true);
    }

    @Override
    public void stop() {
        f.setVisible(false);
    }

    @Override
    public void paint(Graphics g) {
        g.drawString("This is in applet window", 10,20);
    }
}
