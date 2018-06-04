package hm.java01.Day06;

//方法的演示
public class MethodDemo {
	public static void main(String[] args) {
              say();
              sayHi("hujinghao");
           System.out.println();
              int a= getNum();
              System.out.println(a);
             
              //double c =5.2,d=2.5;
              double i =plus(2.5,5.2);
		      System.out.println(i); 

	}
	public static void say(){ System.out.println("say()"); }
    public static void sayHi(String name){  System.out.println(name); }
    public static int getNum(){
    	return 520;
    }
    public static double plus(double num1,double num2 ){
    	return num1+num2;
    }
}
