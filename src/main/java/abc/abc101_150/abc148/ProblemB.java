package abc.abc101_150.abc148;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			char[] s = scanner.next().toCharArray(), t = scanner.next().toCharArray();
			StringBuilder sb = new StringBuilder();
			IntStream.range(0, n).forEach(i -> sb.append(s[i]).append(t[i]));
			System.out.println(sb.toString());
		}
	}
}
