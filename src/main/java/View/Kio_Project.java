package View;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import View.EventListener;

class Ex1 extends JFrame{
	
    Image i = new ImageIcon(Ex1.class.getResource("../image/FirstPage.jpg")).getImage();
    private Image bt = new ImageIcon(Ex1.class.getResource("../image/button.png")).getImage();
    ImageIcon order = new ImageIcon();
    JButton button = new JButton(" ",order);
    
    Ex1(){
        this.setTitle("Kio_Project");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        MyPanel panel = new MyPanel(i);
      
        panel.setLayout(new BorderLayout());
        
        order.setImage(bt);
       
        button.setContentAreaFilled(false);
        button.setBorderPainted(true);
        button.setFocusPainted(false);
        
       
        panel.add(button,BorderLayout.CENTER);
        button.addActionListener(new EventListener("Start", this));
        
        
        this.add(panel);
        this.setSize(400,400);
        this.setVisible(true);
    }
    
    public Container view() {
    	return this.getContentPane();
    }
    


}

public class Kio_Project {
	Ex1 ex1;
	public void StartView(Ex1 ex) {
		ex1 = ex;
	}
	public Ex1 StartView() {
		return ex1;
	}

}




