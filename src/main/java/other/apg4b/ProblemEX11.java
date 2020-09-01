package other.apg4b;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemEX11 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int a = scanner.nextInt();
			String[] op = new String[n];
			int[] b = new int[n];
			IntStream.range(0, n).forEach(i -> {
				op[i] = scanner.next();
				b[i] = scanner.nextInt();
			});
			for (int i = 0; i < n; i++) {
				switch (op[i]) {
				case "+":
					a += b[i];
					break;
				case "-":
					a -= b[i];
					break;
				case "*":
					a *= b[i];
					break;
				case "/":
				default:
					if (0 == b[i]) {
						System.out.println("error");
						return;
					}
					a /= b[i];
					break;
				}
				System.out.println((i + 1) + ":" + a);
			}
		}
	}
}
