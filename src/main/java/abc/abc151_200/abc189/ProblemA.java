package abc.abc151_200.abc189;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] c = scanner.next().toCharArray();
			System.out.println((IntStream.range(0, c.length).map(i -> c[i]).distinct().count() == 1) ? "Won" : "Lost");
		}
	}
}
