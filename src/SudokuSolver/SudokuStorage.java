package SudokuSolver;

import java.util.ArrayList;
import java.util.HashSet;

import javafx.util.Pair;

public class SudokuStorage {
	private int[][] mainGrid = new int[9][9];
	private ArrayList<HashSet<Integer>> boxList = new ArrayList<>();
	private ArrayList<HashSet<Integer>> columnList = new ArrayList<>();
	private ArrayList<HashSet<Integer>> rowList = new ArrayList<>();

	private ArrayList<Pair<Integer, Integer>> emptySpaces = new ArrayList<>();

	public SudokuStorage() {
		for (int i = 0; i < 9; i++) {
			boxList.add(new HashSet<>());
			rowList.add(new HashSet<>());
			columnList.add(new HashSet<>());

		}
		// TODO Auto-generated constructor stub
	}

	public int get(Integer i, Integer j) {
		// TODO Auto-generated method stub
		return mainGrid[i][j];
	}

	public ArrayList<Pair<Integer, Integer>> getEmptySpaces() {
		// TODO Auto-generated method stub
		return emptySpaces;
	}

	public String getPrint() {
		String buffer = "";
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				buffer += mainGrid[i][j] + " ";
			}

		}
		return buffer;
	}

	public boolean insert(int[] args) {
		boolean result = true;
		int number = 0;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				number = args[i * 9 + j];
				mainGrid[i][j] = number;
				if (number > 9) {
					result = false;
				}
				if (rowList.get(i).contains(number) && number != 0) {
					result = false;
				}

				if (columnList.get(j).contains(number) && number != 0) {
					result = false;

				}
				if (i < 3 && j < 3) {
					if (boxList.get(0).contains(number) && number != 0) {
						result = false;
					} else {
						boxList.get(0).add(number);
					}
				} else if (i < 3 && j < 6) {
					if (boxList.get(1).contains(number) && number != 0) {
						result = false;

					} else {
						boxList.get(1).add(number);
					}
				} else if (i < 3 && j < 9) {
					if (boxList.get(2).contains(number) && number != 0) {
						result = false;

					} else {
						boxList.get(2).add(number);
					}
				} else if (i < 6 && j < 3) {
					if (boxList.get(3).contains(number) && number != 0) {
						result = false;

					} else {
						boxList.get(3).add(number);
					}
				} else if (i < 6 && j < 6) {
					if (boxList.get(4).contains(number) && number != 0) {
						result = false;

					} else {
						boxList.get(4).add(number);
					}
				} else if (i < 6 && j < 9) {
					if (boxList.get(5).contains(number) && number != 0) {
						result = false;

					} else {
						boxList.get(5).add(number);
					}
				} else if (i < 9 && j < 3) {
					if (boxList.get(6).contains(number) && number != 0) {
						result = false;

					}
					boxList.get(6).add(number);
				} else if (i < 9 && j < 6) {
					if (boxList.get(7).contains(number) && number != 0) {
						result = false;

					} else {
						boxList.get(7).add(number);
					}
				} else if (i < 9 && j < 9) {
					if (boxList.get(8).contains(number) && number != 0) {
						result = false;

					} else {
						boxList.get(8).add(number);
					}
				}
				rowList.get(i).add(number);
				columnList.get(j).add(number);
				if (number == 0) {

					emptySpaces.add(new Pair<>(i, j));
				}

			}

		}
		return result;
		// TODO Auto-generated method stub

	}

	public void remove(Integer i, Integer j) {
		int number = mainGrid[i][j];
		rowList.get(i).remove(number);
		columnList.get(j).remove(number);
		if (i < 3 && j < 3) {
			boxList.get(0).remove(number);
		} else if (i < 3 && j < 6) {
			boxList.get(1).remove(number);
		} else if (i < 3 && j < 9) {
			boxList.get(2).remove(number);
		} else if (i < 6 && j < 3) {
			boxList.get(3).remove(number);
		} else if (i < 6 && j < 6) {
			boxList.get(4).remove(number);
		} else if (i < 6 && j < 9) {
			boxList.get(5).remove(number);
		} else if (i < 9 && j < 3) {
			boxList.get(6).remove(number);
		} else if (i < 9 && j < 6) {
			boxList.get(7).remove(number);
		} else if (i < 9 && j < 9) {
			boxList.get(8).remove(number);
		}
		mainGrid[i][j] = 0;
	}

	public boolean tryAdd(int i, int j, int number) {
		boolean result = true;
		if (rowList.get(i).contains(number)) {
			result = false;
		}
		if (columnList.get(j).contains(number)) {
			result = false;
		}
		if (i < 3 && j < 3) {

			if (boxList.get(0).contains(number)) {
				result = false;
			}

		} else if (i < 3 && j < 6) {
			if (boxList.get(1).contains(number)) {
				result = false;
			}
		} else if (i < 3 && j < 9) {
			if (boxList.get(2).contains(number)) {
				result = false;
			}
		} else if (i < 6 && j < 3) {
			if (boxList.get(3).contains(number)) {
				result = false;
			}
		} else if (i < 6 && j < 6) {
			if (boxList.get(4).contains(number)) {
				result = false;
			}
		} else if (i < 6 && j < 9) {
			if (boxList.get(5).contains(number)) {
				result = false;
			}
		} else if (i < 9 && j < 3) {
			if (boxList.get(6).contains(number)) {
				result = false;
			}
		} else if (i < 9 && j < 6) {
			if (boxList.get(7).contains(number)) {
				result = false;
			}
		} else if (i < 9 && j < 9) {
			if (boxList.get(8).contains(number)) {
				result = false;
			}
		}
		if (result == true) {
			rowList.get(i).add(number);
			columnList.get(j).add(number);
			if (i < 3 && j < 3) {

				boxList.get(0).add(number);

			} else if (i < 3 && j < 6) {
				boxList.get(1).add(number);

			} else if (i < 3 && j < 9) {
				boxList.get(2).add(number);

			} else if (i < 6 && j < 3) {
				boxList.get(3).add(number);
			} else if (i < 6 && j < 6) {
				boxList.get(4).add(number);

			} else if (i < 6 && j < 9) {
				boxList.get(5).add(number);
			} else if (i < 9 && j < 3) {
				boxList.get(6).add(number);
			} else if (i < 9 && j < 6) {
				boxList.get(7).add(number);
			} else if (i < 9 && j < 9) {
				boxList.get(8).add(number);
			}
			mainGrid[i][j] = number;
		}

		return result;
	}
}
