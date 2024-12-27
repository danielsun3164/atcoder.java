package other.apg4b;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProblemEX25 {

	private static final int N = 50;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			Set<Integer> a = new HashSet<>();
			IntStream.range(0, n).forEach(i -> a.add(scanner.nextInt()));
			int m = scanner.nextInt();
			Set<Integer> b = new HashSet<>();
			IntStream.range(0, m).forEach(i -> b.add(scanner.nextInt()));
			String command = scanner.next();
			switch (command) {
			case "intersection" -> println(intersection(a, b));
			case "union_set" -> {
				a.addAll(b);
				println(a);
			}
			case "symmetric_diff" -> println(symmetricDiff(a, b));
			case "subtract" -> {
				Integer x = scanner.nextInt();
				a.remove(x);
				println(a);
			}
			case "increment" -> println(increment(a));
			case "decrement" -> println(decrement(a));
			}
		}
	}

	/**
	 * 入力集合を数字順に表示する
	 *
	 * @param set 入力集合
	 */
	private static void println(Set<Integer> set) {
		System.out.println(set.stream().sorted().map(i -> i.toString()).collect(Collectors.joining(" ")));
	}

	/**
	 * @param a
	 * @param b
	 * @return aとbの共通して含まれる要素からなる集合
	 */
	private static Set<Integer> intersection(Set<Integer> a, Set<Integer> b) {
		return a.stream().filter(i -> b.stream().anyMatch(i::equals)).collect(Collectors.toSet());
	}

	/**
	 * @param a
	 * @param b
	 * @return aとbのうちどちらか一方にだけ含まれる要素からなる集合
	 */
	private static Set<Integer> symmetricDiff(Set<Integer> a, Set<Integer> b) {
		Set<Integer> result = new HashSet<>(a);
		result.addAll(b);
		result.removeAll(intersection(a, b));
		return result;
	}

	/**
	 * @param a
	 * @return 集合aに含まれる要素すべてに1を加える。ただし、操作前の集合に含まれる49は操作後は0になるものとする。
	 */
	private static Set<Integer> increment(Set<Integer> a) {
		return a.stream().map(i -> (i + 1) % N).collect(Collectors.toSet());
	}

	/**
	 * @param a
	 * @return 集合aに含まれる要素すべてから1を引く。ただし、操作前の集合に含まれる0は操作後は49になるものとする。
	 */
	private static Set<Integer> decrement(Set<Integer> a) {
		return a.stream().map(i -> (i + N - 1) % N).collect(Collectors.toSet());
	}
}
