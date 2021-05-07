package View;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderDTO {
	
	String burger;
	String sidemenu;
	String drink;
	String payment; // ������� ����/ī��
	String packing; // ����/����
	int price; // �� �����ݾ�
	
	SimpleDateFormat form = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
	Date time = new Date();
	String cur_time = form.format(time);
	
	public String getBurger() { return burger; }
	public void setBurger(String burger) { this.burger = burger; }
	
	public String getSidemenu() { return sidemenu; }
	public void setSidemenu(String sidemenu) { this.sidemenu = sidemenu; }
	
	public String getDrink() { return drink; }
	public void setDrink(String drink) { this.drink = drink; }
			
	public String getPayment() { return payment; }
	public void setPayment(String payment) { this.payment = payment; }
	
	public String getPacking() { return packing; }
	public void setPacking(String packing) { this.packing = packing; }
	
	public int getPrice() { return price; }
	public void setPrice(int price) { this.price = price; }
	
	public String getCurTime() { return cur_time; }
	public void setCurTime(String cur_time) { this.cur_time = cur_time; }
	
}

