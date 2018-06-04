package hm.java.recursion;

/**
 * 阶乘：与三角数字类似
 * 
 * 三角数字5： 5+4+3+2+1 = 15
 * 阶乘数字5： 5*4*3*2*1 = 120
 * 阶乘数字n：n! = n*(n-1)!
 * 
 * (n-1)!表示(n-1)的阶乘的阶乘,首先计算(n-1)!即1×2×3×4×.×(n-1),那么(n-1)!=M!=1×2×3×...×M
 * @author 004
 *
 */
public class Demo4{

	public static void main(String[] args) {
		Demo4 d = new Demo4();
		int n = d.factorial(5);
		System.out.println(n);
	}
	
	public int factorial(int n){
		if(n==0){
			return 1;
		}else{
			return (n * factorial(n-1));
		}
	}
	
	
}
