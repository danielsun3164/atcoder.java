package abc.abc151_200.abc172;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] s = scanner.next().toCharArray(), t = scanner.next().toCharArray();
			System.out.println(IntStream.range(0, s.length).filter(i -> s[i] != t[i]).count());
		}
	}
}
