package abc.abc201_250.abc222;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), p = scanner.nextInt();
			System.out.println(IntStream.range(0, n).map(i -> scanner.nextInt()).filter(ai -> ai < p).count());
		}
	}
}
