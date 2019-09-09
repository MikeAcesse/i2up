package com.imooc.socket;

import java.net.MalformedURLException;
import java.net.URL;


/**
 * URl 常用方法
 * @author fanzhikang
 *
 */

public class Test02 {

	public static void main(String[] args) {
		try {
			//创建一个URL实例
			URL imoocUrl = new URL("http://www.imooc.com");
			//System.out.println(imoocUrl);
			//?后面表示参数，#后面表示锚点
			URL url = new URL(imoocUrl, "/index.html?username=fanzhikang2004@126.com#test");
			System.out.println("协议："+url.getProtocol());
			System.out.println("主机: "+url.getHost());
			//如果未指定端口号，则使用默认端口号，此时getPath()返回-1
			System.out.println("端口: "+url.getPort());
			System.out.println("文件路径："+url.getPath());
			System.out.println("文件名： "+url.getFile());
			System.out.println(url.getUserInfo());
			System.out.println("相对路径："+url.getRef());
			System.out.println("查询字符串："+url.getQuery());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
