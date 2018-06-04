package hm.java02.day06;

import java.io.File;

/**
 * 获取一个目录中的所有子项
 * @author soft01
 *
 */
public class File_listFiles {
	public static void main(String[] args) {
	/*
	 * 查看当前目录中的所有子项
	 */
	    File dir = new File(".");
	    /*
	     * boolean isFile()
	     * 判断当前File表示的是否是一个文件
	     * 
	     * boolean c
	     * 判断当前File表示的是否是一个目录
	     */
	    if(dir.isDirectory()){
	    	File[] subs = dir.listFiles();
	    	System.out.println("当前目录有"+subs.length+"个子项");
	    	for(File sub : subs){
	    		if(sub.isFile()){
	    			System.out.print("文件：");
	    		}
	    		if(sub.isDirectory()){
	    			System.out.print("目录：");
	    		}
	    	    System.out.println(sub.getName());
	    	}
	    }

	}
}
