package View;

import java.util.Stack;

public class Chatt {
	static Stack<String> kio = new Stack<>();
	static Stack<String> user = new Stack<>();
	static Stack<String> intent = new Stack<>();
	
	public void kioChatt(String str) {
		kio.add(str);
	}
	public void userChatt(String str) {
		user.add(str);
	}
	public void detectIntent(String str) {
		intent.add(str);
	}
	
	public String kioSay() {
		return kio.peek();
	}
	
	public String userSay() {
		return user.peek();
	}
	
	public String WhatIntent() {
		return intent.peek();
	}
	public void Clear() {
		kio.clear();
		user.clear();
	}

}
