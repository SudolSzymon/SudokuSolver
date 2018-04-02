package SudokuSolver;

import java.util.ArrayList;

import javafx.util.Pair;

public class Solve {
	private static final Exception IndexOutOfBoundsException = new java.lang.IndexOutOfBoundsException(
			"Error in input couldn't solve");
	private ArrayList<Pair<Integer, Integer>> emptySpaces = new ArrayList<>();
	private SudokuStorage sudoku;
	private SudokuView view;

	public Solve(SudokuStorage sudoku, SudokuView view) {
		this.sudoku = sudoku;
		emptySpaces = sudoku.getEmptySpaces();
		this.view = view;

		solve();
		// TODO Auto-generated constructor stub
	}

	private void solve() {

		int i = 0;
		while (i >= 0 && i < emptySpaces.size()) {

			Pair<Integer, Integer> current = emptySpaces.get(i);

			int value = sudoku.get(current.getKey(), current.getValue()) + 1;
			sudoku.remove(current.getKey(), current.getValue());
			while (value < 10) {
				if (sudoku.tryAdd(current.getKey(), current.getValue(), value)) {
					break;
				}
				value++;
			}
			if (value == 10) {

				i -= 2;

			}

			i++;
		}
		// TODO Auto-generated method stub
		view.update(sudoku.getPrint());
	}

}
