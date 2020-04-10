
package problems;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import sun.audio.*;
public class GamePlay extends JPanel implements KeyListener, ActionListener {  //KeyListener detecting arroy key and ActionListener for moving the ball 

    private boolean play = false;
    public int score = 0;

    private int totalBricks = 21;

    private Timer timer;
    private int delay = 8;

    private int playerX = 310;

    private int ballPosX = 120;
    private int ballPosY = 350;
    private int ballDirX = -5;
    private int ballDirY = -2;

    private MapGenerator map;

    public GamePlay() {
        map = new MapGenerator(3, 7);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();
    }

    @Override
    public void paint(Graphics graphics) {
        //background
        graphics.setColor(Color.black);
        graphics.fillRect(1, 1, 692, 592);

        //drawing map of bricks
        map.draw((Graphics2D)graphics);

        //border
        graphics.setColor(Color.yellow);
        graphics.fillRect(0, 0, 3, 592);
        graphics.fillRect(0, 0, 692, 3);
        graphics.fillRect(691, 1, 3, 592);
        //score writtng
        graphics.setColor(Color.CYAN);
        graphics.setFont(new Font("serif",Font.BOLD,32));
        graphics.drawString(""+score, 590, 30);

        //paddle
        graphics.setColor(Color.green);
        graphics.fillRect(playerX, 550, 100, 8);
        //the ball
        graphics.setColor(Color.yellow);
        graphics.fillOval(ballPosX, ballPosY, 20, 20);
         
        //////////////
         if(ballPosY>550){
             graphics.setColor(Color.red);
                 graphics.setFont(new Font("serif",Font.BOLD,32));
                 graphics.drawString("Game Over you Scored "+score, 150, 300);
                 graphics.drawString("press enter to Restart ", 150, 350);
                 graphics.drawString("press ESC to EXIT ", 150, 400);


                 
                 graphics.setColor(Color.red);
                 graphics.setFont(new Font("serif",Font.BOLD,32));
                // graphics.drawString("GmaeOver  "+score, 590, 30);
                
            }
       
         

        
        graphics.dispose();
    }
    

    @Override
    public void keyPressed(KeyEvent ke) {
        if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (playerX > 600) {
                playerX = 600;
            } else {
                moveRight();
            }
        }
        if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
            if (playerX < 10) {
                playerX = 10;
            } else {
                moveLeft();
            }
        }
        if(ke.getKeyCode()==KeyEvent.VK_ENTER){
            if(!play)
            play=true;
            ballPosX=120;
            ballPosY=350;
            ballDirX=-5;
            ballDirY=-2;
            totalBricks = 21;
            map = new MapGenerator(3, 7);
            score=0;
            playerX=310;
            repaint();

            
        }
        if(ke.getKeyCode()==KeyEvent.VK_ESCAPE){
            System.exit(0);
        }
     
    }

    public void moveRight() {
        play = true;
        playerX += 20;
    }

    public void moveLeft() {
        play = true;
        playerX -= 20;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        timer.start();
        if(play){
           
            if(new Rectangle(ballPosX, ballPosY, 20, 20).intersects(new Rectangle(playerX, 550, 100, 8))){
                ballDirY=-ballDirY;
            }
         A:
           for (int i = 0; i < map.map.length; i++) {
            for (int j = 0; j < map.map[0].length; j++) {
                if (map.map[i][j] > 0) {
                 int brickX = j * map.brickWidth + 80;
                  int brickY = i * map.brickHeight + 50;
                  int brickWidth = map.brickWidth;
                   int brickHeight = map.brickHeight;
                    Rectangle rect = new Rectangle(brickX, brickY, brickWidth, brickHeight);
                     Rectangle ballRect = new Rectangle(ballPosX, ballPosY, 20, 20);
                        Rectangle brickRect = rect;
                           if (ballRect.intersects(brickRect)) {
                           map.setbricksvalue(0, i, j);
                               totalBricks--;
                                      score += 5;
                             if (ballPosX + 19 <= brickRect.x || ballPosX + 1 >= brickRect.x + brickRect.width) {
                                            ballDirX = -ballDirX;
                                }
                             else {
                             ballDirY = -ballDirY;
    }
                           break A;
  }
 }
}
   }
            ballPosX+=ballDirX;
            ballPosY+=ballDirY;
            if(ballPosX==0){
                ballDirX=-ballDirX;
            }
            if(ballPosY==0){
                ballDirY=-ballDirY;
            }
            if(ballPosX>670){
                ballDirX=-ballDirX;
            }
        }
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent ke) {

    }

    @Override
    public void keyReleased(KeyEvent ke) {

    }

}

