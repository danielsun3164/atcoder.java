package abc.abc001_050.abc023;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] x = scanner.next().toCharArray();
			System.out.println(IntStream.range(0, x.length).map(i -> x[i] - '0').sum());
		}
	}
}
