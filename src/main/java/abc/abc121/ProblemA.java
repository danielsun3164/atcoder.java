package abc.abc121;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int H = scanner.nextInt(), W = scanner.nextInt();
			int h = scanner.nextInt(), w = scanner.nextInt();
			System.out.println((H - h) * (W - w));
		}
	}
}
