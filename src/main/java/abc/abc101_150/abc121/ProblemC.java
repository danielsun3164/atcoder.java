package abc.abc101_150.abc121;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			List<Store> list = IntStream.range(0, n).mapToObj(i -> new Store(scanner.nextInt(), scanner.nextInt()))
					.sorted((x, y) -> x.price - y.price).collect(Collectors.toList());
			long sum = 0;
			for (Store store : list) {
				if (store.amount >= m) {
					sum += (long) store.price * m;
					break;
				} else {
					sum += (long) store.price * store.amount;
					m -= store.amount;
				}
			}
			System.out.println(sum);
		}
	}

	/**
	 * 値段と本数を表すクラス
	 */
	private static class Store {
		int price;
		int amount;

		Store(int price, int amount) {
			this.price = price;
			this.amount = amount;
		}
	}
}
