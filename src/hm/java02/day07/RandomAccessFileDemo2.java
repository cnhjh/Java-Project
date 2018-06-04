package hm.java02.day07;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 写字符串
 * @author soft01
 *
 */
public class RandomAccessFileDemo2 {
    public static void main(String[] args) throws IOException {
    	RandomAccessFile raf = new RandomAccessFile("raf.txt","rw");
    	
    	String str = "简单点，说话的方式简单点。";//
    	
    	/*
    	 * byte[] getBytes()
    	 * 将当前字符串按照系统默认字符集转换为一组数字
    	 * 
    	 * byte[] getBytes(String csn)
    	 * 将当前字符串按照给定字符集转换为一组对应的字节
    	 * csn:charset name
    	 * 常用字符集
    	 * gbk，utf-8,iso8895-8(欧洲编码，不支持中文)
    	 */
    	byte[] data = str.getBytes("GBK");
    	raf.write(data);
    	System.out.println("写出完毕！");
    	raf.close();
    	
    	
	}
}
