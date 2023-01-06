package other.typical90;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Problem014 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] a = IntStream.range(0, n).map(i -> scanner.nextInt()).sorted().toArray();
			int[] b = IntStream.range(0, n).map(i -> scanner.nextInt()).sorted().toArray();
			System.out.println(IntStream.range(0, n).mapToLong(i -> Math.abs(a[i] - b[i])).sum());
		}
	}
}
