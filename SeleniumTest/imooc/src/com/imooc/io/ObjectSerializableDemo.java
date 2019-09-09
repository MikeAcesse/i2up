package com.imooc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.omg.CORBA.PRIVATE_MEMBER;

public class ObjectSerializableDemo {

	public static void main(String[] args) throws Exception, IOException {
		//对象序列化
		//File file=new File("demo"+File.separator+"obj.data");
		 String file = "demo/obj.data";
		/*ObjectOutputStream oos;
	
			try {
				oos = new ObjectOutputStream(new FileOutputStream(file));
				Student stu = new Student("10001", "fanzhikang", 35);
				oos.writeObject(stu);
				oos.flush();
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			
		//对象的反序列化
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			Student stu1 = (Student)ois.readObject();
			System.out.println(stu1.toString());
	}

}
