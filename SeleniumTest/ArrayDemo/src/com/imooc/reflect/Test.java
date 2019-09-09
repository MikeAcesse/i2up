package com.imooc.reflect;

public class Test {
	static{
		//使用静态初始化块为变量指定初始值
		b=6;
		System.out.println("-----------________");
	}
	static int a =5;
	static int b = 9;
	static int c;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Test.b);

	}

}
