package hm.java02.day06;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * java.io.RandomAccessFile
 * RAF是用来读写文件数据的。其基于指针进行读写，
 * 总是在指针当前位置读写字节，并且完毕后指针自动后移
 * @author soft01
 *
 */
public class RandomAccessFile_write {
	public static void main(String[] args) throws IOException {
	    /**
	     * RAF有两种常见的创建模式：
	     * 1：只读模式，进读取文件数据
	     * 2:读写模式
	     * 
	     * RAF提供了相应的构造方法
	     * RandomAccessFile(File file,String mode)
	     * RandomAccessFile(String path,String mode)
	     * 第一个参数指定要读写的文件，第二个参数为字符串，常用的两个：
	     * 1;"rw"：读写模式
	     * 2:"r":只读模式
	     * 
	     */
	     RandomAccessFile raf = new RandomAccessFile("test.dat","rw");
	         System.out.println("执行完毕！");
	         
	        /**
	         * void write(int d)
	         * 将给定的int值所表示的2进制的“低8位”这个字节写入文件
	         *                             vvvvvvvv
	         *  00000000 00000000 00000000 00000001 
	         */
	         raf.write(1);
	       //  raf.write(21);
	         System.out.println("写出完毕");
	         
	         raf.close();//JUI
	         
	         
	}
}
