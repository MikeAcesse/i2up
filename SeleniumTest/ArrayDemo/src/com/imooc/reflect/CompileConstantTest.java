package com.imooc.reflect;

class MyTest
{
	static 
	{
		int b=3;
		System.out.println("b="+b);
		System.out.println("静态初始化块。。。");
		compileConstant="I love you ";
	}
	// 使用一个字符串直接为static final 的类变量赋值
	static String compileConstant="疯狂Java讲义";
	
}

public class CompileConstantTest {

	public static void main(String[] args) {
	   //访问,输出MyTest中的compileConstant类变量
		System.out.println(MyTest.compileConstant);
	}

}
