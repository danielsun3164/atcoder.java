package abc.abc171;

import java.util.Scanner;

public class ProblemE {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] a = new int[n];
			int xorSum = 0;
			for (int i = 0; i < n; i++) {
				a[i] = scanner.nextInt();
				xorSum ^= a[i];
			}
			System.out.print((xorSum ^ a[0]));
			for (int i = 1; i < n; i++) {
				System.out.print(" " + (xorSum ^ a[i]));
			}
			System.out.println();
		}
	}
}
