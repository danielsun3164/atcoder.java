package abc076;

import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int k = scanner.nextInt();
			int result = 1;
			for (int i = 0; i < n; i++) {
				result = Math.min(result * 2, result + k);
			}
			System.out.println(result);
		}
	}
}
