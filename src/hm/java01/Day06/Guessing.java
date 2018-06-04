package hm.java01.Day06;

public class Guessing {

	public static void main(String[] args) {

	}
      //
	public static char[] Guessing() {
		char[] chs = new char[5];
		char[] letters = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
				'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
		boolean[] flage = new boolean[letters.length];  //创建开关
		for (int i = 0; 1 < chs.length; i++) {   //遍历数组
			int index;
			do{
				index = (int) (Math.random()*letters.length);//随机下标
			} while (flage[index] == true);
			chs[i] = letters[index];
			flage[index] = true;
		}
		return chs;
	}

	// public static int[] check(char[] chs , char[] imput ){

	// }
}
