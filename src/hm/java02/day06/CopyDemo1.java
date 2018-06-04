package hm.java02.day06;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 复制文件
 * @author soft01
 *
 */
public class CopyDemo1 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile src = new RandomAccessFile("mm.jpg","r");	
		RandomAccessFile desc = new RandomAccessFile("mm_mm.jpg","rw");
		
		int d = -1;
		long start = System.currentTimeMillis();
		while(  (d=src.read()) != -1 ){
			desc.write(d);
		}
		long end = System.currentTimeMillis();
		System.out.println("复制完毕！耗时："+(end-start)+"ms");
		src.close();
		desc.close();

	}
}
