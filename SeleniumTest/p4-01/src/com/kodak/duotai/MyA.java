package com.kodak.duotai;

class A{
	public int a;
	public int f(int x)
	{
		System.out.println("This f(int x) in A");
	    return g(x);
	}
	public int g(int x){
		System.out.println("This is g(int x) in A");
	
	  return f(x);
	}
}

class B extends A{
	
	public int a;
	public int f(int x){
		if(x>0){
			System.out.println("This is f(x) in B");
		    a =g(x-2);
			
			
		}
		return a;
		
	}

public int g(int x){
	System.out.println("This is g(x) in B");
	 return super.g(x-3);
	
    }
}
public class MyA {
 public static void main(String[] args){
	 new B().f(10);
	 
 }
}
