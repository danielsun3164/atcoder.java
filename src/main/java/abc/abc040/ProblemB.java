package abc.abc040;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			System.out
					.println(IntStream.rangeClosed(1, (int) Math.sqrt(n)).map(i -> n / i - i + n % i).min().getAsInt());
		}
	}
}
