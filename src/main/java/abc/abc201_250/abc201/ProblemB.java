package abc.abc201_250.abc201;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			System.out.println(IntStream.range(0, n).mapToObj(i -> new Data(scanner.next(), scanner.nextInt()))
					.sorted((a, b) -> Integer.compare(b.t, a.t)).skip(1).findFirst().get().s);
		}
	}

	/**
	 * s,tを保存するクラス
	 */
	private static class Data {
		String s;
		int t;

		Data(String s, int t) {
			super();
			this.s = s;
			this.t = t;
		}
	}
}
