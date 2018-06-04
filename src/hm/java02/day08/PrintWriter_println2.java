package hm.java02.day08;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;


/**
 * 在流连接中使用PrintWriter
 * @author soft01
 *
 */
public class PrintWriter_println2 {
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
	  //FileOutputStream fos = new FileOutputStream("pw2.txt");
		PrintWriter pw = new PrintWriter(//缓冲字符输出流
				         new OutputStreamWriter (//字符流
						 new FileOutputStream("pw2.txt"),"UTF-8"
						 )
					  );
		pw.println("你好！");
		pw.println("再见！");
		
		System.out.println("写出完毕！");
		pw.close();
		
		
	}

}
