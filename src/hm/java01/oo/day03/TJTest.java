package hm.java01.oo.day03;

public class TJTest {
	public static void main(String[] args) {
		System.out.println("T型：");
		Tetromino o1 = new T(2, 5);//先造型后传值
		printWall(o1);//传值同时造型
		System.out.println("J型：");
		Tetromino o2 = new J(1, 4);
		printWall(o2);
		System.out.println("O型：");
		Tetromino o3 = new O(3, 4);
		printWall(o3);
	}

	public static void printWall(Tetromino t) {
		for (int i = 0; i<20; i++) { //行
			for (int j = 0; j<10; j++) { //列
				
				boolean flag = true;//1.假设打 -
				for(int k=0;k<t.cells.length;k++){
					if(i==t.cells[k].row && j==t.cells[k].col){
						flag = false;//2.改为打*
						break;
					}
				}
			if(flag){//3.判断结论
				System.out.print("- ");
			}else{
				System.out.print("* ");
			}
		}
		System.out.println();	
		}
	}

}
