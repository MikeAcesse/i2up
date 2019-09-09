package com.weichangcheng.Dimension;

public class TwoDemensionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//定义一个2维数组
      int[][] a;
      //System.out.println(a.hashCode());
      //把a 当成1维数组进行初始化，初始化a 为一个长度为4 的数组。
      //a数组的数组元素又是引用类型
      a =new int[4][];
      //把a 数组当成一个1维数组，遍历a 数组的每个数组元素
      for(int i=0; i<a.length; i++){
    	 // System.out.println(a.length);
    	  System.out.println(a[i]);
      }
      //初始化a数组的第1个元素
      a[0]= new int[2];
      //访问a数组的第一个元素所指数组的第2个元素
      a[0][1]=6;
      System.out.println("a[0][1]="+a[0][1]);
  	//a数组的第一个元素是1个1维数组，遍历这个1维1维数组
      for(int i=0; i<a.length; i++){
     	 // System.out.println(a.length);
     	  System.out.println(a[i]);
       }
	}

	

}
