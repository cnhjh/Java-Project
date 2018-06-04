package hm.java02.day06;

import java.io.File;

/**
 * 创建一个目录
 * @author soft01
 *
 */
public class File_mkdir {
	public static void main(String[] args) {
	/**
	 * 在当前目录中创建目录demo
	 */
		File dir = new File("."+File.separator+"demo");
		
		if(!dir.exists()){
			dir.mkdir();
			System.out.println("创建目录成功!");
		}else{
			System.out.println("该目录已存在!");
		}

	}
}
