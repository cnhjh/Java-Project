package hm.java01.oo.day04;

public class StaticDemo {
	public static void main(String[] args){
		Joo o1 = new Joo();
		o1.show();
		System.out.println();
		
		Joo o2 = new Joo();
		o2.show();
		System.out.println();
		
		Joo o3 = new Joo();
		o3.show();
		System.out.println(Joo.b);//常常通过类名点访问
		//System.out.println(o1.b);//不建议通过对象点访问，建议类名点来访问
		
//		Loo o3 = new Loo();
//		Loo o4 = new Loo();
		
//		Koo o5 = new Koo();
//		o5.show();

//		o5.show();
//		o5.test();
		//Koo.show();
		//Koo.test();
		
		
	} 
}
class Koo{//演示静态方法
	int a=9;
	static int b=8;
	Koo(){
		a++;
		b++;
	}
	void show(){
		System.out.println(this.a);
		System.out.println(Koo.b);
	}
	static void test(){
		//没有this意味着没有对象
		//因为实例成员a必须通过对象点来访问
		//所以静态方法中不能访问实例成员
		//System.out.println(a);//编译错误
		System.out.println(Koo.b);
	}
	
}






class Loo{//演示静态块
	static{
		System.out.println("静态快");
	}
	Loo(){
		System.out.println("构造方法");
	}
}

class Joo{//演示静态变量
 
	int a;
	static int b;
	Joo(){
		System.out.println("我的a："+a);
		System.out.println("我的b："+b);
		a++;
		b++;
	}
    void show(){
	    System.out.println("a="+a);
	    System.out.println("b="+b);
    }
   
}