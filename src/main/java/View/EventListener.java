package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.UUID;

import com.google.cloud.dialogflow.v2.QueryResult;

import View.SetMenu;
import controller.DetectIntentTexts;
import controller.Playaudio;


public class EventListener implements ActionListener {

	public String str;
	public Ex1 ex;
	
	String projectId = "capstoneproject-ycqucq";
	//   String sessionId = UUID.randomUUID().toString();
		String sessionId = "101";
		String languageCode = "ko";
		public ArrayList<String> texts = new ArrayList<>();
	
	public EventListener(String str, Ex1 ex) {
		this.str = str;
		this.ex = ex;
	}
	public DetectIntentTexts a = new DetectIntentTexts();
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
	    // TODO Auto-generated method stub
	    if(str.equals("Start")) {
	    	try {
				new SetMenu(ex, (new Listener("안녕").ch));
	    	} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	      }
	    
	    //매장인지 포장인지 말하는 부분
	    if(str.equals("Mic1")) {
	    	try {
	    		String mic = "ddd";
	    		mic = a.streamingMicRecognize();
				this.str = mic;
				System.out.println(str);
				
				Listener li = new Listener(1, str);
				
	    		if(li.ch.kioSay().matches(".*카드.*")) {
					System.out.println("Mic1 OK");
					new SelectPayMenu(ex, li.ch);
					
				}else{
					System.out.println("Mic1 error");
					new SelectMenu(ex, li.ch);
				}
	    	} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    }
	    

	    
	    //세트이면서 사이드를 말하는 부분
	    if(str.equals("Mic3")) {
	    	try {
	    		String mic = "ddd";
	    		mic = a.streamingMicRecognize();
				this.str = mic;
				System.out.println(str);
				
				Listener li = new Listener(1, str);
				
	    		//if(li.ch.kioSay().equals("사이드 메뉴는 감자튀김으로 하시겠습니까? 치즈 스틱으로 하시겠습니까?")) {
				if(li.ch.kioSay().equals("음료는 콜라와 사이다중 어떤걸로 하시겠습니까?")) {
					System.out.println("mic3");
					new Select4Menu(ex, li.ch);//콜라 사이다
					
				}
				//음료를 미리 말해둔 경우
				else if(li.ch.kioSay().matches(".*맞나요.*")) {
					System.out.println("mic3");
					new CheckScreen(ex, li.ch);
					
				}
	    		else{
					System.out.println("mic3error");
					new Select3Menu(ex, li.ch);
				}
	    	} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    }
	    
	    //세트이면서 음료 말하는 부분
	    if(str.equals("Mic4")) {
	    	try {
	    		String mic = "ddd";
	    		mic = a.streamingMicRecognize();
				this.str = mic;
				System.out.println(str);
				
				Listener li = new Listener(1, str);
				
	    		if(li.ch.kioSay().matches(".*맞나요 ?.*")) {
					System.out.println("mic4");
					new CheckScreen(ex, li.ch);//콜라 사이다
					
				}
	    		else{
					System.out.println("mic4error");
					new Select4Menu(ex, li.ch);
				}
	    	} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    }
	    
	    //checkscreen에서 확인인지 취소인지 말하는 부분
	    if(str.equals("Mic5")) {
	    	try {
	    		String mic = "ddd";
	    		mic = a.streamingMicRecognize();
				this.str = mic;
				System.out.println(str);
				
				Listener li = new Listener(2, str);
				
				
	    		if(li.ch.kioSay().matches(".*매장.*")) {
					System.out.println("mic5");
					new SelectMenu(ex, li.ch);//콜라 사이다
					
				}
	    		else if(li.ch.kioSay().matches(".*안녕하세요.*")) {
					System.out.println("mic5 cancel");
					new Kio_Project2(ex,li.ch);
					
				}
	    		else{
	    			if(li.ch.userSay().matches(".*세트.*")|| li.ch.userSay().matches(".*배트.*")) {
	    				System.out.println("셑셑");
	    				Iterator<String> it = li.ch.user.iterator();
	    				String input = "";
	    				while(it.hasNext()) {
	    					String str = it.next();
	    					System.out.println(str);
	    					if(str.matches(".*불고기.*")) {
	    						input = "불고기버거 세트";
	    						System.out.println(input);
	    						new Select3Menu(ex,new Listener(input).ch);
	    						break;
	    					}
	    					else if(str.matches(".*새우.*")) {
	    						input = "새우버거 세트";
	    						System.out.println(input);
	    						new Select3Menu(ex,new Listener(input).ch);
	    						break;
	    					}
	    					else if(str.matches(".*빅맥.*")) {
	    						input = "빅맥 세트";
	    						System.out.println(input);
	    						new Select3Menu(ex,new Listener(input).ch);
	    						break;
	    					}
	    				}
	    				
	    			}
	    			else if(li.ch.userSay().matches(".*단품.*")) {
	    				System.out.println("단단");
	    				Iterator<String> it = li.ch.user.iterator();
	    				String input = "";
	    				while(it.hasNext()) {
	    					String str = it.next();
	    					System.out.println(str);
	    					if(str.matches(".*불고기.*")) {
	    						input = "불고기버거";
	    						System.out.println(input);
	    						new CheckScreen(ex,new Listener(input).ch);
	    						break;
	    					}
	    					else if(str.matches(".*새우.*")) {
	    						input = "새우버거";
	    						System.out.println(input);
	    						new CheckScreen(ex,new Listener(input).ch);
	    						break;
	    					}
	    					else if(str.matches(".*빅맥.*")) {
	    						input = "빅맥";
	    						System.out.println(input);
	    						new CheckScreen(ex,new Listener(input).ch);
	    						break;
	    					}
	    				}
	    				
	    			}
					
	    			else{
	    				new CheckScreen(ex, li.ch);
	    			}
				}
	    	} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    }
	    
	    //카드인지 현금인지 확인
	    if(str.equals("Mic6")) {
	    	try {
	    		String mic = "ddd";
	    		mic = a.streamingMicRecognize();
				this.str = mic;
				System.out.println(str);
				
				Listener li = new Listener(1, str);
				
	    		if(li.ch.kioSay().matches(".*준비.*")) {
					System.out.println("mic6");
					new Final(ex, li.ch);//콜라 사이다
					sleep slp = new sleep(ex);
					slp.run();
					
				}
	    		else{
					System.out.println("mic6error");
					new SelectPayMenu(ex, li.ch);
				}
	    	} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    }
	    
	    //세트 햄버거 종류 말하는 부분
	    if(str.equals("Mic7")) {
	    	try {
	    		String mic = "ddd";
	    		mic = a.streamingMicRecognize();
				this.str = mic;
				System.out.println(str);
				
				Listener li = new Listener(1, str);
				
	    		if(li.ch.kioSay().equals("사이드는 감자튀김과 치즈스틱 중 어떤걸로 하시겠습니까?")) {
					System.out.println("mic7");
					new Select3Menu(ex, li.ch);
					
				}
	    		else if(li.ch.kioSay().equals("음료는 콜라와 사이다중 어떤걸로 하시겠습니까?")) {
					System.out.println("mic7 drink");
					new Select4Menu(ex, li.ch);
					
				}
	    		else if(li.ch.kioSay().matches(".*맞나요.*")) {
					System.out.println("mic7 drink");
					new CheckScreen(ex, li.ch);
				}
	    		else if(li.ch.kioSay().matches(".*맞으신가요.*")) {
					System.out.println("mic7 단품");
					new CheckScreen(ex, li.ch);//콜라 사이다
					
				}
	    		else{
					System.out.println("mic7error");
					new SetMenu(ex, li.ch);
				}
	    	} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    }
	    
	    //단품 햄버거 종류 말하는 부분
	    if(str.equals("Mic8")) {
	    	try {
	    		String mic = "ddd";
	    		mic = a.streamingMicRecognize();
				this.str = mic;
				System.out.println(str);
				
				Listener li = new Listener(1, str);
				
	    		if(li.ch.kioSay().matches(".*맞으신가요.*")) {
					System.out.println("mic8");
					
					new CheckScreen(ex, li.ch);//콜라 사이다
					
				}
	    		else if(li.ch.kioSay().equals("사이드는 감자튀김과 치즈스틱 중 어떤걸로 하시겠습니까?")) {
					System.out.println("mic8에서 세트메뉴 말할경우");
					new Select3Menu(ex, li.ch);
					
				}
	    		else if(li.ch.kioSay().equals("음료는 콜라와 사이다중 어떤걸로 하시겠습니까?")) {
					System.out.println("mic8 drink");
					new Select4Menu(ex, li.ch);
					
				}
	    		else if(li.ch.kioSay().matches(".*맞나요.*")) {
					System.out.println("mic8 check");
					new CheckScreen(ex, li.ch);
				}
	    		else{
					System.out.println("mic8error");
					new HamMenu(ex, li.ch);
				}
	    	} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    }
	    
	    
	    
		if(str.equals("mButton")) {
			try {
				new SelectPayMenu(ex, new Listener("매장").ch);
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// 매장에서 식사 디비에 저장
		}
		if(str.equals("pButton")) {
			try {
				new SelectPayMenu(ex, new Listener("포장").ch);
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// 포장 디비에저장
		}
		if(str.equals("SetButton")) {
			try {
				new SetMenu(ex, new Listener().ch);
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(str.equals("HamButton")) {
			try {
				new HamMenu(ex, new Listener().ch);
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if(str.equals("Set1Button")) {
			try {
				new Select3Menu(ex, new Listener("빅맥세트").ch);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		if(str.equals("Set2Button")) {
			try {
				new Select3Menu(ex, new Listener("새우버거세트").ch);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(str.equals("Set3Button")) {
			try {
				new Select3Menu(ex, new Listener("불고기버거세트").ch);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if(str.equals("FriesButton")) {
			try {
				
				Listener li = new Listener("감자튀김");
			
				String Str = li.ch.kioSay();
				
				if(Str.matches(".*맞나요.*")) {
					System.out.println("음료를 미리 말한 경우");
					new CheckScreen(ex, li.ch);
				}
	    		else {
					System.out.println("터치로 감자튀김 선택");
					new Select4Menu(ex,li.ch);
				}
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if(str.equals("CheeseButton")) {
			try {
				Listener li = new Listener("치즈스틱");
				
				String Str = li.ch.kioSay();
				
				if(Str.matches(".*맞나요.*")) {
					System.out.println("음료를 미리 말한 경우");
					new CheckScreen(ex, li.ch);
				}
	    		else {
					System.out.println("터치로 치즈스틱 선택");
					new Select4Menu(ex,li.ch);
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if(str.equals("ColaButton")) {
			try {
				new CheckScreen(ex, new Listener("콜라").ch);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(str.equals("CidarButton")) {
			try {
				new CheckScreen(ex, new Listener("사이다").ch);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if(str.equals("OKButton")) {
			try {
				new SelectMenu(ex, new Listener("확인").ch);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(str.equals("NoButton")) {
			try {
				new Kio_Project2(ex,new Listener("아니").ch);
				
	    	} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//Main.k.StartView();
			System.out.println("취소");
		}
		if(str.equals("CardButton")) {
			try {
				new Final(ex, new Listener("카드").ch);
				sleep slp = new sleep(ex);
				slp.run();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(str.equals("MoneyButton")) {
			try {
				new Final(ex, new Listener("현금").ch);
				sleep slp = new sleep(ex);
				slp.run();				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		if(str.equals("Single1Button")) {
			try {
				new CheckScreen(ex, new Listener("빅맥").ch);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(str.equals("Single2Button")) {
			try {
				new CheckScreen(ex, new Listener("새우버거").ch);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(str.equals("Single3Button")) {
			try {
				new CheckScreen(ex, new Listener("불고기버거").ch);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	
}
