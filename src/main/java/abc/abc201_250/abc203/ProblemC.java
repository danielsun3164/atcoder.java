package abc.abc201_250.abc203;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long k = scanner.nextLong();
			Data[] datas = IntStream.range(0, n).mapToObj(i -> new Data(scanner.nextLong(), scanner.nextLong()))
					.sorted((x, y) -> Long.compare(x.a, y.a)).toArray(Data[]::new);
			for (int i = 0; i < n; i++) {
				if (k < datas[i].a) {
					break;
				}
				k += datas[i].b;
			}
			System.out.println(k);
		}
	}

	/**
	 * a,bを格納するクラス
	 */
	private static class Data {
		long a, b;

		Data(long a, long b) {
			super();
			this.a = a;
			this.b = b;
		}
	}
}
