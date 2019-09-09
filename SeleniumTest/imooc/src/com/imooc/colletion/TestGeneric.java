package com.imooc.colletion;

import java.util.ArrayList;
import java.util.List;

public class TestGeneric {
	
     List<course> coursetoselect;
     public TestGeneric(){
    	 this.coursetoselect = new ArrayList<course>();
     }
     
     public void testAdd(){
    	 course cr = new course("1", "大学英语");
    	 coursetoselect.add(cr);
    	 course cr2 = new course("2", "大学shengwu");
    	 coursetoselect.add(cr2);
//    	 //course cr3 = new course("1", "大学英语");
//    	 coursetoselect.add("ddddddd");
    	
     }
     public void testtype(){
    	 childcourse ccr = new childcourse();
    	 ccr.id="3";
    	 ccr.name="地理";
    	 coursetoselect.add(ccr);
    	 
     }
     public void testfor(){
    	 for (course course : coursetoselect) {
			System.out.println("备选课程："+course.id+":"+course.name);
		}
     }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	   TestGeneric tg= new TestGeneric();
	   tg.testAdd();
	   tg.testtype();
	   tg.testfor();
	   List<Integer> List = new ArrayList<Integer>();
	   List.add(1);

	}

}
