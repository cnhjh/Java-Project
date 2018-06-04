package hm.java02.day06;

import java.io.File;

/**
 * 创建一个多级目录
 * @author soft01
 *
 */
public class File_mkdirs {
    public static void main(String[] args) {
    	/**
    	 * 爱当前目录下创建目录：a/b/c/d/e/f
    	 */
    	File dir = new File("a"+File.separator+
    			"b"+File.separator+
    			"c"+File.separator+
    			"d"+File.separator+
    			"e"+File.separator+
    			"f");
    	if(!dir.exists()){
    		/**
    		 * mkdirs的会将创建的目录创建出来的同时
    		 * 将所有不存在的父目录一同创建出来
    		 * 而mkdir方法在创建目录时要求父目录必须存在
    		 */
    		dir.mkdirs();//mkdir（）不可以，父目录不存在  +s
    		System.out.println("创建目录成功！");
    	}else{
    		System.out.println("该目录已存在！");
    	}


	}
}
