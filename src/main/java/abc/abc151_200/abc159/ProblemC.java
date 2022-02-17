package abc.abc151_200.abc159;

import java.util.Scanner;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int l = scanner.nextInt();
			double ll = l / 3.0d;
			System.out.println(ll * ll * ll);
		}
	}
}
