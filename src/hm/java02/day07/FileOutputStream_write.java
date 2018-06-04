package hm.java02.day07;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * 流  java标准的IO操作
 * 流按照功能分为：
 * 输入流（input）：用来读取数据
 * 输出流（output）：用来写出数据
 * 
 * 流分类为：节点流和处理流
 * 节点流：节点流又称为低级流，是真是负责读写的流，是连接程序与数据的“管道”，
 *        负责将数据搬运。读写一定是基于低级流完成的
 * 特点：数据源明确（知道数据从哪里来，或者数据写到哪里去）
 * 
 * 处理流：处理流不能独立存在，必须基于另一个流进行读或写，目的是通过处理流提供的读
 *        写功能简化我们对实际读写数据的操作
 *       
 * 文件流
 * 用来读写文件数据的流，文件流是一对低级流
 * 论功能与RandomAccessFile一致，都是用来读写文件数据的流但是区别在于实际底层的读写实现方式不同，
 * RAF基于指针进行读写的。文件流是基于流式读写的。
 * @author soft01
 *
 */
public class FileOutputStream_write {
	public static void main(String[] args) throws IOException {
		/*
		 * 默认创建的文件输出流是：覆盖写操作
		 * 即：若文件存在，会先将该文件所有数据清除，
		 * 然后通过该流写出的数据会作为文件数据。
		 * RAF写出则不同，RAF是写出多少数据覆盖多少数据。
		 * 
		 * FOS支持另一种构造方法，要求传入两个参数
		 * 第二个参数是一个boolean值，若该值为true
		 * 则是最佳模式
		 * 即：通过该流写出的数据会被追加到文件末尾。
		 */
		FileOutputStream fos = new FileOutputStream("fos.txt",true);
	
		String str = "，在逼一个最爱你的人即兴表演";//该配合你演出的我演视而不见，在逼一个最爱你的人即兴表演
		byte[] data = str.getBytes("UTF-8");
		
		fos.write(data);
		
		System.out.println("写出完毕！");
		
		fos.close();
	}
	

}
