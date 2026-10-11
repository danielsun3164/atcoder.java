package abc.abc201_250.abc244;

import java.util.Scanner;

public class ProblemB {

	private static final int[] XS = { 1, 0, -1, 0 };
	private static final int[] YS = { 0, -1, 0, 1 };
	private static final char TURN = 'R';

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			// n
			scanner.nextInt();
			char[] t = scanner.next().toCharArray();
			int x = 0, y = 0, idx = 0;
			for (char c : t) {
				if (TURN == c) {
					idx = (idx + 1) % XS.length;
				} else {
					x += XS[idx];
					y += YS[idx];
				}
			}
			System.out.println(x + " " + y);
		}
	}
}
