package View;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import controller.Playaudio;

public class Select4Menu {
	Ex1 ex1;
	Image i = new ImageIcon(Kio_Project.class.getResource("../image/selectdrink.png")).getImage();

	
	
	public Select4Menu(Ex1 ex, Chatt ch) {
		//잘 모르겠지만 첫화면을 가져오고
		ex1 = ex;
		//패널 이미지 교체
		MyPanel mp = new MyPanel(i);
	    
		//size는 기존 size 가져오기
		mp.setSize(1642,2842);

		
		//기존 패널에서 setmenu패널로 교체
        ex1.setContentPane(mp);
        mp.setLayout(null);
        
        JButton colabutton = new JButton("콜라");
        colabutton.setFont(new Font("HY견고딕", Font.PLAIN, 50));
        colabutton.setVerticalAlignment(SwingConstants.BOTTOM);
        colabutton.setBounds(111, 849, 641, 1178);
        mp.add(colabutton);
        colabutton.setContentAreaFilled(false);
        colabutton.setBorderPainted(false);
        colabutton.setFocusPainted(false);
        colabutton.addActionListener(new EventListener("ColaButton",ex1));
        
        JButton cidarbutton = new JButton("사이다");
        cidarbutton.setFont(new Font("HY견고딕", Font.PLAIN, 50));
        cidarbutton.setVerticalAlignment(SwingConstants.BOTTOM);
        cidarbutton.addActionListener(new EventListener("CidarButton",ex1));
        cidarbutton.setBounds(887, 849, 641, 1178);
        mp.add(cidarbutton);
        cidarbutton.setContentAreaFilled(false);
        cidarbutton.setBorderPainted(false);
        cidarbutton.setFocusPainted(false);
        
        JLabel label = new JLabel(ch.userSay());
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        label.setFont(new Font("HY견고딕", Font.PLAIN, 44));
        label.setBounds(145, 80, 1344, 126);
        mp.add(label);
        
        JLabel label_1 = new JLabel(ch.kioSay());
        label_1.setHorizontalAlignment(SwingConstants.LEFT);
        label_1.setFont(new Font("HY견고딕", Font.PLAIN, 44));
        label_1.setBounds(159, 336, 1344, 126);
        mp.add(label_1);
		
        
        Image mic = new ImageIcon(Kio_Project.class.getResource("../image/mic.png")).getImage();
		ImageIcon micicon = new ImageIcon();
		micicon.setImage(mic);
        JButton micButton = new JButton("",micicon);
        micButton.setBounds(130, 2300, 400, 400);
        micButton.setContentAreaFilled(false);
        micButton.setBorderPainted(false);
        micButton.setFocusPainted(false);
        micButton.addActionListener(new EventListener("Mic4",ex1));
        mp.add(micButton);
        
	}

}
