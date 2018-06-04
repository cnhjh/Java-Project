package hm.java02.day07;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;


/**
 * 读取字符串
 * @author soft01
 *
 */
public class RandomAccessFileDemo3 {
    public static void main(String[] args) throws IOException {
    	RandomAccessFile raf = new RandomAccessFile("raf.txt","r");
    	
    	byte[] data = new byte[100];
    	int len = raf.read(data);
    	/*
    	 * String(byte[] data)
    	 * 将给定字节数组中所有字节按照系统默认字符集转换为对应的字符串
    	 * 
    	 * String(byte[] data, int offset,int len,String csn)
    	 * 将给定字符数组从下标offset处开始的连续len个字节按照系统默认字符集转换为字符串
    	 * 
    	 */
    	String str = new String(data,0,len,"GBK");
    	System.out.println(str);
    	
    	raf.close();
    	
    	
    	
	}
}
