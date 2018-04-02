package SudokuSolver;

public class SudokuMain {

	public static void main(String[] args) {
		new SudokuView();

	}

	private SudokuStorage sudoku;

	public SudokuMain(int[] args, SudokuView view) {
		sudoku = new SudokuStorage();

		if (!sudoku.insert(args)) {
			view.wrongInputMessage();

		} else {
			new Solve(sudoku, view);
		}

		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 * @return
	 */

}
