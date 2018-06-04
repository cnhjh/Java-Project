package hm.java02.day04;
/**
 * 该类的每一个实例用于表示直角坐标系中的一个点
 * @author soft01
 *
 */
public class Point {
    private int x;
    private int y;
    
    public Point(){
    	
    }
    
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
	/**
	 * 通常一个类的toString被使用，这个toString就应当被重写
	 * toString返回的字符串没有格式要求，按实际开发需求而定
	 * 原则上返回的字符串中应当包含给定对象属性信息
	 */
    public String toString(){
    	return "(" + x + "," + y + ")";
    }
    /**
     * 通常使用一个类的equals方法就要重写它
     * java API提供的类基本都重写了，我们自己定义的类要自己重写
     * equals方法作用是比较两个对象“像不像”。即：内容是否一致
     */
    public boolean equals(Object obj){
    	if(obj == null){
    		return false;
    	}
    	if(obj == this){
    		return true;
    	}
    
    	if(obj instanceof Point){
    	    Point p = (Point)obj;
    		return p.x==this.x && p.y==this.y;
    		
    	}
    	return false;
    }
}
