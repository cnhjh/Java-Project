package hm.java01.oo.day04;

public class Foo {

	public int a;//所有类
	protected int b;//本类，子类，同包类
	int c;//本类，同包类
	private int d;//本类
	
	void show(){
		a = 1;
		b = 2;
		c = 3;
		d = 4;
	}
}
class Goo{//演示private
	void show(){
		Foo o = new Foo();
		o.a = 1;
		o.b = 2;
		o.c = 3;
		//o.d = 4;
		
	}
}
