package hm.java02.day02;

public class Test {

	public static void main(String[] args) {
	String imgName = "123.jpg";
	
	String names[] = imgName.split("\\.");
	imgName = System.currentTimeMillis()+"."+names[1];
	System.out.println(imgName);

	}

}
