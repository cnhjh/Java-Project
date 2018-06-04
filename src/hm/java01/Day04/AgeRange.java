package hm.java01.Day04;

public class AgeRange {
	
	public static void main(String[] args) {
		A a1 = new A(0);
		A a2 = new A();
		System.out.println(" " + a1.age + " " + a2.age);


	}

}

class A{
	int age = 9;

	public A(int ag) {
		int age = 8;
		age = ag;
		System.out.print(age);
	}

	public A() {
		this.age = 6;
	}


}