package pgdp.math;

public class ControlStructuresI {
	public static void main(String[] args) {
		// Für Experimente und für's Testen der Funktionen
		printCollatz(4);
	}

	public static void printCollatz(int n) {
		// TODO
		if (n <= 0) {
			System.out.println("Eingabe muss größer als 0 sein!");
			return;
		}

		int counter = 0;
		while (n != 1) {
			if (n % 2 == 0) {
				System.out.print(n + " ");
				n /= 2;
				counter++;
			} else if (n % 2 == 1) {
				System.out.print(n + " ");
				n = n * 3 + 1;
				counter++;
			}
		}
		System.out.println(n);
		counter++;
		System.out.println("Länge: " + counter);
	}

	public static void printPowersOfTwoUpTo(int n) {
		// TODO
		if (n <= 0) {
			System.out.println("Eingabe muss größer als 0 sein!");
			return;
		}

		for (int i = 1; i <= n; i *= 2) {
			if (i == 1) {
				System.out.print(i);
			} else {
				System.out.print(" " + i);
			}
		}
	}

	public static void printTriangle(int sideLength) {
		// TODO
		if (sideLength <= 0) {
			System.out.println("Eingabe muss größer als 0 sein!");
		}

		String stern = "*";
		String newLine = "";
		for (int i = 1; i <= sideLength; i++) {
			for (int j = sideLength; i <= j; j--) {
				System.out.print(stern);
			}
			System.out.println(newLine);
		}
	}

	public static int calculateNumberOfDigits(int n) {
		// TODO
		int numberOfDigits = 0;
		int tempn = n;

		if (n == 0) {
			return 0;
		}
		while (n > 0) {
			n /= 10;
			numberOfDigits++;
		}
		return numberOfDigits;
	}

	public static int reverseNumber(int n) {
		// TODO
		int kalan = 0;
		int reversedNumber = 0;
		while (n > 0) {
			kalan = n % 10;
			reversedNumber *= 10;
			reversedNumber += kalan;
			n /= 10;
		}
		return reversedNumber;
	}

	public static boolean isPalindrome(int n) {
		// TODO
		if (n == reverseNumber(n)) {
			return true;
		} else {
			return false;
		}
	}

}