package hm.java02.day08;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 转换输入流InputStreamReader
 * @author soft01
 *
 */
public class InputStreamReader_read {
	public static void main(String[] args) throws IOException  {
		FileInputStream fis = new FileInputStream("osw.txt");
		InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
		
		int d = -1;
		while( (d = isr.read()) != -1 ){
			System.out.print((char)d);	
		}
		isr.close();
		
		
	}
}
