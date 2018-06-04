package hm.java02.day08;

import java.io.Serializable;
import java.util.List;

/**
 * 用于测试对象流进行对象的读写操作
 * 
 * 如果一个类的实例希望被对象流进行读写，那么该类必须实现Serializable接口
 * 
 * @author soft01
 *
 */
public class Person implements Serializable {
	/**
	 * 当一个类实现了序列化接口后，就应当定义一个常量：serialVersionUID， 序列化版本号决定反序列化操作是否成功。
	 * 
	 * 当对象输入流在将一组字节进行反序列化时会对该对象与其对应的类进行版本号比较， 若一致则反序列化，若不一致则抛出版本号不一致异常
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	private String gender;
	/*
	 * 被transient修饰的属性在进行对象序列化时其值会被忽略。 将可有可无的属性忽略可以达到对象序列化“瘦身”的效果
	 */
	private transient List<String> otherInfo;// transient在Serializable实现类才有意义

	public Person() {// 默认无参构造方法

	}

	public Person(String name, int age, String gender, List<String> otherInfo) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.otherInfo = otherInfo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<String> getOtherInfo() {
		return otherInfo;
	}

	public void setOtherInfo(List<String> otherInfo) {
		this.otherInfo = otherInfo;
	}

	public String toString() {
		return name + "," + age + "," + gender + "," + otherInfo;
	}
}
