package com.example.awtSample;

import java.awt.*;    //The star means to import all the class, interfaces and static objects from the java.awt class
import java.awt.event.WindowAdapter;  //The java.awt.event is a separate package to java.awt
import java.awt.event.WindowEvent;

public class MyWindow extends Frame {

    public MyWindow(String title) {
        super(title);
        setSize(500,140);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Font sansSerifLarge = new Font("SansSerif", Font.BOLD,18);
        Font sansSerifSmall = new Font("SansSerif", Font.BOLD,12);
        g.setFont(sansSerifLarge);
        g.drawString("The Complete Java Developer Course",60,60);
        g.setFont(sansSerifSmall);
        g.drawString("by Tim Buchalka", 60,100);
    }
}
