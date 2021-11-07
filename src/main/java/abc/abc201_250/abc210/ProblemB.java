package abc.abc201_250.abc210;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			char[] s = scanner.next().toCharArray();
			System.out.println((0 == (1 & IntStream.range(0, n).filter(i -> '1' == s[i]).findFirst().getAsInt())) ? "Takahashi" : "Aoki");
		}
	}
}
