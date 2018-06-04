package hm.java01.core.test;

import hm.java01.core.Utils;

public class test01 {

	public static void main(String[] args) {
		Utils utils = new Utils();
		if(utils.primeNumber(84)) {
			System.out.print("是");
		}else {
			System.out.print("不是");
		}
        
	}
	
}
