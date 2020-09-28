package other.joi2006yo;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			@SuppressWarnings("unused")
			int n = scanner.nextInt(), m = scanner.nextInt();
			Deque<Integer> aQue = new ArrayDeque<>(), bQue = new ArrayDeque<>(), cQue = new ArrayDeque<>();
			IntStream.range(0, scanner.nextInt()).forEach(i -> aQue.add(scanner.nextInt()));
			IntStream.range(0, scanner.nextInt()).forEach(i -> bQue.add(scanner.nextInt()));
			IntStream.range(0, scanner.nextInt()).forEach(i -> cQue.add(scanner.nextInt()));
			int min = Math.min(fa(aQue, bQue, cQue), fc(aQue, bQue, cQue));
			System.out.println((min <= m) ? min : -1);
		}
	}

	/**
	 * すべてのカップをAに移動した場合のステップ数を計算する
	 * 
	 * @param aQue Aにあるカップの一覧
	 * @param bQue Bにあるカップの一覧
	 * @param cQue Cにあるカップの一覧
	 * @return すべてのカップをAに移動した場合のステップ数
	 */
	private static int fa(Deque<Integer> aQue, Deque<Integer> bQue, Deque<Integer> cQue) {
		if (bQue.isEmpty() && cQue.isEmpty()) {
			return 0;
		}
		int aMin = (aQue.isEmpty()) ? Integer.MAX_VALUE : aQue.peek();
		int bMin = (bQue.isEmpty()) ? Integer.MAX_VALUE : bQue.peek();
		int cMin = (cQue.isEmpty()) ? Integer.MAX_VALUE : cQue.peek();
		int min = min(aMin, bMin, cMin), result = 0;
		if (aMin == min) {
			int temp = aQue.poll();
			result = fa(aQue, bQue, cQue);
			aQue.addFirst(temp);
		} else if (bMin == min) {
			int temp = bQue.poll();
			result = fc(aQue, bQue, cQue) + (int) Math.pow(3, aQue.size() + bQue.size() + cQue.size());
			bQue.addFirst(temp);
		} else {
			int temp = cQue.poll();
			result = fa(aQue, bQue, cQue) + 2 * (int) Math.pow(3, aQue.size() + bQue.size() + cQue.size());
			cQue.addFirst(temp);
		}
		return result;
	}

	/**
	 * すべてのカップをCに移動した場合のステップ数を計算する
	 * 
	 * @param aQue Aにあるカップの一覧
	 * @param bQue Bにあるカップの一覧
	 * @param cQue Cにあるカップの一覧
	 * @return すべてのカップをCに移動した場合のステップ数
	 */
	private static int fc(Deque<Integer> aQue, Deque<Integer> bQue, Deque<Integer> cQue) {
		if (aQue.isEmpty() && bQue.isEmpty()) {
			return 0;
		}
		int aMin = (aQue.isEmpty()) ? Integer.MAX_VALUE : aQue.peek();
		int bMin = (bQue.isEmpty()) ? Integer.MAX_VALUE : bQue.peek();
		int cMin = (cQue.isEmpty()) ? Integer.MAX_VALUE : cQue.peek();
		int min = min(aMin, bMin, cMin), result = 0;
		if (aMin == min) {
			int temp = aQue.poll();
			result = fc(aQue, bQue, cQue) + 2 * (int) Math.pow(3, aQue.size() + bQue.size() + cQue.size());
			aQue.addFirst(temp);
		} else if (bMin == min) {
			int temp = bQue.poll();
			result = fa(aQue, bQue, cQue) + (int) Math.pow(3, aQue.size() + bQue.size() + cQue.size());
			bQue.addFirst(temp);
		} else {
			int temp = cQue.poll();
			result = fc(aQue, bQue, cQue);
			cQue.addFirst(temp);
		}
		return result;
	}

	/**
	 * 配列の最小値を返す
	 * 
	 * @param a 配列
	 * @return 配列の最小値
	 */
	private static int min(int... a) {
		return Arrays.stream(a).min().getAsInt();
	}
}
