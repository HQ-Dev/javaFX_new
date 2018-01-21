package com.archy.swing25awtIntro;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by lenovo-pc on 2018/1/21.
 */
// Handle mouse events in both child and applet windows.
/*
    <applet code="WindowEvents" width=300 height=50>
    </applet>
 */

// Create a subclass of Frame.
class SampleFrame2 extends Frame implements MouseListener, MouseMotionListener {

    String msg = "";
    int mouseX=10, mouseY=40;
    int movX=0, movY=0;

    SampleFrame2(String title) {
        super(title);
        // register this object to receive its own mouse events
        addMouseListener(this);
        addMouseMotionListener(this);
        // Create an object to handle window events
        MyWindowAdapter2 adapter2 = new MyWindowAdapter2(this);
        // register it to receive those events
        addWindowListener(adapter2);
    }

    @Override
    public void paint(Graphics g) {
        g.drawString(msg, mouseX, mouseY);
        g.drawString("Mouse at " + movX + ", " + movY,10,40);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Save coordinates
        mouseX = e.getX();
        mouseY = e.getY();
        msg = "Down";
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Save coordinates
        mouseX = e.getX();
        mouseY = e.getY();
        msg = "Up";
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // Save coordinates
        mouseX = 10;
        mouseY = 54;
        msg = "Mouse just entered child.";
        repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Save coordinates
        mouseX = 10;
        mouseY = 54;
        msg = "Mouse Just Left child window.";
        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // Save coordinates
        mouseX = e.getX();
        mouseY = e.getY();
        movX = e.getX();
        movY = e.getY();
        msg = "*";
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // Save coordinates
        movX = e.getX();
        movY = e.getY();
        repaint(0, 0, 100, 60);
    }
}

class MyWindowAdapter2 extends WindowAdapter {
    SampleFrame2 sampleFrame2;

    public MyWindowAdapter2(SampleFrame2 sampleFrame2) {
        this.sampleFrame2 = sampleFrame2;
    }

    @Override
    public void windowClosing(WindowEvent e) {
        sampleFrame2.setVisible(false);
    }
}

// Applet window.
public class WindowEvents extends Applet implements MouseListener, MouseMotionListener {

    SampleFrame2 f;
    String msg = "";
    int mouseX=0, mouseY=10;
    int movX=0, movY=0;

    // Create a frame window
    @Override
    public void init() {
        f = new SampleFrame2("Handle Mouse events.");
        f.setSize(300, 200);
        f.setVisible(true);

        // register this object to receive its own mouse events
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    // Remove frame window when stopping applet.
    @Override
    public void stop() {
        f.setVisible(false);
    }

    // Show frame window when starting applet.

    @Override
    public void start() {
        f.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Save coordinates.
        mouseX = e.getX();
        mouseY = e.getY();
        msg = "Down";
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Save coordinates.
        mouseX = e.getX();
        mouseY = e.getY();
        msg = "Up";
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // Save coordinates
        mouseX = 0;
        mouseY = 24;
        msg = "Mouse just entered applet window.";
        repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Save coordinates
        mouseX = 0;
        mouseY = 24;
        msg = "Mouse just left applet window.";
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // Save coordinates.
        mouseX = e.getX();
        mouseY = e.getY();
        movX = e.getX();
        movY = e.getY();
        msg = "*";
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // Save coordinates.
        movX = e.getX();
        movY = e.getY();
        repaint(0,0,100,20);
    }

    @Override
    public void paint(Graphics g) {
        g.drawString(msg, mouseX, mouseY);
        g.drawString("Mouse at " + movX + ", " + movY, 0, 10);
    }
}
