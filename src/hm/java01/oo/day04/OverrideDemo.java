package hm.java01.oo.day04;

//重写的演示
public class OverrideDemo{ 
    public static void main(String[] args){
    	Boo1 b1 = new Boo1();
    	
    	System.out.println(b1.show(2));
    }
}	
	/*
class Aoo{
	void show(){}
	double test(){return 0.0;}
	Boo say(){return null;}
	Aoo sayHi(){return null;}
}
class Boo extends Aoo{
	//int show(){return 1;} //编译错误，void时必须相等
	//int test(){return 0;} //编译错误，基本类型时必须相等
	//Aoo say(){return null;} //编译错误，引用类型时必须小于或等于
	Boo sayHi(){return null;} //正确，小于或等于
}
*/
class Aoo{
   void show(){}
   double test(){return 0.0;}
   Boo1 say(){return null;}
   Aoo sayHi(){return null;}
   int show(int a){return a;}
}
class Boo1 extends Aoo{
      // int show(){retuen 1;}
	  // int test(){return 0;}
	  //Aoo say(){return null;}
	  Boo1 sayHi(){return null;}
	  int show(int a){return a+a;}
}