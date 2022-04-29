package abc.abc201_250.abc215;

import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long n = scanner.nextLong(), now = 1L;
			int k = 0;
			while (now <= n) {
				now <<= 1;
				k++;
			}
			System.out.println(k - 1);
		}
	}
}
