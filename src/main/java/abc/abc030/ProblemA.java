package abc.abc030;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt(), b = scanner.nextInt(), c = scanner.nextInt(), d = scanner.nextInt();
			// 高橋の勝率
			int takahashi = b * c;
			// 青木の勝率
			int aoki = d * a;
			if (aoki == takahashi) {
				System.out.println("DRAW");
			} else if (aoki > takahashi) {
				System.out.println("AOKI");
			} else {
				System.out.println("TAKAHASHI");
			}
		}
	}
}
