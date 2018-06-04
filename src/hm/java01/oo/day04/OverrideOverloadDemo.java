package hm.java01.oo.day04;

public class OverrideOverloadDemo {

	public static void main(String[] args) {
		Eoo eoo = new Eoo();
	    Coo o = new Doo();
		eoo.test(o);//重载看引用类型
		
		

	}

}
class Eoo{
	void test(Coo o){
		System.out.println("父型参数");
		o.show();//重写看对象的类型
	}
	void test(Doo o){
		System.out.println("子型参数");
		o.show();
	}
}

class Coo{
	void show(){
		System.out.println("父类show");
	}
}
class Doo extends Coo{
	void show(){
		System.out.println("子类show");
	}
}