package com.kaikeba.ThreadEx;

import java.util.Date;

public class TimePrint extends Thread {
	
	 public int pauseTime;
	 public String name;
	 
	 public TimePrint(int pauseTime, String name){
		 this.pauseTime =pauseTime;
		 this.name = name;
		 
	 }
	 
    public void Run(){
    	  while (true) {
			try {
				System.out.println(name+":"+new Date(System.currentTimeMillis()));
	
				Thread.sleep(pauseTime);
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
				
			}
		}
    }
	public static void main(String[] args) {
		 TimePrint tp1 = new TimePrint(1000, "fanzhikang");
		 tp1.start();
		 //System.out.println(Thread.currentThread().getName()+":"+new Date(System.currentTimeMillis()));
		 
	}

}
