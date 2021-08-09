package abc.abc101_150.abc147;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] s = scanner.next().toCharArray();
			System.out.println(IntStream.range(0, s.length / 2).filter(i -> s[i] != s[s.length - 1 - i]).count());
		}
	}
}
