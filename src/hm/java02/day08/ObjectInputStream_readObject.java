package hm.java02.day08;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * 对象输入流
 * 用于反序列化对象
 * @author soft01
 *
 */
public class ObjectInputStream_readObject {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("Person.obj");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		Person p = (Person)ois.readObject();
		System.out.println(p);
		
		ois.close();
		
		
		
	}
}
