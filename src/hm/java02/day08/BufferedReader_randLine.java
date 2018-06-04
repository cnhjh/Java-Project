package hm.java02.day08;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * java.io.BufferedReader
 * 缓冲字符输入流
 * 可以按行读取字符
 * @author soft01
 *
 */
public class BufferedReader_randLine {
	public static void main(String[] args) throws IOException {
		/*
		 * 将当前源代码输出到控制台
		 */
		FileInputStream fis = new FileInputStream(
				"."+File.separator+
				"src"+File.separator+
				"day08"+File.separator+
				"BufferedReader_randLine.java"
				);
		InputStreamReader isr = new InputStreamReader(fis);// 转换输入流InputStreamReader
		BufferedReader br = new BufferedReader(isr);
		
		/*
		 * BufferedReader提供了读取一行字符串的方法：
		 * String readLine()
		 * 该方法会顺序读取若干字符串，直到读取了换行为止
		 * 然后将换行符之前的所有字符以一个字符形式返回。
		 * 返回值为null，则表示文件末尾
		 * 
		 */
		String line = null;
		while((line = br.readLine()) != null){
			System.out.println(line);
		}
		br.close();
	}

}
