package View;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class MyPanel extends JPanel{
    Image i;
    
    public MyPanel(Image i) {
    	this.i = i;
    }
    
	public void paintComponent(Graphics g){
           // super.paintComponent(g);
  
            g.drawImage(i,0,0,getWidth(),getHeight(),this);
      }
    

}
