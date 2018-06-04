package hm.java02.day06;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 读取文件数据
 * @author soft01
 *
 */
public class RandomAccessFile_read {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf = new RandomAccessFile("test.dat","r");	
     /*
      * int read()
      * 读取一个字节，并将该字节存到一个int值中然后返回该int值，
      * 若返回的int值为-1，则表示本次读取时发现是在文件末尾。
      * 
      */
		int d = raf.read();
		System.out.println(d);
		
		d = raf.read();//第二次读取时是文件末尾
		System.out.println(d);//-1
		
	
		raf.close();
	
	}
}
