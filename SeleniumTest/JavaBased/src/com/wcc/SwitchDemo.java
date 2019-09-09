package com.wcc;

public class SwitchDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 1、 switch 后面小括号中表达式的值必须是整型或字符型

           2、 case 后面的值可以是常量数值，如 1、2；也可以是一个常量表达式，如 2+2 ；但不能是变量或带有变量的表达式，如 a * 2

           3、 case 匹配后，执行匹配块里的程序代码，如果没有遇见 break 会继续执行下一个的 case 块的内容，直到遇到 break 语句或者 switch 语句块结束
		 */
				/*
		         char today='日';
		         switch(today){
		             case '一':
		             case '三':
		             case '五':
		                  System.out.println("早餐吃包子");
		             case '二':
		             case '四':
		             case '六':
		                  System.out.println("早餐吃油条");
		             case '日':
		                  System.out.println("吃主席套餐");
		         }
		       */
		char today='日';
        switch(today){
         
         
            case '日':
            System.out.println("吃主席套餐");
            break;
            case '一':
            case '三':
            case '五':
                 System.out.println("早餐吃包子");
            break;
            default:
            	System.out.println("我吃豆浆");
            	break;
            case '二':
            case '四':
            case '六':
                 System.out.println("早餐吃油条");
            break;  
                 
            
        }
           
		
	}

}
