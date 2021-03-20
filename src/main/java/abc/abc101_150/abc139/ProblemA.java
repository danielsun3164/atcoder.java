package abc.abc101_150.abc139;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] s = scanner.next().toCharArray(), t = scanner.next().toCharArray();
			System.out.println(IntStream.range(0, s.length).filter(i -> s[i] == t[i]).count());
		}
	}
}
