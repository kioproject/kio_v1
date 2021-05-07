import controller.DetectIntentTexts;

public class test {
	
	
	
	
	public void main(String[] args) throws Exception {
		
		DetectIntentTexts a = new DetectIntentTexts();
		
		String e = a.streamingMicRecognize();
		
		System.out.println(e);
	}

}
