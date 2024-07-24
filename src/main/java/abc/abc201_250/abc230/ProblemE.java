package abc.abc201_250.abc230;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemE {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long n = scanner.nextLong();
			int q = (int) Math.sqrt(n);
			System.out.println(IntStream.rangeClosed(1, q).mapToLong(i -> (n / i - n / (i + 1)) * i).sum()
					+ IntStream.rangeClosed(1, (int) (n / (q + 1))).mapToLong(i -> n / i).sum());
		}
	}
}
