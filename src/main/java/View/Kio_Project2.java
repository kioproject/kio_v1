package View;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Kio_Project2 {
	Ex1 ex1;
	Image i = new ImageIcon(Ex1.class.getResource("../image/FirstPage.jpg")).getImage();
	

	Kio_Project2(Ex1 ex,Chatt ch) {
		// 잘 모르겠지만 첫화면을 가져오고
		ex1 = ex;
		MyPanel panel = new MyPanel(i);
		ex1.setContentPane(panel);
		Image bt = new ImageIcon(Ex1.class.getResource("../image/button.png")).getImage();
		ImageIcon order = new ImageIcon();
		order.setImage(bt);
		JButton button = new JButton(" ", order);
		button.setSize(781, 319);
		button.setLocation(459, 1223);
		panel.setSize(1642,2842);
		
		
		panel.setLayout(null);

		
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setFocusPainted(false);

		panel.add(button, BorderLayout.CENTER);
		button.addActionListener(new EventListener("Start", ex1));

		ch.Clear();
		
	}

}
