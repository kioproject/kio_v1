package controller;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Playaudio implements Runnable {
	Clip clip;
	
	public void run() {
		File f = new File("output.wav");
		try {
			AudioInputStream stream = AudioSystem.getAudioInputStream(f); 
			clip = AudioSystem.getClip();
	    
	        clip.open(stream);
	        clip.start();
	        
		}
        catch(Exception e) {        	
        }
	}
	public boolean isrunning() {
		return clip.isRunning();
	}
}
