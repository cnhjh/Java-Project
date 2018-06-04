package hm.java02.day06;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import org.omg.Messaging.SyncScopeHelper;

/**
 *  随机读写效率差，块读写效率高
 *  所以若希望提高读写效率，可以通过每次读写的数据量减少读写次数来达到
 * @author soft01
 *
 */
public class CopyDemo2 {
    public static void main(String[] args) throws IOException {
		RandomAccessFile src = new RandomAccessFile("mm.jpg","r");	
		RandomAccessFile desc = new RandomAccessFile("mm_mm.jpg","rw");
		/**
		 * RandomAccessFile提供了读写一组字节的方法
		 * 
		 * int read(byte[] date)
		 * 一次性读取给定字节数组length的字节量，并存入到给数组中，返回值为实际读取到的字节量
		 * 若返回值为-1表示本次没有读到任何字节，是文件的末尾
		 * 
		 * 
		 * void write(byte[] data,int offset,int len)
		 * 将给定的字节数组中所有字节一次性写出
		 * 
		 * void write(byte[] date,int offset,int len)
		 * 将给定字节数组从下标offset处的字节开始的连续len个一次性写出
		 * 
		 * 
		 * 
		 * 
		 */
		// 10kb
		byte[] data = new byte[1024*10];
		int len = -1;
		long start = System.currentTimeMillis();
		while( (len = src.read()) != -1  ){
			desc.write(data,0,len);
		}
		long end = System.currentTimeMillis();
		System.out.println("复制完毕！耗时："+(end-start)+"ms");
		src.close();
		desc.close();
	}
}
