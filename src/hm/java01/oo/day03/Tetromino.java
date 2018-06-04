package hm.java01.oo.day03;

public class Tetromino {
	Cell[] cells;

	Tetromino() {
		cells = new Cell[4];// 创建格子数组对象
	}

	void drop() { // 下落一格
		for (int i = 0; i < this.cells.length; i++)
			this.cells[i].row++;
	}

	void moveLeft() {// 左移一格
		for (int i = 0; i < this.cells.length; i++)
			this.cells[i].col--;
	}

	void moveRingh() {//右移一格
		for (int i = 0; i < this.cells.length; i++)
			this.cells[i].col++;
	}

	void print() {//输出行列号
		for (int i = 0; i < this.cells.length; i++) {
			String str = this.cells[i].getCellInfo();
			System.out.println(str);
		}

	}
}
