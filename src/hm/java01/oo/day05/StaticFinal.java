package hm.java01.oo.day05;

//static final常量的演示
public class StaticFinal {
	public static void main(String[] args) {
		System.out.println(Hoo.PI); //通过类名点来访问
		//Aoo.PI = 3.1415926; //编译错误，常量不能被修改
		
		//1)加载Boo.class到方法区中
		//2)将num存储在方法区中
		//3)到方法区中获取num的值并输出
		System.out.println(Joo.num);
		
		//编译器在编译时将常量直接替换为具体的值----效率高
		//相当于System.out.println(5);
		System.out.println(Joo.COUNT);
		
	}
}

class Joo{
	public static int num = 5; //静态变量
	public static final int COUNT = 5; //常量
}

class Hoo{
	public static final double PI = 3.1415926;
	//public static final int NUM; //编译错误，常量必须声明同时初始化
}



















