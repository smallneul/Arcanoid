package com.company;

import java.awt.Graphics2D;
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


    private MapGenerator map;
    public Gameplay() {
        map = new MapGenerator(3,7);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(d, this);
        timer.start();

    }
     public void paint(Graphics g){
        g.setColor(Color.black);
        g.fillRect(1,1,692,592);

        map.draw((Graphics2D)g);

        g.setColor(Color.yellow);
        g.fillRect(0,0,3,592);
        g.fillRect(0,0,692,3);
        g.fillRect(691,0,3,592);

        g.setColor(Color.white);
        g.setFont(new Font("serif", Font.BOLD, 25));
        g.drawString(""+sc, 590, 30);



        g.setColor(Color.green);
        g.fillRect(pla, 550,100,8);

        g.setColor(Color.yellow);
        g.fillOval(bpX, bpY,20,20);

        if(tb <=0){
            play = false;
            bx = 0;
            by = 0;
            g.setColor(Color.yellow);
            g.setFont (new Font("serif", Font.BOLD,30));
            g.drawString("WON, score: " + sc , 190, 300);

            g.setFont (new Font("serif", Font.BOLD,20));
            g.drawString("Press Enter", 230, 350);


        }

        if(bpY > 570){
            play = false;
            bx = 0;
            by = 0;
            g.setColor(Color.yellow);
            g.setFont (new Font("serif", Font.BOLD,30));
            g.drawString("GAME OVER, score: " + sc , 190, 300);

            g.setFont (new Font("serif", Font.BOLD,20));
            g.drawString("Press Enter", 230, 350);

        }







     }

    @Override
    public void actionPerformed(ActionEvent e){
        timer.start();
        if(play){
            if(new Rectangle(bpX, bpY, 20,20).intersects( new Rectangle(pla, 550,100,8))){
                by = -by;
            }

            for(int i = 0; i < map.map.length; i++){
                for(int j=0; j< map.map[0].length; j++){
                    if(map.map[i][j]>0){
                        int bX = j*map.bw+80;
                        int bY = i*map.bh+50;
                        int bw = map.bw;
                        int bh = map.bh;

                        Rectangle rect = new Rectangle(bX, bY, bw, bh);
                        Rectangle ballRect = new Rectangle(bpX, bpY, 20,20);
                        Rectangle brickRect = rect;

                        if(ballRect.intersects(brickRect)){
                            map.setBrickValue(0,i,j);
                            tb--;
                            sc += 5;
                            if(bpX + 19 <= brickRect.x || bpX + 1 >= brickRect.x + brickRect.width){
                                bx = -bx;
                        }else{
                                by = -by;
                            }
                        break;

                        }
;                    }

                }
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
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            if(!play){
                play = true;
                bpX = 120;
                bpY = 350;
                bx = -1;
                by = -2;
                pla = 310;
                sc = 0;
                tb = 21;
                map = new MapGenerator(3,7);
                repaint();
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



