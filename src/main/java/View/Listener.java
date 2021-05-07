package View;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import com.google.api.client.util.Maps;
import com.google.cloud.dialogflow.v2.DetectIntentRequest;
import com.google.cloud.dialogflow.v2.DetectIntentResponse;
import com.google.cloud.dialogflow.v2.OutputAudioConfig;
import com.google.cloud.dialogflow.v2.OutputAudioEncoding;
import com.google.cloud.dialogflow.v2.QueryInput;
import com.google.cloud.dialogflow.v2.QueryResult;
import com.google.cloud.dialogflow.v2.SessionName;
import com.google.cloud.dialogflow.v2.SessionsClient;
import com.google.cloud.dialogflow.v2.TextInput;
import com.google.protobuf.ByteString;

import controller.DetectIntentTexts;
import controller.Playaudio;

public class Listener {
	public String str;
	public Ex1 ex;
	public ArrayList<String> texts = new ArrayList<>();
	public Chatt ch = new Chatt();
//	public Playaudio play = new Playaudio();
	Listener(){
		
	}
    public Listener(String str) throws Exception {
		this.str = str;
		Speech(str);
    }
    
   public Listener(int i, String str) throws Exception{
	   this.str = str;
	   if(i == 2 && (str.matches(".*세트.*")||str.matches(".*배트.*"))) {
		   ch.userChatt(str);
	   }
	   else if(i == 2 && str.matches(".*단품.*")) {
		   ch.userChatt(str);
	   }
	   else {
		   Say(str);
	   }
   }
   public void Say(String str) throws Exception{
//		DetectIntentTexts a = new DetectIntentTexts();
			String projectId = "capstoneproject-ycqucq";
		//  String sessionId = UUID.randomUUID().toString();
			String sessionId = "101";
			String languageCode = "ko";
			DetectIntentTexts a = new DetectIntentTexts();
			QueryResult res;
			
			texts.clear();
			String set = str;
			texts.add(set);
		
			try {
				res = a.detectIntentWithTexttoSpeech(projectId, texts, sessionId, languageCode);
			
				ch.kioChatt(res.getFulfillmentText());
				ch.userChatt(set);
				ch.detectIntent(res.getIntent().getDisplayName());
				new Playaudio().run();
				
				
			}catch(Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
   }
    
	
	public void Speech(String str) throws Exception {
		
	//	DetectIntentTexts a = new DetectIntentTexts();
		String projectId = "capstoneproject-ycqucq";
	//  String sessionId = UUID.randomUUID().toString();
		String sessionId = "101";
		String languageCode = "ko";
		DetectIntentTexts a = new DetectIntentTexts();
		QueryResult res;
		
		
		texts.clear();
		String set = str;
		texts.add(set);
		
		try {
			res = a.detectIntentWithTexttoSpeech(projectId, texts, sessionId, languageCode);
		
			ch.kioChatt(res.getFulfillmentText());
			ch.userChatt(set);
			ch.detectIntent(res.getIntent().getDisplayName());
			
			new Playaudio().run();
			
		}catch(Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
	}

	public String kiochatt() {
		return ch.kioSay();
	}
	public String userchatt() {
		return ch.userSay();
	}
}
