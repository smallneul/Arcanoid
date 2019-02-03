package com.company;
import javax.swing.JFrame;
public class Main {

    public static void main(String[] args) {
	     JFrame o = new JFrame();
	     Gameplay gamePlay =  new Gameplay();
	     o.setBounds(10,10,700,600);
	     o.setTitle("Arcanoid");
	     o.setResizable(false);
	     o.setVisible(true);
	     o.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         o.add(gamePlay);
    }
}
