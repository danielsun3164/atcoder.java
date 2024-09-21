package other.math_and_algorithm;

import java.util.Scanner;

public class Problem058 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long n = scanner.nextLong(), x = Math.abs(scanner.nextLong()), y = Math.abs(scanner.nextLong());
			System.out.println(((n >= x + y) && (0L == (1 & (n - Math.abs(x) - y)))) ? "Yes" : "No");
		}
	}
}
