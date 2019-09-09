package com.kaikeba.ThreadEx;

public class TimePrint1 implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			System.out.println(Thread.currentThread().getName());
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Thread thread= new Thread(new TimePrint1());
        thread.setName("fan");
        thread.start();
	}

}
