package com.kaikeba.io;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class FileDemo1 {

	public static void main(String[] args) throws IOException {
		File file = new File("/Users/fanzhikang/Desktop/");
		System.out.println(file);
		File file2 = new File(file, "backup");
		System.out.println(file2);
		File file3 = new File(file2, "hello.txt");
		System.out.println(file3);
		System.out.println(file2.exists());
		System.out.println(file3.exists());
		
	
		File f1 = new File("/Users/fanzhikang//Desktop/f1");
		System.out.println(f1);
		f1.mkdir();
		File f2 = new File("/Users/fanzhikang//Desktop/f1", "1.txt");
		System.out.println(f2);
		f2.createNewFile();
	    File f3 = new File(f1,"33.java");
	    System.out.println(f3);
        f3.createNewFile();
        File f4 =new File("/Users/fanzhikang/Desktop/w1/w2/w3");
        f4.mkdirs();
        File f5 = new File(f4, "java.txt");
        f5.createNewFile();
	}
}
	
