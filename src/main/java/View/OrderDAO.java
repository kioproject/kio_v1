package View;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderDAO {
	OrderDTO dto = new OrderDTO();
	
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/kiosk?serverTimezone=UTC&useSSL=false";

	private static final String USER = "root"; // DB ID
	private static final String PASS = "1111"; // DB 패스워드


	/** DB연결 메소드 */
	public static Connection getConn() {
		Connection con = null;

		try {
			Class.forName(DRIVER); // 1. 드라이버 로딩
			con = DriverManager.getConnection(URL, USER, PASS); // 2. 드라이버 연결
			System.out.println("연결 성공");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}
		
	
	/*
	세트인지 단품인지 인식해서 가격을 가져와서 주문정보를 저장해주는 메소드
	String inputstream: 다이어플로우에서 리턴해주는 stream
	String paymentInfo: 결제방식(스트링이든 int든 넘겨주는 걸로 받아서)
	*/
	public void setOrderList(String inputStream) throws SQLException {
		
		
		Connection con = getConn();
		String sql = "";
		PreparedStatement pstmt;

		
		String burger = "";
		String sidemenu = ""; // 사이드메뉴가 공백이면 알아서 단품으로 인식한다. 채워져 있음 세트로 인식
		String drink = "";
		String payment = ""; // 결제방법 현금/카드
		String packing = ""; // 매장/포장
		
		
		if(inputStream.matches(".*빅맥.*") == true) {
			burger = "빅맥";
		} else if(inputStream.matches(".*새우버거.*") == true) {
			burger = "새우버거";
		} else if(inputStream.matches(".*불고기버거.*") == true) {
			burger = "불고기버거";
		}
		
		if(inputStream.matches(".*감자튀김.*") == true) {
			sidemenu = "감자튀김";
		} else if(inputStream.matches(".*치즈스틱.*") == true) {
			sidemenu = "치즈스틱";
		}
		
		if(inputStream.matches(".*콜라.*") == true) {
			drink = "콜라";
		} else if(inputStream.matches(".*사이다.*") == true) {
			drink = "사이다";
		}
		
		if(inputStream.matches(".*매장.*") == true) {
			packing = "매장";
		} else if(inputStream.matches(".*포장.*") == true) {
			packing = "포장";
		}
		
		if(inputStream.matches(".*카드.*") == true) {
			payment = "카드";
		} else if(inputStream.matches(".*현금.*") == true) {
			payment = "현금";
		}


		
		int price = 0; // DB에서 불러올 가격
		
		dto.setBurger(burger);
		dto.setSidemenu(sidemenu);
		dto.setDrink(drink);
		dto.setPayment(payment);
		dto.setPacking(packing);
		dto.setPrice(price);
		
		
		// 제품의 가격을 읽어옴
		sql = "select price from menu_price where menu = ?";
		pstmt = con.prepareStatement(sql);
		if (sidemenu.equals("")) {
			// 단품일 경우(사이드 메뉴가 없는 경우)
			pstmt.setString(1, dto.getBurger()); // 가격을 검색할 메뉴 설정
		} else {
			// 세트일 경우(사이드 메뉴가 있는 경우)
			pstmt.setString(1, dto.getBurger() + "세트"); // 가격을 검색할 메뉴 설정
		}

		ResultSet rs = pstmt.executeQuery(); // 쿼리 날림
		rs.next();
		dto.setPrice(rs.getInt("price"));

		
		
		
		// 결제 리스트에 추가
		sql = "INSERT INTO order_list";
		if (sidemenu.equals("")) { // 단품일 경우
			sql += "(order_time,burger,payment,packing,price) VALUES(?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getCurTime());
			pstmt.setString(2, dto.getBurger());
			pstmt.setString(3, dto.getPayment());
			pstmt.setString(4, dto.getPacking());
			pstmt.setInt(5, dto.getPrice());
		} else { // 세트일 경우
			sql += "(order_time,burger,sidemenu,drink,payment,packing,price) VALUES(?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getCurTime());
			pstmt.setString(2, dto.getBurger());
			pstmt.setString(3, dto.getSidemenu());
			pstmt.setString(4, dto.getDrink());
			pstmt.setString(5, dto.getPayment());
			pstmt.setString(6, dto.getPacking());
			pstmt.setInt(7, dto.getPrice());
		}
		
				
		int r = pstmt.executeUpdate();
		
		if(r > 0) {
			System.out.println("주문내역 추가 성공");
		}
		else {
			System.out.println("주문내역 추가 실패");
		}
		con.close();
	}

	
}
