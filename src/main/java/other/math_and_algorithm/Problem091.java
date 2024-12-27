package other.math_and_algorithm;

import java.util.Scanner;

public class Problem091 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), x = scanner.nextInt(), answer = 0;
			for (int a = 1; a <= n; a++) {
				for (int b = a + 1; b <= n; b++) {
					int c = x - a - b;
					if ((c > b) && (c <= n)) {
						answer++;
					}
				}
			}
			System.out.println(answer);
		}
	}
}
