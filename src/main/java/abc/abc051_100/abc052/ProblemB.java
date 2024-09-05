package abc.abc051_100.abc052;

import java.util.Scanner;

public class ProblemB {

	private static final char INCREASE = 'I';
	private static final char DECREASE = 'D';

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			// n
			scanner.nextInt();
			char[] s = scanner.next().toCharArray();
			int max = 0, x = 0;
			for (char c : s) {
				switch (c) {
				case INCREASE -> {
					x++;
					max = Math.max(x, max);
				}
				case DECREASE -> x--;
				}
			}
			System.out.println(max);
		}
	}
}
