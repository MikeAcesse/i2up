package com.imooc.io;

import java.io.UnsupportedEncodingException;

public class EncodeDemo {

	public static void main(String[] args) throws Exception {
		String s ="慕课网ABC";
		byte[] bytes1 = s.getBytes();
	    for (byte b : bytes1) {
	    	//把字节（转换成了int），以16进制的方式显示
			System.out.print(Integer.toHexString(b&0xff)+" ");
		}
	    System.out.println();
	    //utf-8 中文3个字节，英文1个字节
	    byte[] bytes2 = s.getBytes("utf-8");
	    
	    for (byte b : bytes2) {
			System.out.print(Integer.toHexString(b&0xff)+" ");
		}
	    System.out.println();
        byte[] bytes3 = s.getBytes("GBK");//GBK 中文占2个字节，英文1个字节
	    
	    for (byte b : bytes3) {
			System.out.print(Integer.toHexString(b&0xff)+" ");
		}
	    System.out.println();
        byte[] bytes4 = s.getBytes("utf-16be");//java 是双字节编码，中文占2个字节，英文占2个字节
	    
	    for (byte b : bytes4) {
			System.out.print(Integer.toHexString(b&0xff)+" ");
		}
       /**
        * 当你的字节序列是某种编码，这个时候想把字节序列变成字符串，也需要用这种编码方式，否则会出乱码
        */
	    System.out.println();
	    String s1 =new String(bytes4,"utf-16be");
	    System.out.println(s1);
	    String s2 = new String(bytes4);
	    System.out.println(s2);
	}

}
