package abc.abc016;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			@SuppressWarnings("unchecked")
			Set<Integer>[] friends = new Set[n];
			IntStream.range(0, n).forEach(i -> friends[i] = new HashSet<>());
			IntStream.range(0, m).forEach(i -> {
				int a = scanner.nextInt() - 1, b = scanner.nextInt() - 1;
				friends[a].add(b);
				friends[b].add(a);
			});
			IntStream.range(0, n).map(i -> {
				Set<Integer> set = new HashSet<>();
				// 友人の友人を全て追加
				for (Integer integer : friends[i]) {
					set.addAll(friends[integer]);
				}
				// 自分自身を削除
				set.remove(i);
				// 自分の友人を削除
				set.removeAll(friends[i]);
				return set.size();
			}).forEach(System.out::println);
		}
	}
}
