package hm.java01.day02;

//数据类型的演示
public class DataTypeDemo {
	public static void main(String[] args) {
		
		
		/*
		 * 数据类型转换的练习:
		 * 1)声明整型变量a并赋值为5
		 *     声明长整型变量b并赋值为a
		 *     声明整型变量c并赋值为b
		 * 2)声明长整型变量d并赋值为100亿
		 *     声明整型变量e并赋值为d，输出e的值
		 *   声明浮点型变量f并赋值为56.987
		 *     声明整型变量g并赋值为f，输出g的值
		 * 3)声明byte型变量b1并赋值为5
		 *     声明byte型变量b2并赋值为6
		 *     声明byte型变量b3并赋值为b1+b2
		 *   输出1+2的值, 输出'1'+'2'的值
		 */
		
		
		/*
		//基本数据类型的转换:
		int a = 5;
		long b = a; //自动类型转换(小到大)
		int c = (int)b; //强制类型转换(大到小)
		
		long d = 5; //自动类型转换
		double e = 5; //自动类型转换
		
		long f = 10000000000L;
		int g = (int)f;
		System.out.println(g); //强转有可能会发生溢出
		
		double h = 56.987654;
		int i = (int)h;
		System.out.println(i); //强转有可能会丢失精度
		
		short s1 = 5;
		short s2 = 6;
		short s3 = (short)(s1+s2);
		
		System.out.println(2+2);     //4
		System.out.println('2'+'2'); //100，'2'的码50，加上'2'的码50
		*/
		
		
		
		/*
		 * boolean、char的练习:
		 * 1)声明布尔型变量b1并赋值为true
		 *   声明布尔型变量b2并赋值为false
		 *   声明布尔型变量b3并赋值为25.6-------???
		 * 2)声明字符型变量c1并赋值为字符男
		 *   声明字符型变量c2并赋值为字符m
		 *   声明字符型变量c3并赋值为字符8
		 *   声明字符型变量c4并赋值为空格符
		 *   声明字符型变量c5并赋值为字符男性-----???
		 *   声明字符型变量c6并赋值为空字符-------???
		 *   声明字符型变量c7并赋值为97，输出c7
		 *   声明字符型变量c8并赋值为单引号('),输出c8
		 */
		
		/*
		//5)char:字符型，2个字节
		char c1 = '女'; //'女'为字符型直接量
		char c2 = 'f';
		char c3 = '6'; //声明字符型变量c3并赋值为字符6
		char c4 = ' '; //声明字符型变量c4并赋值为空格符
		//char c5 = 男; //编译错误，字符必须放在单引号中
		//char c6 = ''; //编译错误，必须有字符--空字符
		//char c7 = '男性'; //编译错误，只能有一个字符
		
		char c8 = 65; //0到65535
		System.out.println(c8); //A
		
		char c9 = '\'';
		System.out.println(c9); //'
		*/
		
		
		
		
		
		/*
		//4)boolean:布尔型，1个字节
		boolean b1 = true;  //true为布尔型直接量
		boolean b2 = false; //false为布尔型直接量
		//boolean b3 = 250; //编译错误，布尔型只能取值为true和false
		*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		 * int、long、double的练习:
		 * 1)声明整型变量a并赋值为250
		 *   声明整型变量b并赋值为100亿----------???
		 *   输出5/2的值，输出2/5的值
		 *   声明整型变量c并赋值为2147483647(int的最大值)
		 *     在c本身基础之上增1，输出c的值
		 * 2)声明长整型变量d并赋值为100亿
		 *   声明长整型变量e并赋值为10亿*2*10L，输出e
		 *   声明长整型变量f并赋值为10亿*3*10L，输出f
		 *   声明长整型变量g并赋值为10亿L*3*10，输出g
		 *   声明长整型变量h并赋值为
		 *      System.currentTimeMillis(),输出h
		 * 3)声明浮点型变量pi并赋值为3.14
		 *   声明浮点型变量i和j，并分别赋值为6.0和4.9
		 *     输出i-j
		 */
		
		
		
		
		
		/*
		//3.double:浮点型，8个字节，很大很大很大
		double pi = 3.14159; //3.14159为浮点数直接量，默认为double型
		float f = 3.14159F; //3.14159F为float的直接量
		
		double a=3.0,b=2.9;
		System.out.println(a-b); //0.10000000000000009
		*/
		
		/*
		//2.long:长整型，8个字节，很大很大很大
		long a = 250L; //250L为长整型直接量
		//long b = 10000000000; //编译错误，100亿默认为int类型，但超出int范围了
		long c = 10000000000L;
		
		long d = 1000000000*2*10L;
		System.out.println(d); //200亿
		long e = 1000000000*3*10L;
		System.out.println(e); //不是300亿
		long f = 1000000000L*3*10;
		System.out.println(f); //300亿
		
		long g = System.currentTimeMillis();
		System.out.println(g); //1499063385779
		*/
		
		/*
		//1.int:整型，4个字节，-21个多亿到21个多亿
		int a = 250; //250为整数直接量，默认为int类型
		//int b = 10000000000; //编译错误，100亿默认为int类型，但超出int范围了
		
		System.out.println(5/2); //2
		System.out.println(8/2); //4
		System.out.println(2/8); //0
		
		int c = 2147483647;
		c = c+1;
		System.out.println(c); //-2147483648，溢出了
		*/
	}
}














