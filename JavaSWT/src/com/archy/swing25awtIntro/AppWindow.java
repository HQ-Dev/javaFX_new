package com.archy.swing25awtIntro;

import java.awt.*;
import java.awt.event.*;

/**
 * Created by lenovo-pc on 2018/1/21.
 */
// Create a frame window.
public class AppWindow extends Frame {
    String keymsg = "This is a test.";
    String mousemsg = "";
    int mouseX = 30, mouseY = 30;

    public AppWindow() {
        addKeyListener(new MyKeyAdapter(this));
        addMouseListener(new MyMouseAdapter(this));
        addWindowListener(new MyWindowAdaper());
    }

    @Override
    public void paint(Graphics g) {
        g.drawString(keymsg, 10, 40);
        g.drawString(mousemsg, mouseX, mouseY);
    }

    // Create the window
    public static void main(String[] args) {
        AppWindow appWindow = new AppWindow();

        appWindow.setSize(new Dimension(300, 200));
        appWindow.setTitle("An AWT-Based Application");
        appWindow.setVisible(true);
    }

    class MyKeyAdapter extends KeyAdapter {
        AppWindow appWindow;

        public MyKeyAdapter(AppWindow appWindow) {
            this.appWindow = appWindow;
        }

        @Override
        public void keyTyped(KeyEvent e) {
            appWindow.keymsg += e.getKeyChar();
            appWindow.repaint();
        }
    }

    class MyMouseAdapter extends MouseAdapter {
        AppWindow appWindow;

        public MyMouseAdapter(AppWindow appWindow) {
            this.appWindow = appWindow;
        }

        @Override
        public void mousePressed(MouseEvent e) {
            appWindow.mouseX = e.getX();
            appWindow.mouseY = e.getY();
            appWindow.mousemsg = "Mouse Down at " + appWindow.mouseX + ", " + appWindow.mouseY;
            appWindow.repaint();
        }

    }

    class MyWindowAdaper extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }
}
