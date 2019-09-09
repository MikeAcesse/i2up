package com.imooc.tcpApply;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		
		try {
			//1.创建一个服务器端Socket，即serverSocket，指定绑定端口，并监听此端口
			ServerSocket serverSocket = new ServerSocket(8888);
			Socket socket = null;
			//记录客户端数量
			int count = 0;
			System.out.println("***服务器即将启动，等待客户端的连接***");
			//调用accept()方法开始监听，等待客户端的连接
			socket =serverSocket.accept();
			
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String info=null;
			while ((info =br.readLine())!=null) {
				System.out.println("我是服务器端，客户端说了： "+info);
			}
		    socket.shutdownInput();//关闭输入流
		    
		    
		    //4.获取输出流，响应客户端的请求
		    OutputStream os = socket.getOutputStream();
		    PrintWriter pw = new PrintWriter(os);//包装为打印流
		    pw.write("欢迎您！");
		    pw.flush();//调用flush()方法将缓冲输出
		    //5. 关闭资源
		    pw.close();
		    os.close();
		    br.close();
		    isr.close();
		    is.close();
		    socket.close();
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

}
