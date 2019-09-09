package com.imooc.reflect;
import java.lang.reflect.Field;
import java.util.Set;


public class reflectdemo {
	      public static void main(String[] args) throws Exception{
		  Class<?> cls = Class.forName("com.imooc.po.Book");
	      Object obj = cls.newInstance();
	      Field titleField = cls.getDeclaredField("title");
	      titleField.setAccessible(true);
	      titleField.set(obj, "Javadevelopement");
	      System.out.println(titleField.get(obj));
		  
	  
	}
}
    
