package other.joi2006ho;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			List<List<Integer>> lists = process(n, n);
			for (List<Integer> list : lists) {
				System.out.println(list.stream().map(String::valueOf).collect(Collectors.joining(" ")));
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
	private static List<List<Integer>> process(int max, int remain) {
		if (0 == remain) {
			return Arrays.asList(new ArrayList<Integer>());
		}
		List<List<Integer>> resultLists = new ArrayList<>();
		for (int i = Math.min(max, remain); i > 0; i--) {
			List<List<Integer>> lists = process(i, remain - i);
			for (List<Integer> list : lists) {
				list.add(0, i);
				resultLists.add(list);
			}
		}
		return resultLists;
	}
}
