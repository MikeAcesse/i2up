package com.imooc.reflect;

interface Fruit{
	public void eat();
}
class Apple implements Fruit{
	@Override
	public void eat() {
		System.out.println("******吃苹果了*******");
		
	}
}
class Orange implements Fruit{
	@Override
	public void eat() {
		System.out.println("******吃橘子了*******");
		
	}
}

class  Factory {
	public static Fruit getInstance(String className){
		  Fruit f =null;
			try {
				f=(Fruit)Class.forName(className).newInstance();
			} catch (InstantiationException | IllegalAccessException
					| ClassNotFoundException e) {
				
				e.printStackTrace();
			}
				
			return f;
		
	} 
}
public class TestFactory {
	
   public static void main(String[] args) {
	Fruit f = Factory.getInstance("com.imooc.reflect.Apple");
	f.eat();
    Fruit f1 =Factory.getInstance("com.imooc.reflect.Orange");
    f1.eat();
}
}
