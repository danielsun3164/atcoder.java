package abc.abc051_100.abc068;

import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int result = 1;
			while ((result << 1) <= n) {
				result <<= 1;
			}
			System.out.println(result);
		}
	}
}
