package abc.abc201_250.abc213;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			System.out.println(IntStream.range(0, n).mapToObj(i -> new Data(i + 1, scanner.nextInt()))
					.sorted((x, y) -> Integer.compare(y.value, x.value)).skip(1).findFirst().get().index);
		}
	}

	/**
	 * indexとvalueを格納するクラス
	 */
	private static class Data {
		int index, value;

		Data(int index, int value) {
			super();
			this.index = index;
			this.value = value;
		}
	}
}
