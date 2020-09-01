package abc.abc097;

import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int x = scanner.nextInt(), max = 1;
			for (int i = 2; i <= (int) Math.sqrt(x); i++) {
				int pow = i * i;
				while (pow <= x) {
					max = Math.max(pow, max);
					pow *= i;
				}
			}
			System.out.println(max);
		}
	}
}
