package hm.java02.day08;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;



/**
 * 对象流是一对高级流，作用是方便读写java中的对象
 * 
 * java.io.ObjectOutputStream
 * 对象输出流，可以将给定的对象转换为一组字节，然后通过其处理的流将这组数字写出 
 * @author soft01
 *
 */
public class ObjectOutputStream_witeObject {
	public static void main(String[] args) throws IOException  {
		Person p = new Person();
		p.setName("苍老师");
		p.setAge(18);
		p.setGender("女");
		List<String> otherInfo = new ArrayList<String>();
		otherInfo.add("是一名演员");
		otherInfo.add("爱好是写书法");
		otherInfo.add("致力于促进中日文化交流");
		otherInfo.add("广大男性同胞的启蒙老师");
		p.setOtherInfo(otherInfo);
		System.out.println(p);
		/*
		 * 将该对象写入文件保存
		 */
		//创建用于向文件中写出字节的文件输出流
	    FileOutputStream  fos = new FileOutputStream("Person.obj");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		/*
		 * 对象流输出提供方便写出对象的方法
		 * void writeObject(Object o)
		 * 该方法可以将给定的对象按照其结构转换为一组对应的字节，
		 * 然后通过对象输出流连接的流将该组字节写出。
		 * 
		 * 
		 * 
		 * 将一个对象通过对象列转换为字节后并写入文件的操作及两个专业名词：
		 * 
		 * 1：对象序列化
		 *   对象序列化就是将一个java中的对象按照其结构转化为
		 *   一组字节的过程(对象输出流完成)
		 * 2:持久化
		 *   将一组字节写入文件（硬盘上）的过程成为持久化
		 * 
		 */
		oos.writeObject(p);
		System.out.println("写出完毕！");
		oos.close();
		
	}

}
