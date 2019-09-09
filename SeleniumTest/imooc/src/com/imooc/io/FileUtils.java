package com.imooc.io;

import java.io.File;

//列出File的一些常用操作比如过滤，遍历等操作。
public class FileUtils {
	public static void listDirectory(File dir){
		if (!dir.exists()) {
			throw new IllegalArgumentException("目录"+dir+"不存在");
		}
		if (!dir.isDirectory()) {
			throw new IllegalArgumentException(dir+"不是目录");
		}
		/*String[] str1 =dir.list();//返回的是字符串数组，直接子的名称，不包含子目录下的内容
		for (String string : str1) {
			System.out.println(string);
		}*/
		//如果要遍历子目录下的内容，就需要构造File对象做递归操作，File 类提供了直接返回File类对象的API
		File[] files = dir.listFiles();//返回的是直接子目录（文件）的抽象。
		/*for (File file : files) {
			System.out.println(file);
		}*/
		if (files !=null && files.length>0) {
			for (File file : files) {
				if (file.isDirectory()) {
					 listDirectory(file);
				} else {
                  System.out.println(file);
				}
			}
		}
	}

}
