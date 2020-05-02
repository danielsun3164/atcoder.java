package abc096;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説どおりに作成したソースコード
 */
public class ProblemD {

	/** 最大数 */
	static final int MAX = 55555;

	/** 合計を計算する数字の数 */
	static final int N = 5;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			// MAXまでのすべての素数を計算
			boolean[] isPrime = new boolean[MAX + 1];
			Arrays.fill(isPrime, true);
			isPrime[0] = isPrime[1] = false;
			IntStream.range(2, MAX).forEach(i -> {
				if (isPrime[i]) {
					for (int j = i * 2; j <= MAX; j += i) {
						isPrime[j] = false;
					}
				}
			});
			@SuppressWarnings("unchecked")
			List<Integer>[] lists = new List[N];
			IntStream.range(0, N).forEach(i -> lists[i] = new ArrayList<>());
			IntStream.range(2, MAX).filter(i -> isPrime[i]).forEach(i -> lists[i % N].add(i));
			int index = IntStream.range(1, N).filter(i -> lists[i].size() >= n).findFirst().getAsInt();
			IntStream.range(0, n).forEach(i -> System.out.println(lists[index].get(i)));
		}
	}
}
