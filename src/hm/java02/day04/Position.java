package hm.java02.day04;

/**
 * 泛型
 * @author soft01
 *
 */
public class Position<T> {
	private T x;
	private T y;
	public Position(T x, T y) {
		super();
		this.x = x;
		this.y = y;
	}
	public T getX() {
		return x;
	}
	public void setX(T x) {
		this.x = x;
	}
	public T getY() {
		return y;
	}
	public void setY(T y) {
		this.y = y;
	}
	public String toString(){
		return"("+x+","+y+")";
	}

}
