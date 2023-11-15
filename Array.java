package pgdp.array;

public class Array {
	public static int[][] minsAndMaxs(int[][] a) {
		// TODO
		int[][] outerArray = new int[a.length][2];

		for (int i = 0; i < a.length; i++) {
			int min = a[i][0];
			int max = a[i][0];
			for (int j = 0; j < a[i].length - 1; j++) {

				if (a[i][j + 1] > max) {
					max = a[i][j + 1];
				}

				if (a[i][j + 1] < min) {
					min = a[i][j + 1];
				}
			}
			outerArray[i][1] = max;
			outerArray[i][0] = min;
		}

		return outerArray;
	}

	// columns = a[0].length , rows = a.length
	public static int[][] transpose(int[][] a) {
		// TODO
		int[][] transposed2dArray = new int[a[0].length][a.length];
		for (int i = 0; i < a.length; i++) {
			if (a[i].length != a[0].length) {
				return null;
			}
		}

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				transposed2dArray[j][i] = a[i][j];
			}

		}
		return transposed2dArray;
	}

	public static int[] linearize(int[][] a) {
		// TODO
		int integerCount = 0;
		for (int k = 0; k < a.length; k++) {
			for (int n = 0; n < a[k].length; n++) {
				integerCount++;
			}
		}

		int[] oneDimensionalNewArray = new int[integerCount];

		int currentIndex = 0;
		for (int i = 0; i < a.length; i++) {
			for (int m = 0; m < a[i].length; m++) {
				oneDimensionalNewArray[currentIndex] = a[i][m];
				currentIndex++;
			}
		}
		return oneDimensionalNewArray;
	}

	public static boolean crossword(char[][] letterGrid, char[] word) {
		for (int i = 0; i < letterGrid.length; i++) {
			//square olmasını isteseydin "letterGrid[i].length != letterGrid[0].length || letterGrid.length != letterGrid[0].length" yazardın mesela
			if (letterGrid[i].length != letterGrid[0].length) {
				return false;
			}
		}

		for (int i = 0; i < letterGrid.length; i++) {
			for (int j = 0; j < letterGrid[i].length; j++) {
				// Check horizontally, vertically, and diagonally if the first character matches
				if (word[0] == letterGrid[i][j]) {
					if (checkHorizontal(letterGrid, word, i, j) ||
							checkVertical(letterGrid, word, i, j) ||
							checkDiagonal(letterGrid, word, i, j)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	private static boolean checkHorizontal(char[][] letterGrid, char[] word, int row, int col) {
		// Check if the word fits in the grid horizontally
		if (col + word.length > letterGrid[row].length) return false;
		for (int i = 0; i < word.length; i++) {
			if (letterGrid[row][col + i] != word[i]) return false;
		}
		return true;
	}

	private static boolean checkVertical(char[][] letterGrid, char[] word, int row, int col) {
		// Check if the word fits in the grid vertically
		if (row + word.length > letterGrid.length) return false;
		for (int i = 0; i < word.length; i++) {
			if (letterGrid[row + i][col] != word[i]) return false;
		}
		return true;
	}

	private static boolean checkDiagonal(char[][] letterGrid, char[] word, int row, int col) {
		// Check if the word fits in the grid diagonally
		if (row + word.length > letterGrid.length || col + word.length > letterGrid[row].length) return false;
		for (int i = 0; i < word.length; i++) {
			if (letterGrid[row + i][col + i] != word[i]) return false;
		}
		return true;
	}
}