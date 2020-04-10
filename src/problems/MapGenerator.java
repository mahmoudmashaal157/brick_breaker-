/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problems;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import sun.audio.AudioStream;
import sun.audio.AudioPlayer;
import java.io.*;
public class MapGenerator {
    public int map[][];
    public int brickWidth;
    public int brickHeight;

    public MapGenerator(int row, int col) {
        map = new int[row][col];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = 1;
            }
        }
        brickWidth=540/col;
        brickHeight=150/row;
   
}
    public void draw(Graphics2D g){
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[0].length;j++){
                if(map[i][j]>0){
                g.setColor(Color.PINK);
                g.fillRect(j*brickWidth+80, i*brickHeight+50, brickWidth, brickHeight);
                g.setStroke(new BasicStroke(3));
                g.setColor(Color.black);
                g.drawRect(j*brickWidth+80, i*brickHeight+50, brickWidth, brickHeight);
            }
            }
        }
            
        }
    public void setbricksvalue(int value,int row,int col){
        map[row][col]=value;
    }
    public void music(String filepath){
        InputStream music;
        try{
            music =new FileInputStream(new File(filepath));
            AudioStream audios =new AudioStream(music);
            AudioPlayer.player.start(audios);
        }
        catch(Exception ae){
            System.out.println("error");
        }
    }

}