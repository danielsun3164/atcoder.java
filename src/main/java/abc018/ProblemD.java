package abc018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			int p = scanner.nextInt();
			int q = scanner.nextInt();
			int r = scanner.nextInt();
			@SuppressWarnings("unchecked")
			List<Boy>[] lists = new List[n];
			IntStream.range(0, n).forEach(i -> lists[i] = new ArrayList<>());
			IntStream.range(0, r)
					.forEach(i -> lists[scanner.nextInt() - 1].add(new Boy(scanner.nextInt() - 1, scanner.nextInt())));
			System.out.println(IntStream.range(1, (int) Math.pow(2.0, n)).filter(i -> (p == Integer.bitCount(i)))
					.map(i -> getMaxHappiness(i, lists, m, q)).max().getAsInt());
		}
	}

	/**
	 * @param k     女の子を表す数字。2進数で1となる桁では女の子がいる
	 * @param lists 女の子と男の子＋幸福度の関係リスト
	 * @param m     男の子の数
	 * @param q     選ぶ男の子の数
	 * @return 最大幸福度
	 */
	private static int getMaxHappiness(int k, List<Boy>[] lists, int m, int q) {
		int[] hapinesses = new int[m];
		IntStream.range(0, m).forEach(i -> hapinesses[i] = 0);
		IntStream.range(0, lists.length).filter(i -> 1 == ((k >> i) & 1))
				.forEach(i -> lists[i].forEach(boy -> hapinesses[boy.boy] += boy.happiness));
		return Arrays.stream(hapinesses).sorted().skip(m - q).sum();
	}

	/**
	 * 男の子と幸福度を格納するクラス
	 */
	private static class Boy {
		/** 男の子 */
		int boy;
		/** 幸福度 */
		int happiness;

		Boy(int boy, int happiness) {
			super();
			this.boy = boy;
			this.happiness = happiness;
		}
	}
}
