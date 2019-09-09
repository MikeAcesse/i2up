package com.kodak.string;

public class MyA {
	public static void main(String[] args){
		String a = new String("a");
		String b = new String("b");
		String c = new String("c");
		System.out.println("a = "+a+" b="+b+" c="+c+"\n");
		a =b;
		b=c;
		c=a;
		System.out.println("a = "+a+" b="+b+" c="+c+"\n");
	}

}
