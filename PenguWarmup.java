package pgdp.warmup;

public class PenguWarmup {

	protected PenguWarmup() {
		throw new UnsupportedOperationException();
	}

	public static void penguInfoOut(int penguin) {
		// TODO
		if (penguin < 0){
			System.out.println("Penguin " + penguin + " is not a known penguin!");
		}
		else if (penguin % 2 == 0){
			System.out.println("Penguin: " + penguin);
			System.out.println("This penguin is a male.");
		}

		else{
			System.out.println("Penguin: " + penguin);
			System.out.println("This penguin is a female.");
		}
	}

	public static int penguEvolution(int penguin, int years) {
		// TODO
		for (int i = 0; i <= years; ) {
			if (penguin != 1 && penguin != 0 && (penguin & (penguin - 1)) == 0) {
				penguin = 1;
				i++;
			} else if (penguin % 2 == 1 && penguin % 7 == 0) {
				i += 6;
			} else if (penguin % 2 == 0) {
				penguin /= 2;
				i++;
			} else {
				penguin = 3 * penguin + 1;
				i++;
			}
		}
			return penguin;
	}

	public static int penguSum(int penguin) {
		int sum = 0;
		while (penguin != 0){
			int sonHane = penguin % 10;
			sum = sum + sonHane;
			penguin /= 10;
		}
	return sum;
	}

	public static long penguPermutation(long n, long k) {
		// TODO
		long sum = 1;
		for (long i = k + 1; i <= n; i++) {
			sum *= i;
		}
		return sum;
	}

	public static long penguPowers(int x, int i) {
		// TODO
		long result = 1;
		while (i-- > 0){
			long temporaryResult = 0;
			long temporaryX = x;
			while (temporaryX-- > 0){
				temporaryResult += result;
			}
			result = temporaryResult;
		}
	return result;
	}

	/*	Die Inhalte der main()-Methode beeinflussen nicht die Bewertung dieser Aufgabe
	 *	(es sei denn natürlich, sie verursachen Compiler-Fehler).
	 */
	public static void main(String[] args) {

		// Here is a place for you to play around :)
		System.out.println(penguPowers(3,6));
	}

}
