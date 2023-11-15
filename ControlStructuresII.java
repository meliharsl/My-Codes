package pgdp.math;

public class ControlStructuresII {
	public static void main(String[] args) {
		// Zum Testen
		printAsciiCodesFor((char) 60, 5);
	}

	public static int threeAndSeven(int n) {
		// TODO
		int sum = 0;
		if (n < 0) {
			System.out.println("Eingabe muss größer oder gleich 0 sein!");
			return -1;
		} else {
			for (int i = 1; i <= n; i++) {
				if (i % 3 == 0 || i % 7 == 0) {
					sum += i;
				}
			}
		}
		return sum;
	}

	public static void printAsciiCodesFor(char start, int count) {
		// TODO
		for (int i = 1; i <= count; i++) {
			System.out.println("Der ASCII-Code von " + "'" + start + "'" + " ist " + (int) start + ".");
			start++;
		}
	}

	public static void printMultiplicationTable(int n) {
		// TODO
		int columns = 1;
		int rows = 1;
		String tab = "\t";
		System.out.print(tab);
		for (; columns <= n; columns++) {
			System.out.print(columns + "\t");
		}
		String lineBreak = "\n";
		System.out.println(lineBreak);

		for (; rows <= n; rows++) {
			System.out.print(rows + "\t");
			for (int i = 1; i <= n; i++) {
				if (i < n) {
					System.out.print(rows * i + "\t");
				} else if (i == n) {
					System.out.print(rows * i);
				}
			}
			System.out.println(lineBreak);
		}
	}

	public static void printPrimesUpTo(int n) {
		// TODO
		for (int i = 2; i <= n; i++){
			boolean isPrime = true;
			for (int k = 2; k<i; k++) {
				if (i % k == 0) {
					isPrime = false;
					break;
				}
			}
				if (isPrime == true) {
					System.out.print(i + " ");
				}
			}
		}
	}