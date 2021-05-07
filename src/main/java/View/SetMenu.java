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
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;


public class SetMenu {
	Image i = new ImageIcon(Kio_Project.class.getResource("../image/setmenu.jpg")).getImage();
	Ex1 ex1;
	
	public SetMenu(Ex1 ex, Chatt ch) {

		//잘 모르겠지만 첫화면을 가져오고
		ex1 = ex;
		//패널 이미지 교체
		MyPanel mp = new MyPanel(i);
  
	    
		//size는 기존 size 가져오기
		mp.setSize(1642,2842);
		
		//기존 패널에서 setmenu패널로 교체
        ex1.setContentPane(mp);
        mp.setLayout(null);
        
        
        
        JButton Set1Bt = new JButton("빅맥세트 ");
        Set1Bt.setFont(new Font("HY견고딕", Font.PLAIN, 44));
        Set1Bt.setVerticalAlignment(SwingConstants.BOTTOM);
        Set1Bt.setBounds(122, 337, 685, 747);
        
        mp.add(Set1Bt);
        Set1Bt.addActionListener(new EventListener("Set1Button",ex1));
        Set1Bt.setContentAreaFilled(false);
        Set1Bt.setBorderPainted(false);
        Set1Bt.setFocusPainted(false);
        
      
        
        JButton Set2Bt = new JButton("새우버거 세트");
        Set2Bt.setFont(new Font("HY견고딕", Font.PLAIN, 40));
        Set2Bt.setVerticalAlignment(SwingConstants.BOTTOM);
        Set2Bt.setBounds(874, 337, 685, 747);
        mp.add(Set2Bt);
        Set2Bt.addActionListener(new EventListener("Set2Button",ex1));
        Set2Bt.setContentAreaFilled(false);
        Set2Bt.setBorderPainted(false);
        Set2Bt.setFocusPainted(false);
        
        
        
        JButton Set3Bt = new JButton("불고기 버거 세트 ");
        Set3Bt.setFont(new Font("HY견고딕", Font.PLAIN, 40));
        Set3Bt.setVerticalAlignment(SwingConstants.BOTTOM);
        Set3Bt.setBounds(122, 1331, 685, 747);
        mp.add(Set3Bt);
        Set3Bt.addActionListener(new EventListener("Set3Button",ex1));
        Set3Bt.setContentAreaFilled(false);
        Set3Bt.setBorderPainted(false);
        Set3Bt.setFocusPainted(false);
        
        

        
        JLabel lblNewLabel = new JLabel(ch.kioSay());
        lblNewLabel.setFont(new Font("HY견고딕", Font.PLAIN, 38));
        lblNewLabel.setBounds(158, 2588, 1212, 123);
        mp.add(lblNewLabel);
        
        JLabel label = new JLabel(ch.userSay());
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        label.setFont(new Font("HY견고딕", Font.PLAIN, 44));
        label.setBounds(115, 2324, 1354, 123);
        mp.add(label);
        
      //mic5
        Image mic = new ImageIcon(Kio_Project.class.getResource("../image/mic.png")).getImage();
		ImageIcon micicon = new ImageIcon();
		micicon.setImage(mic);
        JButton micButton = new JButton("",micicon);
        
        micButton.setContentAreaFilled(false);
        micButton.setBorderPainted(false);
        micButton.setFocusPainted(false);
        micButton.setBounds(1028, 1488, 310, 310);
        micButton.addActionListener(new EventListener("Mic7",ex1));
        mp.add(micButton);
        
        JButton btnNewButton = new JButton("세트");
        btnNewButton.setFont(new Font("HY견고딕", Font.BOLD, 44));
        btnNewButton.setBounds(217, 107, 310, 155);
        btnNewButton.setContentAreaFilled(false);
        btnNewButton.setBorderPainted(false);
        btnNewButton.setFocusPainted(false);
        btnNewButton.addActionListener(new EventListener("SetButton",ex1));
        mp.add(btnNewButton);
        
        JButton button = new JButton("단품");
        button.setFont(new Font("HY견고딕", Font.BOLD, 44));
        button.setBounds(537, 107, 310, 155);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.addActionListener(new EventListener("HamButton",ex1));
        mp.add(button);
        
        
	}
}
