package abc.abc054;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			// パスの一覧
			@SuppressWarnings("unchecked")
			Set<Integer>[] paths = new Set[n];
			IntStream.range(0, n).forEach(i -> paths[i] = new HashSet<>());
			IntStream.range(0, m).forEach(i -> {
				int a = scanner.nextInt() - 1;
				int b = scanner.nextInt() - 1;
				paths[a].add(b);
				paths[b].add(a);
			});
			System.out.println(getResult(0, paths, ~(0xFFFF_FFFF << n), new HashMap<>()));
		}
	}

	/**
	 * @param startNode アクセス始点
	 * @param paths
	 * @param status    グラフのアクセス済ステータス（nビット目が1＝まだアクセスしていない）
	 * @param map
	 * @return アクセスのパスの数
	 */
	private static int getResult(int startNode, Set<Integer>[] paths, int status, Map<List<Integer>, Integer> map) {
		// 現在のノードが最後のノードの場合
		if (0 == (status & (~(1 << startNode)))) {
			return 1;
		}
		List<Integer> key = Arrays.asList(startNode, status);
		Integer result = map.get(key);
		if (null == result) {
			result = 0;
			// 現在のノードをアクセス済にする
			status &= ~(1 << startNode);
			for (Integer nextNode : paths[startNode]) {
				if ((status & (1 << nextNode)) > 0) {
					result += getResult(nextNode, paths, status, map);
				}
			}
			map.put(key, result);
		}
		return result;
	}
}
