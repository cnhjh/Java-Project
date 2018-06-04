package hm.java02.day01;
/**
 * String substring(int start,int end)
 *  截取当前字符串的部分内容
 *  start，end为下标，确定截取范围。
 *  需要注意，java api中有一个特点，通常使用两个数字
 *  表示一个范围时都是“含头不含尾”的
 *  
 * int indexOf(String str, int fromIndex)
 *  参数：
 * 	   str - 要搜索的子字符串。
 * 	   fromIndex - 开始搜索的索引位置。 
 * 	返回：
 * 	     指定子字符串在此字符串中第一次出现处的索引，从指定的索引开始。
 * @author soft01
 *
 */
public class String_substring {
    public static void main(String[] args) {  	
	    //            01234567890123
    	String str = "www.cracle.com";
    	//截取域名
    	String  name = str.substring(4,10);
    	System.out.println(name);//cracle
    	
    	//重载方法传入一个参数，截取到尾
        name = str.substring(4);
        System.out.println(name);//cracle.com
        
        name = getHost("www.tedu.cn");
        System.out.println(name);//tedu
        name = getHost("http：//www.tedu.cn");
        System.out.println(name);//tedu
        name = getHost("http：//www.baidu.com.cn");
        System.out.println(name);//baidu
	}

    /**
     * 返回给定地址中的域名
     * @param url
     * @return 
     */
    public static String getHost(String url){//String getHost8
    	int start = url.indexOf(".")+1;//
    	//indexOf(String str, int fromIndex)
    	//从下标start开始检索下一次出现“.”的位置结束
    	int end = url.indexOf(".",start);
    	System.out.println();
    	System.out.println("范围："+start+","+end);
    	return url.substring(start,end);
    }
}
