package hm.java02.day08;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 异常捕获机制在IO中的用法
 * @author soft01
 *
 */
public class Exception_finally2 {
    public static void main(String[] args) {
		BufferedReader br = null;

	try {
		br = new BufferedReader(
				new InputStreamReader(
						new FileInputStream(
		 						"./src/day08/Exception_finally2.java")
				)
	);
		  String line = null;
		  while((line = br.readLine()) != null){
			  System.out.println(line);
	      }
	} catch (FileNotFoundException e) {

	} catch (IOException e) {
	
	}finally{
		if(br != null){
			try {
				br.close();
			} catch (IOException e2) {
				
			}
		}
	}

	
   }
}
