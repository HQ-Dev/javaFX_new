package com.archy.swing26;

import java.applet.Applet;
import java.awt.*;

/**
 * Created by lenovo-pc on 2018/1/21.
 */
/*
<applet code="LabelDemo" width=300 height=200>
</applet>
*/
public class LabelDemo extends Applet {

    @Override
    public void init() {
        Label one = new Label("One");
        Label two = new Label("Two");
        Label three = new Label("Three");

        // add labels to applet window
        add(one);
        add(two);
        add(three);
    }

//    public static void main(String[] args) {
//        LabelDemo labelDemo = new LabelDemo();
//        labelDemo.init();
//    }

}
