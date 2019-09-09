package com.wechengchang.arraydemo;


public class ArrayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 定义并动态初始化一个int[]数组
		int[] pos=new int[5];
		//采用循环为每个数组元素赋值
		for(int i =0 ; i<pos.length; i++){
			pos[i]=(i+1)*2;
			System.out.println("数组第 "+i+"个的值是"+pos[i]);
			
		}
		int a = pos[1];
		System.out.println("a 的值为="+a);
		int b= 20;
		pos[2]=b;
		System.out.println("pos[2]="+pos[2]);
		//定义并动态初始化一个Car[]数组
		Cat[] cats =new Cat[2];
		cats[0] =new Cat(3.34, 2);
		System.out.println("cats[0].weight="+cats[0].weight+" cats[0].age="+cats[0].age);
		cats[1]= new Cat(3.2,2);
		System.out.println(cats[1]);
		System.out.println(cats[1].hashCode());
		Cat c1 =cats[0];
		Cat c2 =new Cat(4.3,3);
		cats[1]=c2;
		
		
	}

}
