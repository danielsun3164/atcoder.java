package other.hhkb2020;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] p = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			boolean[] exists = new boolean[200001];
			Arrays.fill(exists, false);
			int index = 0;
			for (int i = 0; i < n; i++) {
				exists[p[i]] = true;
				while (exists[index]) {
					index++;
				}
				System.out.println(index);
			}
		}
	}
}
