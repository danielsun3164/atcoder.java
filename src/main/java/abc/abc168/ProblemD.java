package abc.abc168;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * https://qiita.com/drken/items/996d80bcae64649a6580 を参考に作成
 */
public class ProblemD {

	/** 判定用大きい数 */
	private static final int INF = Integer.MAX_VALUE >> 1;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			Room[] rooms = new Room[n + 1];
			IntStream.range(0, n + 1).forEach(i -> rooms[i] = new Room(i));
			IntStream.range(0, m).forEach(i -> {
				int a = scanner.nextInt(), b = scanner.nextInt();
				rooms[a].children.add(b);
				rooms[b].children.add(a);
			});
			rooms[1].depth = 0;
			Queue<Room> queue = new PriorityQueue<>();
			queue.add(rooms[1]);
			while (!queue.isEmpty()) {
				Room parent = queue.poll();
				for (Integer child : parent.children) {
					if (rooms[child].depth == INF) {
						rooms[child].depth = parent.depth + 1;
						rooms[child].parent = parent.no;
						queue.add(rooms[child]);
					}
				}
			}
			for (int i = 1; i < n + 1; i++) {
				if (rooms[i].depth >= INF) {
					System.out.println("No");
					return;
				}
			}
			System.out.println("Yes");
			IntStream.range(2, n + 1).map(i -> rooms[i].parent).forEach(System.out::println);
		}
	}

	/**
	 * 各部屋を表すクラス
	 */
	private static class Room implements Comparable<Room> {
		/** 自分の番号 */
		int no;
		/** 深さ */
		int depth = INF;
		/** 親 */
		int parent = 0;
		/** 子供のリスト */
		List<Integer> children = new ArrayList<>();

		/**
		 * コンストラクター
		 * 
		 * @param no 番号
		 */
		Room(int no) {
			super();
			this.no = no;
		}

		@Override
		public int compareTo(Room o) {
			return this.depth - o.depth;
		}
	}
}
