package com.wcc;

import java.util.ArrayList;
import java.util.List;


/**
 * 添加课程
 * @author fanzhikang
 *
 */

public class TestList {
	 
	List coursetoselct;
	public TestList(){
		this.coursetoselct = new ArrayList();
	}
	
   public void testAdd(){
	   Course cr = new Course("1", "数据结构");
	   coursetoselct.add(cr);
	   Course temp = (Course) coursetoselct.get(0);
	  // System.out.println("添加了课程："+ temp.id+"  "+temp.name);
	   Course cr1 = new Course("2", "C 语言");
	   coursetoselct.add(0, cr1);
	   Course temp1 = (Course) coursetoselct.get(0);
	   System.out.println("添加了课程："+ temp1.id+"  "+temp1.name);
	   
	   
			   
   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestList tl =new TestList();
		tl.testAdd();

	}

}
