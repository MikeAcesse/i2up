package com.imooc.reflect;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class ClassLoaderPropTest {

	public static void main(String[] args) throws IOException {
		//��ȡϵͳ�������
		ClassLoader systemLoader =ClassLoader.getSystemClassLoader();
		System.out.println("ϵͳ�������:"+systemLoader);
		/*
		 * ��ȡϵͳ��������ļ���·����ͨ����CLASSPATH��������ָ��
		 * �������ϵͳû��ָ��CLASSPATH����������Ĭ���Ե�ǰ·��Ϊϵͳ��������ļ���·��
		 */
		Enumeration<URL> em1 =systemLoader.getResources("");
		while (em1.hasMoreElements()) {
			System.out.println(em1.nextElement());
			
		}
		//��ȡϵͳ��������ĸ��������� �õ���չ�������
		ClassLoader extensionLoader =systemLoader.getParent();
		System.out.println("��չ����������"+extensionLoader);
		System.out.println("��չ��������ļ���·����"+System.getProperty("java.ext.dirs"));
		System.out.println("��չ���������parent:"+extensionLoader.getParent());
		

	}

}
