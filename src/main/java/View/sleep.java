package View;


import java.util.Timer;
import java.util.TimerTask;

import View.Ex1;
import View.Kio_Project2;

public   class sleep implements Runnable{
	
	Ex1 ex;
	Timer time = new Timer();
	Listener li = new Listener();
	sleep(Ex1 ex){
		this.ex = ex;
	}
	TimerTask task = new TimerTask() {
		public void run() {
			new Kio_Project2(ex,li.ch);
		}
	};

	@Override
	public void run() {
		
		time.schedule(task, 10000);
		// TODO Auto-generated method stub
		
		
		
	}

}
