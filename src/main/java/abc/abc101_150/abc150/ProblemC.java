package abc.abc101_150.abc150;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			List<Integer> p = IntStream.range(0, n).map(i -> scanner.nextInt() - 1).boxed()
					.collect(Collectors.toList());
			List<Integer> q = IntStream.range(0, n).map(i -> scanner.nextInt() - 1).boxed()
					.collect(Collectors.toList());
			System.out.println(Math.abs(calcOrder(p) - calcOrder(q)));
		}
	}

	/**
	 * 数列のリストの順番を計算する
	 *
	 * @param p 数列のリスト
	 * @return 数列のリストの順番
	 */
	private static int calcOrder(List<Integer> p) {
		if (p.size() == 1) {
			return 0;
		}
		return p.get(0) * frac(p.size() - 1) + calcOrder(subList(p));
	}

	/**
	 * 数列のリストの最初の文字を削除して、新しいリストを生成する
	 *
	 * @param list 数列のリスト
	 * @return 新しいリスト
	 */
	private static List<Integer> subList(List<Integer> list) {
		int first = list.get(0);
		list.remove(0);
		for (int i = 0; i < list.size(); i++) {
			Integer number = list.get(i);
			list.set(i, (number > first) ? number - 1 : number);
		}
		return list;
	}

	/**
	 * nの階乗を計算する
	 *
	 * @param n
	 * @return nの階乗
	 */
	private static int frac(int n) {
		return (n <= 0) ? 1 : IntStream.rangeClosed(1, n).reduce(1, (m, i) -> m * i);
	}
}
