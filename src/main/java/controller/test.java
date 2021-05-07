package controller;
import java.awt.MediaTracker;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

import com.google.cloud.dialogflow.v2.QueryResult;
import controller.DetectIntentTexts;

public class test {
	


	public static void main(String[] args) throws Exception {
		  
	    ArrayList<String> texts = new ArrayList<>();
	    String projectId = "capstoneproject-ycqucq";
	    String sessionId = UUID.randomUUID().toString();
	    String languageCode = "ko";
	    Scanner scan = new Scanner(System.in);
	    String e = "";
	    
	    //api 불러오기
	    DetectIntentTexts a = new DetectIntentTexts();
	    
	    String an = null;
	    String qu = null;
	    
	    try {
	    	while(true) {
	        	while(!e.equals("end")) {
	            	texts.clear();
	            	System.out.print("다음 문장을 입력하세요:");
	            	e = a.streamingMicRecognize();
	            	System.out.println(e);
	            	//e = scan.nextLine(); //타이핑
	            	texts.add(e);
	            	QueryResult b = a.detectIntentTexts(projectId, texts, sessionId, languageCode);
	                an = b.getFulfillmentText();
	            	qu = b.getQueryText();
	            	System.out.println("챗봇:"+an);
	            	System.out.println("사용자:"+qu);
	            }
	        	texts.clear();
	        	System.out.println("주문 완료 다음 손님 입장");
	        	System.out.print("다음 문장을 입력하세요:");
	        	e = scan.nextLine();
	        	texts.add(e);
	        	sessionId = UUID.randomUUID().toString();
	        } 
	    }
	    catch(Exception e1){
	    	System.out.println(e1);
	    }
	  }
	
	
}
