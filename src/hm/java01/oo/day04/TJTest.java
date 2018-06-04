package hm.java01.oo.day04;

public class TJTest {
	public static void main(String[] args) {
		T t = new T(2,5);  
		t.print();
		J j = new J(1,4);  
		j.print();

	}
public static void printWall(Tetromino t) {
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 10; j++) {

				boolean flag = true;
				for (int k = 0; k < t.cells.length; k++) {//

					// for(int i=0;i<t.cells.row.length;i++){
					// for(int j=0;j<t.cells.col.length;j++){
					// if(cells[i].row==sells[k].row &&
					// cells[j].col==sells[k].col ){
					if (i == t.cells[k].row && j == t.cells[k].col) {
						flag = false;
						break;
					}
				}

				if (flag) {
					System.out.print("- ");
				} else {
					System.out.print("* ");

				}

			}
			System.out.println();
	   }

    }
}
