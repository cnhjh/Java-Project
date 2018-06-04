package hm.java01.oo.day03;

public class J extends Tetromino { // 格子数组

	J() {
		this(0, 0);
	}

	J(int row, int col) {

		this.cells[0] = new Cell(row, col);
		this.cells[1] = new Cell(row + 1, col);
		this.cells[2] = new Cell(row + 2, col);
		this.cells[3] = new Cell(row + 2, col - 1);
	}

}
