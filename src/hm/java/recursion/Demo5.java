package hm.java.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 变位字
 * 能写出的排列的数量是单词字母的阶乘
 * 
 * 如：and (3个字母，3的阶乘为6，排列所得的结果为6种) 
 *  1 and     2 adn     3 nda     4 nad     5 dan     6 dna   
 *  
 * @author 004
 *
 */
public class Demo5 {

	static int size;
	static int count;
	static char[] arrChar = new char[100];
	
	public static void main(String[] args) throws IOException {
		System.out.println("Enter a word:");
		String input = getString();
		size = input.length();
		count = 0;
		for(int j=0;j<size;j++){
			arrChar[j] = input.charAt(j);
		}
		System.out.println("输入单词的长度："+size);
		doAnagram(size);
				
	}

	/**
	 * @param newSize 输入单词的长度
	 */
	public static void doAnagram(int newSize){
		if(newSize == 1){
			return;
		}
		for (int j = 0; j < newSize; j++) {
			doAnagram(newSize-1);
			if(newSize==2){
				displayWord();
			}else{
			}
			rotate(newSize);
		}
	}

	private static void rotate(int newSize) {
		int j;
		int position = size - newSize;
		System.out.print(" position="+position);
		char temp = arrChar[position];
		for(j=position+1;j<size;j++){
			arrChar[j-1] = arrChar[j];
		}
		arrChar[j-1] = temp;
	}

	private static void displayWord() {
		if(count < 99){
			System.out.print(" ");
		}
		if(count < 9){
			System.out.print(" ");
		}
		System.out.print(++count + " ");
		
		for(int j=0;j<size;j++){
			System.out.print(arrChar[j]);
		}
		System.out.print("   ");
		System.out.flush();
		if(count%6 == 0){
			System.out.println("");
		}
	}
	
	private static String getString() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		System.out.println("输入的s="+s);
		return s;
	}
	
}


//---------------- 输入abcd的测试结果 --------------------------
/*
 *  Enter a word:
	abcd
	
	输入的s=abcd
	
	  1 abcd     2 abdc     3 acdb     4 acbd     5 adbc     6 adcb   
	  7 bcda     8 bcad     9 bdac    10 bdca    11 bacd    12 badc   
	 13 cdab    14 cdba    15 cabd    16 cadb    17 cbda    18 cbad   
	 19 dabc    20 dacb    21 dbca    22 dbac    23 dcab    24 dcba  
	  
 */


















