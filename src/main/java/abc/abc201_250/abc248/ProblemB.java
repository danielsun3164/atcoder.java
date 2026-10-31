package abc.abc201_250.abc248;

import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long a = scanner.nextLong(), b = scanner.nextLong(), k = scanner.nextLong();
			int answer = 0;
			while (a < b) {
				a *= k;
				answer++;
			}
			System.out.println(answer);
		}
	}
}
