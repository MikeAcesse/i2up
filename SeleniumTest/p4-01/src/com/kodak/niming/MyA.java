package com.kodak.niming;
//内部类的对象的寄生性
//匿名对象， 匿名类
class Animal{
	public void eat(){ System.out.println("abc");};
}

public class MyA {
	private int x;
	class T{
		private int x;
		public void f(int x){
			int a = this.x +x+ MyA.this.x;
			
		}
		
	}
	public void hh(){
		(new Animal(){
			public void eat(){System.out.println("yyyy");}
			
		}).eat();
	}
	class MyX extends Animal{
		public void eat(){System.out.println("xxxx");}
	}
	public static void main(String [] args){
		
		//MyA a  = new MyA();
		//a.new MyX().eat();
		//new MyA().hh();
		MyA a = new MyA();
		T b = a.new T();

		
	}

}
