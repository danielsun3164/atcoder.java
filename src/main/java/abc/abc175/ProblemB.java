package abc.abc175;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] l = new int[n];
			IntStream.range(0, n).forEach(i -> l[i] = scanner.nextInt());
			int count = 0;
			for (int i = 0; i < n - 2; i++) {
				for (int j = i + 1; j < n - 1; j++) {
					if (l[i] != l[j]) {
						for (int k = j + 1; k < n; k++) {
							if ((l[k] != l[i]) && (l[k] != l[j])) {
								if ((l[i] < (l[j] + l[k])) && (l[j] < (l[i] + l[k])) && (l[k] < (l[i] + l[j]))) {
									count++;
								}
							}
						}
					}
				}
			}
			System.out.println(count);
		}
	}
}
