package hm.java01.oo.day03;

public class UpTypeDemo {	
    public static void main(String[] args) {
		Eoo o1 = new Eoo();
		o1.a=1;
		o1.show();
		//o1.b=5;//编译错误，父不能访问子
		//o1.test();//编译错误，父不能访问子
		
		Goo o2 = new Goo();
		o2.a=2;
		o2.show();
		o2.b=5;//子可以访问父
		o2.test();//子可以访问父
		
		Eoo o3 = new Goo();//向上造型
		o3.a=8;
		o3.show();
		//o3.b=2;//编译错误.能点出什么来.看引用类型.
		
		//Goo o4 = new Eoo();
    	
    	
	}

}
class Eoo{
	int a;
	void show(){}
}
class Goo extends Eoo{
	int b;
	void test(){}
}