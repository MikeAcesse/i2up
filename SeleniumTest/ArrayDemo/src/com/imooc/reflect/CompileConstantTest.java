package com.imooc.reflect;

class MyTest
{
	static 
	{
		int b=3;
		System.out.println("b="+b);
		System.out.println("��̬��ʼ���顣����");
		compileConstant="I love you ";
	}
	// ʹ��һ���ַ���ֱ��Ϊstatic final ���������ֵ
	static String compileConstant="���Java����";
	
}

public class CompileConstantTest {

	public static void main(String[] args) {
	   //����,���MyTest�е�compileConstant�����
		System.out.println(MyTest.compileConstant);
	}

}
