package abc.abc151_200.abc194;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			Data[] a = new Data[n], b = new Data[n];
			IntStream.range(0, n).forEach(i -> {
				a[i] = new Data(scanner.nextInt(), i);
				b[i] = new Data(scanner.nextInt(), i);
			});
			Arrays.sort(a, (x, y) -> Integer.compare(x.value, y.value));
			Arrays.sort(b, (x, y) -> Integer.compare(x.value, y.value));
			if (a[0].index != b[0].index) {
				System.out.println(Math.max(a[0].value, b[0].value));
			} else {
				System.out.println(min(Math.max(a[0].value, b[1].value), Math.max(a[1].value, b[0].value),
						a[0].value + b[0].value));
			}
		}
	}

	private static int min(int... value) {
		return Arrays.stream(value).min().getAsInt();
	}

	private static class Data {
		int value, index;

		Data(int value, int index) {
			super();
			this.value = value;
			this.index = index;
		}
	}
}
