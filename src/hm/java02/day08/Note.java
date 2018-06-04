package hm.java02.day08;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/**
 * 完成记事本功能
 * 程序启动后，要求用户输入一个文件名，然后将控制台输入
 * 的每行字符串都写入该文件中。
 * 当用户输入"exit"时，程序退出。
 * @author soft01
 *
 */
public class Note {
	public static void main(String[] args) throws UnsupportedEncodingException, FileNotFoundException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入一个文件名：");
		String filename = scanner.nextLine();
		
		/*
		 * 当创建PrintWriter时，如果使用的构造方法中第一个参数是一个流，
		 * 那么就支持一个重载的构造方法可以传入一个boolean值的参数该值为true，
		 * 则当前PrintWriter具有自动刷新功能。即：
		 * 每当使用println方法写出一行字符串后会自动flush，注意！
		 * 调用print方法不会flush。
		 */
		
		PrintWriter pw = new PrintWriter(//缓冲字符输出流
		         new OutputStreamWriter (//字符流
				 new FileOutputStream(filename),"UTF-8"//创建文件输出流
				 ),true
			  );
		System.out.println("请开始输入内容：");
		String line = null;
		while(true){
			line = scanner.nextLine();
			if("exit".equals(line)){
				break;
			}
			pw.println(line);
			//pw.flush();
		}
		System.out.println("再见!");
		pw.close();
		
	}

}
