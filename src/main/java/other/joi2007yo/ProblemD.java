package other.joi2007yo;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			int[] cards = IntStream.rangeClosed(1, 2 * n).toArray();
			IntStream.range(0, m).forEach(i -> {
				int k = scanner.nextInt();
				if (0 == k) {
					shuffle(cards);
				} else {
					cut(cards, k);
				}
			});
			Arrays.stream(cards).forEach(System.out::println);
		}
	}

	/**
	 * カードをカットする
	 * 
	 * @param cards カードを表す配列
	 * @param k     カットする位置
	 */
	private static void cut(int[] cards, int k) {
		int n = cards.length;
		int[] array = Arrays.copyOf(cards, n);
		System.arraycopy(array, k, cards, 0, n - k);
		System.arraycopy(array, 0, cards, n - k, k);
	}

	/**
	 * カードをシャッフルする
	 * 
	 * @param cards カードを表す配列
	 */
	private static void shuffle(int[] cards) {
		int n = cards.length;
		int[] array = Arrays.copyOf(cards, n);
		IntStream.range(0, n / 2).forEach(i -> {
			cards[2 * i] = array[i];
			cards[2 * i + 1] = array[n / 2 + i];
		});
	}
}
