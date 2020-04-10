/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problems;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import sun.audio.ContinuousAudioDataStream;
/**
 *
 * @author HP
 */
public class  Problems extends JFrame implements ActionListener {
    JButton b1=new JButton("Start");
    JButton b2=new JButton("How to PLay");
    JPanel p1 = new JPanel();
    BufferedImage bi;
    public  void  myframe(){
        JLabel l=new JLabel();
        l.setIcon(new ImageIcon("E:\\m7mood\\a.jpg"));
        setSize(700,600);
        setLocation(300, 50);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        b1.setBounds(280, 195, 200, 50);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b2.setBounds(280, 250, 200, 50);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        add(l);
        l.add(b1);
        l.add(b2);
        //add(b1);
        b1.addActionListener(this);
        b2.addActionListener(this);
        //setLayout(new CardLayout(10, 10));  
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        g.drawImage(bi, 0, 0, getWidth(),getHeight(),null);
    }
      public static void playSound() {
    try {
            InputStream iAudio;
            iAudio =new FileInputStream(new File("C:\\Users\\HP\\Downloads\\Music\\nnn.wav"));
            AudioStream iMusic =new AudioStream(iAudio);
       //     ContinuousAudioDataStream sound =new ContinuousAudioDataStream(iAudio);
            AudioPlayer.player.start(iMusic);
            
        } catch (FileNotFoundException ex) {
            System.out.println("error");
           // Logger.getLogger(Piano_d.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("error");
           // Logger.getLogger(Piano_d.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    public static void main(String[] args) {
        Problems p=new Problems();
        p.myframe();
        playSound();
        //Textarea t=new Textarea();

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==b1){
            frame f=new frame();
        }
        if(ae.getSource()==b2){
            JOptionPane.showMessageDialog(null, "USE THE RIGHT AND LEFT BUTTONS TO MOVE THE PADDLE \n OR \n "
                    + "PRESS ESCAPE TO CLOSE THE GAME");
         }
    }
    
    
}
