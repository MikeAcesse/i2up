package com.imooc.colletion;

import java.util.HashSet;
import java.util.Set;

/**
 * 学生类
 * @author fanzhikang
 *
 */
public class student {
     public String id;
     public String name;
     public Set<course>courses;
     public  student(String id,String name){
    	 this.id =id;
    	 this.name = name;
    	 this.courses = new HashSet<course>();
     }
}
