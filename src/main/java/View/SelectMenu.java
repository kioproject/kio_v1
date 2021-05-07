package View;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import com.google.appengine.api.search.Query;
import com.google.cloud.dialogflow.v2.QueryResult;

import controller.DetectIntentTexts;
import controller.Playaudio;

import java.awt.Color;

public class SelectMenu {
	Ex1 ex1;
	Image i = new ImageIcon(Kio_Project.class.getResource("../image/select1.png")).getImage();
	QueryResult text;

	
	public SelectMenu(Ex1 ex,Chatt ch) {
		// TODO Auto-generated constructor stub
		//잘 모르겠지만 첫화면을 가져오고
		ex1 = ex;
		//패널 이미지 교체
		MyPanel mp = new MyPanel(i);

		//size는 기존 size 가져오기
		mp.setSize(1642,2842);
		
		//기존 패널에서 setmenu패널로 교체
        ex1.setContentPane(mp);
        mp.setLayout(null);
        
        JButton mbutton = new JButton("매장에서 식사");
        mbutton.setVerticalAlignment(SwingConstants.BOTTOM);
        mbutton.setFont(new Font("HY견고딕", Font.PLAIN, 50));
        mbutton.setBounds(111, 849, 641, 1178);
        mp.add(mbutton);
        mbutton.setContentAreaFilled(false);
        mbutton.setBorderPainted(false);
        mbutton.setFocusPainted(false);
        
      
        mbutton.addActionListener(new EventListener("mButton",ex1));
        
        JButton pbutton = new JButton("포장");
        pbutton.setFont(new Font("HY견고딕", Font.PLAIN, 50));
        pbutton.setVerticalAlignment(SwingConstants.BOTTOM);
        pbutton.addActionListener(new EventListener("pButton",ex1));
        pbutton.setContentAreaFilled(false);
        pbutton.setBorderPainted(false);
        pbutton.setFocusPainted(false);
        
      
        pbutton.setBounds(892, 849, 641, 1178);
        mp.add(pbutton);
        
        JLabel lblNewLabel = new JLabel(ch.kioSay());
        lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel.setFont(new Font("HY견고딕", Font.PLAIN,35));
        lblNewLabel.setBounds(159, 336, 1344, 126);
        mp.add(lblNewLabel);
        
        JLabel label = new JLabel(ch.userSay());
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        label.setFont(new Font("HY견고딕", Font.PLAIN, 44));
        label.setBounds(145, 80, 1344, 126);
        mp.add(label);
       
        
        Image mic = new ImageIcon(Kio_Project.class.getResource("../image/mic.png")).getImage();
		ImageIcon micicon = new ImageIcon();
		micicon.setImage(mic);
        JButton micButton = new JButton("",micicon);
        micButton.setBounds(130, 2300, 400, 400);
        micButton.setContentAreaFilled(false);
        micButton.setBorderPainted(false);
        micButton.setFocusPainted(false);
        micButton.addActionListener(new EventListener("Mic1",ex1));
        mp.add(micButton);
       
	}

	

	
}
