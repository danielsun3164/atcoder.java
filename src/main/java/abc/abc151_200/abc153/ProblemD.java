package abc.abc151_200.abc153;

import java.util.Scanner;

public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long h = scanner.nextLong(), answer = 0L, count = 1L;
			while (h > 0) {
				answer += count;
				h >>= 1;
				count <<= 1;
			}
			System.out.println(answer);
		}
	}
}
