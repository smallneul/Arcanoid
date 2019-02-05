package com.company;


import java.awt.*;

public class MapGenerator {
    public int map[][];
    public int bh;
    public int bw;
    public MapGenerator(int row, int col){
        map = new int[row][col];
        for(int i = 0; i < map.length; i++){
           for(int j=0; j < map[0].length; j++){
               map[i][j] = 1;

           }
        }
        bw =  77;
        bh = 50;

    }
    public void draw(Graphics2D g) {
        for(int i = 0; i<map.length; i++){
            for(int j=0; j<map[0].length; j++){
               if(map [i][j] >0){
                   g.setColor((Color.white));
                   g.fillRect((j * bw) +80, (i * bw) + 50, bw, bh);

                   g.setStroke(new BasicStroke(3));
                   g.setColor(Color.black);
                   g.drawRect((j * bw) +80, (i * bw) + 50, bw, bh);
               }

            }
        }

    }
    public void setBrickValue(int value, int row, int col){
        map[row][col] = value;
    }
}
