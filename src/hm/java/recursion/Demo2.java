package hm.java.recursion;

/**
 * 三角数字，递归
 * 计算第n项的值时所求有 余列 的和与求第 n-1项 值时求所有列之和时一样的
 * @author 004
 *
 */
public class Demo2 {
	public static void main(String[] args) {
		Demo1 d = new Demo1();
		//求第7项的值
		int i = d.triangle(7);
		System.out.println(i);//28

	}
	
	
	public static int triangle(int n){
		if(n==1){
			return 1;
		}else{
			return (n+triangle(n-1));
		}
		
	}
}
