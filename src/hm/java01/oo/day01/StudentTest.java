package hm.java01.oo.day01;
//学生类的测试
public class StudentTest {
	public static void main(String[] args){
		Student jh= new Student();
		jh.name ="jinghao";
		jh.age = 21;
		jh.addres = "广东茂名";
		jh.study();
		jh.sayHi();
		
		
		Student hjh= new Student();
		hjh.name = "hujinghao";
		hjh.age = 21;
		hjh.addres = "maoming";
		hjh.study();
		hjh.sayHi();
		
		Student a = new Student();
		a.study();
		a.sayHi();
		
	}   
}
