package com.imooc.colletion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 备选课程类
 * @author fanzhikang
 *
 */

public class ListTest {
    public List coursesToSelect;
     
     public ListTest(){
    	 this.coursesToSelect = new ArrayList();
     }
     public void testAdd(){
    	 course cr1 = new course("1", "数据结构");
    	 coursesToSelect.add(cr1);
    	 course temp = (course) coursesToSelect.get(0);
    	 System.out.println("储备的课程是："+temp.id+":"+temp.name);
    	 course cr2= new course("2", "大学英语");
    	 coursesToSelect.add(cr2);
    	 course temp2 = (course) coursesToSelect.get(1);
    	 System.out.println("储备的课程是："+temp2.id+":"+temp2.name);
    	 course cr3 = new course("3", "小学语文");
    	 coursesToSelect.add(0, cr3);
    	 course temp3 =(course) coursesToSelect.get(0);
    	 System.out.println("储备的课程是："+temp3.id+":"+temp3.name);
    	 /**
    	  * 边界异常
    	  */
    	 //course cr4 =new course("4", "小学地理");
    	 //coursesToSelect.add(4,cr4);
    	 course[] cr5={new course("5", "物理"),new course("6", "生物")};
    	 coursesToSelect.addAll(Arrays.asList(cr5));
         course temp5 =(course) coursesToSelect.get(3);
    	 course temp6 =(course) coursesToSelect.get(4);
    	 System.out.print("储备的课程是："+temp5.id+":"+temp5.name+"\n");
    	 System.out.println("储备的课程是："+temp6.id+":"+temp6.name);
    	 coursesToSelect.add(cr2);
    	 System.out.println("储备课程的长度："+coursesToSelect.size());
    	 //coursesToSelect.add("ddddd");
    	 
     }
     /**
      * 课程查询
      * @param args
      */
     public void testget(){
    	 //使用for来查询coursetoselect中的元素
    	 System.out.println("----------开始使用for查询备选课程-----------");
    	 for (int i = 0; i < coursesToSelect.size(); i++) {
			course cr =(course) coursesToSelect.get(i);
			System.out.println("储备的课程是："+cr.id+":"+cr.name);
		}
     }
     /**
      * 使用迭代器来查询
      * @param args
      */
      public void testIterator(){
    		 System.out.println("----------开始使用Iterator迭代器查询备选课程-----------");
    		 Iterator it = coursesToSelect.iterator();
    		 while (it.hasNext()) {
				course cr = (course) it.next();
				System.out.println("储备的课程是："+cr.id+":"+cr.name);
				
			}
      }
      public void testForeach(){
    	  System.out.println("----------开始使用foreach查询备选课程-----------");
    	  for (Object object : coursesToSelect) {
    		  course cr = (course) object;
    		  System.out.println("储备的课程是："+cr.id+":"+cr.name);
		}
      }
      /**
       * 修改List中元素
       * @param args
       */
      public void testModify(){
    	  course cr = new course("8" ,"化学");
    	  coursesToSelect.set(5, cr);
      }
      public void testRemove(){
    	  System.out.println("-------即将开始删除课程-------");
    	  //coursesToSelect.remove(1);
    	  course cr =(course) coursesToSelect.get(1);
    	  coursesToSelect.remove(cr);
    	  testForeach();
    	  System.out.println("-------删除课程结束-------");
      }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ListTest lt = new ListTest();
        lt.testAdd();
        lt.testget();
        lt.testIterator();
        lt.testForeach();
        lt.testModify();
        lt.testForeach();
        lt.testRemove();
      
	}

}
