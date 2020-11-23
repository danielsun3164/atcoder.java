package other.joi2007yo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProblemE {

	/** 合格 */
	private static final int OK = 1;
	/** 不合格 */
	private static final int NG = 0;
	/** 決まらない */
	private static final int UNKNOWN = 2;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt(), b = scanner.nextInt(), c = scanner.nextInt(), n = scanner.nextInt();
			int[] status = new int[a + b + c];
			Arrays.fill(status, UNKNOWN);
			@SuppressWarnings("unchecked")
			List<List<Integer>>[] lists = new List[a + b + c];
			IntStream.range(0, a + b + c).forEach(i -> lists[i] = new ArrayList<>());
			for (int i = 0; i < n; i++) {
				int[] l = IntStream.range(0, 3).map(j -> scanner.nextInt() - 1).toArray();
				int r = scanner.nextInt();
				if (OK == r) {
					Arrays.stream(l).forEach(j -> ok(j, status, lists));
				} else {
					List<Integer> list = Arrays.stream(l).filter(j -> OK != status[j]).boxed()
							.collect(Collectors.toList());
					if (1 == list.size()) {
						status[list.get(0)] = NG;
					} else {
						list.stream().forEach(j -> lists[j].add(list));
					}
				}
			}
			Arrays.stream(status).forEach(System.out::println);
		}
	}

	/**
	 * 部品aを合格にする
	 * 
	 * @param a      部品
	 * @param status ステータスの一覧
	 * @param lists  決まらない部品一覧の一覧
	 */
	private static void ok(int a, int[] status, List<List<Integer>>[] lists) {
		if (OK != status[a]) {
			status[a] = OK;
			// aを含む不合格の組合せを処理する
			lists[a].forEach(list -> {
				list.remove(Integer.valueOf(a));
				if (1 == list.size()) {
					status[list.get(0)] = NG;
				}
			});
		}
	}
}
