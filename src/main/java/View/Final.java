package View;

import java.awt.Image;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import controller.ResultMenu;

public class Final {
	 Image i = new ImageIcon(Ex1.class.getResource("../image/Final.jpg")).getImage();
	 Ex1 ex1;
	 public Final(Ex1 ex, Chatt ch) throws SQLException {
		 ex1 = ex;
		 MyPanel mp = new MyPanel(i);
		 
		 mp.setSize(1642,2842);
		 ex1.setContentPane(mp);
		 ResultMenu res = new ResultMenu(ch);
		 
		 System.out.println(res.sendTODB());
		 
		 OrderDAO dao = new OrderDAO();
		 dao.setOrderList(res.sendTODB());
		 
		 ch.Clear(); 
		 
		
	
		 
	 }
}
