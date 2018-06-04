package hm.java02.day05;
/**
 * 用于测试作为集合元素排序
 * @author soft01
 *
 */
public class Point implements Comparable<Point>{
	private int x;
	private int y;
	
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
 
	
	public String toString(){
		return "("+x+","+y+")";
	}
	/**
	 * 实现Comaparable接口后必须重写compareTo
	 * 该方法的作用是定义当前对象this与参数对象o之间比较大小的规则
	 * 返回值不关注具体值，只关注取值范围：
	 * 当返回值return>0：当前对象this大于参数对象o（this>o）
	 * 当返回值return<0:this<o
	 * 当返回值return=0：this==o
	 */
	public int compareTo(Point o) {
		int len = this.x*this.x+this.y*this.y;
		int olen = o.x*o.x+o.y*o.y;
		return len-olen;
	}
} 
