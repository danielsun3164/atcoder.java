package other.typical90;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Scanner;

/**
 * 解説通りに実装したソースコード
 */
public class Problem058 {

	/** 処理する最大数字 */
	private static final int MAX = 100_000;
	/** 10 */
	private static final int TEN = 10;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long k = scanner.nextLong();
			BitSet bitSet = new BitSet(MAX);
			List<Integer> answers = new ArrayList<>();
			while (!bitSet.get(n)) {
				answers.add(n);
				bitSet.set(n, true);
				n = process(n);
			}
			int pre = answers.indexOf(n), size = answers.size() - pre;
			System.out.println(answers.get((int) ((k - pre) % size + pre)));
		}
	}

	/**
	 * ボタンAを押すときの処理を行う
	 *
	 * @param n 現在表示される数字
	 * @return ボタンAを押した後に表示される数字
	 */
	private static int process(int n) {
		int result = n;
		while (n > 0) {
			result += n % TEN;
			n /= TEN;
		}
		return result % MAX;
	}
}
