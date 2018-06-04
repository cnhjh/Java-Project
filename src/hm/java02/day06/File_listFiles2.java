package hm.java02.day06;

import java.io.File;
import java.io.FileFilter;

/**
 * File提供了一个重载listFiles方法，该方法可以
 * 指定一个文件过滤器，这样可以将该目录中所有满足过滤器要求的子项获取到
 * @author soft01
 *
 */
public class File_listFiles2 {
	public static void main(String[] args) {
		File dir = new File(".");
		/**
		 * 获取当前目录的所有文件
		 */
		File[] subs = dir.listFiles(new FileFilter(){
			public boolean accept(File file) {
			String name = file.getName();
			System.out.println("正在过滤："+name);
				return file.isFile();
			}	
		});	
		for(File sub : subs){
			System.out.println(sub.getName());
		}

	}
}
