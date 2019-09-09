package com.imooc.io;

import java.io.File;
import java.io.IOException;

/**
 * File 类
 * @author fanzhikang
 *
 */
public class FileDemo1 {

	public static void main(String[] args) {
        //了解构造函数的情况，查帮助
		 File file = new File("/Users/fanzhikang/Desktop/javaio/imooc");
		 System.out.println(file.exists());
		 if (!file.exists()) {
			  file.mkdirs();
		} else {
			file.delete();

		}
		 //是否是一个目录，如果是目录返回true, 如果不是目录，或者目录不存在就返回false
		 System.out.println(file.isDirectory());
		 //是否是一个文件
		 System.out.println(file.isFile());
		 //File file2 = new File ("/Users/fanzhikang/Desktop/javaio/日记1.txt");
		 File file2 = new File("/Users/fanzhikang/Desktop/javaio/", "日记.txt");
		 if (!file2.exists()) {
			 try {
				file2.createNewFile();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		} else {
            //file2.delete();
		}
		 //常用的File 对象的API
		 System.out.println(file);
		 System.out.println(file.getAbsolutePath());
		 System.out.println(file.getName());
		 System.out.println(file2.getName());
		 System.out.println(file.getParent());
		 System.out.println(file2.getParent());
		 System.out.println(file.getParentFile().getName());
		 System.out.println(file.getParentFile().getAbsolutePath());
		 
		 
	}

}
