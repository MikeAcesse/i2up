package com.imooc.io;

import java.io.File;

public class FileUtilsTest1 {

	public static void main(String[] args) {
		File file = new File("/Users/fanzhikang/Desktop/javaio/");
		FileUtils.listDirectory(file);

	}

}
