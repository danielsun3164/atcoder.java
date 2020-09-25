package other.joi2006ho;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * TLEを防ぐため、Stream APIを使用しない
 */
public class ProblemD {

	/** ノードの値の最大値 */
	private static final int MAX = 100;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			@SuppressWarnings("unchecked")
			List<Integer>[] pathLists = new List[MAX];
			IntStream.range(0, MAX).forEach(i -> pathLists[i] = new ArrayList<>());
			IntStream.range(0, n).forEach(i -> {
				int a = scanner.nextInt() - 1, b = scanner.nextInt() - 1;
				pathLists[a].add(b);
				pathLists[b].add(a);
			});
			boolean[] visited = new boolean[MAX];
			Arrays.fill(visited, false);
			// TLEを防ぐため、Stream APIを使用しない
			int max = 1;
			for (int i = 0; i < MAX; i++) {
				max = Math.max(max, getResult(i, pathLists, visited));
			}
			System.out.println(max);
		}
	}

	/**
	 * 現在のノードから最大にたどることができる深さを計算する
	 * 
	 * @param current   現在のノード
	 * @param pathLists パスの一覧
	 * @param visited   各ノードが使用されたかどうか
	 * @return 現在のノードから最大にたどることができる深さ
	 */
	private static int getResult(int current, List<Integer>[] pathLists, boolean[] visited) {
		if (pathLists[current].isEmpty()) {
			return 1;
		}
		visited[current] = true;
		// TLEを防ぐため、Stream APIを使用しない
		int max = 1;
		for (int next : pathLists[current]) {
			if (!visited[next]) {
				max = Math.max(max, getResult(next, pathLists, visited) + 1);
			}
		}
		visited[current] = false;
		return max;
	}
}
