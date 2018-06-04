package hm.java01.oo.day06;

public class InnerClassDemo {
	public static void main(String[] args) {
		Mama m = new Mama();
		//Baby b = new Baby();//编译错误，内部类对外不具备可见性
        m.createBaby();

	}
}
class Mama{
	private String name = "胡景皓" ;
	void createBaby(){
		Baby b = new Baby();
		b.test();
	}
	class Baby{
		void test(){
			System.out.println(name);
			System.out.println(Mama.this.name);
			//System.out.println(this.name);编译错误，当前类中不包含name属性
			
		}
	}
}