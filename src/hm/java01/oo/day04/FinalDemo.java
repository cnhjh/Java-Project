package hm.java01.oo.day04;

//final演示
public class FinalDemo {
    public static void main(String[] args) {
		
    }
}
final class Hoo{}
//class Goo extends Hoo{}//编译错误，final类不能被继承

class Roo{}
final class Boo extends Roo{}








class Noo{
	final void show(){}
    void test(){}
}	
class Ooo extends Noo{
	  //void show(){}//编译错误，final的方法不能被重写
	  void test(){}
}


class Moo{//演示final修饰变量
	final int a = 3;
	final int b;
	Moo(){
		b = 2;
	}
	void show(){
		final int d;
		//a = 4;//编译错误，final的变量不能被改变
	}
}
