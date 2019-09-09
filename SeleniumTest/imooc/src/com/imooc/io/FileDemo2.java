package com.imooc.io;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

/**
 * 列出File 的一些常用操作比如： 过滤，遍历等操作
 * @author fanzhikang
 *
 */
public class FileDemo2 {

	public static void main(String[] args) {
		File file = new File("/Users/fanzhikang/Desktop/javaio/");
		/*String[] filenames = file.list();//列出当前目录下的所以文件及目录
		for (String string : filenames) {
			//System.out.println(string);
			System.out.println(file+File.separator+string);
		}*/
		
	/*	String[] filenames = file.list(new FilenameFilter() {
			//filenameFilter 过滤文件名
			@Override
			public boolean accept(File dir, String name) {
				System.out.println(dir+dir.separator+name);
				return name.endsWith("txt");
				
			}
		});
		for (String string : filenames) {
			System.out.println(string);
		}*/
		
		/*File[] file1 = file.listFiles();
		for (File file2 : file1) {
			System.out.println(file2);
		}*/
	   /* File[] files = file.listFiles(new FileFilter() {
			
			@Override
			public boolean accept(File pathname) {
			    System.out.println(pathname);
				return false;
			}
		} );*/
		File[] files =file.listFiles(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				// TODO Auto-generated method stub
				//System.out.println(name);
				System.out.println(dir);
				return false;
			}
		});
	}

}
