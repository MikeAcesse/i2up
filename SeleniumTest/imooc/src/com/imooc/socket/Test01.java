package com.imooc.socket;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * InetAddress 类
 * @author fanzhikang
 *
 */

public class Test01 {

	public static void main(String[] args) {
	 
		try {
			 //获取本机的InetAddress实例
			InetAddress address = InetAddress.getLocalHost();
			System.out.println("计算机名称："+address.getHostName());
			System.out.println("IP地址："+address.getHostAddress());
			byte[] bytes = address.getAddress();//获取字节数组的IP地址
			System.out.println("字节数组形式的IP: "+Arrays.toString(bytes));
			System.out.println(address);//直接输出InetAddress的对象
			
			//根据机器名获取InetAddress实例;
			//InetAddress address2 =InetAddress.getByName("MikeAcesse");
			InetAddress address2 = InetAddress.getByName("192.168.1.6");
			System.out.println("计算机名称: "+address2.getHostName());
			System.out.println("IP 地址： "+address2.getHostAddress());
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
