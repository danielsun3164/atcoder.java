package abc.abc001_050.abc035;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int w = scanner.nextInt(), h = scanner.nextInt();
			System.out.println((w / 4 == h / 3) ? "4:3" : "16:9");
		}
	}
}
