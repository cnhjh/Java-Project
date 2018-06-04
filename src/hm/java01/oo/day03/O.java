package hm.java01.oo.day03;

public class O extends Tetromino {
	// Cell[] cells;
	O() {
		this(0, 0);
	}

	O(int row, int col) {
		// cells = new Cell[4];//创建格子数组对象
		this.cells[0] = new Cell(row, col);
		this.cells[1] = new Cell(row + 1, col);
		this.cells[2] = new Cell(row, col + 1);
		this.cells[3] = new Cell(row + 1, col + 1);
	}

}
