package abc.abc014;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), x = scanner.nextInt();
			int[] a = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			System.out.println(IntStream.range(0, n).filter(i -> (1 == (1 & (x >> i)))).map(i -> a[i]).sum());
		}
	}
}
