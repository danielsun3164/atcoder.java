package abc.abc115;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			StringBuilder sb = new StringBuilder("Christmas");
			IntStream.range(0, 25 - n).forEach(i -> sb.append(" Eve"));
			System.out.println(sb.toString());
		}
	}
}
