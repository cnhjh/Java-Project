package hm.java02.day01;
/**
 * char charAt(int index)
 * 返回指定下标处对应的字符
 * @author soft01
 *
 */
public class String_charAt {
	public static void main(String[] args) {
	    //            0123456789012345
		String str = "thinking in java";
	   
		//查看第十个字符是什么？
		char c = str.charAt(10);//n
		System.out.println(c);//n
		
		//检查回文  
		String info = "上海自来水来自海上";
		
		//int a = info.length()/2;
		//System.out.println(a);//a=4
		
		System.out.println(info.length());
		System.out.println(9/2);
		System.out.println( 3 < 9/2);
		for(int i=0;i<info.length()/2;i++){			
			if(info.charAt(i) != info.charAt(info.length()-1-i)){	
			//  (0)上  (1)海                 (7)海  (8)上 
				System.out.println("不是回文");
				return;//方法返回        以下代码不再运行
		}
	}
		System.out.println("是回文");
}
}