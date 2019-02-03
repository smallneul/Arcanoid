package com.company;

import java.awt.*;



import javax.swing.JPanel;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

public class Gameplay extends JPanel implements KeyListener, ActionListener {
    private boolean play = false;
    private int sc = 0;
    private int tb = 21;

    private Timer timer;
    private int d = 10;

    private int pla = 310;
    private int bpX= 120;
    private int bpY = 350;
    private int bx = -1;
    private int by = -2;

    public Gameplay() {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(d, this);
        timer.start();

    }
     public void paint(Graphics g){
        g.setColor(Color.pink);
        g.fillRect(1,1,692,592);

        g.setColor(Color.orange);
        g.fillRect(0,0,3,592);
        g.fillRect(0,0,692,3);
        g.fillRect(691,0,3,592);

        g.setColor(Color.black);
        g.fillRect(pla, 550,100,8);

        g.setColor(Color.red);
        g.fillOval(bpX, bpY,20,20);





     }

    @Override
    public void actionPerformed(ActionEvent e){
        timer.start();
        if(play){
            if(new Rectangle(bpX, bpY, 20,20).intersects( new Rectangle(pla, 550,100,8))){
                by = -by;
            }
            bpX+=bx;
            bpY+=by;
            if(bpX <0){
                bx = -bx;
            }
            if(bpY <0){
                by = -by;
            }
            if(bpX > 670){
                bx = -bx;
            }
        }
        repaint();

    }


    @Override
    public void keyTyped(KeyEvent e){ }
    @Override
    public void keyReleased(KeyEvent e){ }
    @Override
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            if(pla >= 600){
                pla = 600;
            }else{
                moveRight();
            }
        }

        if(e.getKeyCode() == KeyEvent.VK_LEFT){

            if (pla >= 600) {
                pla = 600;
            } else {
                moveLeft();
            }
        }
    }
    public void moveRight(){
            play = true;
            pla +=20;

    }
    public void moveLeft(){
        play = true;
        pla -=20;

    }}



