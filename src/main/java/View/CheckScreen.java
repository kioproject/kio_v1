package View;

import java.awt.Image;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import controller.Playaudio;
import controller.ResultMenu;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Color;

public class CheckScreen {
	Ex1 ex1;
	Image i = new ImageIcon(Kio_Project.class.getResource("../image/Basic.png")).getImage();
	Image bt1 = new ImageIcon(Kio_Project.class.getResource("../image/Yesbutton.png")).getImage();
	ImageIcon icon1 = new ImageIcon();
	Image bt2 = new ImageIcon(Kio_Project.class.getResource("../image/Nobutton.png")).getImage();
	ImageIcon icon2 = new ImageIcon();
	
	public CheckScreen(Ex1 ex, Chatt ch) {
		//잘 모르겠지만 첫화면을 가져오고
		ex1 = ex;
		//패널 이미지 교체
		MyPanel mp = new MyPanel(i);
		ResultMenu res = new ResultMenu(ch);
		icon1.setImage(bt1);
		icon2.setImage(bt2);
		//size는 기존 size 가져오기
		mp.setSize(1642,2842);
		
		//기존 패널에서 setmenu패널로 교체
        ex1.setContentPane(mp);
        mp.setLayout(null);
        
        JButton OKButton = new JButton("",icon1);
        OKButton.setFont(new Font("HY견고딕", Font.PLAIN, 44));
        OKButton.setBounds(163, 2007, 442, 180);
        OKButton.setContentAreaFilled(false);
        OKButton.setBorderPainted(false);
        OKButton.setFocusPainted(false);
        
        mp.add(OKButton);
        OKButton.addActionListener(new EventListener("OKButton",ex1));
        
        JButton NObutton = new JButton("",icon2);
        NObutton.setFont(new Font("HY견고딕", Font.PLAIN, 44));
        NObutton.setBounds(664, 2007, 442, 180);
        NObutton.setContentAreaFilled(false);
        NObutton.setBorderPainted(false);
        NObutton.setFocusPainted(false);
        mp.add(NObutton);
        
        JLabel lblNewLabel = new JLabel(ch.kioSay());
        lblNewLabel.setFont(new Font("HY견고딕", Font.PLAIN, 38));
        lblNewLabel.setBounds(161, 2577, 1212, 123);
        mp.add(lblNewLabel);
        
        JLabel label = new JLabel(ch.userSay());
        label.setFont(new Font("HY견고딕", Font.PLAIN, 44));
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        label.setBounds(109, 2319, 1354, 123);
        mp.add(label);
        NObutton.addActionListener(new EventListener("NoButton",ex1));
        
        Hashtable<Integer,String> ht = res.label();
        
        
        
        Vector v = new Vector(ht.keySet());
        Collections.sort(v);
        Enumeration en= v.elements();
        
        JPanel resPanel = new JPanel();
        resPanel.setSize(1275, 527);
        resPanel.setLocation(188, 424);
       
        
        Image photo = new ImageIcon(Kio_Project.class.getResource(res.photo())).getImage();
        ImageIcon icon3 = new ImageIcon();
        
        
        icon3.setImage(photo);
       
        JPanel lPanel = new JPanel();
        lPanel.setBackground(Color.WHITE);
        
        lPanel.setLayout(new GridLayout(10,1));
        int i = 0;
        
        JLabel[] reslabel = new JLabel[10];
        int num = 0;
       
        while(en.hasMoreElements()) {
        	
        	Integer str = (Integer)en.nextElement();
        	reslabel[i] = new JLabel(ht.get(str));
        	reslabel[i].setFont(new Font("HY견고딕", Font.PLAIN, 44));
        	reslabel[i].setBounds(0, num, 300, 400);
        	lPanel.add(reslabel[i]);
        	num += 80;
        	i++;
        }
        
        lPanel.setBounds(602,436,875,527);
       
        
        mp.add(lPanel);
        JButton PButton = new JButton("",icon3);
        PButton.setBounds(96, 464, 500, 467);
        PButton.setContentAreaFilled(false);
        PButton.setBorderPainted(false);
        PButton.setFocusPainted(false);
        mp.add(PButton);
        
        
        //mic5
        Image mic = new ImageIcon(Kio_Project.class.getResource("../image/mic.png")).getImage();
		ImageIcon micicon = new ImageIcon();
		micicon.setImage(mic);
        JButton micButton = new JButton("",micicon);
       
        micButton.setContentAreaFilled(false);
        micButton.setBorderPainted(false);
        micButton.setFocusPainted(false);
        micButton.setBounds(1146, 1900, 310, 310);
        micButton.addActionListener(new EventListener("Mic5",ex1));
        mp.add(micButton);
        
        
       System.out.println(res.photo());
     
     
       
		
	}
}

