package com.kodak.String1;
class MyB{
	private String data1;
	public String data;
	public MyB(String x){
		data =x;
	}
}
class MyC extends MyB{
//	public MyB b1;
	private MyB b1;
	public MyC b2;
	public MyC(String y){
		super(y);
		
	}
}

public class MyA {
  public static void main(String[] args){
	  MyC a = new MyC("abc");
	  System.out.println(a.b2);
	  System.out.println(a.data);
	  a.b2 =new MyC("abc");
	  System.out.println(a.b2);
	  System.out.println(a.b2.data);
	  
  }
}
