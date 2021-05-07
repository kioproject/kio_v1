package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import View.MyPanel;
import controller.Playaudio;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JLabel;


public class HamMenu {
	Image i = new ImageIcon(Kio_Project.class.getResource("../image/hammenu.jpg")).getImage();   
	Ex1 ex1;
	
	public HamMenu(Ex1 ex, Chatt ch) {

		//잘 모르겠지만 첫화면을 가져오고
		ex1 = ex;
		//패널 이미지 교체
		MyPanel mp = new MyPanel(i);
		

		//size는 기존 size 가져오기
		mp.setSize(1642,2842);
		
		//기존 패널에서 setmenu패널로 교체
        ex1.setContentPane(mp);
        mp.setLayout(null);
        
        JButton Single1Bt = new JButton("빅맥");
        Single1Bt.setFont(new Font("HY견고딕", Font.PLAIN, 44));
        Single1Bt.setVerticalAlignment(SwingConstants.BOTTOM);
        Single1Bt.setBounds(161, 396, 603, 700);
        mp.add(Single1Bt);
        Single1Bt.addActionListener(new EventListener("Single1Button",ex1));
        Single1Bt.setContentAreaFilled(false);
        Single1Bt.setBorderPainted(false);
        Single1Bt.setFocusPainted(false);
        
      
        
        JButton Single2Bt = new JButton("새우 버거");
        Single2Bt.setVerticalAlignment(SwingConstants.BOTTOM);
        Single2Bt.setFont(new Font("HY견고딕", Font.PLAIN, 44));
        Single2Bt.setBounds(889, 396, 603, 700);
        mp.add(Single2Bt);
        Single2Bt.addActionListener(new EventListener("Single2Button",ex1));
        Single2Bt.setContentAreaFilled(false);
        Single2Bt.setBorderPainted(false);
        Single2Bt.setFocusPainted(false);
        
      
        JButton Single3Bt = new JButton("불고기 버거");
        Single3Bt.setVerticalAlignment(SwingConstants.BOTTOM);
        Single3Bt.setFont(new Font("HY견고딕", Font.PLAIN, 44));
        Single3Bt.setBounds(161, 1309, 603, 700);
        mp.add(Single3Bt);
        Single3Bt.addActionListener(new EventListener("Single3Button",ex1));
        Single3Bt.setContentAreaFilled(false);
        Single3Bt.setBorderPainted(false);
        Single3Bt.setFocusPainted(false);
        
        //키오
        JLabel label = new JLabel(ch.kioSay());
        label.setHorizontalAlignment(SwingConstants.LEFT);
        label.setFont(new Font("HY견고딕", Font.PLAIN, 38));
        label.setBounds(161, 2579, 1212, 123);
        mp.add(label);
        
        //사용자
        JLabel label_1 = new JLabel(ch.userSay());
        label_1.setHorizontalAlignment(SwingConstants.RIGHT);
        label_1.setFont(new Font("HY견고딕", Font.PLAIN, 44));
        label_1.setBounds(138, 2321, 1354, 123);
        mp.add(label_1);
        
        
      //mic5
        Image mic = new ImageIcon(Kio_Project.class.getResource("../image/mic.png")).getImage();
		ImageIcon micicon = new ImageIcon();
		micicon.setImage(mic);
        JButton micButton = new JButton("",new ImageIcon("C:\\Users\\server\\eclipse-workspace\\kio_v1.1\\src\\main\\java\\image\\mic.png"));
        micButton.setBounds(1007, 1467, 310, 310);
        micButton.setContentAreaFilled(false);
        micButton.setBorderPainted(false);
        micButton.setFocusPainted(false);
       
        micButton.addActionListener(new EventListener("Mic8",ex1));
        mp.add(micButton);
        
        JButton btnNewButton = new JButton("세트");
        btnNewButton.setFont(new Font("HY견고딕", Font.BOLD, 44));
        btnNewButton.setBounds(216, 104, 315, 154);
        btnNewButton.setContentAreaFilled(false);
        btnNewButton.setBorderPainted(false);
        btnNewButton.setFocusPainted(false);
        btnNewButton.addActionListener(new EventListener("SetButton",ex1));
        mp.add(btnNewButton);
        
        JButton button = new JButton("단품");
        button.setFont(new Font("HY견고딕", Font.BOLD, 44));
        button.setBounds(540, 104, 315, 154);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.addActionListener(new EventListener("HamButton",ex1));
        mp.add(button);
      
	}
}
