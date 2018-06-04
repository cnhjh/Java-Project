package hm.java02.day07;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
/**
 * 缓冲输出流写出数据的缓冲区问题
 */
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class BufferedOutputStream_flush {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("bos.txt");
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		
		String str = "让我再看你一边，从南到北.";
		byte[] data = str.getBytes("UTF-8");
		bos.write(data);
		/*
		 * void flush（）
		 * 一次性将缓冲区中的数据写出
		 */
		bos.flush();
		
		System.out.println("写出完毕！");
		
		bos.close();

    }
}
