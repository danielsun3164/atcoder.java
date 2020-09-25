package other.joi2006ho;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			for (int i = n; i > 0; i--) {
				List<Integer>[] lists = process(i, n - i);
				for (List<Integer> list : lists) {
					System.out.print(i + ((list.size() > 0) ? " " : ""));
					System.out.println(list.stream().map(String::valueOf).collect(Collectors.joining(" ")));
				}
			}
		}
	}

	/**
	 * 最大値と合計値で数列を作成する
	 * 
	 * @param max    数列の最大値
	 * @param remain 数列の合計値
	 * @return 最大値と合計値で作成された数列
	 */
	@SuppressWarnings("unchecked")
	private static List<Integer>[] process(int max, int remain) {
		// System.out.println("max=" + max + ", remain=" + remain);
		if (0 == remain) {
			return new List[] { Collections.<Integer>emptyList() };
		}
		List<List<Integer>> resultLists = new ArrayList<>();
		for (int i = Math.min(max, remain); i > 0; i--) {
			List<Integer>[] lists = process(i, remain - i);
			for (List<Integer> list : lists) {
				List<Integer> nowList = new ArrayList<>();
				nowList.add(i);
				nowList.addAll(list);
				resultLists.add(nowList);
			}
		}
		return resultLists.toArray(List[]::new);
	}
}
