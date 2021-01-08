package abc.abc151_200.abc185;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemA {

	private static final int N = 4;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println(IntStream.range(0, N).map(i -> scanner.nextInt()).min().getAsInt());
		}
	}
}
