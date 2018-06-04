package hm.java02.day08;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * java.io.PrintWriter
 * 缓冲字符输出流
 * 特点：可以按行写出字符串，由于有缓冲，写出字符串效率高
 * 
 * 实际上PrintWriter自身的最大特点是支持“自动行刷新”功能，
 * 而缓冲功能是靠其内嵌的BufferedWriter实现。
 * 因为实例化PrintWriter时，它总会内部实例化BufferedWriter并与其连接。
 * 
 * @author soft01
 *
 */
public class PrintWriter_println {
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		/*
		 * PW提供了很多构造方法，其中有直接对文件写操作的
		 * 构造方法：
		 * PrintWriter(String pafh)
		 * PrintWriter(File file)
		 * 
		 * 可以使用重载构造方法指定字符集
		 * PrintWriter(String path,String charsetName)
		 * PrintWriter(File file,String charsetName)
		 * 
		 */
		PrintWriter pw = new PrintWriter ("pw.txt","UTF-8");
		pw.println("夜空中最亮的星");
		pw.println("能否听清，");
		pw.println("那仰望的人心底的孤独和叹息！");
		System.out.println("写出完毕！");
		pw.close();

	}

	

}
