package hm.java02.day07;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 * 缓冲流
 * BufferedInputStream：缓冲输入流，提高读写效率
 * BufferedOutputStream：缓冲输出流，提高写出效率
 * @author soft01
 *
 */
public class CopyDemo2 {
	public static void main(String[] args) throws IOException {
	FileInputStream fis = new FileInputStream("mianshiti.doc");
	BufferedInputStream bis = new BufferedInputStream(fis);
	
	FileOutputStream fos = new FileOutputStream("mianshiti_cp02.doc");
	BufferedOutputStream bos = new BufferedOutputStream(fos);
	
	int d = -1;
	long start = System.currentTimeMillis();
	/*
	 * 缓冲流内部维护着一个缓冲区（字节数组)
	 * bis.read（）看似读取一个字节，实际上缓冲流会一次性通过fis读取一组字节，并存入内部维护的字节
	 * 数组中，然后将第一个字节返回。这样当再次调用bis.read()读取一个字节时，会直接从内部的字节数组将
	 * 第二个字节返回。
	 * 所以缓冲流还是通过提高一次实际读取的字节量
	 * 减少实际读取次数提高的效率
	 * 缓冲输出流也是同样原理
	 * 
	 */
	while( (d = bis.read()) != -1){
		bos.write(d);
	}
	long end = System.currentTimeMillis();
	System.out.println("复制完毕，耗时："+(end-start)+"ms");
	bis.close();
	bos.close();
	

	}
}
