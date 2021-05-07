package View;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import controller.Playaudio;
import javax.swing.SwingConstants;
import java.awt.Font;

public class SelectPayMenu {
	Ex1 ex1;
	Image i = new ImageIcon(Kio_Project.class.getResource("../image/payselect.png")).getImage();
	public SelectPayMenu(Ex1 ex,Chatt ch) {
		//잘 모르겠지만 첫화면을 가져오고
		ex1 = ex;
		//패널 이미지 교체
		MyPanel mp = new MyPanel(i);
	    
		//size는 기존 size 가져오기
		mp.setSize(1642,2842);
		
		//기존 패널에서 setmenu패널로 교체
        ex1.setContentPane(mp);
        mp.setLayout(null);
        
        JButton Cardbutton = new JButton("현금으로 결제");
        Cardbutton.setFont(new Font("HY견고딕", Font.PLAIN, 44));
        Cardbutton.setVerticalAlignment(SwingConstants.BOTTOM);
        Cardbutton.setBounds(111, 849, 641, 1178);
        Cardbutton.setContentAreaFilled(false);
        Cardbutton.setBorderPainted(false);
        Cardbutton.setFocusPainted(false);
        mp.add(Cardbutton);
        
        Cardbutton.addActionListener(new EventListener("CardButton",ex1));
        
        JButton Moneybutton = new JButton("카드로 결제");
        Moneybutton.setFont(new Font("HY견고딕", Font.PLAIN, 44));
        Moneybutton.setVerticalAlignment(SwingConstants.BOTTOM);
        Moneybutton.addActionListener(new EventListener("MoneyButton",ex1));
        Moneybutton.setContentAreaFilled(false);
        Moneybutton.setBorderPainted(false);
        Moneybutton.setFocusPainted(false);
        Moneybutton.setBounds(892, 849, 641, 1178);
        mp.add(Moneybutton);
		
        
        JLabel label = new JLabel(ch.userSay());
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        label.setFont(new Font("HY견고딕", Font.PLAIN, 44));
        label.setBounds(145, 80, 1344, 126);
        mp.add(label);
        
        JLabel label_1 = new JLabel(ch.kioSay());
        label_1.setHorizontalAlignment(SwingConstants.LEFT);
        label_1.setFont(new Font("HY견고딕", Font.PLAIN, 44));
        label_1.setBounds(145, 336, 1344, 126);
        mp.add(label_1);
        
        Image mic = new ImageIcon(Kio_Project.class.getResource("../image/mic.png")).getImage();
		ImageIcon micicon = new ImageIcon();
		micicon.setImage(mic);
        JButton micButton = new JButton("",micicon);
        micButton.setBounds(130, 2300, 400, 400);
        micButton.setContentAreaFilled(false);
        micButton.setBorderPainted(false);
        micButton.setFocusPainted(false);
        micButton.addActionListener(new EventListener("Mic6",ex1));
        mp.add(micButton);
        
        
	}

}
