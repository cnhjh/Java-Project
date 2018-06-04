package hm.java01.oo.day05;

//接口的演示 
public class InterfaceDemo {
	public static void main(String[] args){
		//Inter4 o1 = new Inter4();
		Inter4 o2 = new Eoo();
		Inter3 o3 = new Eoo();
		//Coo c= new Coo(); //抽象类不能实例化
		Doo d = new Doo();
		d.d();
	}
}	
interface Inter1{
	double PI=10;
	void show();
	
}
interface Inter2{
   void a();
   void b();
}
class Aoo implements Inter2{
	public void a(){}
	public void b(){}
}
interface Inter3{
	void c();
}
class Boo implements Inter2,Inter3{
	public void a(){}
	public void b(){}
	public void c(){}
}


 abstract class Coo{
	 abstract  void d();
 }
 class Doo extends Coo implements Inter2,Inter3{
		public void a(){}
		public void b(){}
		public void c(){}
		public void d(){System.out.println("继承的父类（抽象类）");}
 }
 
 interface Inter4 extends Inter3{
	   void c();
	   void e();
 }
 
class Eoo implements Inter4{
	public void c(){}
    public void e(){}
}
 
 
 
abstract class Koo{
	 abstract  void d();
}
class Loo extends Koo implements Inter2,Inter3{
		public void a(){}
		public void b(){}
		public void c(){}
		public void d(){System.out.println("继承的父类（抽象类）");}
}
 
 
 
 
 
 
 
 