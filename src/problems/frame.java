/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problems;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

/**
 *
 * @author HP
 */
public class frame extends JFrame implements KeyListener  {
    frame(){
    GamePlay gamePlay = new GamePlay();
        //buttons b =new buttons();
        setLocation(300, 50);
        setBounds(300, 50, 700, 600);
        setTitle("Brick Breaker");
        setResizable(false);
        setVisible(true);
       // setDefaultCloseOperation();        
        add(gamePlay);
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
