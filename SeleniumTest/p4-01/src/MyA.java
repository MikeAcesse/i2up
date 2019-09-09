
public class MyA {
 public static void main(String[]args){
	 String s ="abcdef";
	 for(int i =0;i<s.length();i++){
		 char c = s.charAt(i);
		 if(s.lastIndexOf(c)!=i){
			 System.out.println("find!");
			 break;
			 
		 }
		 System.out.println("跳出了for 循环");
	 }
	 
//	  String s1 ="fcabcbdefc";
//	  int n =s1.indexOf('c');
//	  int n1 =s1.indexOf("de");
//	  int n2= s1.indexOf('b', 2);
//	  int n3 =s1.indexOf("fc",4);
//	  System.out.println(n);
//	  System.out.println(n1);
//	  System.out.println(n2);
//	  System.out.println(n3);
	 try{
	 String s1 ="abcdefgh";
	 String s2 =s1.substring(2);
	 String s3 =s1.substring(1,100);
	 System.out.println(s2);
	 System.out.println(s3);
	 }catch(Exception e){
		// System.out.println("index is nevigate!");
		System.out.println(e.getMessage()); 
//		 System.out.println(e.getStackTrace());
		 
	 }
	 
	 
 }
}
