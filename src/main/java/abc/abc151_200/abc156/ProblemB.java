package abc.abc151_200.abc156;

import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt(), d = 0;
			while (n > 0) {
				n /= k;
				d++;
			}
			System.out.println(d);
		}
	}
}
